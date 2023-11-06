package com.narayanjoshi.gplapplication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.scene.canvas.Canvas;

public class InvalidCommandTest {

	private CommandParser commandParser;
    private CanvasUtil canvasUtil;
    
    @BeforeEach
    public void init(){
        this.commandParser= new CommandParser(null, null, null);
        canvasUtil= new CanvasUtil(new Canvas());
    }
    
	 @Test
	    public void testWithInValidSingleCommandWithIntParamRequiredString(){
	        String command = "pEn 10";
	        Assertions.assertThrows(
	                CommandNotFound.class,
	                () -> this.commandParser.processTheGivenInstruction(command, this.canvasUtil),
	                "pen does not have a valid param type. Param Values Errors: 10 is not a string."
	        );

	    }
	 
	 @Test
	    public void testWithInValidCommandAndParam(){
	        String command = "rectangles 100,200";

	        Assertions.assertThrows(
	                CommandNotFound.class,
	                () -> this.commandParser.processTheGivenInstruction(command, this.canvasUtil),
	                "'rectangles 100,200' command has not defined"
	        );

	    }
	 
	 @Test
	    public void testWithFillInvalidCommandCommentCmd(){
	        String command = "fill true";
	        
	        Assertions.assertThrows(
	                CommandNotFound.class,
	                () -> this.commandParser.processTheGivenInstruction(command, this.canvasUtil),
	                "fill does not have a valid param type. Param Values Errors: true is not a boolean."
	        );
	    }
	 
	 @Test
	    public void testWithTriangleInvalidCommand_three_param(){
	        String command = "triangle 50,100,100";
	        this.commandParser.processTheGivenInstruction(command, this.canvasUtil);
	        Assertions.assertThrows(
	                CommandNotFound.class,
	                () -> this.commandParser.processTheGivenInstruction(command, this.canvasUtil),
	                "'triangle <base_float>,<adjacent_float>' command parameter does not match.\n"
	                + "Error on 'triangle 50,100,100'"
	        );
	    }
}
