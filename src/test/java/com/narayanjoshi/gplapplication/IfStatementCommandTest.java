package com.narayanjoshi.gplapplication;

import com.narayanjoshi.gplapplication.service.CommandParser;
import com.narayanjoshi.gplapplication.service.RootCommandIfc;
import com.narayanjoshi.gplapplication.service.command.CommandEnum;
import com.narayanjoshi.gplapplication.service.command.draw.MoveToCommand;
import com.narayanjoshi.gplapplication.service.command.programming.IFStatementCommand;
import com.narayanjoshi.gplapplication.util.CanvasUtil;
import com.narayanjoshi.gplapplication.util.Util;
import javafx.scene.canvas.Canvas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IfStatementCommandTest {


    /**
     * The test will run if statement command with valid condition.
     * It will also check for move pointer not be changed as well as the variable values hold at the end to make sure data is correct.
     * */
    @Test
    public void ifStatementWithTrueCondition() {
        String command =
                "clear\n" +
                        "   var a=5\n" +
                        "   if a<50\n" + //this statement will be reverse for two different test case
                        "       circle a\n" +
                        "       var a = a+ 80\n" +
                        "   endif\n" +
                        "   circle a";

        CanvasUtil canvasUtil = drawMock(command);

        Assertions.assertEquals(0, canvasUtil.getMoveX(), "move first param not set properly.");
        Assertions.assertEquals(0, canvasUtil.getMoveY(), "move second param not set properly.");

        Assertions.assertEquals("85", canvasUtil.getVariableAndValues().get("a"), "a values changed to 85 i.e initial value changed.");

    }


    /**
     * The test will run if statement command with false condition.
     * It will also check for move pointer not be changed as well as the variable values hold at the end to make sure data is correct.
     * */
    @Test
    public void ifStatementWithFalseCondition() {
        String command =
                "clear\n" +
                        "   var a=5\n" +
                        "   if a>50\n" +
                        "       circle a\n" +
                        "       var a = a+ 80\n" +
                        "   endif\n" +
                        "   circle a";

        CanvasUtil canvasUtil = drawMock(command);

        Assertions.assertEquals(0, canvasUtil.getMoveX(), "move first param not set properly.");
        Assertions.assertEquals(0, canvasUtil.getMoveY(), "move second param not set properly.");

        Assertions.assertEquals("5", canvasUtil.getVariableAndValues().get("a"), "a values does not changed here because if condition false.");


    }



    private CanvasUtil drawMock(String command){
        CanvasUtil canvasUtil = new CanvasUtil(new Canvas());
        CommandParser commandParser = new CommandParser(canvasUtil.getCanvasId(), null, command);
        commandParser.processTheGivenInstruction(false, null, command, canvasUtil, false);
        return canvasUtil;
    }
}
