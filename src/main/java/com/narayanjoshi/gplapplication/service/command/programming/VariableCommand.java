package com.narayanjoshi.gplapplication.service.command.programming;

import com.narayanjoshi.gplapplication.exception.CommandNotFoundException;

import java.util.Map;

public class VariableCommand extends ProgrammingRootCommand {

    /**
     * {@inheritDoc}
     * This method will ignore this particular line for commenting code.
     * Nothing can be happened just no operation
     */
    @Override
    public void execute() {
        String userParam = paramList.get(0);
        String[] split = userParam.split("=");
        String variableName = split[0];
        String variableValue = split[1];
        if(canvasUtil.getVariableAndValues().containsKey(variableValue)){
            throw new CommandNotFoundException(variableName+" has defined already.", -1);
        }
        //ignore this as it is comment no process
        canvasUtil.getVariableAndValues().put(variableName, variableValue);

    }

}
