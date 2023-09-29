package com.example.gplapplication.service;

import com.example.gplapplication.CanvasUtil;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TriangleShape  extends DrawShape{

    public final static String COMMAND="triangle <x>,<y>";

    public TriangleShape(CanvasUtil canvasUtil){
        super(canvasUtil);
    }


    @Override
    public void draw(String command) {
        System.out.println("Triangle shape draw area.");
        // Below lines are for shaping Triangle
        canvasUtil.moveTo(35, 35);
        canvasUtil.lineTo(155, 35);
        canvasUtil.lineTo(155, 155);
        canvasUtil.lineTo(35, 35);
        canvasUtil.getGraphicsContext().stroke();
    }
}
