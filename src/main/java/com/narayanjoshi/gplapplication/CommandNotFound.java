package com.narayanjoshi.gplapplication;

/**
 * The {@code CommandNotFound} class represents exception generate by GPL application.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class CommandNotFound extends RuntimeException {

    /**
     * error code for further work to control message
     * */
    private int code = 0;

    /**
     * constructor for exception
     * @param message custom message to throw exception
     * @param code error code to handle message type
     * */
    public CommandNotFound(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
