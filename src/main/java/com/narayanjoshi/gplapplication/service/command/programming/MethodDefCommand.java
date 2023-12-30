package com.narayanjoshi.gplapplication.service.command.programming;

import com.narayanjoshi.gplapplication.service.CommandParser;
import com.narayanjoshi.gplapplication.util.Util;

import java.util.Arrays;

public class MethodDefCommand extends ProgrammingRootCommand {

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
        canvasUtil.setCurrentProgramExecutionIndex(lastProgramExecutionIndex++);
    }
}
