package com.narayanjoshi.gplapplication.service.command;

import com.narayanjoshi.gplapplication.Util;
import com.narayanjoshi.gplapplication.service.RootCommand;
import javafx.fxml.FXML;

import java.util.List;

/**
 * The {@code MoveToCommand} class represents validation of command and
 * define pen position by moving to particular position based on defined instruction.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class MoveToCommand extends RootCommand {

    /**
     * {@inheritDoc}
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
