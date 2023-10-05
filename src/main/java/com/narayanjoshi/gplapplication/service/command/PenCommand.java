package com.narayanjoshi.gplapplication.service.command;

import com.narayanjoshi.gplapplication.CommandNotFound;
import com.narayanjoshi.gplapplication.Util;
import com.narayanjoshi.gplapplication.service.RootCommand;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.List;

public class PenCommand extends RootCommand {

    public static final List<Color> pen_colors= Arrays.asList(Color.RED, Color.BLACK, Color.YELLOW, Color.GREEN, Color.GRAY);


    @Override
    public void validate(String command) {
        Util.validateCommand(command, this.command, this.param);
        String color = Util.getAllParameterFromCommand(command).get(0);
        Color penColor = Color.valueOf(color);
        boolean isPenColorContains = pen_colors.contains(penColor);
        if(!isPenColorContains){
            throw new CommandNotFound(String.format("'%s' pen parameter color is not valid one. Please check docs",command), -1);
        }
    }

    @Override
    public void draw(String command) {
        this.validate(command);
        List<String> param = Util.getAllParameterFromCommand(command);
        Color color = Color.valueOf(param.get(0));
        canvasUtil.getGraphicsContext().setStroke(color);
    }
}
