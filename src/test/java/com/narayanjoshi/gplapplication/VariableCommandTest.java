package com.narayanjoshi.gplapplication;

import com.narayanjoshi.gplapplication.service.RootCommandIfc;
import com.narayanjoshi.gplapplication.service.command.CommandEnum;
import com.narayanjoshi.gplapplication.service.command.programming.VariableCommand;
import com.narayanjoshi.gplapplication.util.CanvasUtil;
import com.narayanjoshi.gplapplication.util.Util;
import javafx.scene.canvas.Canvas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VariableCommandTest {

    @Test
    public void simpleVariableInitTest() {
        String command = "var x=5";
        CanvasUtil canvasUtil = new CanvasUtil(new Canvas());

        RootCommandIfc commandIfc = drawMock(command, canvasUtil);

        Assertions.assertEquals("5", canvasUtil.getVariableAndValues().get("x"), "a values does not changed here because if condition false.");

        Assertions.assertEquals(VariableCommand.class, commandIfc.getClass(), "fill command parser class not invoke.");

    }

    @Test
    public void arithmeticVariableInitTest() {
        String command = "var x=100+5";
        CanvasUtil canvasUtil = new CanvasUtil(new Canvas());

        RootCommandIfc commandIfc = drawMock(command, canvasUtil);

        Assertions.assertEquals("105", canvasUtil.getVariableAndValues().get("x"), "a values does not changed here because if condition false.");

        Assertions.assertEquals(VariableCommand.class, commandIfc.getClass(), "fill command parser class not invoke.");

    }

    @Test
    public void arithmeticVariableWithVariablePassInitTest() {
        String commandInit = "var x=100+5";
        CanvasUtil canvasUtil = new CanvasUtil(new Canvas());

        RootCommandIfc commandIfcInit = drawMock(commandInit, canvasUtil);

        Assertions.assertEquals("105", canvasUtil.getVariableAndValues().get("x"), "a values does not changed here because if condition false.");

        Assertions.assertEquals(VariableCommand.class, commandIfcInit.getClass(), "fill command parser class not invoke.");

        String command = "var x=x+50";

        RootCommandIfc commandIfc = drawMock(command, canvasUtil);

        Assertions.assertEquals("155", canvasUtil.getVariableAndValues().get("x"), "a values does not changed here because if condition false.");

        Assertions.assertEquals(VariableCommand.class, commandIfc.getClass(), "fill command parser class not invoke.");



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
