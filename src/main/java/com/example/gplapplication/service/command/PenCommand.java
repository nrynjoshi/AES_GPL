package com.example.gplapplication.service.command;

import com.example.gplapplication.CanvasUtil;
import com.example.gplapplication.CommandEnum;
import com.example.gplapplication.Util;
import com.example.gplapplication.service.RootCommand;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.List;

public class PenCommand extends RootCommand {

    public static final List<Color> pen_colors= Arrays.asList(Color.RED, Color.BLACK, Color.YELLOW, Color.GREEN, Color.GRAY);


    public PenCommand(CanvasUtil canvasUtil){
        super(canvasUtil, CommandEnum.PEN);
    }

    @Override
    public void validate(String command) {
        Util.validateCommand(command, this.COMMAND);
    }

    @Override
    public void draw(String command) {
        this.validate(command);
        List<String> param = Util.getAllParameterFromCommand(command);
        Color color = Color.valueOf(param.get(0));
        canvasUtil.getGraphicsContext().setStroke(color);
    }
}
