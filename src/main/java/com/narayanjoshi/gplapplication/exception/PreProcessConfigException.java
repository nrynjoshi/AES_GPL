package com.narayanjoshi.gplapplication.exception;

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