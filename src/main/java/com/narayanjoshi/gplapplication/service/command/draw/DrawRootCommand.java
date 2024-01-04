package com.narayanjoshi.gplapplication.service.command.draw;

import com.narayanjoshi.gplapplication.service.command.CommandEnum;
import com.narayanjoshi.gplapplication.service.RootCommand;
import com.narayanjoshi.gplapplication.util.Util;

/**
 * The {@code DrawRootCommand} class represents super class for all draw operation.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public abstract class DrawRootCommand extends RootCommand {



    /**
     * This method is responsible to perform draw operation of all types of shapes and command process.
     * @see CommandEnum for command syntax
     * */
    public abstract void draw();

    /**
     * {@inheritDoc}
     * This method will draw by taking user input command.
     */
    public void execute(){
        this.draw();
    }
}
