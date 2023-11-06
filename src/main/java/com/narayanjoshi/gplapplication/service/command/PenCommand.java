package com.narayanjoshi.gplapplication.service.command;

import com.narayanjoshi.gplapplication.CommandNotFound;
import com.narayanjoshi.gplapplication.Util;
import com.narayanjoshi.gplapplication.service.RootCommand;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.List;

/**
 * The {@code PenCommand} class represents validation of command and
 * performing pen color operation i.e. proving color based on defined instruction.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class PenCommand extends RootCommand {

    /**
     * {@inheritDoc}
     * this will validate the colour param passed by user.
     * @throws CommandNotFound if param colour is not defined or valid.
     */
    @Override
    public void validate(String command) {
        Util.validateCommand(command, this.command, this.param);
        String color = Util.getAllParameterFromCommand(command).get(0);
        try{
            Color.valueOf(color);
        }catch (IllegalArgumentException e){
            throw new CommandNotFound(String.format("'%s' command attribute values does not exist.\nError on '%s'.",this.command, command), -1);
        }


    }

    /**
     * {@inheritDoc}
     * This method will update the pen colour for drawing purpose and be default it will set set as black.
     * This will read colour name from parameter of that particular command and changed the pen colour with that one.
     * @see Color for more information about pen colour acceptance
     */
    @Override
    public void draw(String command) {
        List<String> param = Util.getAllParameterFromCommand(command);
        Color color = Color.valueOf(param.get(0));
        canvasUtil.setPenColor(color);
        if(canvasUtil.isFillOn()){
            canvasUtil.getGraphicsContext().setFill(canvasUtil.getPenColor());
        }else{
            canvasUtil.getGraphicsContext().setStroke(canvasUtil.getPenColor());
        }
    }
}
