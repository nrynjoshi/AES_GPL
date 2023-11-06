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

	 /**
     * The command to save a file is 'saveToFile <filepath_string>'. The filepath_string param is the complete path for path where the file need to be saved.
     */
    SAVE_TO_FILE("saveToFile","<filepath_string>", new SaveToFileCommand(),"description goes here"),
    
    /**
     * The command to save a file is 'readFromFile <filepath_string>'. The filepath_string param is the complete path for path where the file need to be saved.
     */
    READ_FROM_FILE("readFromFile","<filepath_string>", new ReadFromFileCommand(),"description goes here"),
    
    /**
     * The command to save a file is 'moveTo <x_float>,<y_float>. The filepath_string param is the complete path for path where the file need to be saved.
     */
    MOVE_TO("moveTo","<x_float>,<y_float>", new MoveToCommand(),"description goes here"),

    /**
     * The command to save a file is 'circle <radius_float>.The filepath_string param is the complete path for path where the file need to be saved.
     */
    CIRCLE("circle","<radius_float>", new CircleCommand(),"description goes here"),

    /**
     * The command to save a file is 'rectangle <width_float>,<height_float>.The filepath_string param is the complete path for path where the file need to be saved.
     */
    RECTANGLE("rectangle","<width_float>,<height_float>", new RectangleCommand(),"description goes here"),

    /**
     * The command to save a file is 'triangle <base_float>,<adjacent_float>.The filepath_string param is the complete path for path where the file need to be saved.
     */
    TRIANGLE("triangle","<base_float>,<adjacent_float>", new TriangleCommand(),"description goes here"),

    DRAW_TO("drawTo","<x_float>,<y_float>", new DrawToCommand(),"description goes here"),

    /**
     * The command to save a file is '\/\/ your_comment_goes here.The filepath_string param is the complete path for path where the file need to be saved.
     */
    COMMENT("//", null, new CommentCommand(),"description goes here"),

    /**
     * The command to save a file is 'clear.The filepath_string param is the complete path for path where the file need to be saved.
     */
    CLEAR("clear", null, new ClearCommand(),"description goes here"),

    /**
     * The command to save a file is 'reset.The filepath_string param is the complete path for path where the file need to be saved. 
     */
    RESET("reset", null, new ResetCommand(),"description goes here"),

    /**
     * The command to save a file is 'pen <color_string>.The filepath_string param is the complete path for path where the file need to be saved.
     * 
     */
    PEN("pen","<color_string>", new PenCommand(),"description goes here"),

    /**
     * The command to save a file is 'fill <flag_boolean>.The filepath_string param is the complete path for path where the file need to be saved.
     * <flag_boolean> can be on or off only
     */
    FILL("fill","<flag_boolean>", new FillCommand(),"description goes here")
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
