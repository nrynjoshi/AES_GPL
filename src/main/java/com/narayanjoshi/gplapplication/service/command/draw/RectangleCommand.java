package com.narayanjoshi.gplapplication.service.command.draw;

import com.narayanjoshi.gplapplication.util.Util;

import java.util.List;

/**
 * The {@code RectangleCommand} class represents validation of command and
 * performing draw operation of rectangle based on defined instruction.
 * Rectangle is draw based on pen position and by using width and height.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class RectangleCommand extends DrawRootCommand {

    /**
     * {@inheritDoc}
     * This method will draw a rectangle by taking user input command. 
     * This will read width and height of the rectangle from parameter of that particular command and draw a rectangle.
     */
    @Override
    public void draw(String command) {

        List<String> params = Util.getAllParameterFromCommand(command);

        double width = Float.parseFloat(params.get(0));
        double height = Float.parseFloat(params.get(1));
        if(canvasUtil.isFillOn()){
            canvasUtil.getGraphicsContext().fillRect(canvasUtil.getMoveX(), canvasUtil.getMoveY(), width,height);
        }else{
            canvasUtil.getGraphicsContext().strokeRect(canvasUtil.getMoveX(), canvasUtil.getMoveY(), width,height);
        }
            }
}
