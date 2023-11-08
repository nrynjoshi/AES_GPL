package com.narayanjoshi.gplapplication;


import javafx.scene.canvas.Canvas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * command parser test
 * */
public class CommandParserTest {

    //--------------------------process-------------
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
     * the test will check for whether there is canvas or not for processing.
     * */
    @Test
    public void testWithCanvasNull_process(){
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new CanvasUtil(null),
                "Canvas cannot be null."
        );
    }

    /**
     * the test will run with null command, and it will throw message with no command passed.
     * */
    @Test
    public void testWithNull(){
        String command = null;
        Assertions.assertThrows(
                CommandNotFound.class,
                () -> this.commandParser.processTheGivenInstruction(command, this.canvasUtil),
                "Please write your command on console and press Run button."
        );
    }

    /**
     * the test will run with empty command, and it will throw message with no command passed.
     * */
    @Test
    public void testWithEmptyString(){
        String command = "";

        Assertions.assertThrows(
                CommandNotFound.class,
                () -> this.commandParser.processTheGivenInstruction(command, this.canvasUtil),
                "Please write your command on console and press Run button."
        );
    }

    /**
     * the test will run with multiple space command, and it will throw message with no command passed.
     * */
    @Test
    public void testWithSpaceInString(){
        String command = "   ";
        Assertions.assertThrows(
                CommandNotFound.class,
                () -> this.commandParser.processTheGivenInstruction(command, this.canvasUtil),
                "Please write your command on console and press Run button."
        );

    }

    

   


   

   

    
}
