package com.example.gplapplication;

import com.example.gplapplication.service.command.ClearCommand;
import com.example.gplapplication.service.command.MoveToCommand;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CanvasUtil{

    protected Canvas canvasId;
    protected GraphicsContext graphicsContext;

    private double moveX;
    private double moveY;

    private boolean isRun = true;

    private String userInputCommands=null;

    public CanvasUtil(Canvas canvasId){
        this.canvasId= canvasId;
        this.graphicsContext = canvasId.getGraphicsContext2D();
        this.graphicsContext.beginPath();
    }

    public CanvasUtil(Canvas canvasId, boolean isRun){
        this.canvasId= canvasId;
        this.graphicsContext = canvasId.getGraphicsContext2D();
        this.graphicsContext.beginPath();
        this.isRun = false;
    }

    public Canvas getCanvasId() {
        return canvasId;
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public double getMoveX() {
        return moveX;
    }

    public void setMoveX(double moveX) {
        this.moveX = moveX;
    }

    public double getMoveY() {
        return moveY;
    }

    public void setMoveY(double moveY) {
        this.moveY = moveY;
    }


    public boolean isRun() {
        return this.isRun;
    }

    public String getUserInputCommands() {
        return userInputCommands;
    }

    public void setUserInputCommands(String userInputCommands) {
        this.userInputCommands = userInputCommands;
    }
}
