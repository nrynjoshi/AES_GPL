package com.narayanjoshi.gplapplication.service;

import com.narayanjoshi.gplapplication.util.CanvasUtil;
import com.narayanjoshi.gplapplication.service.command.CommandEnum;
import com.narayanjoshi.gplapplication.util.Util;

public abstract class RootCommand implements RootCommandIfc{
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
    public void validate(String inputCommand) {
        Util.validateCommand(inputCommand, this.command, this.param);
    }


}
