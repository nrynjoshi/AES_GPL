package com.narayanjoshi.gplapplication;

import com.narayanjoshi.gplapplication.service.RootCommandIfc;
import com.narayanjoshi.gplapplication.service.command.*;

/**
 * The {@code CommandEnum} class represents all command, parameter, and its process instance.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public enum CommandEnum {

    SAVE_TO_FILE("saveToFile","<filepath>", new SaveToFileCommand(),"descrition goes here"),

    READ_FROM_FILE("readFromFile","<filepath>", new ReadFromFileCommand(),"descrition goes here"),

    MOVE_TO("moveTo","<x>,<y>", new MoveToCommand(),"description goes here"),

    CIRCLE("circle","<radius>", new CircleCommand(),"description goes here"),

    RECTANGLE("rectangle","<width>,<height>", new RectangleCommand(),"description goes here"),

    TRIANGLE("triangle","<base>,<adjacent>", new TriangleCommand(),"description goes here"),

    DRAW_TO("drawTo","<x>,<y>", new DrawToCommand(),"description goes here"),

    COMMENT("//", null, new CommentCommand(),"description goes here"),

    CLEAR("clear", null, new ClearCommand(),"description goes here"),

    RESET("reset", null, new ResetCommand(),"description goes here"),

    PEN("pen","<color>", new PenCommand(),"description goes here"),

    FILL("fill","<boolean>", new FillCommand(),"description goes here")
    ;

    public final String command;

    public final String param;

    public final String description;
    public final RootCommandIfc commandIfc;
    CommandEnum(String command, String param, RootCommandIfc commandIfc, String description) {
        this.command = command;
        this.param = param;
        this.commandIfc = commandIfc;
        this.description = description;
    }

    public String getCommand(){
        return this.command;
    }

    public String getParam(){
        return this.param;
    }

    public RootCommandIfc getCommandInstance(){
        return this.commandIfc;
    }

    public String getDescription() {
        return description;
    }
}
