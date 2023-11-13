package com.narayanjoshi.gplapplication.service.command.programming;

import com.narayanjoshi.gplapplication.util.Util;
import com.narayanjoshi.gplapplication.service.command.draw.DrawRootCommand;

import java.util.List;

/**
 * The {@code SaveToFileCommand} class represents validation of command and
 * performing save operation of all command passed from console on given
 * filepath based on defined instruction.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class SaveToFileCommand  extends DrawRootCommand {


    /**
     * {@inheritDoc}
     * This method will save a command to a file path given by user in command param.  
     */
    @Override
    public void draw(String command) {

        List<String> param = Util.getAllParameterFromCommand(command);

        Util.saveContentToFile(param.get(0), this.canvasUtil.getUserInputCommands());
    }
}
