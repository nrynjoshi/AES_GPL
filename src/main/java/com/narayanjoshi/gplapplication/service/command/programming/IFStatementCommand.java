package com.narayanjoshi.gplapplication.service.command.programming;

import com.narayanjoshi.gplapplication.exception.CommandNotFoundException;
import com.narayanjoshi.gplapplication.service.CommandParser;
import com.narayanjoshi.gplapplication.util.Util;

public class IFStatementCommand   extends ProgrammingRootCommand {

    /**
     * {@inheritDoc}
     * This method will validation if statement expression and its terminate block.
     */
    @Override
    public void validate() {
        String[] commandLineByLineArray = canvasUtil.getCommandLineByLineArray();

        int currentExecutionIndex = canvasUtil.getCurrentProgramExecutionIndex();
        String chunkCommand = commandLineByLineArray[currentExecutionIndex];
        String[] loopSplit = chunkCommand.split(" ", 2);
        String conditionPart = loopSplit[1];

        int loopStatementProcessingIndex = currentExecutionIndex+1;

        try{
            evalCondition(conditionPart, canvasUtil);
        }catch (Exception x){
            throw new CommandNotFoundException("If evaluation expression condition is not valid.", -1);
        }

        int count = 0;
        boolean isIfTerminationExist = false;
        while (true){

            if(commandLineByLineArray.length== loopStatementProcessingIndex){
                break;
            }

            String chunkCommandNext = commandLineByLineArray[loopStatementProcessingIndex];

            if (chunkCommandNext.contains("endif")) {
                isIfTerminationExist=true;
                break;
            }

            loopStatementProcessingIndex++;

            count++;
            if(count >500){ //limiting the threshold to terminate the loops
                break;
            }
        }

        if(!isIfTerminationExist){
            throw new CommandNotFoundException("Looks like the if statement does not have end if statement.", -1);
        }
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
        boolean ifStatementCondition = evalCondition(conditionPart, canvasUtil);
        while (true){

            String chunkCommandNext = commandLineByLineArray[loopStatementProcessingIndex];

            if (chunkCommandNext.contains("endif")) {
                break;
            }

            if (ifStatementCondition) {
                if (chunkCommandNext.contains("if")) {
                    return ifCommandProcess(loopStatementProcessingIndex);
                }else if(Util.isNotEmpty(chunkCommandNext)){
                    CommandParser commandParser = new CommandParser(canvasUtil.getCanvasId(), null, chunkCommandNext);
                    commandParser.processTheGivenInstruction(chunkCommandNext, canvasUtil, true);
                }
            }
            loopStatementProcessingIndex++;
        }
        return loopStatementProcessingIndex;
    }
}
