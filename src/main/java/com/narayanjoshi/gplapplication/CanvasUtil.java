package com.narayanjoshi.gplapplication;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 * The {@code CanvasUtil} class represents all instance of canvas and hold all type of
 * data necessary for canvas and display work.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class CanvasUtil{

    /**
     * @see Canvas
     * */
    protected Canvas canvasId;
    /**
     * @see GraphicsContext
     * */
    protected GraphicsContext graphicsContext;
    /**
     * hold pen X position for drawing
     * */
    private double moveX;
    /**
     * hold pen Y position for drawing
     * */
    private double moveY;
    /**
     * if true run the command else just syntax check of the particular instruction
     * */
    private boolean isRun = true;
    /**
     * if true fill the drawing shape else just draw using outline or stroke
     * */
    private boolean isFillOn = false;
    /**
     * holds the pen color for drawing and by default it will be set as black
     * */
    private Color penColor = Color.BLACK;
    /**
     * holds the user submit instruction
     * */
    private String userInputCommands=null;
    /**
     * this contractor will run the instruction by default
     * */
    public CanvasUtil(Canvas canvasId){
        init(canvasId, true);
    }
    /**
     * this constructor will run or validate syntax as per the @see isRun boolean flag
     * */
    public CanvasUtil(Canvas canvasId, boolean isRun){
        init(canvasId, isRun);
    }
    /**
     * initialize the canvas, graphics and other basic flag to operation drawing and related command
     * */
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
