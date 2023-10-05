package com.narayanjoshi.gplapplication.service.command;

import com.narayanjoshi.gplapplication.Util;
import com.narayanjoshi.gplapplication.service.RootCommand;

public class ClearCommand extends RootCommand {

    @Override
    public void validate(String command) {
        Util.validateCommand(command, this.command, this.param);
    }

    @Override
    public void draw(String command) {
        this.validate(command);
        canvasUtil.getGraphicsContext().clearRect(0, 0, canvasUtil.getCanvasId().getWidth(), canvasUtil.getCanvasId().getHeight());
    }

}
