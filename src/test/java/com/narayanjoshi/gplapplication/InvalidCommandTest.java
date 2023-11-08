package com.narayanjoshi.gplapplication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.scene.canvas.Canvas;

/**
 * invalid command test
 * */
public class InvalidCommandTest {

	/**
	 * command parser dummy instance
	 * @see CommandParser
	 * */
	private CommandParser commandParser;

	/**
	 * canvas util dummy or mock instance
	 * @see CanvasUtil
	 * */
    private CanvasUtil canvasUtil;

	/**
	 * setup all instance which are being used
	 * to perform Single Command Line operation before each test case run
	 * */
    @BeforeEach
    public void init(){
        this.commandParser= new CommandParser(null, null, null);
        canvasUtil= new CanvasUtil(new Canvas());
    }

	/**
	 * the test will run pen command with number instate of color value
	 * this test will generate exception CommandNotFound with message of param value error
	 * */
	 @Test
	    public void testWithInValidSingleCommandWithIntParamRequiredString(){
	        String command = "pEn 10";
	        Assertions.assertThrows(
	                CommandNotFound.class,
	                () -> this.commandParser.processTheGivenInstruction(command, this.canvasUtil),
	                "pen does not have a valid param type. Param Values Errors: 10 is not a string."
	        );

	    }

	/**
	 * the test will run rectangles command which has extra 's' in command part
	 * this test will generate exception CommandNotFound with command has not defined message
	 * */
	 @Test
	    public void testWithInValidCommandAndParam(){
	        String command = "rectangles 100,200";

	        Assertions.assertThrows(
	                CommandNotFound.class,
	                () -> this.commandParser.processTheGivenInstruction(command, this.canvasUtil),
	                "'rectangles 100,200' command has not defined"
	        );

	    }

	/**
	 * the test will run fill command which has non accepted value i.e. true
	 * this test will generate exception CommandNotFound with 'true is not a boolean' message
	 * */
	 @Test
	    public void testWithFillInvalidCommandCommentCmd(){
	        String command = "fill true";
	        
	        Assertions.assertThrows(
	                CommandNotFound.class,
	                () -> this.commandParser.processTheGivenInstruction(command, this.canvasUtil),
	                "fill does not have a valid param type. Param Values Errors: true is not a boolean."
	        );
	    }

	/**
	 * the test will run triangle command which has 3 parameter but accepted 2 by system
	 * this test will generate exception CommandNotFound with 'command parameter does not match' message
	 * */
	 @Test
	    public void testWithTriangleInvalidCommand_three_param(){
	        String command = "triangle 50,100,100";
	        Assertions.assertThrows(
	                CommandNotFound.class,
	                () -> this.commandParser.processTheGivenInstruction(command, this.canvasUtil),
	                "'triangle <base_float>,<adjacent_float>' command parameter does not match.\n" +
							"Error on 'triangle 50,100,100'"
	        );
	    }
}
