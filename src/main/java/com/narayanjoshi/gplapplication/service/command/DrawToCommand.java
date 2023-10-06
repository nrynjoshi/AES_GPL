package com.narayanjoshi.gplapplication.service.command;

import com.narayanjoshi.gplapplication.Util;
import com.narayanjoshi.gplapplication.service.RootCommand;

import java.util.List;

public class DrawToCommand extends RootCommand {

    @Override
    public void draw(String command) {
        this.validate(command);
        List<String> params = Util.getAllParameterFromCommand(command);

        double x = Float.parseFloat(params.get(0));
        double y = Float.parseFloat(params.get(1));

        if(canvasUtil.isFillOn()){
            canvasUtil.getGraphicsContext().strokeLine(canvasUtil.getMoveX(), canvasUtil.getMoveY(), x, y);
        }else{
            canvasUtil.getGraphicsContext().strokeLine(canvasUtil.getMoveX(), canvasUtil.getMoveY(), x, y);
        }

    }
}
