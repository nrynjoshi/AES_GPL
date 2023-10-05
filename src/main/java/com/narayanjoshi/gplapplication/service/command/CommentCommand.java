package com.narayanjoshi.gplapplication.service.command;

import com.narayanjoshi.gplapplication.Util;
import com.narayanjoshi.gplapplication.service.RootCommand;

public class CommentCommand extends RootCommand {

    @Override
    public void draw(String command) {
        this.validate(command);
        //ignore this as it is comment no process
    }
}
