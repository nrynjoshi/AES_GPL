package com.narayanjoshi.gplapplication.service.command;

import com.narayanjoshi.gplapplication.Util;
import com.narayanjoshi.gplapplication.service.RootCommand;

import java.util.List;

/**
 * The {@code DrawToCommand} class represents validation of command and
 * performing draw operation of line based on defined instruction.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class DrawToCommand extends RootCommand {

    /**
     * {@inheritDoc}
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
