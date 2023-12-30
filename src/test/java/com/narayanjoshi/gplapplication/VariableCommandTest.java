package com.narayanjoshi.gplapplication;

import com.narayanjoshi.gplapplication.exception.CommandNotFoundException;
import com.narayanjoshi.gplapplication.service.RootCommandIfc;
import com.narayanjoshi.gplapplication.service.command.CommandEnum;
import com.narayanjoshi.gplapplication.service.command.draw.CircleCommand;
import com.narayanjoshi.gplapplication.service.command.draw.FillCommand;
import com.narayanjoshi.gplapplication.service.command.programming.VariableCommand;
import com.narayanjoshi.gplapplication.util.CanvasUtil;
import com.narayanjoshi.gplapplication.util.Util;
import javafx.scene.canvas.Canvas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VariableCommandTest {

    /**
     * The test case will check for simple variable init.
     * */
    @Test
    public void simpleVariableInitTest() {
        String command = "var x=5";
        CanvasUtil canvasUtil = new CanvasUtil(new Canvas());

        RootCommandIfc commandIfc = drawMock(command, canvasUtil);

        Assertions.assertEquals("5", canvasUtil.getVariableAndValues().get("x"), "x values does not changed here.");

        Assertions.assertEquals(VariableCommand.class, commandIfc.getClass(), "Variable command parser class not invoke.");

    }

    /**
     * The test case will check for variable initialize with two values addition.
     * */
    @Test
    public void arithmeticVariableInitTest() {
        String command = "var x=100+5";
        CanvasUtil canvasUtil = new CanvasUtil(new Canvas());

        RootCommandIfc commandIfc = drawMock(command, canvasUtil);

        Assertions.assertEquals("105", canvasUtil.getVariableAndValues().get("x"), "x values changed to 105.");

        Assertions.assertEquals(VariableCommand.class, commandIfc.getClass(), "variable command parser class not invoke.");

    }

    /**
     * The test case will check for variable initialize with two values addition and modified at some stage of program running.
     * and This test also cover variable should be passed and calculated on arithmetician operation.
     * and variable can be used as draw parameter
     * */
    @Test
    public void arithmeticVariableWithVariablePassInitTest() {
        String commandInit = "var x=100+5";
        CanvasUtil canvasUtil = new CanvasUtil(new Canvas());

        RootCommandIfc commandIfcInit = drawMock(commandInit, canvasUtil);

        Assertions.assertEquals("105", canvasUtil.getVariableAndValues().get("x"), "x values changed to 105.");

        Assertions.assertEquals(VariableCommand.class, commandIfcInit.getClass(), "variable command parser class not invoke.");

        String command = "var x=x+50";

        RootCommandIfc commandIfc = drawMock(command, canvasUtil);

        Assertions.assertEquals("155", canvasUtil.getVariableAndValues().get("x"), "x values changed to 155.");

        Assertions.assertEquals(VariableCommand.class, commandIfc.getClass(), "variable command parser class not invoke.");

        String commandDraw = "circle x";

        RootCommandIfc commandIfcDraw = drawMock(commandDraw, canvasUtil);

        Assertions.assertEquals(CircleCommand.class, commandIfcDraw.getClass(), "circle command parser class not invoke.");

    }

    /**
     * The test case will check for variable initialize with two values addition and modified at some stage of program running.
     * and This test also cover variable should be passed and calculated on arithmetician operation.
     * */
    @Test
    public void arithmeticMulOnVariableWithVariablePassInitTest() {
        String commandInit = "var x=5";
        CanvasUtil canvasUtil = new CanvasUtil(new Canvas());

        RootCommandIfc commandIfcInit = drawMock(commandInit, canvasUtil);


        Assertions.assertEquals(VariableCommand.class, commandIfcInit.getClass(), "variable command parser class not invoke.");

        String command = "var x=x*10";

        RootCommandIfc commandIfc = drawMock(command, canvasUtil);

        Assertions.assertEquals("50", canvasUtil.getVariableAndValues().get("x"), "x values changed to 50.");
        Assertions.assertEquals(VariableCommand.class, commandIfc.getClass(), "variable command parser class not invoke.");


    }

    /**
     * The test case will check for variable initialize with two values addition and modified at some stage of program running.
     * and This test also cover variable should be passed and calculated on arithmetician operation.
     * */
    @Test
    public void arithmeticMulOnVariableWithInvalidRightSideValueTest() {
        String commandInit = "var x=";
        CanvasUtil canvasUtil = new CanvasUtil(new Canvas());

        Assertions.assertThrows(
                CommandNotFoundException.class,
                () -> drawMock(commandInit, canvasUtil),
                "Variables right hand side portion is blank.'=' operator right hand side variable value is missing."
        );



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
