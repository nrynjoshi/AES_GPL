package com.narayanjoshi.gplapplication.service;

import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class GPLShowMessage {

    /**
     * This method show success notification message for GPL desktop application
     *
     * @param message text message to display on notification message box area
     * */
    public static void showSuccess(String message){
        prepareMessage("Success: ", message, 2000).show();
    }

    /**
     * This method show build or compile notification message for GPL desktop application
     *
     * @param message text message to display on notification message box area
     * */
    public static void showBuildSuccess(String message){
        prepareMessage("Build Success: ", message, 2000).show();
    }

    /**
     * This method show error notification message for GPL desktop application
     *
     * @param message text message to display on notification message box area
     * */
    public static void showError(String message){
        prepareMessage("Error: ", message, 4000).showError();
    }

    /**
     * This method show information notification message for GPL desktop application
     *
     * @param message text message to display on notification message box area
     * */
    public static void showInfo(String message){
        prepareMessage("Info: ", message, 2000).showInformation();
    }


    /**
     * This method show information notification message for GPL desktop application
     *
     * @param title tile for notification
     * @param message actual message for notification
     * @param duration_in_ms the millisecond time to display the notification duration
     * @return {@link Notifications} instance to called method
     * */
    private static Notifications prepareMessage(String title, String message, int duration_in_ms){
        return Notifications.create().title(title).text(message).position(Pos.TOP_RIGHT).hideAfter(Duration.millis(duration_in_ms));
    }
}
