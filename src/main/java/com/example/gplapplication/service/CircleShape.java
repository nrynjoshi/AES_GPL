package com.example.gplapplication.service;

import com.example.gplapplication.CanvasUtil;
import com.example.gplapplication.Util;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class CircleShape  extends DrawShape{

    public final static String COMMAND="circle <radius>";

    public CircleShape(CanvasUtil canvasUtil){
        super(canvasUtil);
    }


    @Override
    public void draw(String command) {
        Util.validateCommand(command, this.COMMAND);
        List<String> params = Util.getAllParameterFromCommand(command);

        System.out.println("Circle shape draw area.");
        // Below lines are for shaping Triangle

        double moveX = canvasUtil.getMoveX();
        double moveY = canvasUtil.getMoveY();

        double radius = Float.parseFloat(params.get(0))+ moveX;

        // Set the stroke and fill color.
        canvasUtil.getGraphicsContext().setStroke(Color.BLUE);
        canvasUtil.getGraphicsContext().setFill(Color.RED);

        canvasUtil.getGraphicsContext().strokeOval(moveX, moveY, radius, radius);
        canvasUtil.getGraphicsContext().stroke();
    }
}
