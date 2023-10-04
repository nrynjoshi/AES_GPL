package com.example.gplapplication;

/**
 * GPL Commands
 * */
public enum CommandEnum {

    /**
     * saveToFile filepath
     *
     *  filepath will be java full path including filename
     */
    SAVE_TO_FILE("saveToFile <filepath>"),
    READ_FROM_FILE("readFromFile <filepath>"),
    MOVE_TO("moveTo <x>,<y>"),
    CIRCLE("circle <radius>"),
    RECTANGLE("rectangle <width>,<height>"),
    TRIANGLE("triangle <base>,<adjacent>"),
    DRAW_TO("drawTo <x>,<y>"),
    COMMENT("//"),
    CLEAR("clear"),
    RESET("reset"),
    PEN("pen <color>"),
    FILL("fill <boolean>")
    ;

    public final String command;

    CommandEnum(String command) {
        this.command = command;
    }

    public String getCommand(){
        return this.command;
    }

}
