package com.narayanjoshi.gplapplication.service.command;

import com.narayanjoshi.gplapplication.Util;
import com.narayanjoshi.gplapplication.service.RootCommand;

import java.util.List;

public class RectangleCommand extends RootCommand {

    @Override
    public void draw(String command) {

        this.validate(command);

        List<String> params = Util.getAllParameterFromCommand(command);

        double width = Float.parseFloat(params.get(0));
        double height = Float.parseFloat(params.get(1));

        canvasUtil.getGraphicsContext().strokeRect(canvasUtil.getMoveX(), canvasUtil.getMoveY(), width,height);
    }
}
