package com.narayanjoshi.gplapplication.service.command.draw;

import com.narayanjoshi.gplapplication.service.command.CommandEnum;
import com.narayanjoshi.gplapplication.service.RootCommand;
import com.narayanjoshi.gplapplication.util.Util;

/**
 * The {@code FillCommand} class represents validation of command and
 * performing fill operation of pen based on defined instruction.
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

    public void execute(){
        this.draw();
    }
}
