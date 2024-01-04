package com.narayanjoshi.gplapplication.service.command.draw;

import com.narayanjoshi.gplapplication.service.command.CommandEnum;
import com.narayanjoshi.gplapplication.util.Util;
import com.narayanjoshi.gplapplication.service.RootCommandIfc;

/**
 * The {@code FillCommand} class represents validation of command and
 * performing fill operation of pen based on defined instruction.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
import java.util.List;

/**
 * The {@code FillCommand} class represents validation of command and
 * performing draw operation of fill based on defined instruction.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class FillCommand extends DrawRootCommand {

    /**
     * {@inheritDoc}
     * This method will draw fill the pen with given colour.
     * @see CommandEnum
     */
    @Override
    public void draw() {

        String param1 = paramList.get(0);
        canvasUtil.setFillOn(param1.equalsIgnoreCase("on"));

        //call this code portion to set color for fill or stock for pen
        RootCommandIfc penCommand = CommandEnum.PEN.getCommandInstance();
        canvasUtil.setUserInputCommandLineByLine(CommandEnum.PEN.getCommand()+" "+canvasUtil.getPenColor());
        penCommand.init(canvasUtil, CommandEnum.PEN);
        penCommand.execute();
    }
}