package com.narayanjoshi.gplapplication.service.command.programming;

import com.narayanjoshi.gplapplication.service.CommandParser;
import com.narayanjoshi.gplapplication.util.Util;
import com.narayanjoshi.gplapplication.service.command.draw.DrawRootCommand;

import java.util.List;

/**
 * The {@code ReadFromFileCommand} class represents validation of command and
 * performing read operation from given file path based on defined instruction.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class ReadFromFileCommand  extends DrawRootCommand {

    /**
     * {@inheritDoc}
     * This method will read a file and execute it from a user given file path. 
     */
    @Override
    public void draw(String command) {

        List<String> param = Util.getAllParameterFromCommand(command);

        String readCommand = Util.readFromFile(param.get(0));

        CommandParser commandParser= new CommandParser(canvasUtil.getCanvasId(), null, readCommand);
        commandParser.processTheGivenInstruction(readCommand, canvasUtil);

    }
}
