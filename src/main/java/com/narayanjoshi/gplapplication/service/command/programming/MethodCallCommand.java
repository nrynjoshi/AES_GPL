package com.narayanjoshi.gplapplication.service.command.programming;

import com.narayanjoshi.gplapplication.service.CommandParser;

public class MethodCallCommand extends ProgrammingRootCommand {

    @Override
    public void validate() {

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



//        //change current index to 0 to process method command
//        canvasUtil.setCurrentProgramExecutionIndex(0);
//        CommandParser commandParser = new CommandParser(canvasUtil.getCanvasId(), null, methodCodeBlock);
//        commandParser.processTheGivenInstruction(methodCodeBlock, canvasUtil, true);

        //reset to previous working index i.e method call index
        canvasUtil.setCurrentProgramExecutionIndex(currentProgramExecutionIndex);

        System.out.println("Method Call Processed Index :" + canvasUtil.getCurrentProgramExecutionIndex());
    }
}