package com.example.gplapplication.service;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;

public class RectangleShape extends DrawShape{

    private int width, height;

    public final static String COMMAND="rectangle <x>,<y>";

    public RectangleShape(Canvas canvasId){
        super(canvasId);
    }

    @Override
    @FXML
    public void draw(String command) {
        System.out.println("Rectangle shape draw area.");

        //----------------------
        GraphicsContext gc = canvasId.getGraphicsContext2D();
        // Set the stroke and fill color.
        gc.setStroke(Color.BLUE);
        gc.setFill(Color.RED);

        gc.fillRect(200, 200, 100, 50);

    }
}
