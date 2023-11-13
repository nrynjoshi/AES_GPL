package com.narayanjoshi.gplapplication;

import com.narayanjoshi.gplapplication.service.CommandParser;
import com.narayanjoshi.gplapplication.util.CanvasUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.scene.canvas.Canvas;

/**
 * Single line command run test
 * */
public class CommandLineTest {

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
		 *the test will run valid clear command and this will not throw any exception for success
		 * */
	    @Test
	    public void testWithClearValidString(){
	        String command = "clear";
	        this.commandParser.processTheGivenInstruction(command, this.canvasUtil);
	    }

		/**
		 * the test will run valid pen command and this will not throw any exception for success
		 * */
	    @Test
	    public void testWithPenValidCommandAndParam(){
	        String command = "pen blue";
	        this.commandParser.processTheGivenInstruction(command, this.canvasUtil);
	    }


		/**
		 * the test will run valid pen command with mix command letter like uppercase and lowercase and this will not throw any exception for success
		 * */
	    @Test
	    public void testWithPenValidSingleCommandAndParamWithMixCase(){
	        String command = "pEn blue";
	        this.commandParser.processTheGivenInstruction(command, this.canvasUtil);
	    }

		/**
		 * the test will run valid comment command and this will not throw any exception for success
		 * */
	    @Test
	    public void testWithValidCommentCmd(){
	        String command = "// comment_here";
	        this.commandParser.processTheGivenInstruction(command, this.canvasUtil);
	    }

		/**
		 * the test will run valid fill command with on value and this will not throw any exception for success
		 * */
	    @Test
	    public void testWithFillOnCommandCommentCmd(){
	        String command = "fill on";
	        this.commandParser.processTheGivenInstruction(command, this.canvasUtil);
	    }

		/**
		 * the test will run valid fill command with off value and this will not throw any exception for success
		 * */
	    @Test
	    public void testWithFillOffCommand(){
	        String command = "fill off";
	        this.commandParser.processTheGivenInstruction(command, this.canvasUtil);
	    }

		/**
		 * the test will run valid triangle command with two param and this will not throw any exception for success
		 * */
	    @Test
	    public void testWithTriangleCommand(){
	        String command = "triangle 50,100";
	        this.commandParser.processTheGivenInstruction(command, this.canvasUtil);
	    }

}
