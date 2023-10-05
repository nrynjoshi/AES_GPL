package com.example.gplapplication.service;

import com.example.gplapplication.CanvasUtil;
import com.example.gplapplication.CommandEnum;
import com.example.gplapplication.CommandNotFound;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.List;

public class RootCommand implements RootCommandIfc {

    protected CanvasUtil canvasUtil;

    public String command;
    public String param;

    public RootCommand(){
    }

    public void init(CanvasUtil canvasUtil, String command, String param){
        this.canvasUtil= canvasUtil;
        this.command = command;
        this.param = param;
    }

    @Override
    public void draw(String command) {
       throw new CommandNotFound("Implementation not done yet", 1);
    }

    @Override
    public void validate(String inputCommand) {
        throw new CommandNotFound("Implementation not done yet", 1);
    }

}
