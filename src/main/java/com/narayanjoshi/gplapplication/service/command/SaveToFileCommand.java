package com.narayanjoshi.gplapplication.service.command;

import com.narayanjoshi.gplapplication.Util;
import com.narayanjoshi.gplapplication.service.RootCommand;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SaveToFileCommand  extends RootCommand {

    @Override
    public void validate(String command) {
        Util.validateCommand(command, this.command, this.param);
    }

    @Override
    public void draw(String command) {

        this.validate(command);

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
        }
    }
}
