package com.narayanjoshi.gplapplication.service.command.programming;

import com.narayanjoshi.gplapplication.service.CommandParser;
import com.narayanjoshi.gplapplication.util.CanvasUtil;
import com.narayanjoshi.gplapplication.util.Util;

public class WhileLoopCommand   extends ProgrammingRootCommand {


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
        currentProgramExecutionIndex = loopCommandProcess(currentProgramExecutionIndex);
        canvasUtil.setCurrentProgramExecutionIndex(currentProgramExecutionIndex);
    }

    private int loopCommandProcess(int currentExecutionIndex) {
        String[] commandLineByLineArray = canvasUtil.getCommandLineByLineArray();
        String chunkCommand = commandLineByLineArray[currentExecutionIndex];
        String[] loopSplit = chunkCommand.split(" ", 2);
        String conditionPart = loopSplit[1];

        int loopStatementStartIndex = currentExecutionIndex+1;
        int loopStatementProcessingIndex = currentExecutionIndex+1;
        int loopStatementLastProcessedBeforeEndwhileTriggerIndex = currentExecutionIndex+1;
        while (evalCondition(conditionPart, canvasUtil)) {
            String chunkCommandNext = commandLineByLineArray[loopStatementProcessingIndex];
            if(Util.isEmpty(chunkCommandNext)){
                loopStatementProcessingIndex++;
                continue;
            }
            if (chunkCommandNext.contains("endwhile")) {
                loopStatementLastProcessedBeforeEndwhileTriggerIndex= loopStatementProcessingIndex;
                loopStatementProcessingIndex = loopStatementStartIndex;
            }else if (chunkCommandNext.contains("while")) {
                loopStatementProcessingIndex = loopCommandProcess(loopStatementProcessingIndex);
            }else if(Util.isNotEmpty(chunkCommandNext)){
                CommandParser commandParser = new CommandParser(canvasUtil.getCanvasId(), null, chunkCommandNext);
                commandParser.processTheGivenInstruction(chunkCommandNext, canvasUtil, true);
                loopStatementProcessingIndex++;
            }
        }
        return loopStatementLastProcessedBeforeEndwhileTriggerIndex+1;
    }


}
