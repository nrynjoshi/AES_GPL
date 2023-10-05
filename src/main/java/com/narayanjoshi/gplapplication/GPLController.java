package com.narayanjoshi.gplapplication;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GPLController {

    @FXML
    public Canvas canvasId;

    @FXML
    private TextArea inputMultipleCodeText;

    @FXML
    private TextField inputSingleCodeText;


    @FXML
    protected void onRunButtonClick() {

        String commandSingle = inputSingleCodeText.getText();
        String commandMultiple = inputMultipleCodeText.getText();

        CommandParser commandParser= new CommandParser(canvasId, commandSingle, commandMultiple);

        commandParser.run();
    }

    @FXML
    protected void onSyntaxButtonClick() {

        String commandSingle = inputSingleCodeText.getText();
        String commandMultiple = inputMultipleCodeText.getText();

        CommandParser commandParser= new CommandParser(canvasId, commandSingle, commandMultiple);
        commandParser.syntax();
    }


}