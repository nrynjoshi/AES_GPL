package com.example.gplapplication.service;

import com.example.gplapplication.CommandNotFound;
import javafx.scene.canvas.Canvas;

public class DrawShape implements DrawShapeIfc {


    protected Canvas canvasId;

    protected DrawShape(Canvas canvasId){
        this.canvasId= canvasId;
    }

    @Override
    public void draw(String command) {
       throw new CommandNotFound("Implementation not done yet");
    }

    @Override
    public void setCanvas(Canvas canvas) {

    }
}
