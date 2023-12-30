package com.narayanjoshi.gplapplication.service.command.programming;

import com.narayanjoshi.gplapplication.exception.CommandNotFoundException;
import com.narayanjoshi.gplapplication.exception.CommandProcessingException;
import com.narayanjoshi.gplapplication.util.CanvasUtil;
import com.narayanjoshi.gplapplication.util.Util;

import java.util.Map;

public class VariableCommand extends ProgrammingRootCommand {

    /**
     * {@inheritDoc}
     * This method will validate a user input command.
     */
    @Override
    public void validate() {
        if(paramList.isEmpty()){
            throw new CommandNotFoundException("Variables command is not valid. ie var a=5. ", -1);
        }
        String userParam = paramList.get(0);

        if(!userParam.contains("=")){
            throw new CommandNotFoundException("Variables command is not valid. '=' operator is missing.", -1);
        }

        String[] split = userParam.split("=");
        String resultVariableName = split[0].trim();
        if(split.length != 2 || resultVariableName.isEmpty()){
            throw new CommandNotFoundException("Variables command is not valid.'=' operator left hand side variable name is missing.", -1);
        }

        String resultVariableVal = split[1].trim();

        if(split.length != 2 || resultVariableVal.isEmpty()){
            throw new CommandNotFoundException("Variables right hand side portion is blank.'=' operator right hand side variable value is missing.", -1);
        }
        String expression = split[1].trim();

        try {
            arithmeticOperation(expression);
        }catch (Exception x){
            throw new CommandNotFoundException("The Expression is not valid.", -1);
        }

    }

    /**
     * {@inheritDoc}
     * This method will ignore this particular line for commenting code.
     * Nothing can be happened just no operation
     */
    @Override
    public void execute() {
        String userParam = paramList.get(0);
        String[] split = userParam.split("=");
        String resultVariableName = split[0].trim();
        String expression = split[1].trim();

        //ignore this as it is comment no process
        canvasUtil.getVariableAndValues().put(resultVariableName, String.valueOf(arithmeticOperation(expression)));

    }

    private int arithmeticOperation(String expression) {
        int result;
        if (Util.containIgnoreCase(expression, "+")) {
            String[] splitVariableValue = expression.split("[+]");
            int operand1 = Util.getOperandValue(canvasUtil, splitVariableValue[0]);
            int operand2 = Util.getOperandValue(canvasUtil, splitVariableValue[1]);
            result = operand1 + operand2;
        } else if (Util.containIgnoreCase(expression, "-")) {
            String[] splitVariableValue = expression.split("-");
            int operand1 = Util.getOperandValue(canvasUtil, splitVariableValue[0]);
            int operand2 = Util.getOperandValue(canvasUtil, splitVariableValue[1]);
            result = operand1 - operand2;
        } else if (Util.containIgnoreCase(expression, "/")) {
            String[] splitVariableValue = expression.split("/");
            int operand1 = Util.getOperandValue(canvasUtil, splitVariableValue[0]);
            int operand2 = Util.getOperandValue(canvasUtil, splitVariableValue[1]);
            result = operand1 / operand2;
        } else if (Util.containIgnoreCase(expression, "*")) {
            String[] splitVariableValue = expression.split("[*]");
            int operand1 = Util.getOperandValue(canvasUtil, splitVariableValue[0]);
            int operand2 = Util.getOperandValue(canvasUtil, splitVariableValue[1]);
            result = operand1 * operand2;
        }  else {
            result = Util.getOperandValue(canvasUtil, expression);
        }
        return result;
    }

}
