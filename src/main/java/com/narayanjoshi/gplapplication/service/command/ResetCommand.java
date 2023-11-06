package com.narayanjoshi.gplapplication.service.command;

import com.narayanjoshi.gplapplication.CommandEnum;
import com.narayanjoshi.gplapplication.Util;
import com.narayanjoshi.gplapplication.service.RootCommand;

/**
 * The {@code ResetCommand} class represents validation of command and
 * performing reset operation based on defined instruction. In this
 * {@link ClearCommand} is trigger and pen will be reset as well as
 * pen position will be reset to default one i.e. 0,0.
 * @author Narayan Joshi
 * @since v1.0
 * */
public class ResetCommand extends RootCommand {

    /**
     * {@inheritDoc}
      * This method will reset the drawing area but does not move the pen position.
      * This is reset everything like pen position, pen colour, drawing from the output area.
     */
    @Override
    public void draw(String command) {
        ClearCommand clearCommand = new ClearCommand();
        clearCommand.init(canvasUtil, CommandEnum.CLEAR);
        clearCommand.draw(CommandEnum.CLEAR.getCommand());
        MoveToCommand moveToCommand = new MoveToCommand();
        moveToCommand.init(canvasUtil, CommandEnum.MOVE_TO);
        moveToCommand.draw(CommandEnum.MOVE_TO.getCommand()+" 0,0");
        PenCommand penCommand = new PenCommand();
        penCommand.init(canvasUtil, CommandEnum.PEN);
        penCommand.draw(CommandEnum.PEN.getCommand()+" black");
        canvasUtil.setFillOn(false);
    }
}
