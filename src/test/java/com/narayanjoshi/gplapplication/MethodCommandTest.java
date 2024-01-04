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
                "def testmethod a, b\n" +
                        "var i =40\n" +
                        "circle i\n" +
                        "endMethod";


        CanvasUtil canvasUtil = new CanvasUtil(new Canvas());
        CommandParser commandIfcDef = new CommandParser(canvasUtil.getCanvasId(), null, command);
        commandIfcDef.processTheGivenInstruction(false, null, command, canvasUtil, false);

        Assertions.assertNotNull(canvasUtil.getMethodCodeBlock().get("testmethod"), "method def command parser class found.");


        String commandDraw = "methodCall testmethod";

        RootCommandIfc commandIfcCall = drawMock(commandDraw, canvasUtil);

        Assertions.assertEquals(MethodCallCommand.class, commandIfcCall.getClass(), "method call command parser class not invoke.");
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
