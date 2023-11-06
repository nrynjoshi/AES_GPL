package com.narayanjoshi.gplapplication.service;

import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class GPLShowMessage {

    public static void showSuccess(String message){
        prepareMessage("Success: ", message, 2000).show();
    }

    public static void showBuildSuccess(String message){
        prepareMessage("Build Success: ", message, 2000).show();
    }

    public static void showError(String message){
        prepareMessage("Error: ", message, 4000).showError();
    }

    public static void showInfo(String message){
        prepareMessage("Info: ", message, 2000).showInformation();
    }

    private static Notifications prepareMessage(String title, String message, int duration_in_ms){
        return Notifications.create().title(title).text(message).position(Pos.TOP_RIGHT).hideAfter(Duration.millis(duration_in_ms));
    }
}
