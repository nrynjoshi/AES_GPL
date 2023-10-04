package com.example.gplapplication.service.command;

import com.example.gplapplication.CanvasUtil;
import com.example.gplapplication.CommandEnum;
import com.example.gplapplication.Util;
import com.example.gplapplication.service.RootCommand;
import javafx.scene.paint.Color;

import java.util.List;

public class CircleCommand extends RootCommand {

    public CircleCommand(CanvasUtil canvasUtil){
        super(canvasUtil, CommandEnum.CIRCLE);
    }

    @Override
    public void validate(String command) {
        Util.validateCommand(command, this.COMMAND);
    }

    @Override
    public void draw(String command) {

        this.validate(command);

        List<String> params = Util.getAllParameterFromCommand(command);

        double moveX = canvasUtil.getMoveX();
        double moveY = canvasUtil.getMoveY();

        double radius = Float.parseFloat(params.get(0));

        // Set the stroke and fill color.
        canvasUtil.getGraphicsContext().setStroke(Color.BLUE);
        canvasUtil.getGraphicsContext().setFill(Color.RED);

        canvasUtil.getGraphicsContext().strokeOval(moveX, moveY, radius, radius);
    }
}
