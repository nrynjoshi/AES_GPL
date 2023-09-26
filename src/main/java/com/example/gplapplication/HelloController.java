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

        this.fetchClickText();
    }

    @FXML
    protected void onSyntaxButtonClick() {
        welcomeText.setText("Syntax Button Clicked");
    }

    private void fetchClickText(){
        StringBuilder stringBuilder= new StringBuilder("Run button clicked !");
       String inputSingleCodeString = inputSingleCodeText.getText();
        String inputMultipleCodeString = inputMultipleCodeText.getText();
        if(inputSingleCodeString != null && !inputSingleCodeString.trim().isEmpty()){
            stringBuilder.append("\n Single line of code executed.");
        }else if(inputMultipleCodeString != null && !inputMultipleCodeString.trim().isEmpty()){
            stringBuilder.append("\n Multiple line of code executed.");
        }else {
            stringBuilder.append("\n Nothing to execute.");
        }

        welcomeText.setText(stringBuilder.toString());
    }
}