package com.narayanjoshi.gplapplication.service.command;

import com.narayanjoshi.gplapplication.Util;
import com.narayanjoshi.gplapplication.service.RootCommand;

import java.util.List;

public class CircleCommand extends RootCommand {

    @Override
    public void draw(String command) {

        this.validate(command);

        List<String> params = Util.getAllParameterFromCommand(command);

        double moveX = canvasUtil.getMoveX();
        double moveY = canvasUtil.getMoveY();

        double radius = Float.parseFloat(params.get(0));

        if(canvasUtil.isFillOn()){
            canvasUtil.getGraphicsContext().fillOval(moveX, moveY, radius, radius);
        }else{
            canvasUtil.getGraphicsContext().strokeOval(moveX, moveY, radius, radius);
        }


    }
}
