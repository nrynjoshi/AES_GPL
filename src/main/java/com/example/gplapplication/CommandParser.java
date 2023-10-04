package com.example.gplapplication;


import com.example.gplapplication.service.*;
import com.example.gplapplication.service.command.*;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class CommandParser {

    private final String commandSingle;
    private final String commandMultiple;
    public Canvas canvasId;

    CommandParser(Canvas canvasId, String commandSingle, String commandMultiple){
        this.canvasId = canvasId;
        this.commandSingle= commandSingle;
        this.commandMultiple = commandMultiple;
    }

    public void run() {
        CanvasUtil canvasUtil = new CanvasUtil(canvasId);
        run(canvasUtil);
    }

    public void syntax(){
        CanvasUtil canvasUtil = new CanvasUtil(canvasId, false);
        run(canvasUtil);

    }

    public void run( CanvasUtil canvasUtil){

        try{
            boolean isRunSingleLineCommand = isRunSingleLineCommand(commandSingle, commandMultiple);
            if(isRunSingleLineCommand){
                process(commandSingle, canvasUtil);
            }else{
                process(commandMultiple, canvasUtil);
            }
            if(!canvasUtil.isRun()){
                Notifications.create().title("Build Success ").text("There is no error on given code.").position(Pos.TOP_RIGHT).hideAfter(Duration.millis(2000)).show();

            }
            Notifications.create().title("Success ").text("Operation Perform successfully").position(Pos.TOP_RIGHT).hideAfter(Duration.millis(2000)).show();
        }catch (CommandNotFound x){
            x.printStackTrace();
            if(x.getCode() == -1){
                Notifications.create().title("Error ").text(x.getMessage()).position(Pos.TOP_RIGHT).hideAfter(Duration.millis(6000)).showError();
            }else{
                Notifications.create().title("Info ").text(x.getMessage()).position(Pos.TOP_RIGHT).hideAfter(Duration.millis(4000)).showInformation();
            }
        }


    }

    private void process(String command, CanvasUtil canvasUtil){
        String[] commandSplit = command.split("\n");

        canvasUtil.setUserInputCommands(command);

        for (int i = 0; i < commandSplit.length; i++) {
            String chunkCommand = commandSplit[i];
            RootCommandIfc gplEngine = null;
            if(Util.validateForCommand(chunkCommand, CommandEnum.COMMENT.getCommand()) || !Util.isNotEmpty(chunkCommand)){
                gplEngine = new CommentCommand(canvasUtil);
            }else if(Util.validateForCommand(chunkCommand, CommandEnum.DRAW_TO.getCommand())){
                gplEngine = new DrawToCommand(canvasUtil);
            }else if(Util.validateForCommand(chunkCommand,CommandEnum.MOVE_TO.getCommand())){
                gplEngine = new MoveToCommand(canvasUtil);
            }else if(Util.validateForCommand(chunkCommand,CommandEnum.CLEAR.getCommand())){
                gplEngine = new ClearCommand(canvasUtil);
            }else if(Util.validateForCommand(chunkCommand,CommandEnum.RESET.getCommand())){
                gplEngine = new ResetCommand(canvasUtil);
            }else if(Util.validateForCommand(chunkCommand,CommandEnum.PEN.getCommand())){
                gplEngine = new PenCommand(canvasUtil);
            }else if(Util.validateForCommand(chunkCommand,CommandEnum.SAVE_TO_FILE.getCommand())){
                new SaveToFileCommand(canvasUtil);
                continue;
            }else if(Util.validateForCommand(chunkCommand,CommandEnum.READ_FROM_FILE.getCommand())){
                new ReadFromFileCommand(canvasUtil);
                continue;
            }else if(Util.validateForCommand(chunkCommand,CommandEnum.FILL.getCommand())){
                gplEngine = new FillCommand(canvasUtil);
            }else if(Util.validateForCommand(chunkCommand, CommandEnum.RECTANGLE.getCommand())){
                gplEngine= new RectangleCommand(canvasUtil);
            }else if(Util.validateForCommand(chunkCommand, CommandEnum.TRIANGLE.getCommand())){
                gplEngine= new TriangleCommand(canvasUtil);
            }else if(Util.validateForCommand(chunkCommand, CommandEnum.CIRCLE.getCommand())){
                gplEngine= new CircleCommand(canvasUtil);
            }else {
                throw new CommandNotFound(String.format("%s command does not exist.", chunkCommand), -1);
            }

            gplEngine.validate(chunkCommand);

            if (canvasUtil.isRun()) {
                gplEngine.draw(chunkCommand);
            }

        }
    }

    private boolean isRunSingleLineCommand(String commandSingle, String commandMultiple) {
        if(Util.isNotEmpty(commandSingle)){
            return true;
        }else if(Util.isNotEmpty(commandMultiple)){
            return false;
        }
        throw new CommandNotFound("No command has been passed.", 1);
    }



}
