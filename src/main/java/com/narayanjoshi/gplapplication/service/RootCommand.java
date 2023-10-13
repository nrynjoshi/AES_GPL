package com.narayanjoshi.gplapplication.service;

import com.narayanjoshi.gplapplication.CanvasUtil;
import com.narayanjoshi.gplapplication.CommandEnum;
import com.narayanjoshi.gplapplication.CommandNotFound;
import com.narayanjoshi.gplapplication.Util;

/**
 * The {@code FillCommand} class represents validation of command and
 * performing fill operation of pen based on defined instruction.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class RootCommand implements RootCommandIfc {

    /**
     *  This instance holds all the required information for performing operation
     * @see CanvasUtil
     * */
    protected CanvasUtil canvasUtil;

    /**
     * system defined command
     * */
    public String command;

    /**
     * system defined parameter for particular command
     * */
    public String param;

    /**
     * protected constructor
     * */
    protected RootCommand(){
    }

    /**
     * {@inheritDoc}
     */
    public void init(CanvasUtil canvasUtil, CommandEnum commandEnum){
        this.canvasUtil= canvasUtil;
        this.command = commandEnum.getCommand();
        this.param = commandEnum.getParam();
    }

    /**
     * {@inheritDoc}
     */
     @Override
      public void draw(String command) {
       throw new CommandNotFound(String.format("'%s' command has not been implemented yet.\nError on '%s'.",this.command, command), -1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void validate(String inputCommand) {
        Util.validateCommand(inputCommand, this.command, this.param);
    }

}
