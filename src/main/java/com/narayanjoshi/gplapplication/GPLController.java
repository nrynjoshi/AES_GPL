package com.narayanjoshi.gplapplication;

import com.narayanjoshi.gplapplication.exception.CommandNotFoundException;
import com.narayanjoshi.gplapplication.service.CommandParser;
import com.narayanjoshi.gplapplication.util.GPLShowMessage;
import com.narayanjoshi.gplapplication.util.Util;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * The {@code GPLController} class is a controller to handle all type of
 * event generated by GPL application using UI.
 *
 * @author Narayan Joshi
 * @since v1.0
 */
public class GPLController {

    /**
     * This canvasId is responsible for making all shapes and performing output on the display box.
     *
     * @see Canvas for more information
     */
    @FXML
    public Canvas canvasId;

    /**
     * This inputMultipleCodeText holds multiple line code for further processing.
     *
     * @see TextArea for more information
     */
    @FXML
    private TextArea inputMultipleCodeText;

    /**
     * This inputSingleCodeText holds single line code for further processing.
     *
     * @see TextField for more information
     */
    @FXML
    private TextField inputSingleCodeText;

    /**
     * This secondThreadMultilineTextArea holds multiple line code for further processing.
     *
     * @see TextArea for more information
     */
    @FXML
    private TextArea secondThreadMultilineTextArea;

    /**
     * This secondThreadSingleTextField holds single line code for further processing.
     *
     * @see TextField for more information
     */
    @FXML
    private TextField secondThreadSingleTextField;

    @FXML
    private Tab threadTabOne;

    /**
     * The run button form GLP application is the entry point for processing as per the given instruction
     */
    @FXML
    protected void onRunButtonClick() {

        String commandSingle = inputSingleCodeText.getText();
        String commandMultiple = inputMultipleCodeText.getText();

        runGPLProgrammingOnThreadProcessThread(commandSingle, commandMultiple, true, "First Thread Run");
    }

    /**
     * The syntax button form GLP application is the entry point for validating all the command by the user input.
     */
    @FXML
    protected void onSyntaxButtonClick() {

        String commandSingle = inputSingleCodeText.getText();
        String commandMultiple = inputMultipleCodeText.getText();

        runGPLProgrammingOnThreadProcessThread(commandSingle, commandMultiple, false, "First Thread Syntax");
    }

    /**
     * The save command button form GLP application will save the given instruction to a file path.
     */
    @FXML
    protected void onSaveCommandButtonClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("C:/"));
        boolean tabOneSelected = threadTabOne.isSelected();
        fileChooser.setTitle("Save your "+(tabOneSelected?"Thread One":"Thread Two")+" command to file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));


        if(tabOneSelected){
            fileChooser.setInitialFileName("gpl_application_thread1_command");
        }else{
            fileChooser.setInitialFileName("gpl_application_thread2_command");
        }


        File file = fileChooser.showSaveDialog(new Stage());
        //cancel the file chooser without saving file
        if (file == null) {
            throw new CommandNotFoundException("File has not saved.", -5);
        }

        String commandSingle;
        String commandMultiple;
        if(tabOneSelected){
            commandSingle = inputSingleCodeText.getText();
            commandMultiple = inputMultipleCodeText.getText();
        }else{
            commandSingle = secondThreadSingleTextField.getText();
            commandMultiple = secondThreadMultilineTextArea.getText();
        }


        Util.saveContentToFile(file.getAbsolutePath(), commandSingle + "\n" + commandMultiple);
        GPLShowMessage.getInstance().showSuccess("File saved successfully.");

    }

    /**
     * The open file button form GLP application will open file and read all instruction from particular file.
     */
    @FXML
    protected void onOpenFileButtonClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("C:/"));
        boolean tabOneSelected = threadTabOne.isSelected();
        fileChooser.setTitle("Load your saved command from file to "+(tabOneSelected?"Thread One":"Thread Two"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));


        File file = fileChooser.showOpenDialog(new Stage());
        //cancel the file chooser without saving file
        if (file == null) {
            throw new CommandNotFoundException("File has not selected or canceled.", -5);
        }
        String readCommand = Util.readFromFile(file.getAbsolutePath());

        if(tabOneSelected){
            inputMultipleCodeText.setText(readCommand);
        }else {
            secondThreadMultilineTextArea.setText(readCommand);
        }

        GPLShowMessage.getInstance().showSuccess("File read successfully.");
    }

    /**
     * This method is trigger when the close button form GLP application trigger and will close the application.
     *
     * @param event event object passed from UI menu with addition information of event
     */
    @FXML
    public void doExit(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    /**
     * The run button form GLP application is the entry point for processing as per the given instruction
     */
    @FXML
    protected void onSecondThreadRunButtonClick() {
        String commandSingle = secondThreadSingleTextField.getText();
        String commandMultiple = secondThreadMultilineTextArea.getText();
        runGPLProgrammingOnThreadProcessThread(commandSingle, commandMultiple, true, "Second Thread Run");
    }

    /**
     * The syntax button form GLP application is the entry point for validating all the command by the user input.
     */
    @FXML
    protected void onSecondThreadSyntaxButtonClick() {
        String commandSingle = secondThreadSingleTextField.getText();
        String commandMultiple = secondThreadMultilineTextArea.getText();
        runGPLProgrammingOnThreadProcessThread(commandSingle, commandMultiple, false, "Second Thread Syntax");
    }

    public void runGPLProgrammingOnThreadProcessThread(String commandSingle, String commandMultiple, boolean isRun, String threadName) {
        System.out.println("Processing: "+threadName);

        CommandParser commandParser = new CommandParser(canvasId, commandSingle, commandMultiple);
        if (isRun) {
            commandParser.run();
        } else {
            commandParser.syntax();
        }

    }





}