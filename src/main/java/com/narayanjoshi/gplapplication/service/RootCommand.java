package com.narayanjoshi.gplapplication.service;

import com.narayanjoshi.gplapplication.exception.PreProcessConfigException;
import com.narayanjoshi.gplapplication.util.CanvasUtil;
import com.narayanjoshi.gplapplication.service.command.CommandEnum;
import com.narayanjoshi.gplapplication.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class RootCommand implements RootCommandIfc{
    /**
     *  This instance holds all the required information for performing operation
     * @see CanvasUtil
     * */
    protected CanvasUtil canvasUtil;


    /**
     * system defined command
     * system defined parameter for particular command
     * */
    public CommandEnum commandEnum = null;

    public List<String> paramList = null;

    /**
     * {@inheritDoc}
     */
    public void init(CanvasUtil canvasUtil, CommandEnum commandEnum){
        this.canvasUtil= canvasUtil;
        this.commandEnum = commandEnum;

        paramList = Util.getAllParameterFromCommand(canvasUtil.getUserInputCommandLineByLine());
        paramList = Util.checkForVariableAndReplaceWithValue(canvasUtil, paramList);

    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void validate() {
        this.preProcessCheck();
        Util.validateCommand(canvasUtil.getUserInputCommandLineByLine(), paramList, commandEnum);
    }


/**
 * Pre validation code for GPL application which is responsible to validate all required param to process.
 * */
        public void preProcessCheck(){
            if(canvasUtil == null ){
                throw new PreProcessConfigException("CanvasUtil instance not initialized.", -1 );
            }

            if(commandEnum == null ){
                throw new PreProcessConfigException("CommandEnum instance not initialized.", -1 );
            }

            if(Util.isEmpty(canvasUtil.getUserInputCommandLineByLine())){
                throw new PreProcessConfigException("User input command not found", -1 );
            }

        }
}
