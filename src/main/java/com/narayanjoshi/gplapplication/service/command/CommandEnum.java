package com.narayanjoshi.gplapplication.service.command;

import com.narayanjoshi.gplapplication.service.RootCommandIfc;
import com.narayanjoshi.gplapplication.service.command.draw.*;
import com.narayanjoshi.gplapplication.service.command.programming.*;

/**
 * The {@code CommandEnum} class represents all command, parameter, and its process instance.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public enum CommandEnum {

	 /**
     * The command to save a file is 'saveToFile &lt;filepath_string&gt;'. The filepath_string param is the complete path for path where the file need to be saved.
     */
    SAVE_TO_FILE("saveToFile","<filepath_string>", new SaveToFileCommand(),"description goes here"),

    /**
     * The command to read a file is 'readFromFile &lt;filepath_string&gt;'. The filepath_string param is the complete path for path from where the file need to be read.
     */
    READ_FROM_FILE("readFromFile","<filepath_string>", new ReadFromFileCommand(),"description goes here"),

    /**
     * The command to move a pen is 'moveTo &lt;x_float&gt;,&lt;y_float&gt;'.
     */
    MOVE_TO("moveTo","<x_float>,<y_float>", new MoveToCommand(),"description goes here"),

    /**
     * The command to draw a circle is 'circle &lt;radius_float&gt;'.
     */
    CIRCLE("circle","<radius_float>", new CircleCommand(),"description goes here"),

    /**
     * The command to draw a rectangle is 'rectangle &lt;width_float&gt;,&lt;height_float&gt;'.
     */
    RECTANGLE("rectangle","<width_float>,<height_float>", new RectangleCommand(),"description goes here"),

    /**
     * The command to draw a triangle is 'triangle &lt;base_float&gt;,&lt;adjacent_float&gt;'.
     */
    TRIANGLE("triangle","<base_float>,<adjacent_float>", new TriangleCommand(),"description goes here"),

    /**
     * The command to draw a line is 'triangle &lt;base_float&gt;,&lt;adjacent_float&gt;'.
     */
    DRAW_TO("drawTo","<x_float>,<y_float>", new DrawToCommand(),"description goes here"),

    /**
     * The command to comment something in program is '\/\/ your_comment_goes here'.
     */
    COMMENT("//", null, new CommentCommand(),"description goes here"),

    /**
     * The command to clear a drawing is 'clear'.
     */
    CLEAR("clear", null, new ClearCommand(),"description goes here"),

    /**
     * The command to reset the drawing area is 'reset'.
     */
    RESET("reset", null, new ResetCommand(),"description goes here"),

    /**
     * The command to set a pen color for drawing outline or to fill a shape is 'pen &lt;color_string&gt;'.
     *
     */
    PEN("pen","<color_string>", new PenCommand(),"description goes here"),

    /**
     * The command to fill a shape is 'fill &lt;flag_boolean&gt;'.
     * &lt;flag_boolean&gt; attributes can have on or off values only
     */
    FILL("fill","<flag_boolean>", new FillCommand(),"description goes here"),

    /**
     * The command to fill a shape is 'fill &lt;flag_boolean&gt;'.
     * &lt;flag_boolean&gt; attributes can have on or off values only
     */
    VARIABLE("var","<varname=varvalue_string>", new VariableCommand(),"description goes here"),

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
