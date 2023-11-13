package com.narayanjoshi.gplapplication.service.command.draw;

import com.narayanjoshi.gplapplication.service.command.CommandEnum;
import com.narayanjoshi.gplapplication.service.RootCommand;

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
     * @param command represent the user input instruction with consist of command and param
     * @see CommandEnum for command syntax
     * */
    public abstract void draw(String command);

    public void execute(String command){
        this.draw(command);
    }
}
