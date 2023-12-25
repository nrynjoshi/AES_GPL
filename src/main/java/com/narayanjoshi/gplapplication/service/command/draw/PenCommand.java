package com.narayanjoshi.gplapplication.service.command.draw;

import com.narayanjoshi.gplapplication.exception.CommandNotFoundException;
import com.narayanjoshi.gplapplication.exception.CommandNotFoundException;
import com.narayanjoshi.gplapplication.util.Util;
import javafx.scene.paint.Color;

import java.util.List;

/**
 * The {@code PenCommand} class represents validation of command and
 * performing pen color operation i.e. proving color based on defined instruction.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class PenCommand extends DrawRootCommand {

    /**
     * {@inheritDoc}
     * this will validate the colour param passed by user.
     * @throws CommandNotFoundException if param colour is not defined or valid.
     */
    @Override
    public void validate() {
        Util.validateCommand(canvasUtil.getUserInputCommandLineByLine(), paramList, commandEnum);

        String color = paramList.get(0);
        try{
            Color.valueOf(color);
        }catch (IllegalArgumentException e){
            throw new CommandNotFoundException(String.format("'%s' command attribute values does not exist.\nError on '%s'.",commandEnum.getCommand(), canvasUtil.getUserInputCommandLineByLine()), -1);
        }


    }

    /**
     * {@inheritDoc}
     * This method will update the pen colour for drawing purpose and be default it will set set as black.
     * This will read colour name from parameter of that particular command and changed the pen colour with that one.
     * @see Color for more information about pen colour acceptance
     */
    @Override
    public void draw() {
        Color color = Color.valueOf(paramList.get(0));
        canvasUtil.setPenColor(color);
        if(canvasUtil.isFillOn()){
            canvasUtil.getGraphicsContext().setFill(canvasUtil.getPenColor());
        }else{
            canvasUtil.getGraphicsContext().setStroke(canvasUtil.getPenColor());
        }
    }
}
