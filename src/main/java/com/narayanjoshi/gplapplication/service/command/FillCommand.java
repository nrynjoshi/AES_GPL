package com.narayanjoshi.gplapplication.service.command;

import com.narayanjoshi.gplapplication.CommandNotFound;
import com.narayanjoshi.gplapplication.Util;
import com.narayanjoshi.gplapplication.service.RootCommand;

import java.util.List;

public class FillCommand extends RootCommand {

    @Override
    public void draw(String command) {
        this.validate(command);

        List<String> params = Util.getAllParameterFromCommand(command);
        String param1 = params.get(0);
        throw new CommandNotFound("Fill command not implemented yet..", 2);
    }
}