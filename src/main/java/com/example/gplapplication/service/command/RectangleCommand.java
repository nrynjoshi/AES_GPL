package com.example.gplapplication.service.command;

import com.example.gplapplication.CanvasUtil;
import com.example.gplapplication.CommandEnum;
import com.example.gplapplication.Util;
import com.example.gplapplication.service.RootCommand;
import javafx.fxml.FXML;

import java.util.List;

public class RectangleCommand extends RootCommand {

    public RectangleCommand(CanvasUtil canvasUtil){
        super(canvasUtil, CommandEnum.RECTANGLE);
    }

    @Override
    public void validate(String command) {
        Util.validateCommand(command, this.COMMAND);
    }

    @Override
    public void draw(String command) {

        this.validate(command);

        List<String> params = Util.getAllParameterFromCommand(command);

        double width = Float.parseFloat(params.get(0));
        double height = Float.parseFloat(params.get(1));

        canvasUtil.getGraphicsContext().strokeRect(canvasUtil.getMoveX(), canvasUtil.getMoveY(), width,height);
    }
}
