package com.narayanjoshi.gplapplication.service.command;

import com.narayanjoshi.gplapplication.CommandEnum;
import com.narayanjoshi.gplapplication.CommandNotFound;
import com.narayanjoshi.gplapplication.Util;
import com.narayanjoshi.gplapplication.service.RootCommand;
import com.narayanjoshi.gplapplication.service.RootCommandIfc;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.List;

public class FillCommand extends RootCommand {

    @Override
    public void draw(String command) {
        this.validate(command);

        List<String> params = Util.getAllParameterFromCommand(command);
        String param1 = params.get(0);
        canvasUtil.setFillOn(param1.equalsIgnoreCase("on"));

        RootCommandIfc penCommand = CommandEnum.PEN.getCommandInstance();;
        penCommand.draw(CommandEnum.PEN.getCommand()+" "+canvasUtil.getPenColor());
    }
}