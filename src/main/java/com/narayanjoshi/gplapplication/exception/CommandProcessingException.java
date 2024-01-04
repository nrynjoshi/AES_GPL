package com.narayanjoshi.gplapplication.exception;

/**
 * The {@code CommandProcessingException} class represents exception generate by GPL application process like programming.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class CommandProcessingException extends RuntimeException {

    /**
     * error code for further work to control message
     * */
    private int code = 0;

    /**
     * constructor for exception
     * @param message custom message to throw exception
     * @param code error code to handle message type
     * */
    public CommandProcessingException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}