package com.narayanjoshi.gplapplication.service.command;

import com.narayanjoshi.gplapplication.CommandEnum;
import com.narayanjoshi.gplapplication.CommandNotFound;
import com.narayanjoshi.gplapplication.Util;
import com.narayanjoshi.gplapplication.service.RootCommand;
import com.narayanjoshi.gplapplication.service.RootCommandIfc;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * The {@code FillCommand} class represents validation of command and
 * performing fill operation of pen based on defined instruction.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
import java.util.List;

public class FillCommand extends RootCommand {

    /**
     * {@inheritDoc}
     * This method will draw fill the pen with given colour.
     * @see CommandEnum
     */
    @Override
    public void draw(String command) {

        List<String> params = Util.getAllParameterFromCommand(command);
        String param1 = params.get(0);
        canvasUtil.setFillOn(param1.equalsIgnoreCase("on"));

        RootCommandIfc penCommand = CommandEnum.PEN.getCommandInstance();;
        penCommand.draw(CommandEnum.PEN.getCommand()+" "+canvasUtil.getPenColor());
    }
}