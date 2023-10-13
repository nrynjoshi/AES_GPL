package com.narayanjoshi.gplapplication;

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
        run(canvasUtilValidate);

        //this will run drawing for run event
        CanvasUtil canvasUtil = new CanvasUtil(canvasId);
        run(canvasUtil);
    }

    /**
     * this will process the code for validation of syntax.
     * */
    public void syntax(){
        CanvasUtil canvasUtil = new CanvasUtil(canvasId, false);
        canvasUtil.setRunEvent(false);
        run(canvasUtil);
    }

    /**
     * This method check the single or multiple line of code and gives priority
     * to single line of code over multiple line of code.
     * */
    public void run( CanvasUtil canvasUtil){

        try{
            boolean isRunSingleLineCommand = isRunSingleLineCommand(commandSingle, commandMultiple);
            if(isRunSingleLineCommand){
                process(commandSingle, canvasUtil);
            }else{
                process(commandMultiple, canvasUtil);
            }
            if(!canvasUtil.isRunEvent()){
                Notifications.create().title("Build Success ").text("There are no error on given code.").position(Pos.TOP_RIGHT).hideAfter(Duration.millis(2000)).show();
            } else if(canvasUtil.isRun()){
                Notifications.create().title("Success ").text("Run successfully").position(Pos.TOP_RIGHT).hideAfter(Duration.millis(2000)).show();
            }
        }catch (CommandNotFound x){
            x.printStackTrace();
            if(x.getCode() == -1){
                Notifications.create().title("Error ").text(x.getMessage()).position(Pos.TOP_RIGHT).hideAfter(Duration.millis(6000)).showError();
            }else{
                Notifications.create().title("Info ").text(x.getMessage()).position(Pos.TOP_RIGHT).hideAfter(Duration.millis(4000)).showInformation();
            }
            throw x;
        }


    }

    /**
     * This method is responsible to split the instruction and get appropriate process instance
     * {@link CommandEnum} to perform operation of particular command. And validate the code
     * syntax and process it as per the event generate by the GPL application.
     * */
    public void process(String command, CanvasUtil canvasUtil){

        if(Util.isEmpty(command)){
            throw new CommandNotFound("Command has not passed.\nPlease write your command on console and press Run button.", -1);

        }

        String[] commandSplit = command.split("\n");

        canvasUtil.setUserInputCommands(command);

        for (int i = 0; i < commandSplit.length; i++) {
            String chunkCommand = commandSplit[i];
            if(Util.isEmpty(chunkCommand)){
                //ignore this as a new line
                continue;
            }

            CommandEnum commandEnum=Util.getCommandOperation(chunkCommand);
            if(commandEnum==null){
                throw new CommandNotFound(String.format("'%s' command does not exist.\nPlease check doc file for more information.", chunkCommand), -1);
            }
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
