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

public class ReadFromFileCommand  extends RootCommand {

    @Override
    public void draw(String command) {

        this.validate(command);

        List<String> param = Util.getAllParameterFromCommand(command);

        Path path = Path.of(param.get(0));
        File file = path.toFile();
        if(!file.exists()){
            throw new CommandNotFound("File not found.", 0);
        }
        // read the file
        try{
            String readCommand = Files.readString(path);
            CommandParser commandParser= new CommandParser(canvasUtil.getCanvasId(), null, readCommand);
            commandParser.run();
        }catch (IOException x){
            throw new CommandNotFound("File can not read.", 0);
        }

    }
}
