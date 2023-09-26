package com.example.gplapplication;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextArea inputMultipleCodeText;

    @FXML
    private TextField inputSingleCodeText;

    @FXML
    protected void onRunButtonClick() {
        welcomeText.setText("Run button clicked !");
    }

    @FXML
    protected void onSyntaxButtonClick() {
        welcomeText.setText("Syntax Button Clicked");
    }
}