package com.narayanjoshi.gplapplication.service.command;

import com.narayanjoshi.gplapplication.CommandEnum;
import com.narayanjoshi.gplapplication.Util;
import com.narayanjoshi.gplapplication.service.RootCommand;

public class ResetCommand extends RootCommand {

    @Override
    public void validate(String command) {
        Util.validateCommand(command, this.command, this.param);
    }

    @Override
    public void draw(String command) {
        this.validate(command);
        ClearCommand clearCommand = new ClearCommand();
        clearCommand.init(canvasUtil, CommandEnum.CLEAR.getCommand(), CommandEnum.CLEAR.getParam());
        clearCommand.draw(CommandEnum.CLEAR.getCommand());
        MoveToCommand moveToCommand = new MoveToCommand();
        moveToCommand.init(canvasUtil, CommandEnum.MOVE_TO.getCommand(), CommandEnum.MOVE_TO.getParam());
        moveToCommand.draw(CommandEnum.MOVE_TO.getCommand()+" 0,0");
        PenCommand penCommand = new PenCommand();
        penCommand.init(canvasUtil, CommandEnum.PEN.getCommand(), CommandEnum.PEN.getParam());
        penCommand.draw(CommandEnum.PEN.getCommand()+" black");
    }
}
