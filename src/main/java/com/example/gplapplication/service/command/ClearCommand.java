package com.example.gplapplication.service.command;

import com.example.gplapplication.CanvasUtil;
import com.example.gplapplication.CommandEnum;
import com.example.gplapplication.Util;
import com.example.gplapplication.service.RootCommand;
import javafx.fxml.FXML;

public class ClearCommand extends RootCommand {

    public ClearCommand(CanvasUtil canvasUtil){
        super(canvasUtil, CommandEnum.CLEAR);
    }

    @Override
    public void validate(String command) {
        Util.validateCommand(command, this.COMMAND);
    }

    @Override
    public void draw(String command) {
        this.validate(command);
        canvasUtil.getGraphicsContext().clearRect(0, 0, canvasUtil.getCanvasId().getWidth(), canvasUtil.getCanvasId().getHeight());
    }

}
