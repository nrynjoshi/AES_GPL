package com.narayanjoshi.gplapplication;

import com.narayanjoshi.gplapplication.service.RootCommandIfc;
import com.narayanjoshi.gplapplication.service.command.CommandEnum;
import com.narayanjoshi.gplapplication.service.command.draw.*;
import com.narayanjoshi.gplapplication.util.CanvasUtil;
import com.narayanjoshi.gplapplication.util.Util;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasicDrawingCommandTest {

    /**
     * The test will run moveto command and check if values set as expected for processing.
     * It will also check for instance to processed particular moveto command has been invoked or not
     * */
    @Test
    public void moveTo() {
        String command = "moveto 100,150";
        CanvasUtil canvasUtil = new CanvasUtil(new Canvas());

        RootCommandIfc commandIfc = drawMock(command, canvasUtil);

        Assertions.assertEquals(100, canvasUtil.getMoveX(), "move first param not set properly.");
        Assertions.assertEquals(150, canvasUtil.getMoveY(), "move second param not set properly.");

        Assertions.assertEquals(MoveToCommand.class, commandIfc.getClass(), "moveto command parser class not invoke.");

    }

    /**
     * The test will run drawto command and check if values for moveto is 0,0.
     * It will also check for instance to processed particular drawto command has been invoked or not
     * */
    @Test
    public void drawto() {
        String command = "drawto 200,200";
        CanvasUtil canvasUtil = new CanvasUtil(new Canvas());

        RootCommandIfc commandIfc = drawMock(command, canvasUtil);

        Assertions.assertEquals(0, canvasUtil.getMoveX(), "move first param should be initial i.e. 0.");
        Assertions.assertEquals(0, canvasUtil.getMoveY(), "move second param should be initial i.e. 0");

        Assertions.assertEquals(DrawToCommand.class, commandIfc.getClass(), "drawto command parser class not invoke.");

    }

    /**
     * The test will run clear command and check if values for moveto has set as per expected after clear.
     * It will also check for instance to processed particular clear command has been invoked or not
     * */
    @Test
    public void clear() {

        CanvasUtil canvasUtil = new CanvasUtil(new Canvas());

        //draw something first
        String drawcommand = "drawto 200,200";
        drawMock(drawcommand, canvasUtil);

        //clear after draw complete
        String command = "clear";
        RootCommandIfc commandIfc = drawMock(command, canvasUtil);

        Assertions.assertEquals(0, canvasUtil.getMoveX(), "move first param should be initial i.e. 0.");
        Assertions.assertEquals(0, canvasUtil.getMoveY(), "move second param should be initial i.e. 0");

        Assertions.assertEquals(ClearCommand.class, commandIfc.getClass(), "clear command parser class not invoke.");

        //move pen something first
        String movecommand = "moveto 80,100";
        drawMock(movecommand, canvasUtil);

        //draw something after move
        String drawcommand_2 = "drawto 200,200";
        drawMock(drawcommand_2, canvasUtil);

        //clear after draw complete
        String clearcommand_2 = "clear";
        RootCommandIfc commandIfc_2 = drawMock(clearcommand_2, canvasUtil);

        Assertions.assertEquals(80, canvasUtil.getMoveX(), "move first param should be 80.");
        Assertions.assertEquals(100, canvasUtil.getMoveY(), "move second param should be 100.");

        Assertions.assertEquals(ClearCommand.class, commandIfc_2.getClass(), "clear command parser class not invoke.");


    }

    /**
     * The test will run clear command and check if values for moveto has set as per expected after clear.
     * It will also check for instance to processed particular clear command has been invoked or not
     * */
    @Test
    public void reset() {

        CanvasUtil canvasUtil = new CanvasUtil(new Canvas());

        //draw something first
        String drawcommand = "drawto 200,200";
        drawMock(drawcommand, canvasUtil);

        //clear after draw complete
        String command = "reset";
        RootCommandIfc commandIfc = drawMock(command, canvasUtil);

        Assertions.assertEquals(0, canvasUtil.getMoveX(), "move first param should be initial i.e. 0.");
        Assertions.assertEquals(0, canvasUtil.getMoveY(), "move second param should be initial i.e. 0");

        Assertions.assertEquals(ResetCommand.class, commandIfc.getClass(), "reset command parser class not invoke.");

        //move pen something first
        String movecommand = "moveto 80,100";
        drawMock(movecommand, canvasUtil);

        //draw something after move
        String drawcommand_2 = "drawto 200,200";
        drawMock(drawcommand_2, canvasUtil);

        //clear after draw complete
        String clearcommand_2 = "reset";
        RootCommandIfc commandIfc_2 = drawMock(clearcommand_2, canvasUtil);

        Assertions.assertEquals(0, canvasUtil.getMoveX(), "move first param should be initial i.e. 0.");
        Assertions.assertEquals(0, canvasUtil.getMoveY(), "move second param should be initial i.e. 0");

        Assertions.assertEquals(ResetCommand.class, commandIfc_2.getClass(), "reset command parser class not invoke.");


    }

    /**
     * The test will run rectangle command and check if values for moveto is 0,0.
     * It will also check for instance to processed particular rectangle command has been invoked or not
     * */
    @Test
    public void rectangle() {
        String command = "rectangle 50,100";
        CanvasUtil canvasUtil = new CanvasUtil(new Canvas());

        RootCommandIfc commandIfc = drawMock(command, canvasUtil);

        Assertions.assertEquals(0, canvasUtil.getMoveX(), "move first param should be initial i.e. 0.");
        Assertions.assertEquals(0, canvasUtil.getMoveY(), "move second param should be initial i.e. 0");

        Assertions.assertEquals(RectangleCommand.class, commandIfc.getClass(), "rectangle command parser class not invoke.");

    }

    /**
     * The test will run circle command and check if values for moveto is 0,0.
     * It will also check for instance to processed particular circle command has been invoked or not
     * */
    @Test
    public void circle() {
        String command = "Circle 50";
        CanvasUtil canvasUtil = new CanvasUtil(new Canvas());

        RootCommandIfc commandIfc = drawMock(command, canvasUtil);

        Assertions.assertEquals(0, canvasUtil.getMoveX(), "move first param should be initial i.e. 0.");
        Assertions.assertEquals(0, canvasUtil.getMoveY(), "move second param should be initial i.e. 0");

        Assertions.assertEquals(CircleCommand.class, commandIfc.getClass(), "circle command parser class not invoke.");

    }

    /**
     * The test will run triangle command and check if values for moveto is 0,0.
     * It will also check for instance to processed particular triangle command has been invoked or not
     * */
    @Test
    public void triangle() {
        String command = "triangle 50,100";
        CanvasUtil canvasUtil = new CanvasUtil(new Canvas());

        RootCommandIfc commandIfc = drawMock(command, canvasUtil);

        Assertions.assertEquals(0, canvasUtil.getMoveX(), "move first param should be initial i.e. 0.");
        Assertions.assertEquals(0, canvasUtil.getMoveY(), "move second param should be initial i.e. 0");

        Assertions.assertEquals(TriangleCommand.class, commandIfc.getClass(), "triangle command parser class not invoke.");

    }

    /**
     * The test will run pen command.
     * It will also check for instance to processed particular pen command has been invoked or not
     * */
    @Test
    public void pen() {
        String command = "pen red";
        CanvasUtil canvasUtil = new CanvasUtil(new Canvas());

        RootCommandIfc commandIfc = drawMock(command, canvasUtil);

         Assertions.assertEquals(Color.RED, canvasUtil.getPenColor(), "pen color should be red.");

        Assertions.assertEquals(PenCommand.class, commandIfc.getClass(), "pen command parser class not invoke.");

    }

    /**
     * The test will run fill command.
     * It will also check for instance to processed particular fill command has been invoked or not
     * */
    @Test
    public void fill() {
        String command = "fill on";
        CanvasUtil canvasUtil = new CanvasUtil(new Canvas());

        RootCommandIfc commandIfc = drawMock(command, canvasUtil);

        Assertions.assertTrue(canvasUtil.isFillOn(), "fill should be on.");

        Assertions.assertEquals(FillCommand.class, commandIfc.getClass(), "fill command parser class not invoke.");

    }

    private RootCommandIfc drawMock(String command, CanvasUtil canvasUtil){
        CommandEnum commandEnum= Util.getCommandOperation(command);

        RootCommandIfc gplEngine = commandEnum.getCommandInstance();
        gplEngine.init(canvasUtil, commandEnum);
        gplEngine.draw(command);
        return gplEngine;
    }

}
