package com.example.gplapplication.service.command;

import com.example.gplapplication.CanvasUtil;
import com.example.gplapplication.CommandEnum;
import com.example.gplapplication.Util;
import com.example.gplapplication.service.RootCommand;

import java.util.List;

public class DrawToCommand extends RootCommand {

    public DrawToCommand(CanvasUtil canvasUtil){
        super(canvasUtil, CommandEnum.DRAW_TO);
    }

    @Override
    public void validate(String command) {
        Util.validateCommand(command, this.COMMAND);
    }

    @Override
    public void draw(String command) {
        Util.validateCommand(command, CommandEnum.DRAW_TO.getCommand());
        List<String> params = Util.getAllParameterFromCommand(command);

        double x = Float.parseFloat(params.get(0));
        double y = Float.parseFloat(params.get(1));

        canvasUtil.getGraphicsContext().strokeLine(canvasUtil.getMoveX(), canvasUtil.getMoveY(), x, y);
        canvasUtil.getGraphicsContext().stroke();
    }
}
