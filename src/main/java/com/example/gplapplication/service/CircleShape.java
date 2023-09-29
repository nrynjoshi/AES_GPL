package com.example.gplapplication.service;

import com.example.gplapplication.CanvasUtil;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CircleShape  extends DrawShape{

    public final static String COMMAND="circle <x>,<y>";

    public CircleShape(CanvasUtil canvasUtil){
        super(canvasUtil);
    }


    @Override
    public void draw(String command) {
        System.out.println("Circle shape draw area.");

        // Set the stroke and fill color.
        canvasUtil.getGraphicsContext().setStroke(Color.BLUE);
        canvasUtil.getGraphicsContext().setFill(Color.RED);

        canvasUtil.getGraphicsContext().fillOval(200, 200, 50, 50);
    }
}
