package com.narayanjoshi.gplapplication;

import com.narayanjoshi.gplapplication.service.RootCommandIfc;
import com.narayanjoshi.gplapplication.service.command.MoveToCommand;
import javafx.scene.canvas.Canvas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasicDrawingCommandTest {

    /**
     * The test will run moveto command and check if values set as expected for processing.
     * It will also check for instance to processed particular moveto command has been invoke or not
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


    private RootCommandIfc drawMock(String command, CanvasUtil canvasUtil){
        CommandEnum commandEnum=Util.getCommandOperation(command);

        RootCommandIfc gplEngine = commandEnum.getCommandInstance();
        gplEngine.init(canvasUtil, commandEnum);
        gplEngine.draw(command);
        return gplEngine;
    }

}
