package com.narayanjoshi.gplapplication.service.command.programming;

import com.narayanjoshi.gplapplication.exception.CommandNotFoundException;
import com.narayanjoshi.gplapplication.service.CommandParser;
import com.narayanjoshi.gplapplication.util.Util;

import java.util.Arrays;

public class MethodDefCommand extends ProgrammingRootCommand {

    /**
     * {@inheritDoc}
     * This method will validation method def statement expression and its terminate block.
     */
    @Override
    public void validate() {
        String userInput = canvasUtil.getUserInputCommandLineByLine();

        String[] split = userInput.split("\\s", 3);

        String[] commandLineByLineArray = canvasUtil.getCommandLineByLineArray();

        int lastProgramExecutionIndex;
        int count = 0;
        boolean isMethodTerminationExist = false;
        for (lastProgramExecutionIndex = canvasUtil.getCurrentProgramExecutionIndex()+1; lastProgramExecutionIndex < commandLineByLineArray.length; lastProgramExecutionIndex++) {

            if(commandLineByLineArray.length== lastProgramExecutionIndex){
                break;
            }

            String nextStatment = commandLineByLineArray[lastProgramExecutionIndex];
            if (nextStatment.trim().equalsIgnoreCase("endmethod")) {
                isMethodTerminationExist= true;
                break;
            }
            count++;
            if(count >500){ //limiting the threshold to terminate the loops
                break;
            }
        }
        if(!isMethodTerminationExist){ //limiting the threshold to terminate the loops
            throw new CommandNotFoundException("Looks like the method definition does not have end method statement.", -1);
        }
        String methodKey = split[1];
        boolean isMethodAlreayExist = canvasUtil.getMethodCodeBlock().containsKey(methodKey);
        if(isMethodAlreayExist){
            throw new CommandNotFoundException(methodKey+" method has already defined previously.", -1);
        }
    }

    /**
     * {@inheritDoc}
     * This method will read a file and execute it from a user given file path.
     */
    @Override
    public void execute() {
        String userInput = canvasUtil.getUserInputCommandLineByLine();

        String[] split = userInput.split("\\s", 3);

        String[] commandLineByLineArray = canvasUtil.getCommandLineByLineArray();

        StringBuilder methodBody = new StringBuilder();
        int lastProgramExecutionIndex;
        for (lastProgramExecutionIndex = canvasUtil.getCurrentProgramExecutionIndex()+1; lastProgramExecutionIndex < commandLineByLineArray.length; lastProgramExecutionIndex++) {
            String nextStatment = commandLineByLineArray[lastProgramExecutionIndex];
            if (nextStatment.trim().equalsIgnoreCase("endmethod")) {
                break;
            }
            methodBody.append(nextStatment).append("\n");
        }


        String methodKey = split[1];
        String methodCodeBlock = methodBody.toString();
        canvasUtil.getMethodCodeBlock().put(methodKey, methodCodeBlock);
        canvasUtil.setCurrentProgramExecutionIndex(lastProgramExecutionIndex);
    }
}
