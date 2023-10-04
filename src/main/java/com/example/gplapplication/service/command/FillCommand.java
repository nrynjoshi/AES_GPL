package com.example.gplapplication.service.command;

import com.example.gplapplication.CanvasUtil;
import com.example.gplapplication.CommandEnum;
import com.example.gplapplication.CommandNotFound;
import com.example.gplapplication.Util;
import com.example.gplapplication.service.RootCommand;

import java.util.List;

public class FillCommand extends RootCommand {

    public FillCommand(CanvasUtil canvasUtil){
        super(canvasUtil, CommandEnum.FILL);
    }

    @Override
    public void validate(String command) {
        Util.validateCommand(command, this.COMMAND);
    }

    @Override
    public void draw(String command) {
        Util.validateCommand(command, CommandEnum.DRAW_TO.getCommand());

        List<String> params = Util.getAllParameterFromCommand(command);
        String param1 = params.get(0);
        throw new CommandNotFound("Fill command not implemented yet..", 2);
    }
}