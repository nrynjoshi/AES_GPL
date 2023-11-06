package com.narayanjoshi.gplapplication.service.command;

import com.narayanjoshi.gplapplication.CommandEnum;
import com.narayanjoshi.gplapplication.Util;
import com.narayanjoshi.gplapplication.service.RootCommand;

import java.util.List;

/**
 * The {@code CircleCommand} class represents validation of command and
 * Circle is draw based on pen position and by using radius.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class CircleCommand extends RootCommand {

    /**
     * {@inheritDoc}
     * This method will draw a circle by taking user input command. 
     * This will read radius from parameter of that particular command and draw a circle.
     */
    @Override
    public void draw(String command) {

        List<String> params = Util.getAllParameterFromCommand(command);

        double moveX = canvasUtil.getMoveX();
        double moveY = canvasUtil.getMoveY();

        double radius = Float.parseFloat(params.get(0));
        if(canvasUtil.isFillOn()){
            canvasUtil.getGraphicsContext().fillOval(moveX - radius, moveY - radius, 2* radius, 2* radius);
        }else{
            canvasUtil.getGraphicsContext().strokeOval(moveX - radius, moveY - radius, 2* radius, 2* radius);
        }


    }
}
