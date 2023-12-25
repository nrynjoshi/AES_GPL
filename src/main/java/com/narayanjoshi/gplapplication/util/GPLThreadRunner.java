package com.narayanjoshi.gplapplication.util;

import com.narayanjoshi.gplapplication.service.CommandParser;

public class GPLThreadRunner extends Thread {

    private String commandSingle;
    private String commandMultiple;
    private boolean innerEngineCall;
    private boolean isRunSingleLineCommand;
    private CanvasUtil canvasUtil;

    public void init(boolean isRunSingleLineCommand,String commandSingle, String commandMultiple, CanvasUtil canvasUtil,boolean innerEngineCall) {
        this.commandSingle = commandSingle;
        this.commandMultiple = commandMultiple;
        this.innerEngineCall = innerEngineCall;
        this.isRunSingleLineCommand = isRunSingleLineCommand;
        this.canvasUtil = canvasUtil;
    }

    @Override
    public void run() {
        System.out.println("Calling "+Thread.currentThread().getName());
        Util.sleepThread(1000);
        CommandParser commandParser = new CommandParser(canvasUtil.getCanvasId(), commandSingle, commandMultiple);
        if (isRunSingleLineCommand) {
            commandParser.processTheGivenInstruction(commandSingle, canvasUtil, innerEngineCall);
        } else {
            commandParser.processTheGivenInstruction(commandMultiple, canvasUtil, innerEngineCall);
        }
        System.out.println("Completed "+Thread.currentThread().getName());
    }
}
