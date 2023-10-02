package com.example.gplapplication;


import com.example.gplapplication.service.*;
import javafx.scene.canvas.Canvas;

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

    private void process(String command){
        String[] commandSplit = command.split("\n");
        CanvasUtil canvasUtil= new CanvasUtil(canvasId);
        for (int i = 0; i < commandSplit.length; i++) {
            String chunkCommand = commandSplit[i];
            System.out.println("===> "+i+" :"+ chunkCommand);
            DrawShapeIfc drawShape = new DrawShape(canvasUtil);
            if(Util.startWithIgnoreCase(chunkCommand, CommandEnum.COMMENT.getCommand())){
                System.out.println("comment line so ignore");
            }else if(Util.startWithIgnoreCase(chunkCommand, CommandEnum.DRAW_TO.getCommand())){
                System.out.println("drawTo command found.");
                canvasUtil.drawTo(chunkCommand);
            }else if(Util.startWithIgnoreCase(chunkCommand,CommandEnum.MOVE_TO.getCommand())){
                System.out.println("moveTo command found.");
                canvasUtil.moveTo(chunkCommand);
            }else if(Util.startWithIgnoreCase(chunkCommand,CommandEnum.LINE_TO.getCommand())){
                System.out.println("lineTo command found.");
                canvasUtil.lineTo(chunkCommand);
            }else if(Util.startWithIgnoreCase(chunkCommand,CommandEnum.CLEAR.getCommand())){
                System.out.println("clear command found.");
                canvasUtil.clear();
            }else if(Util.startWithIgnoreCase(chunkCommand,CommandEnum.LINE_TO.getCommand())){
                System.out.println("clear command found.");
                canvasUtil.reset();
            }else if(Util.startWithIgnoreCase(chunkCommand,CommandEnum.PEN.getCommand())){
                System.out.println("pen command found.");
                canvasUtil.setPenColor(chunkCommand);
            }else if(Util.startWithIgnoreCase(chunkCommand,CommandEnum.SAVE_TO_FILE.getCommand())){
                System.out.println("saveToFile command found.");
                canvasUtil.saveToFile(chunkCommand, command);
            }else if(false){
                System.out.println("loadFromFile command found.");
            }else if(Util.startWithIgnoreCase(chunkCommand, RectangleShape.COMMAND)){
                System.out.println("rectangle command found.");
                drawShape= new RectangleShape(canvasUtil);
                drawShape.draw(chunkCommand);
            }else if(Util.startWithIgnoreCase(chunkCommand, TriangleShape.COMMAND)){
                System.out.println("triangle command found.");
                drawShape= new TriangleShape(canvasUtil);
                drawShape.draw(chunkCommand);
            }else if(Util.startWithIgnoreCase(chunkCommand, CircleShape.COMMAND)){
                System.out.println("circle command found.");
                drawShape= new CircleShape(canvasUtil);
                drawShape.draw(chunkCommand);
            }else {
                System.out.println("not condition detected...");
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



}
