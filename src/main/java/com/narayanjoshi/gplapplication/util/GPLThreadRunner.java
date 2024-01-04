package com.narayanjoshi.gplapplication.util;

import com.narayanjoshi.gplapplication.service.CommandParser;

/**
 * The {@code GPLThreadRunner} class extends the Thread class to run the GPL main process application code logic in thread.
 *
 * @author Narayan Joshi
 * @since v2.0
 * */
public class GPLThreadRunner extends Thread {

    private String commandSingle;
    private String commandMultiple;
    private boolean innerEngineCall;
    private boolean isRunSingleLineCommand;
    private CanvasUtil canvasUtil;

    /**
     * initialize the basic param to process
     * @param isRunSingleLineCommand is single or multiline code process
     * @param commandSingle single line code variable
     * @param commandMultiple multiline code variables
     * @see  CanvasUtil
     * @param innerEngineCall is this call generated by application or user generated
     * */
    public void init(boolean isRunSingleLineCommand,String commandSingle, String commandMultiple, CanvasUtil canvasUtil,boolean innerEngineCall) {
        this.commandSingle = commandSingle;
        this.commandMultiple = commandMultiple;
        this.innerEngineCall = innerEngineCall;
        this.isRunSingleLineCommand = isRunSingleLineCommand;
        this.canvasUtil = canvasUtil;
    }

    /**
     * This will run the thread application
     */
    @Override
    public void run() {
        System.out.println("Calling "+Thread.currentThread().getName());
        Util.sleepThread(10);
        CommandParser commandParser = new CommandParser(canvasUtil.getCanvasId(), commandSingle, commandMultiple);
       commandParser.processTheGivenInstruction(isRunSingleLineCommand, commandSingle, commandMultiple, canvasUtil, innerEngineCall);
        System.out.println("Completed "+Thread.currentThread().getName());
    }
}
