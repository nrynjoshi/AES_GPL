package com.narayanjoshi.gplapplication.service.command.programming;

import com.narayanjoshi.gplapplication.service.RootCommand;
import com.narayanjoshi.gplapplication.util.CanvasUtil;
import com.narayanjoshi.gplapplication.util.Util;

public abstract class ProgrammingRootCommand  extends RootCommand {


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
