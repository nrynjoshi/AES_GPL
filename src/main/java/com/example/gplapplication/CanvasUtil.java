package com.example.gplapplication;

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

    public CanvasUtil(Canvas canvasId){
        this.canvasId= canvasId;
        this.graphicsContext = canvasId.getGraphicsContext2D();
        this.graphicsContext.beginPath();

    }

    public Canvas getCanvasId() {
        return canvasId;
    }

    public GraphicsContext getGraphicsContext() {
        this.graphicsContext.setStroke(Color.BLACK);
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
        graphicsContext.stroke();
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
        graphicsContext.stroke();
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

   public static final String saveToFile_COMMAND = "saveToFile <filepath>";

    public boolean saveToFile(String command, String program) {
        List<String> param = Util.getAllParameterFromCommand(command);

        Path path = Paths.get(param.get(0));

        File file= path.toFile();
        if(file !=null){
            file.delete();
        }

        try{
            Files.write(path, program.getBytes(StandardCharsets.UTF_8));
            return true;
        }catch (IOException x){
            x.printStackTrace();
        }
        return false;
    }
}
