package com.example.gplapplication.service.command;

import com.example.gplapplication.CanvasUtil;
import com.example.gplapplication.CommandEnum;
import com.example.gplapplication.Util;
import com.example.gplapplication.service.RootCommand;
import javafx.fxml.FXML;

public class ResetCommand extends RootCommand {

    public ResetCommand(CanvasUtil canvasUtil){
        super(canvasUtil, CommandEnum.RESET);
    }

    @Override
    public void validate(String command) {
        Util.validateCommand(command, this.COMMAND);
    }

    @Override
    public void draw(String command) {
        this.validate(command);
        new ClearCommand(canvasUtil).draw("clear");
        new MoveToCommand(canvasUtil).draw("moveTo 0,0");
        new MoveToCommand(canvasUtil).draw("pen black");
    }
}
