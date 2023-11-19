package com.narayanjoshi.gplapplication.service.command.programming;

import com.narayanjoshi.gplapplication.service.command.draw.DrawRootCommand;

/**
 * The {@code CommentCommand} class represents validation of command and
 * ignore particular line of code and consider as comment line.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class CommentCommand extends ProgrammingRootCommand {

    /**
     * {@inheritDoc}
     * This method will ignore this particular line for commenting code.
     * Nothing can be happened just no operation

     */
    @Override
    public void execute() {
        //ignore this as it is comment no process
    }
}
