package com.narayanjoshi.gplapplication.service.command.draw;

import com.narayanjoshi.gplapplication.util.Util;

import java.util.List;

/**
 * The {@code DrawToCommand} class represents validation of command and
 * performing draw operation of line based on defined instruction.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class DrawToCommand extends DrawRootCommand {

    /**
     * {@inheritDoc}
     * This method will draw a line by taking user input command. 
     * This will read line  X and Y coordinate of the ending point of the line from the user input command.
     */
    @Override
    public void draw(String command) {
        List<String> params = Util.getAllParameterFromCommand(command);

        double x = Float.parseFloat(params.get(0));
        double y = Float.parseFloat(params.get(1));

        if(canvasUtil.isFillOn()){
            canvasUtil.getGraphicsContext().strokeLine(canvasUtil.getMoveX(), canvasUtil.getMoveY(), x, y);
        }else{
            canvasUtil.getGraphicsContext().strokeLine(canvasUtil.getMoveX(), canvasUtil.getMoveY(), x, y);
        }

    }
}
