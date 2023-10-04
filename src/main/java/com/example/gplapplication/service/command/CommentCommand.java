package com.example.gplapplication.service.command;

import com.example.gplapplication.CanvasUtil;
import com.example.gplapplication.CommandEnum;
import com.example.gplapplication.Util;
import com.example.gplapplication.service.RootCommand;
import javafx.fxml.FXML;

public class CommentCommand extends RootCommand {
    public CommentCommand(CanvasUtil canvasUtil){
        super(canvasUtil, CommandEnum.COMMENT);
    }

    @Override
    public void validate(String command) {
        Util.validateCommand(command, this.COMMAND);
    }

    @Override
    public void draw(String command) {
        this.validate(command);
        //ignore this as it is comment no process
    }
}
