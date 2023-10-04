package com.example.gplapplication.service.command;

import com.example.gplapplication.CanvasUtil;
import com.example.gplapplication.CommandEnum;
import com.example.gplapplication.CommandNotFound;
import com.example.gplapplication.Util;
import com.example.gplapplication.service.RootCommand;
import javafx.fxml.FXML;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadFromFileCommand  extends RootCommand {

    public ReadFromFileCommand(CanvasUtil canvasUtil){
        super(canvasUtil, CommandEnum.READ_FROM_FILE);
    }

    @Override
    public void validate(String command) {
        Util.validateCommand(command, this.COMMAND);
    }

    @Override
    public void draw(String command) {

        this.validate(command);

        List<String> param = Util.getAllParameterFromCommand(command);

        Path path = Path.of(param.get(0));
        File file = path.toFile();
        if(!file.exists()){
            throw new CommandNotFound("File not found.", 0);
        }
        // Now calling Files.readString() method to
        // read the file
        try{
            String readCommand = Files.readString(path);
        }catch (IOException x){
            throw new CommandNotFound("File can not read.", 0);
        }

    }
}
