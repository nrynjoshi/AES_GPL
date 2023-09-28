package com.example.gplapplication;


import com.example.gplapplication.service.CircleShape;
import com.example.gplapplication.service.DrawShape;
import com.example.gplapplication.service.RectangleShape;
import com.example.gplapplication.service.TriangleShape;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.Arrays;
import java.util.List;

public class CommandParser {

    private final String commandSingle;
    private final String commandMultiple;
    public Canvas canvasId;

    CommandParser(Canvas canvasId, String commandSingle, String commandMultiple){
        this.canvasId = canvasId;
        this.commandSingle= commandSingle;
        this.commandMultiple = commandMultiple;
    }

    public void run(){
        boolean isRunSingleLineCommand = isRunSingleLineCommand(commandSingle, commandMultiple);
        if(isRunSingleLineCommand){
            //run single line command
            System.out.println(commandSingle);
            process(commandSingle);
        }else{
            //run multiline command
            System.out.println(commandMultiple);
            process(commandMultiple);
        }
    }

    List<String> commands = Arrays.asList("drawTo <x>,<y>", "moveTo <x>,<y>", "lineTo <x>,<y>"
            ,"rectangle <x>,<y>", "triangle <x>,<y>", "circle <x>,<y>"
    );

    private void process(String command){
        String[] commandSplit = command.split("\n");
        for (int i = 0; i < commandSplit.length; i++) {
            String chunkCommand = commandSplit[i];
            System.out.println("===> "+i+" :"+ chunkCommand);
            Util.validateCommand(chunkCommand, TriangleShape.COMMAND);
            DrawShape drawShape;
            if(Util.startWithIgnoreCase(chunkCommand, "drawTo")){
                System.out.println("drawTo command found.");
                drawTo(chunkCommand);
            }else if(Util.startWithIgnoreCase(chunkCommand,"moveTo")){
                System.out.println("moveTo command found.");
                moveTo(chunkCommand);
            }else if(Util.startWithIgnoreCase(chunkCommand,"lineTo")){
                System.out.println("lineTo command found.");
                lineTo(chunkCommand);
            }else if(Util.startWithIgnoreCase(chunkCommand,"clear")){
                System.out.println("clear command found.");
                clear();
            }else if(Util.startWithIgnoreCase(chunkCommand, RectangleShape.COMMAND)){
                System.out.println("rectangle command found.");
                drawShape= new RectangleShape(canvasId);
                drawShape.draw(chunkCommand);
            }else if(Util.startWithIgnoreCase(chunkCommand, TriangleShape.COMMAND)){
                System.out.println("triangle command found.");
                drawShape= new TriangleShape(canvasId);
                drawShape.draw(chunkCommand);
            }else if(Util.startWithIgnoreCase(chunkCommand, CircleShape.COMMAND)){
                System.out.println("circle command found.");
                drawShape= new CircleShape(canvasId);
                drawShape.draw(chunkCommand);
            }
        }
    }

    private boolean isRunSingleLineCommand(String commandSingle, String commandMultiple) {
        if(Util.isNotEmpty(commandSingle)){
            return true;
        }else if(Util.isNotEmpty(commandMultiple)){
            return false;
        }
        throw new CommandNotFound("No command has been passed.");
    }

    private void moveTo(String command){
        GraphicsContext graphicsContext = canvasId.getGraphicsContext2D();
        graphicsContext.beginPath();
        graphicsContext.moveTo(35, 35);

    }

    private void lineTo(String command){
        GraphicsContext graphicsContext = canvasId.getGraphicsContext2D();
        graphicsContext.beginPath();
        graphicsContext.lineTo(35, 35);

    }

    private void drawTo(String command){
        //unknown about drawTo functionalities
    }

    private void clear(){
        GraphicsContext graphicsContext = canvasId.getGraphicsContext2D();
        graphicsContext.beginPath();
        graphicsContext.clearRect(0, 0, canvasId.getWidth(), canvasId.getHeight());
    }

    private void reset(){

    }
}
