package com.example.gplapplication.service;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CircleShape  extends DrawShape{

    public final static String COMMAND="circle <x>,<y>";

    public CircleShape(Canvas canvasId){
        super(canvasId);
    }


    @Override
    public void draw(String command) {
        System.out.println("Circle shape draw area.");

        GraphicsContext gc = canvasId.getGraphicsContext2D();
        // Set the stroke and fill color.
        gc.setStroke(Color.BLUE);
        gc.setFill(Color.RED);

        gc.fillOval(200, 200, 50, 50);
    }
}
