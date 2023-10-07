package com.narayanjoshi.gplapplication;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CanvasUtil{

    protected Canvas canvasId;
    protected GraphicsContext graphicsContext;

    private double moveX;
    private double moveY;

    private boolean isRun = true;

    private boolean isFillOn = false;

    private Color penColor = Color.BLACK;

    private String userInputCommands=null;

    public CanvasUtil(Canvas canvasId){
        init(canvasId, true);
    }

    public CanvasUtil(Canvas canvasId, boolean isRun){
        init(canvasId, isRun);
    }

    private void init(Canvas canvasId, boolean isRun){
        if(canvasId ==null){
            throw new IllegalArgumentException("Canvas cannot be null.");
        }
        this.canvasId= canvasId;
        this.graphicsContext = canvasId.getGraphicsContext2D();
        this.graphicsContext.beginPath();
        this.isRun = isRun;
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

    public void setFillOn(boolean fillOn) {
        isFillOn = fillOn;
    }

    public boolean isFillOn() {
        return isFillOn;
    }

    public void setPenColor(Color penColor) {
        this.penColor = penColor;
    }

    public Color getPenColor() {
        return penColor;
    }

}
