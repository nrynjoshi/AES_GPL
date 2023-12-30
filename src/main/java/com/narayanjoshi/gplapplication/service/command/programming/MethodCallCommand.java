package com.narayanjoshi.gplapplication.service.command.programming;

import com.narayanjoshi.gplapplication.exception.CommandNotFoundException;
import com.narayanjoshi.gplapplication.service.CommandParser;
import com.narayanjoshi.gplapplication.util.Util;

public class MethodCallCommand extends ProgrammingRootCommand {

    /**
     * {@inheritDoc}
     * This method will validation if method defined or not.
     */
    @Override
    public void validate() {
        super.validate();
        String userInput = canvasUtil.getUserInputCommandLineByLine();
        System.out.println("Method Call Processing Index :" + canvasUtil.getCurrentProgramExecutionIndex());

        String[] split = userInput.split("\\s", 3);
        String methodKey = split[1];
        String methodCodeBlock = canvasUtil.getMethodCodeBlock().get(methodKey);
        if(methodCodeBlock == null || methodCodeBlock.isEmpty()){
            throw new CommandNotFoundException(methodKey+ " method is not defined yet.", -1);
        }
    }

    /**
     * {@inheritDoc}
     * This method will read a file and execute it from a user given file path.
     */
    @Override
    public void execute() {
        String userInput = canvasUtil.getUserInputCommandLineByLine();
        System.out.println("Method Call Processing Index :" + canvasUtil.getCurrentProgramExecutionIndex());

        String[] split = userInput.split("\\s", 3);
        String methodKey = split[1];
        String methodCodeBlock = canvasUtil.getMethodCodeBlock().get(methodKey);
        int currentProgramExecutionIndex = canvasUtil.getCurrentProgramExecutionIndex();

        String[] commandSplit = methodCodeBlock.split("\n");

        for (int i = 0; i < commandSplit.length; i++) {
            canvasUtil.setCurrentProgramExecutionIndex(i);
            CommandParser.executeCoreEngine(canvasUtil, commandSplit, i);
        }

        //reset to previous working index i.e method call index
        canvasUtil.setCurrentProgramExecutionIndex(currentProgramExecutionIndex);

        System.out.println("Method Call Processed Index :" + canvasUtil.getCurrentProgramExecutionIndex());
    }
}