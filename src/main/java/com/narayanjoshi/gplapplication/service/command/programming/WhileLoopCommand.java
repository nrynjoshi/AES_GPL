package com.narayanjoshi.gplapplication.service.command.programming;

import com.narayanjoshi.gplapplication.exception.CommandNotFoundException;
import com.narayanjoshi.gplapplication.exception.CommandProcessingException;
import com.narayanjoshi.gplapplication.service.CommandParser;
import com.narayanjoshi.gplapplication.util.CanvasUtil;
import com.narayanjoshi.gplapplication.util.Util;

/**
 * The {@code WhileLoopCommand} class represents validation of command and
 * performing while loop operation with evaluating the condition.
 *
 * @author Narayan Joshi
 * @since v2.0
 * */
public class WhileLoopCommand   extends ProgrammingRootCommand {

    /**
     * {@inheritDoc}
     * This method will validation while loop statement expression and its terminate block.
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
            throw new CommandNotFoundException("While evaluation expression condition is not valid.", -1);
        }

        boolean isLoopTerminationExist = false;
        int count = 0;
        if(evalCondition(conditionPart, canvasUtil)){
            while (evalCondition(conditionPart, canvasUtil)) {

                if(commandLineByLineArray.length== loopStatementProcessingIndex){
                    break;
                }

                String chunkCommandNext = commandLineByLineArray[loopStatementProcessingIndex];

                if (chunkCommandNext.contains("endwhile")) {
                    isLoopTerminationExist = true;
                    break;
                }
                loopStatementProcessingIndex++;
                count++;
                if(count >500){ //limiting the threshold to terminate the loops
                    break;
                }
            }
        }else {
            throw new CommandProcessingException("Loop condition is not valid to process", -1);
        }

        if(!isLoopTerminationExist){ //limiting the threshold to terminate the loops
            throw new CommandNotFoundException("Looks like the Loop definition does not have end method statement.", -1);
        }
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
        if(evalCondition(conditionPart, canvasUtil)){
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
        }else {
           throw new CommandProcessingException("Loop condition is not valid to process", -1);
        }

        return loopStatementLastProcessedBeforeEndwhileTriggerIndex+1;
    }


}
