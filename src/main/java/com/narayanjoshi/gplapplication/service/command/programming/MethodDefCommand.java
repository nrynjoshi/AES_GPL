package com.narayanjoshi.gplapplication.service.command.programming;

import com.narayanjoshi.gplapplication.service.CommandParser;
import com.narayanjoshi.gplapplication.util.Util;

public class MethodDefCommand extends ProgrammingRootCommand {

    /**
     * {@inheritDoc}
     * This method will read a file and execute it from a user given file path.
     */
    @Override
    public void execute() {
        String userInput = canvasUtil.getUserInputCommandLineByLine();
//        userInput.substring(canvasUtil.getCurrentProgramExecutionIndex(), userInput.indexOf());
        String methodKey = "";
        String methodCodeBlock = "";
        canvasUtil.getMethodCodeBlock().put(methodKey, methodCodeBlock);
    }
}
