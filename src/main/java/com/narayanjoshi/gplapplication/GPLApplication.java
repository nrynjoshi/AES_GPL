package com.narayanjoshi.gplapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * The {@code GPLApplication} class is a entry class to run this Graphical Programming Language desktop application
 * We have all desktop related configuration to view for our GPL.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class GPLApplication extends Application {

    /**
     * This method is representing to start the application
     * @param stage hold all desktop connection and build UI for GPL application.
     *
     * @apiNote
     * This will use xml file where configuration is located to build desktop
     * application and set basic operation activities like setting frame size, resizing
     * application window, and setting fav icon.
     * */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GPLApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load(), 1000, 600);
        stage.setTitle("Graphical Programming Language");
        stage.getIcons().add(new Image(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("icon.png"))));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}