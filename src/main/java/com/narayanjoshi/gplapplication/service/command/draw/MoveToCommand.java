package com.narayanjoshi.gplapplication.service.command.draw;

import com.narayanjoshi.gplapplication.util.Util;

import java.util.List;

/**
 * The {@code MoveToCommand} class represents validation of command and
 * define pen position by moving to particular position based on defined instruction.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class MoveToCommand extends DrawRootCommand {

    /**
     * {@inheritDoc}
     * This method will move the pen position to one location to another for drawing shapes.
     * This will read x and y position from parameter of that particular command and move the pen position to that x and y position.
     */
    @Override
    public void draw(String command) {
        List<String> params = Util.getAllParameterFromCommand(command);

        double x = Float.parseFloat(params.get(0));
        double y = Float.parseFloat(params.get(1));

        canvasUtil.setMoveX(x);
        canvasUtil.setMoveY(y);
        canvasUtil.getGraphicsContext().moveTo(x, y);
    }
}
