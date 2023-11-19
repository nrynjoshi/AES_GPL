package com.narayanjoshi.gplapplication.service;

import com.narayanjoshi.gplapplication.exception.CommandNotFoundException;
import com.narayanjoshi.gplapplication.service.command.programming.ProgrammingRootCommand;
import com.narayanjoshi.gplapplication.util.Util;
import com.narayanjoshi.gplapplication.exception.CommandNotFoundException;
import com.narayanjoshi.gplapplication.service.command.CommandEnum;
import com.narayanjoshi.gplapplication.util.CanvasUtil;
import com.narayanjoshi.gplapplication.util.GPLShowMessage;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The {@code CommandParser} class is responsible to perform all operation like 
 * identifying command and class that instance to perform operation.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class CommandParser {

    /**
     * This commandSingle holds single line of code for parser.
     * */
    private final String commandSingle;

    /**
     * This commandMultiple holds multiple line of code for parser.
     * */
    private final String commandMultiple;

    /**
     * This canvasId holds canvas for performing operation on GPL application.
     * for more information @see Canvas
     * */
    public Canvas canvasId;

    /**
     * @param canvasId canvas instance
     * @param commandSingle user provided single line of code.
     * @param commandMultiple  user provided multiple line of code.
     * */
    public CommandParser(Canvas canvasId, String commandSingle, String commandMultiple){
        this.canvasId = canvasId;
        this.commandSingle= commandSingle;
        this.commandMultiple = commandMultiple;
    }

    /**
     * this will process the run operation of command
     * */
    public void run() {
        //this will run validate for run event
        CanvasUtil canvasUtilValidate = new CanvasUtil(canvasId, false);
        checkSingleOrMultiLineCodeAndProcessAccordingly(canvasUtilValidate);

        //this will run drawing for run event
        CanvasUtil canvasUtil = new CanvasUtil(canvasId);
        checkSingleOrMultiLineCodeAndProcessAccordingly(canvasUtil);
    }

    /**
     * this will process the code for validation of syntax.
     * */
    public void syntax(){
        CanvasUtil canvasUtil = new CanvasUtil(canvasId, false);
        canvasUtil.setRunEvent(false);
        checkSingleOrMultiLineCodeAndProcessAccordingly(canvasUtil);
    }

    /**
     * This method check the single or multiple line of code and gives priority
     * to single line of code over multiple line of code.
     * */
    public void checkSingleOrMultiLineCodeAndProcessAccordingly(CanvasUtil canvasUtil){

        try{
            boolean isRunSingleLineCommand = isRunSingleLineCommand(commandSingle, commandMultiple);
            if(isRunSingleLineCommand){
                processTheGivenInstruction(commandSingle, canvasUtil);
            }else{
                processTheGivenInstruction(commandMultiple, canvasUtil);
            }

            String messagePrefix = isRunSingleLineCommand?"Single line code":"Multiple line code";
            if(!canvasUtil.isRunEvent()){
                GPLShowMessage.showBuildSuccess(messagePrefix+" compiles successfully.");
            } else if(canvasUtil.isRun()){
                GPLShowMessage.showSuccess(messagePrefix+" run successfully.");
            }
        }catch (CommandNotFoundException x){
            x.printStackTrace();
            if(x.getCode() == -1){
                GPLShowMessage.showError(x.getMessage());
            }else{
                GPLShowMessage.showInfo(x.getMessage());
            }
            throw x;
        }


    }

    /**
     * This method is responsible to split the instruction and get appropriate process instance
     * {@link CommandEnum} to perform operation of particular command. And validate the code
     * syntax and process it as per the event generate by the GPL application.
     * */
    public void processTheGivenInstruction(String command, CanvasUtil canvasUtil){

        if(Util.isEmpty(command)){
            throw new CommandNotFoundException("Command has not passed.\nPlease write your command on console and press Run button.", -1);

        }

        String[] commandSplit = command.split("\n");


        for (int i = 0; i < commandSplit.length; i++) {
            String chunkCommand = commandSplit[i];
            if(Util.isEmpty(chunkCommand)){
                //ignore this as a new empty line
                continue;
            }

            chunkCommand = chunkCommand.trim();

            CommandEnum commandEnum=Util.getCommandOperation(chunkCommand);

            canvasUtil.setUserInputCommandLineByLine(chunkCommand);
            RootCommandIfc gplEngine = commandEnum.getCommandInstance();
            gplEngine.init(canvasUtil, commandEnum);

            gplEngine.validate();


            if (canvasUtil.isRun() || gplEngine instanceof ProgrammingRootCommand) {
                gplEngine.execute();
            }
        }
    }

    /**
     * */
    private boolean isRunSingleLineCommand(String commandSingle, String commandMultiple) {
        if(Util.isNotEmpty(commandSingle)){
            return true;
        }else if(Util.isNotEmpty(commandMultiple)){
            return false;
        }
        throw new CommandNotFoundException("Command has not passed.\nPlease write your command on console and press Run button.", 1);

    }



}
