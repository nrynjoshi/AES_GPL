package com.narayanjoshi.gplapplication.exception;

/**
 * The {@code PreProcessConfigException} class represents exception if all required information to process GPL not setup properly.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class PreProcessConfigException  extends RuntimeException {

    /**
     * error code for further work to control message
     * */
    private int code = 0;

    /**
     * constructor for exception
     * @param message custom message to throw exception
     * @param code error code to handle message type
     * */
    public PreProcessConfigException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}