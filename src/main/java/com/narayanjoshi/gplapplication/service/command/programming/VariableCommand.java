package com.narayanjoshi.gplapplication.service.command.programming;

import com.narayanjoshi.gplapplication.exception.CommandNotFoundException;
import com.narayanjoshi.gplapplication.util.CanvasUtil;
import com.narayanjoshi.gplapplication.util.Util;

import java.util.Map;

public class VariableCommand extends ProgrammingRootCommand {


    @Override
    public void validate() {

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
        String resultVariableName = split[0];
        String expression = split[1];

        //ignore this as it is comment no process
        canvasUtil.getVariableAndValues().put(resultVariableName, String.valueOf(arithmeticOperation(expression)));

    }

    private double arithmeticOperation(String expression) {
        double result;
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
            result = (double) operand1 / operand2;
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
