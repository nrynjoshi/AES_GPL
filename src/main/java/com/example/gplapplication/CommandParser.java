package com.example.gplapplication;


import com.example.gplapplication.service.*;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

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

        //clear messageBox
        CanvasUtil canvasUtil= new CanvasUtil(canvasId);
        try{
            boolean isRunSingleLineCommand = isRunSingleLineCommand(commandSingle, commandMultiple);
            if(isRunSingleLineCommand){
                process(commandSingle, canvasUtil);
            }else{
                process(commandMultiple, canvasUtil);
            }
            Notifications.create().title("Success ").text("Operation Perform successfully").position(Pos.TOP_RIGHT).hideAfter(Duration.millis(2000)).show();
        }catch (CommandNotFound x){
            x.printStackTrace();
            if(x.getCode() == -1){
                Notifications.create().title("Error ").text(x.getMessage()).position(Pos.TOP_RIGHT).hideAfter(Duration.millis(6000)).showError();
            }else{
                Notifications.create().title("Info ").text(x.getMessage()).position(Pos.TOP_RIGHT).hideAfter(Duration.millis(4000)).showInformation();
            }
        }


    }

    private void process(String command, CanvasUtil canvasUtil){
        String[] commandSplit = command.split("\n");

        for (int i = 0; i < commandSplit.length; i++) {
            String chunkCommand = commandSplit[i];
            DrawShapeIfc drawShape = new DrawShape(canvasUtil);
            if(Util.startWithIgnoreCase(chunkCommand, CommandEnum.COMMENT.getCommand()) || !Util.isNotEmpty(chunkCommand)){
                //ignore this line of code
            }else if(Util.startWithIgnoreCase(chunkCommand, CommandEnum.DRAW_TO.getCommand())){
                canvasUtil.drawTo(chunkCommand);
            }else if(Util.startWithIgnoreCase(chunkCommand,CommandEnum.MOVE_TO.getCommand())){
                canvasUtil.moveTo(chunkCommand);
            }else if(Util.startWithIgnoreCase(chunkCommand,CommandEnum.CLEAR.getCommand())){
                canvasUtil.clear();
            }else if(Util.startWithIgnoreCase(chunkCommand,CommandEnum.RESET.getCommand())){
                canvasUtil.reset();
            }else if(Util.startWithIgnoreCase(chunkCommand,CommandEnum.PEN.getCommand())){
                canvasUtil.setPenColor(chunkCommand);
            }else if(Util.startWithIgnoreCase(chunkCommand,CommandEnum.SAVE_TO_FILE.getCommand())){
                canvasUtil.saveToFile(chunkCommand, command);
            }else if(Util.startWithIgnoreCase(chunkCommand,CommandEnum.READ_FROM_FILE.getCommand())){
                String savedCommand = canvasUtil.readFromFile(chunkCommand);
                process(savedCommand, canvasUtil);
            }else if(Util.startWithIgnoreCase(chunkCommand,CommandEnum.FILL.getCommand())){
                canvasUtil.setFill(chunkCommand);
            }else if(Util.startWithIgnoreCase(chunkCommand, RectangleShape.COMMAND)){
                drawShape= new RectangleShape(canvasUtil);
                drawShape.draw(chunkCommand);
            }else if(Util.startWithIgnoreCase(chunkCommand, TriangleShape.COMMAND)){
                drawShape= new TriangleShape(canvasUtil);
                drawShape.draw(chunkCommand);
            }else if(Util.startWithIgnoreCase(chunkCommand, CircleShape.COMMAND)){
                drawShape= new CircleShape(canvasUtil);
                drawShape.draw(chunkCommand);
            }else {
                throw new CommandNotFound(String.format("%s command does not exist.", chunkCommand), -1);
            }
        }
    }

    private boolean isRunSingleLineCommand(String commandSingle, String commandMultiple) {
        if(Util.isNotEmpty(commandSingle)){
            return true;
        }else if(Util.isNotEmpty(commandMultiple)){
            return false;
        }
        throw new CommandNotFound("No command has been passed.", 1);
    }



}
