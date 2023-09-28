package com.example.gplapplication.service;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TriangleShape  extends DrawShape{

    public final static String COMMAND="triangle <x>,<y>";

    public TriangleShape(Canvas canvasId){
        super(canvasId);
    }


    @Override
    public void draw(String command) {
        System.out.println("Triangle shape draw area.");

        GraphicsContext graphicsContext = canvasId.getGraphicsContext2D();
        graphicsContext.beginPath();
        // Below lines are for shaping Triangle
        graphicsContext.moveTo(35, 35);
        graphicsContext.lineTo(155, 35);
        graphicsContext.lineTo(155, 155);
        graphicsContext.lineTo(35, 35);
        graphicsContext.stroke();
    }
}
