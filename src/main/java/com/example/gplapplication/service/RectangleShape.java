package com.example.gplapplication.service;

import com.example.gplapplication.CanvasUtil;
import com.example.gplapplication.CommandEnum;
import com.example.gplapplication.Util;
import javafx.fxml.FXML;

import java.util.List;

public class RectangleShape extends DrawShape{

    private int width, height;

    public final static String COMMAND= CommandEnum.RECTANGLE.getCommand();

    public RectangleShape(CanvasUtil canvasUtil){
        super(canvasUtil);
    }

    @Override
    @FXML
    public void draw(String command) {

        Util.validateCommand(command, this.COMMAND);
        List<String> params = Util.getAllParameterFromCommand(command);

        System.out.println("Rectangle shape draw area.");

        double moveX = canvasUtil.getMoveX();
        double moveY = canvasUtil.getMoveY();

        double width = Float.parseFloat(params.get(0))+ moveX;
        double height = Float.parseFloat(params.get(1))+ moveY;

        canvasUtil.lineTo(width, moveY);
        canvasUtil.lineTo(width, height);
        canvasUtil.lineTo(moveX, height);
        canvasUtil.lineTo(moveX, moveY);
        canvasUtil.getGraphicsContext().stroke();
    }
}
