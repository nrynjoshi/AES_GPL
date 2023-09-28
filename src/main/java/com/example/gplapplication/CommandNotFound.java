package com.example.gplapplication;

public class CommandNotFound extends RuntimeException {
    public CommandNotFound(String s) {
        super(s);
    }
}
