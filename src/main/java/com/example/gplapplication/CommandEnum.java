package com.example.gplapplication;

import com.example.gplapplication.service.RootCommandIfc;
import com.example.gplapplication.service.command.*;
import javafx.scene.shape.Circle;

/**
 * GPL Commands
 * */
public enum CommandEnum {

    /**
     * saveToFile filepath
     *
     *  filepath will be java full path including filename
     */
    SAVE_TO_FILE("saveToFile","<filepath>", new SaveToFileCommand()),
    READ_FROM_FILE("readFromFile","<filepath>", new ReadFromFileCommand()),
    MOVE_TO("moveTo","<x>,<y>", new MoveToCommand()),
    CIRCLE("circle","<radius>", new CircleCommand()),
    RECTANGLE("rectangle","<width>,<height>", new RectangleCommand()),
    TRIANGLE("triangle","<base>,<adjacent>", new TriangleCommand()),
    DRAW_TO("drawTo","<x>,<y>", new DrawToCommand()),
    COMMENT("//", null, new CommentCommand()),
    CLEAR("clear", null, new ClearCommand()),
    RESET("reset", null, new ResetCommand()),
    PEN("pen","<color>", new PenCommand()),
    FILL("fill","<boolean>", new FillCommand())
    ;

    public final String command;

    public final String param;
    public final RootCommandIfc commandIfc;
    CommandEnum(String command, String param, RootCommandIfc commandIfc) {
        this.command = command;
        this.param = param;
        this.commandIfc = commandIfc;
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

}
