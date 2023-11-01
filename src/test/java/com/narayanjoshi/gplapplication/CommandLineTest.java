package com.narayanjoshi.gplapplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.scene.canvas.Canvas;

public class CommandLineTest {

	 	private CommandParser commandParser;
	    private CanvasUtil canvasUtil;
	    
	    @BeforeEach
	    public void init(){
	        this.commandParser= new CommandParser(null, null, null);
	        canvasUtil= new CanvasUtil(new Canvas());
	    }
	    
	    @Test
	    public void testWithClearValidString(){
	        String command = "clear";
	        this.commandParser.process(command, this.canvasUtil);
	    }

	    @Test
	    public void testWithPenValidCommandAndParam(){
	        String command = "pen blue";
	        this.commandParser.process(command, this.canvasUtil);
	    }

	    @Test
	    public void testWithPenValidSingleCommandAndParamWithMixCase(){
	        String command = "pEn blue";
	        this.commandParser.process(command, this.canvasUtil);
	    }
	    
	    @Test
	    public void testWithValidCommentCmd(){
	        String command = "// comment_here";
	        this.commandParser.process(command, this.canvasUtil);
	    }
	    
	    @Test
	    public void testWithFillOnCommandCommentCmd(){
	        String command = "fill on";
	        this.commandParser.process(command, this.canvasUtil);
	    }
	    
	    @Test
	    public void testWithFillOffCommand(){
	        String command = "fill off";
	        this.commandParser.process(command, this.canvasUtil);
	    }
	    
	    @Test
	    public void testWithTriangleCommand(){
	        String command = "triangle 50,100";
	        this.commandParser.process(command, this.canvasUtil);
	    }

}
