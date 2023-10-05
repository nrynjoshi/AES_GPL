package com.narayanjoshi.gplapplication.service;

import com.narayanjoshi.gplapplication.CanvasUtil;
import com.narayanjoshi.gplapplication.CommandNotFound;
import com.narayanjoshi.gplapplication.Util;

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
        Util.validateCommand(inputCommand, this.command, this.param);
    }

}
