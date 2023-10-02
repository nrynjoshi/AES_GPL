package com.example.gplapplication;

public enum CommandEnum {

    SAVE_TO_FILE("saveToFile <filepath>"),
    READ_FROM_FILE("pen <color>"),

    MOVE_TO("moveTo <x>,<y>"),

    CIRCLE("circle <radius>"),

    RECTANGLE("rectangle <width>,<height>"),

    TRIANGLE("triangle <base>,<adjacent>"),

    LINE_TO(""),
    DRAW_TO(""),
    COMMENT("//"),
    CLEAR("clear"),
    RESET("reset"),
    PEN("pen <color>"),



    ;

    public final String command;

    CommandEnum(String command) {
        this.command = command;
    }

    public String getCommand(){
        return this.command;
    }

}
