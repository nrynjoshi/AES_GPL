package com.narayanjoshi.gplapplication;

import com.narayanjoshi.gplapplication.service.command.CircleCommand;
import com.narayanjoshi.gplapplication.service.command.ResetCommand;
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
    public void testWithNull_process(){
        String command = null;
        this.commandParser.process(command, this.canvasUtil);
    }
    @Test
    public void testWithEmptyString_process(){
        String command = "";
        this.commandParser.process(command, this.canvasUtil);
    }

    @Test
    public void testWithSpaceInString_process(){
        String command = "   ";
        this.commandParser.process(command, this.canvasUtil);
    }

    @Test
    public void testWithValidString_process(){
        String command = "clear";
        this.commandParser.process(command, this.canvasUtil);
    }

    @Test
    public void testWithValidCommandAndParam_process(){
        String command = "pen blue";
        this.commandParser.process(command, this.canvasUtil);
    }

    @Test
    public void testWithInValidCommandAndParam_process(){
        String command = "rectangles 100,200";
        this.commandParser.process(command, this.canvasUtil);
    }
}
