package com.example.gplapplication.service;

import com.example.gplapplication.CanvasUtil;
import com.example.gplapplication.CommandEnum;
import com.example.gplapplication.CommandNotFound;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.List;

public class RootCommand implements RootCommandIfc {

    protected CanvasUtil canvasUtil;

    public static String COMMAND;

    public RootCommand(CanvasUtil canvasUtil, CommandEnum commandEnum){
        this.canvasUtil= canvasUtil;
        this.COMMAND = commandEnum.getCommand();
    }

    @Override
    public void draw(String command) {
       throw new CommandNotFound("Implementation not done yet", 1);
    }

    @Override
    public void validate(String command) {
        throw new CommandNotFound("Implementation not done yet", 1);
    }

}
