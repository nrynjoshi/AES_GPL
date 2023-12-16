package com.narayanjoshi.gplapplication.service.command.programming;

import com.narayanjoshi.gplapplication.service.CommandParser;
import com.narayanjoshi.gplapplication.util.Util;

public class IFStatementCommand   extends ProgrammingRootCommand {

    @Override
    public void validate() {

    }

    /**
     * {@inheritDoc}
     * This method will save a command to a file path given by user in command param.
     */
    @Override
    public void execute() {
        int currentProgramExecutionIndex = canvasUtil.getCurrentProgramExecutionIndex();
        currentProgramExecutionIndex = ifCommandProcess(currentProgramExecutionIndex);
        canvasUtil.setCurrentProgramExecutionIndex(currentProgramExecutionIndex);
    }

    private int ifCommandProcess(int currentExecutionIndex) {
        String[] commandLineByLineArray = canvasUtil.getCommandLineByLineArray();
        String chunkCommand = commandLineByLineArray[currentExecutionIndex];
        String[] loopSplit = chunkCommand.split(" ", 2);
        String conditionPart = loopSplit[1];

        int loopStatementStartIndex = currentExecutionIndex+1;
        int loopStatementProcessingIndex = currentExecutionIndex+1;
        while (true){
            if (evalCondition(conditionPart, canvasUtil)) {
                String chunkCommandNext = commandLineByLineArray[loopStatementProcessingIndex];

                if (chunkCommandNext.contains("endif")) {
                    break;
                }else if (chunkCommandNext.contains("if")) {
                    return ifCommandProcess(loopStatementProcessingIndex);
                }else if(Util.isNotEmpty(chunkCommandNext)){
                    CommandParser commandParser = new CommandParser(canvasUtil.getCanvasId(), null, chunkCommandNext);
                    commandParser.processTheGivenInstruction(chunkCommandNext, canvasUtil, true);
                    loopStatementProcessingIndex++;
                }
            }
        }
        return loopStatementProcessingIndex;
    }
}
