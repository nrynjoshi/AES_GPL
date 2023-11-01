package com.narayanjoshi.gplapplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.scene.canvas.Canvas;

public class MultilineCommandTest {

	private CommandParser commandParser;
    private CanvasUtil canvasUtil;
    
    @BeforeEach
    public void init(){
        this.commandParser= new CommandParser(null, null, null);
        canvasUtil= new CanvasUtil(new Canvas());
    }
	
	 @Test
	    public void testWithValidMultipleCommandAndParam(){
	        String command = "pen blue \n" +
	                "circle 50 \n" +
	                "rectangle 80,40";
	        this.commandParser.process(command, this.canvasUtil);
	    }
	 
	 @Test
	    public void testWithValidMultipleCommandAndParamWithMixCase(){
	        String command = "clear \n pen bLue \n" +
	                "ciRcle 50 \n" +
	                "rectAngle 80,40";
	        this.commandParser.process(command, this.canvasUtil);
	    }
}
