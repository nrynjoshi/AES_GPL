package com.example.gplapplication.service.command;

import com.example.gplapplication.CanvasUtil;
import com.example.gplapplication.CommandEnum;
import com.example.gplapplication.CommandNotFound;
import com.example.gplapplication.Util;
import com.example.gplapplication.service.RootCommand;

import java.util.List;

public class FillCommand extends RootCommand {

    @Override
    public void validate(String command) {
        Util.validateCommand(command, this.command, this.param);
    }

    @Override
    public void draw(String command) {
        this.validate(command);

        List<String> params = Util.getAllParameterFromCommand(command);
        String param1 = params.get(0);
        throw new CommandNotFound("Fill command not implemented yet..", 2);
    }
}