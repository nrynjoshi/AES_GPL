package com.narayanjoshi.gplapplication;

import com.narayanjoshi.gplapplication.service.CommandParser;
import com.narayanjoshi.gplapplication.service.RootCommandIfc;
import com.narayanjoshi.gplapplication.service.command.CommandEnum;
import com.narayanjoshi.gplapplication.service.command.draw.CircleCommand;
import com.narayanjoshi.gplapplication.service.command.programming.MethodCallCommand;
import com.narayanjoshi.gplapplication.service.command.programming.MethodDefCommand;
import com.narayanjoshi.gplapplication.util.CanvasUtil;
import com.narayanjoshi.gplapplication.util.Util;
import javafx.scene.canvas.Canvas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MethodCommandTest {


    /**
     * The test will defined a method definition and call a method statement
     * */
    @Test
    public void methodDefAndCallTest() {
        String command =
                "def testMethod a, b\n" +
                        "var i =40\n" +
                        "circle i\n" +
                        "endMethod";

        CanvasUtil canvasUtil = drawMock(command);

        RootCommandIfc commandIfcDef = drawMock(command, canvasUtil);

        Assertions.assertEquals(MethodDefCommand.class, commandIfcDef.getClass(), "method def command parser class not invoke.");
        Assertions.assertNotNull(canvasUtil.getMethodCodeBlock().get("testMethod"), "method def command parser class found.");


        String commandDraw = "methodCall testMethod";

        RootCommandIfc commandIfcCall = drawMock(commandDraw, canvasUtil);

        Assertions.assertEquals(MethodCallCommand.class, commandIfcCall.getClass(), "method call command parser class not invoke.");
    }




    private CanvasUtil drawMock(String command){
        CanvasUtil canvasUtil = new CanvasUtil(new Canvas());
        CommandParser commandParser = new CommandParser(canvasUtil.getCanvasId(), null, command);
        commandParser.processTheGivenInstruction(false, null, command, canvasUtil, false);
        return canvasUtil;
    }

    private RootCommandIfc drawMock(String command, CanvasUtil canvasUtil){
        CommandEnum commandEnum= Util.getCommandOperation(command);

        RootCommandIfc gplEngine = commandEnum.getCommandInstance();
        canvasUtil.setUserInputCommandLineByLine(command);
        gplEngine.init(canvasUtil, commandEnum);

        gplEngine.validate();
        gplEngine.execute();
        return gplEngine;
    }
}
