package com.narayanjoshi.gplapplication.service.command.programming;

import com.narayanjoshi.gplapplication.service.RootCommand;
import com.narayanjoshi.gplapplication.util.CanvasUtil;
import com.narayanjoshi.gplapplication.util.Util;

/**
 * The {@code ProgrammingRootCommand} class represents super class for all programming operation.
 *
 * @author Narayan Joshi
 * @since v2.0
 * */
public abstract class ProgrammingRootCommand  extends RootCommand {

/**
 * this method is responsible to evaluate the condition for given expression
 * this one will be used for loop condition, if condition evaluation
 * */
    protected boolean evalCondition(String command, CanvasUtil canvasUtil) {
        boolean result;
        if (Util.containIgnoreCase(command, "<")) {
            String[] split = command.split("<");
            int operand1 = Util.getOperandValue(canvasUtil, split[0]);
            int operand2 = Util.getOperandValue(canvasUtil, split[1]);
            result = operand1 < operand2;
        } else if (Util.containIgnoreCase(command, ">")) {
            String[] split = command.split(">");
            int operand1 = Util.getOperandValue(canvasUtil, split[0]);
            int operand2 = Util.getOperandValue(canvasUtil, split[1]);
            result = operand1 > operand2;
        } else if (Util.containIgnoreCase(command, "<=")) {
            String[] split = command.split("<=");
            int operand1 = Util.getOperandValue(canvasUtil, split[0]);
            int operand2 = Util.getOperandValue(canvasUtil, split[1]);
            result = operand1 <= operand2;
        } else if (Util.containIgnoreCase(command, ">=")) {
            String[] split = command.split(">=");
            int operand1 = Util.getOperandValue(canvasUtil, split[0]);
            int operand2 = Util.getOperandValue(canvasUtil, split[1]);
            result = operand1 >= operand2;
        } else if (Util.containIgnoreCase(command, "!=")) {
            String[] split = command.split("!=");
            int operand1 = Util.getOperandValue(canvasUtil, split[0]);
            int operand2 = Util.getOperandValue(canvasUtil, split[1]);
            result = operand1 != operand2;
        } else if (Util.containIgnoreCase(command, "==")) {
            String[] split = command.split("==");
            int operand1 = Util.getOperandValue(canvasUtil, split[0]);
            int operand2 = Util.getOperandValue(canvasUtil, split[1]);
            result = operand1 == operand2;
        } else {
            throw new IllegalArgumentException("Invalid operator");
        }
        return result;
    }

}
