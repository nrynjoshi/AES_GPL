package com.narayanjoshi.gplapplication;


import javafx.scene.canvas.Canvas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommandParserTest {

    //--------------------------process-------------

    private CommandParser commandParser;
    private CanvasUtil canvasUtil;
    @BeforeEach
    public void init(){
        this.commandParser= new CommandParser(null, null, null);
        canvasUtil= new CanvasUtil(new Canvas());
    }

    @Test
    public void testWithCanvasNull_process(){
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new CanvasUtil(null),
                "Canvas cannot be null."
        );
    }
    @Test
    public void testWithNull(){
        String command = null;
        Assertions.assertThrows(
                CommandNotFound.class,
                () -> this.commandParser.process(command, this.canvasUtil),
                "Please write your command on console and press Run button."
        );
    }
    @Test
    public void testWithEmptyString(){
        String command = "";

        Assertions.assertThrows(
                CommandNotFound.class,
                () -> this.commandParser.process(command, this.canvasUtil),
                "Please write your command on console and press Run button."
        );
    }

    @Test
    public void testWithSpaceInString(){
        String command = "   ";
        Assertions.assertThrows(
                CommandNotFound.class,
                () -> this.commandParser.process(command, this.canvasUtil),
                "Please write your command on console and press Run button."
        );

    }

    

   


   

   

    
}
