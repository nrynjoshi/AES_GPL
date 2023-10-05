package com.narayanjoshi.gplapplication.service.command;

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
    }

    @Override
    public void draw(String command) {
        this.validate(command);
        List<String> param = Util.getAllParameterFromCommand(command);
        Color color = Color.valueOf(param.get(0));
        canvasUtil.getGraphicsContext().setStroke(color);
    }
}
