package com.narayanjoshi.gplapplication.service.command;

import com.narayanjoshi.gplapplication.Util;
import com.narayanjoshi.gplapplication.service.RootCommand;
import javafx.fxml.FXML;

import java.util.List;

public class MoveToCommand extends RootCommand {

    @Override
    public void validate(String command) {
        Util.validateCommand(command, this.command, this.param);
    }

    @Override
    @FXML
    public void draw(String command) {
        this.validate(command);
        List<String> params = Util.getAllParameterFromCommand(command);

        double x = Float.parseFloat(params.get(0));
        double y = Float.parseFloat(params.get(1));

        canvasUtil.setMoveX(x);
        canvasUtil.setMoveY(y);
        canvasUtil.getGraphicsContext().moveTo(x, y);
    }
}
