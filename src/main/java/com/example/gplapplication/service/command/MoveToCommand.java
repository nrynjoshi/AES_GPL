package com.example.gplapplication.service.command;

import com.example.gplapplication.CanvasUtil;
import com.example.gplapplication.CommandEnum;
import com.example.gplapplication.Util;
import com.example.gplapplication.service.RootCommand;
import javafx.fxml.FXML;

import java.util.List;

public class MoveToCommand extends RootCommand {

    public MoveToCommand(CanvasUtil canvasUtil){
        super(canvasUtil, CommandEnum.MOVE_TO);
    }

    @Override
    public void validate(String command) {
        Util.validateCommand(command, this.COMMAND);
    }

    @Override
    @FXML
    public void draw(String command) {
        Util.validateCommand(command, CommandEnum.MOVE_TO.getCommand());
        List<String> params = Util.getAllParameterFromCommand(command);

        double x = Float.parseFloat(params.get(0));
        double y = Float.parseFloat(params.get(1));

        canvasUtil.setMoveX(x);
        canvasUtil.setMoveY(y);
        canvasUtil.getGraphicsContext().moveTo(x, y);
    }
}
