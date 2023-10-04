package com.example.gplapplication.service;

import com.example.gplapplication.CanvasUtil;
import com.example.gplapplication.CommandNotFound;
import com.example.gplapplication.Util;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.List;

public class DrawShape implements DrawShapeIfc {

    public static final List<Color> pen_colors= Arrays.asList(Color.RED, Color.BLACK, Color.YELLOW, Color.GREEN, Color.GRAY);

    protected CanvasUtil canvasUtil;

    public DrawShape(CanvasUtil canvasUtil){
        this.canvasUtil= canvasUtil;
    }

    @Override
    public void draw(String command) {
       throw new CommandNotFound("Implementation not done yet", 1);
    }


}
