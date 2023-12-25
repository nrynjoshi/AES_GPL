package com.narayanjoshi.gplapplication.service.command.draw;

import com.narayanjoshi.gplapplication.service.command.CommandEnum;

/**
 * The {@code ResetCommand} class represents validation of command and
 * performing reset operation based on defined instruction. In this
 * {@link ClearCommand} is trigger and pen will be reset as well as
 * pen position will be reset to default one i.e. 0,0.
 * @author Narayan Joshi
 * @since v1.0
 * */
public class ResetCommand extends DrawRootCommand {

    /**
     * {@inheritDoc}
      * This method will reset the drawing area but does not move the pen position.
      * This is reset everything like pen position, pen colour, drawing from the output area.
     */
    @Override
    public void draw() {
        ClearCommand clearCommand = new ClearCommand();
        canvasUtil.setUserInputCommandLineByLine(CommandEnum.CLEAR.getCommand());
        clearCommand.init(canvasUtil, CommandEnum.CLEAR);
        clearCommand.draw();
        MoveToCommand moveToCommand  = new MoveToCommand();
        canvasUtil.setUserInputCommandLineByLine(CommandEnum.MOVE_TO.getCommand()+" 0,0");
        moveToCommand.init(canvasUtil, CommandEnum.MOVE_TO);
        moveToCommand.draw();
        PenCommand penCommand = new PenCommand();
        canvasUtil.setUserInputCommandLineByLine(CommandEnum.PEN.getCommand()+" black");
        penCommand.init(canvasUtil, CommandEnum.PEN);
        penCommand.draw();
        canvasUtil.setFillOn(false);
    }
}
