package com.narayanjoshi.gplapplication;

import com.narayanjoshi.gplapplication.service.CommandParser;
import com.narayanjoshi.gplapplication.util.CanvasUtil;
import javafx.scene.canvas.Canvas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoopCommandTest {

    /**
     * The test will run nested loop statement and nested loop statement
     * It will also check for move pointer to be  changed as and at the correct position at the end
     * as well as the variable values hold at the end to make sure data is correct.
     * */
    @Test
    public void loopStatementWithTrueCondition() {
        String command =
                "var x = 100\n" +
                        "   var y = 100\n" +
                        "   var num1 = 25\n" +
                        "   var num2 = 25\n" +
                        "   while num1< 200\n" +
                        "       moveto x,y\n" +
                        "       circle num1\n" +
                        "       while num2<200\n" +
                        "           triangle num2,num1\n" +
                        "           var num2 = num2 + 25\n" +
                        "           var x = x +5\n" +
                        "       endwhile\n" +
                        "   var num2 = 25\n" +
                        "   var num1 = num1 + 25\n" +
                        "   var y = y +5\n" +
                        "   endwhile";

        CanvasUtil canvasUtil = drawMock(command);

        Assertions.assertEquals(280, canvasUtil.getMoveX(), "move first param set to 280.");
        Assertions.assertEquals(130, canvasUtil.getMoveY(), "move second param set to 130 .");

        Assertions.assertEquals("310", canvasUtil.getVariableAndValues().get("x"), "x values changed to 310 i.e initial value changed.");

    }

    /**
     * The test will run loop statement and nested loop statement
     * It will also check for move pointer to be  changed as and at the correct position at the end
     * as well as the variable values hold at the end to make sure data is correct.
     * */
    @Test
    public void loopStatementWithDifferentLoopCondition() {
        String command =
                "var x = 100\n" +
                        "   var y = 100\n" +
                        "   var num1 = 25\n" + // change value from 25
                        "   while num1< 200\n" +
                        "       moveto x,y\n" +
                        "       circle num1\n" +
                        "   var num1 = num1 + 25\n" +
                        "   var y = y +5\n" +
                        "   endwhile";

        CanvasUtil canvasUtil = drawMock(command);

        Assertions.assertEquals(100, canvasUtil.getMoveX(), "move first param set to 100.");
        Assertions.assertEquals(130, canvasUtil.getMoveY(), "move second param set to 130 .");

        Assertions.assertEquals("100", canvasUtil.getVariableAndValues().get("x"), "x values unchanged to 100 i.e initial value remain.");


    }



    private CanvasUtil drawMock(String command){
        CanvasUtil canvasUtil = new CanvasUtil(new Canvas());
        CommandParser commandParser = new CommandParser(canvasUtil.getCanvasId(), null, command);
        commandParser.processTheGivenInstruction(false, null, command, canvasUtil, false);
        return canvasUtil;
    }
}
