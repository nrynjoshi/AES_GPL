package com.narayanjoshi.gplapplication.service.command;

import com.narayanjoshi.gplapplication.CommandNotFound;
import com.narayanjoshi.gplapplication.Util;
import com.narayanjoshi.gplapplication.service.RootCommand;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.List;

public class PenCommand extends RootCommand {

    @Override
    public void validate(String command) {
        Util.validateCommand(command, this.command, this.param);
        String color = Util.getAllParameterFromCommand(command).get(0);
        try{
            Color.valueOf(color);
        }catch (IllegalArgumentException e){
            throw new CommandNotFound(String.format("'%s' command attribute values does not exist.\nError on '%s'.",this.command, command), -1);
        }


    }

    @Override
    public void draw(String command) {
        this.validate(command);
        List<String> param = Util.getAllParameterFromCommand(command);
        Color color = Color.valueOf(param.get(0));
        canvasUtil.setPenColor(color);
        if(canvasUtil.isFillOn()){
            canvasUtil.getGraphicsContext().setFill(canvasUtil.getPenColor());
        }else{
            canvasUtil.getGraphicsContext().setStroke(canvasUtil.getPenColor());
        }
    }
}
