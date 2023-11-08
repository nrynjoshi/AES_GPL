package com.narayanjoshi.gplapplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.scene.canvas.Canvas;

/**
 * multiline command test
 * */
public class MultilineCommandTest {

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
	 * the test will run valid multiple command and this will not throw any exception for success
	 * */
	 @Test
	    public void testWithValidMultipleCommandAndParam(){
	        String command = "pen blue \n" +
	                "circle 50 \n" +
	                "rectangle 80,40";
	        this.commandParser.processTheGivenInstruction(command, this.canvasUtil);
	    }

	/**
	 * the test will run valid multiple command with case in-sensitive test and this will not throw any exception for success
	 * */
	 @Test
	    public void testWithValidMultipleCommandAndParamWithMixCase(){
	        String command = "clear \n pen bLue \n" +
	                "ciRcle 50 \n" +
	                "rectAngle 80,40";
	        this.commandParser.processTheGivenInstruction(command, this.canvasUtil);
	    }
}
