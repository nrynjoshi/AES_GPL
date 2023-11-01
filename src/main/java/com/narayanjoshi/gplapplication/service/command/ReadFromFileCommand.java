package com.narayanjoshi.gplapplication.service.command;

import com.narayanjoshi.gplapplication.CommandNotFound;
import com.narayanjoshi.gplapplication.CommandParser;
import com.narayanjoshi.gplapplication.Util;
import com.narayanjoshi.gplapplication.service.RootCommand;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * The {@code ReadFromFileCommand} class represents validation of command and
 * performing read operation from given file path based on defined instruction.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class ReadFromFileCommand  extends RootCommand {

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(String command) {

        List<String> param = Util.getAllParameterFromCommand(command);

        String readCommand = Util.readFromFile(param.get(0));

        CommandParser commandParser= new CommandParser(canvasUtil.getCanvasId(), null, readCommand);
        commandParser.processTheGivenInstruction(readCommand, canvasUtil);

    }
}
