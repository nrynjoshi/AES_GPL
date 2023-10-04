package com.example.gplapplication;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    public Canvas canvasId;

    @FXML
    private TextArea inputMultipleCodeText;

    @FXML
    private TextField inputSingleCodeText;


    @FXML
    protected void onRunButtonClick() throws IOException {

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