package com.narayanjoshi.gplapplication;

import com.narayanjoshi.gplapplication.service.GPLShowMessage;
import com.narayanjoshi.gplapplication.service.RootCommandIfc;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

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
    public void checkSingleOrMultiLineCodeAndProcessAccordingly( CanvasUtil canvasUtil){

        try{
            boolean isRunSingleLineCommand = isRunSingleLineCommand(commandSingle, commandMultiple);
            if(isRunSingleLineCommand){
                processTheGivenInstruction(commandSingle, canvasUtil);
            }else{
                processTheGivenInstruction(commandMultiple, canvasUtil);
            }
            if(!canvasUtil.isRunEvent()){
                GPLShowMessage.showBuildSuccess("Code compiles successfully.");
            } else if(canvasUtil.isRun()){
                GPLShowMessage.showSuccess("Code run successfully.");
            }
        }catch (CommandNotFound x){
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
            throw new CommandNotFound("Command has not passed.\nPlease write your command on console and press Run button.", -1);

        }

        String[] commandSplit = command.split("\n");

        canvasUtil.setUserInputCommands(command);

        for (int i = 0; i < commandSplit.length; i++) {
            String chunkCommand = commandSplit[i];
            if(Util.isEmpty(chunkCommand)){
                //ignore this as a new empty line
                continue;
            }

            chunkCommand = chunkCommand.trim();

            CommandEnum commandEnum=Util.getCommandOperation(chunkCommand);

            RootCommandIfc gplEngine = commandEnum.getCommandInstance();
            gplEngine.init(canvasUtil, commandEnum);

            gplEngine.validate(chunkCommand);

            if (canvasUtil.isRun()) {
                gplEngine.draw(chunkCommand);
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
        throw new CommandNotFound("Command has not passed.\nPlease write your command on console and press Run button.", 1);

    }



}
