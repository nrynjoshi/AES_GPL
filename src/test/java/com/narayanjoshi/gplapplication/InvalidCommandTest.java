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
	                () -> this.commandParser.process(command, this.canvasUtil),
	                "pen does not have a valid param type. Param Values Errors: 10 is not a string."
	        );

	    }
	 
	 @Test
	    public void testWithInValidCommandAndParam(){
	        String command = "rectangles 100,200";

	        Assertions.assertThrows(
	                CommandNotFound.class,
	                () -> this.commandParser.process(command, this.canvasUtil),
	                "'rectangles 100,200' command has not defined"
	        );

	    }
	 
	 @Test
	    public void testWithFillInvalidCommandCommentCmd(){
	        String command = "fill true";
	        this.commandParser.process(command, this.canvasUtil);
	    }
	 
	 @Test
	    public void testWithTriangleInvalidCommand_three_param(){
	        String command = "triangle 50,100,100";
	        this.commandParser.process(command, this.canvasUtil);
	    }
}
