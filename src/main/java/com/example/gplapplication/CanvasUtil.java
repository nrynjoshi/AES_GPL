package com.example.gplapplication;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class CanvasUtil{

    protected Canvas canvasId;
    protected GraphicsContext graphicsContext;

    private double moveX;
    private double moveY;

    public CanvasUtil(Canvas canvasId){
        this.canvasId= canvasId;
        this.graphicsContext = canvasId.getGraphicsContext2D();
        this.graphicsContext.beginPath();

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




    public void moveTo(String command){

        Util.validateCommand(command, "moveTo <x>,<y>");
        List<String> params = Util.getAllParameterFromCommand(command);

        double x = Float.parseFloat(params.get(0));
        double y = Float.parseFloat(params.get(1));

        this.moveTo(x, y);
    }


    public void moveTo(double x, double y){
        this.moveX = x;
        this.moveY = y;
        graphicsContext.moveTo(x, y);
    }


    public void lineTo(String command){
        Util.validateCommand(command, "lineTo");
        List<String> params = Util.getAllParameterFromCommand(command);

        double x = Float.parseFloat(params.get(0));
        double y = Float.parseFloat(params.get(1));

        this.lineTo(x, y);
    }


    public void lineTo(double x, double y){
        graphicsContext.lineTo( x, y);
    }


    public void drawTo(String command){
        Util.validateCommand(command, "drawTo");
        List<String> params = Util.getAllParameterFromCommand(command);

        double height = Float.parseFloat(params.get(1));
        double width = Float.parseFloat(params.get(0));

        //unknown about drawTo functionalities
    }

    public void clear(){
        graphicsContext.beginPath();
        graphicsContext.clearRect(0, 0, canvasId.getWidth(), canvasId.getHeight());
    }

    public void reset(){
        graphicsContext.beginPath();
        this.clear();
        this.moveTo(0,0);
        this.moveX = 0;
        this.moveY = 0;
    }
}
