package com.narayanjoshi.gplapplication.util;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

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
    protected Canvas canvasId;
    /**
     * This will hold graphicsContext of canvas to perform draw operation of shapes.
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
     * if true when user called run event otherwise false for syntax check
     * */
    private boolean isRunEvent = true;

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
    private String userInputCommandLineByLine=null;


    Map<String, String> variableAndValues = new HashMap<>();

    String[] commandLineByLineArray;

    private int currentProgramExecutionIndex;

    /**
     * this contractor will run the instruction by default
     * @param canvasId canvas instance
     * */
    public CanvasUtil(Canvas canvasId){
        init(canvasId, true);
    }
    /**
     * this constructor will run or validate syntax as per the @see isRun boolean flag
     * @param canvasId canvas instance
     * @param isRun indicator to run the program or just validate syntax
     * */
    public CanvasUtil(Canvas canvasId,boolean isRun){
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
        this.canvasId= canvasId;
        this.graphicsContext = canvasId.getGraphicsContext2D();
        this.graphicsContext.beginPath();
        this.isRun = isRun;
    }

    public Canvas getCanvasId() {
        return this.canvasId;
    }

    public GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    public double getMoveX() {
        return this.moveX;
    }

    public void setMoveX(double moveX) {
        this.moveX = moveX;
    }

    public double getMoveY() {
        return this.moveY;
    }

    public void setMoveY(double moveY) {
        this.moveY = moveY;
    }


    public boolean isRun() {
        return this.isRun;
    }

    public String getUserInputCommandLineByLine() {
        return userInputCommandLineByLine;
    }

    public void setUserInputCommandLineByLine(String userInputCommandLineByLine) {
        this.userInputCommandLineByLine = userInputCommandLineByLine;
    }

    public void setFillOn(boolean fillOn) {
        this.isFillOn = fillOn;
    }

    public boolean isFillOn() {
        return this.isFillOn;
    }

    public void setPenColor(Color penColor) {
        this.penColor = penColor;
    }

    public Color getPenColor() {
        return this.penColor;
    }

    public boolean isRunEvent() {
        return this.isRunEvent;
    }

    public void setRunEvent(boolean runEvent) {
        this.isRunEvent = runEvent;
    }

    public Map<String, String> getVariableAndValues() {
        return variableAndValues;
    }

    public void setVariableAndValues(Map<String, String> variableAndValues) {
        this.variableAndValues = variableAndValues;
    }

    public String[] getCommandLineByLineArray() {
        return commandLineByLineArray;
    }

    public void setCommandLineByLineArray(String[] commandLineByLineArray) {
        this.commandLineByLineArray = commandLineByLineArray;
    }

    public int getCurrentProgramExecutionIndex() {
        return currentProgramExecutionIndex;
    }

    public void setCurrentProgramExecutionIndex(int currentProgramExecutionIndex) {
        this.currentProgramExecutionIndex = currentProgramExecutionIndex;
    }
}
