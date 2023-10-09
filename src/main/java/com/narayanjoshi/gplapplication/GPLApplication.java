package com.narayanjoshi.gplapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * This class is a main class to run this Graphical Programming Language
 * We have all desktop frame configuration to view for our GPL.
 * For other view part you will look at  hello-view.fxml file for more details of UI.
 */
public class GPLApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GPLApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load(), 1000, 600);
        stage.setTitle("Graphical Programming Language");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}