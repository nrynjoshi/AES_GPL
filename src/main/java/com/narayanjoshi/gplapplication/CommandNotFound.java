package com.narayanjoshi.gplapplication;

public class CommandNotFound extends RuntimeException {


    private int code = 0;
    public CommandNotFound(String s, int code) {
        super(s);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
