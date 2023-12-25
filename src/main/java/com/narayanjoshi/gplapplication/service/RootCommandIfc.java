package com.narayanjoshi.gplapplication.service;

import com.narayanjoshi.gplapplication.util.CanvasUtil;
import com.narayanjoshi.gplapplication.service.command.CommandEnum;

/**
 * The {@code RootCommandIfc} interface represents generic method required for drawing.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public interface RootCommandIfc {



    /**
     * This method is responsible to initialization all the instance,
     * command and param which are required to draw a shape or process
     * all type of instruction provided by user input.

     * @param canvasUtil holds all requirement information for processing {@link CanvasUtil}
     * @param commandEnum holds all the process instance information as per the provided command
     * */
    void init(CanvasUtil canvasUtil, CommandEnum commandEnum);


    /**
     * This method validate user input command and parameter with system defined command and parameter.
     * */
    void validate();

    /**
     * This method is responsible to perform execution operation of all types of instruction like if else statement, loops, variables.
     * @see CommandEnum for command syntax
     * */
    void execute();

}
