package com.narayanjoshi.gplapplication.service.command;

import com.narayanjoshi.gplapplication.CommandNotFound;
import com.narayanjoshi.gplapplication.Util;
import com.narayanjoshi.gplapplication.service.RootCommand;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * The {@code SaveToFileCommand} class represents validation of command and
 * performing save operation of all command passed from console on given
 * filepath based on defined instruction.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class SaveToFileCommand  extends RootCommand {

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(String command) {

        List<String> param = Util.getAllParameterFromCommand(command);

        Path path = Paths.get(param.get(0));

        File file= path.toFile();
        if(file !=null){
            file.delete();
        }

        try{
            Files.write(path, this.canvasUtil.getUserInputCommands().getBytes(StandardCharsets.UTF_8));
        }catch (IOException x){
            x.printStackTrace();
            throw new CommandNotFound(String.format("'%s' command filepath can not be created.\nError on '%s'.",this.command, command), -1);

        }
    }
}
