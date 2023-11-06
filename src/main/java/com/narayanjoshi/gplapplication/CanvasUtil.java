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
     * This will hold the Canvas instance for processing.
     * @see Canvas
     * */
    protected static Canvas canvasId;
    /**
     * This will hold graphicsContext of canvas to perform draw operation of shapes.
     * @see GraphicsContext
     * */
    protected GraphicsContext graphicsContext;
    /**
     * hold pen X position for drawing
     * */
    private static double moveX;
    /**
     * hold pen Y position for drawing
     * */
    private static double moveY;
    /**
     * if true run the command else just syntax check of the particular instruction
     * */
    private static boolean isRun = true;

    /**
     * if true when user called run event otherwise false for syntax check
     * */
    private static boolean isRunEvent = true;

    /**
     * if true fill the drawing shape else just draw using outline or stroke
     * */
    private static boolean isFillOn = false;
    /**
     * holds the pen color for drawing and by default it will be set as black
     * */
    private static Color penColor = Color.BLACK;
    /**
     * holds the user submit instruction
     * */
    private static String userInputCommands=null;
    /**
     * this contractor will run the instruction by default
     * @param canvasId canvas instance
     * */
    public  CanvasUtil(Canvas canvasId){
        init(canvasId, true);
    }
    /**
     * this constructor will run or validate syntax as per the @see isRun boolean flag
     * @param canvasId canvas instance
     * @param isRun indicator to run the program or just validate syntax
     * */
    public CanvasUtil(Canvas canvasId, boolean isRun){
        init(canvasId, isRun);
    }
    /**
     * initialize the canvas, graphics and other basic flag to operation drawing and related command
     * @param canvasId canvas instance
     * @param isRun indicator to run the program or just validate syntax
     * */
    private void init(Canvas canvasId, boolean isRun){
        if(canvasId ==null){
            throw new IllegalArgumentException("Canvas cannot be null.");
        }
        CanvasUtil.canvasId= canvasId;
        this.graphicsContext = canvasId.getGraphicsContext2D();
        this.graphicsContext.beginPath();
        CanvasUtil.isRun = isRun;
    }

    public Canvas getCanvasId() {
        return CanvasUtil.canvasId;
    }

    public GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    public double getMoveX() {
        return CanvasUtil.moveX;
    }

    public void setMoveX(double moveX) {
        CanvasUtil.moveX = moveX;
    }

    public double getMoveY() {
        return CanvasUtil.moveY;
    }

    public void setMoveY(double moveY) {
        CanvasUtil.moveY = moveY;
    }


    public boolean isRun() {
        return CanvasUtil.isRun;
    }

    public String getUserInputCommands() {
        return CanvasUtil.userInputCommands;
    }

    public void setUserInputCommands(String userInputCommands) {
        CanvasUtil.userInputCommands = userInputCommands;
    }

    public void setFillOn(boolean fillOn) {
        CanvasUtil.isFillOn = fillOn;
    }

    public boolean isFillOn() {
        return CanvasUtil.isFillOn;
    }

    public void setPenColor(Color penColor) {
        CanvasUtil.penColor = penColor;
    }

    public Color getPenColor() {
        return CanvasUtil.penColor;
    }

    public boolean isRunEvent() {
        return CanvasUtil.isRunEvent;
    }

    public void setRunEvent(boolean runEvent) {
        CanvasUtil.isRunEvent = runEvent;
    }
}
