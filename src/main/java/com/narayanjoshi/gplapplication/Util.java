package com.narayanjoshi.gplapplication;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * The {@code Util} class is a utility to support GPL application to perform work.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class Util {

    /**
     * validate the input command and param with system defined command and param
     *
     * @throws CommandNotFound for any invalid result form comparison
     *launch
     * @param inputCommand This param consist of command with param given from user input
     * @param validCommandOnly This param consist of command only which is predefined by system.
     * @param validParam This param consist of pattern parameters with  number of parameter
     *                   required by predefined command.
     * */
    public static void validateCommand(String inputCommand, String validCommandOnly, String validParam){

        if(!checkBothCommandStartWithSameWord(inputCommand, validCommandOnly)){
            throw new CommandNotFound( String.format("'%s' command has not defined", inputCommand), -1);
        }

        //if command validation passed and that valid command is comment
        // then no need to check parameter
        if(CommandEnum.COMMENT.getCommand().equalsIgnoreCase(validCommandOnly)){
            return;
        }

        //split into multiple command
        int validCommandParamCount = 0;
        if(validParam !=null && validParam.length()>0){
            String regex = "<[^>]+>";
            Matcher validCommandMatcher = Pattern.compile(regex).matcher(validParam);
            while (validCommandMatcher.find()) {
                validCommandParamCount++;
            }
        }

        List<String> actualParamValue = getAllParameterFromCommand(inputCommand);

        if(validCommandParamCount != actualParamValue.size()){
            throw new CommandNotFound( String.format("'%s %s' command parameter does not match.\nError on '%s'",validCommandOnly, isEmpty(validParam)?"":validParam, inputCommand), -1);
        }

    }

    /**
     * get all parameter values from user input command
     *
     * @param inputCommand This param consist of command with param given from user input
     *
     * @return this will return list with input command parameter values in the given order
     */
    public static List<String> getAllParameterFromCommand(String inputCommand){

        if(isEmpty(inputCommand)){
            return Collections.EMPTY_LIST;
        }

        // check first with first one and other rest as param
        String[] words1 = inputCommand.trim().split("\\s+");
        List<String> al = Arrays.asList(words1);


        List<String> actualParamValue = new ArrayList<>();
        for (int i = 1; i < al.size(); i++) {
            String arg = al.get(i);
            if(isNotEmpty(arg)){
                String[] paramValues = arg.split(",");
                actualParamValue.addAll(Arrays.asList(paramValues));
            }
        }

        actualParamValue = actualParamValue.stream().filter(data -> isNotEmpty(data)).map(data -> data.trim()).collect(Collectors.toList());

        return actualParamValue;
    }

    /**
     * check input and predefined command has same word
     *
     * @param command1 This param consist of command with param given from user input
     * @param command2 This param consist of command with param given from user input
     *
     * @return boolean value, true if match and false if not match
     */
    private static boolean checkBothCommandStartWithSameWord(String command1, String command2) {
        // Split the strings into words
        String[] words1 = command1.split("\\s+");

        // Check if both arrays have at least one word and if the first words are the same
        return (words1.length > 0 && !command2.isEmpty() && words1[0].toLowerCase().trim().equals(command2.toLowerCase().trim()));
    }

    /**
     * check pass value is empty or not
     *
     * @param content this is the string value
     *
     * @return boolean value, true if match and false if not match
     */
    public static boolean isEmpty(String content){
        return !isNotEmpty(content);
    }

    /**
     * check pass value is not empty
     *
     * @param content this is the string value
     *
     * @return boolean value, true if match and false if not match
     */
    public static boolean isNotEmpty(String content){
        return content != null && !content.trim().isEmpty();
    }

    /**
     * check pass value is validated and compare with lowercase
     *
     * @param inputCommand this is the string value
     * @param validCommand this is the string value
     *
     * @return boolean value, true if match and false if not match
     */
    private static boolean validateForCommand(String inputCommand, String validCommand){
        String inputCommandSplit = inputCommand.toLowerCase().split("\\s+")[0];
        String validCommandSplit = validCommand.toLowerCase().split("\\s+")[0];
        return inputCommandSplit.startsWith(validCommandSplit);
    }

    /**
     * get process instance from the given command
     *
     * @param chunkCommand user input command to fetch the process instance {@link CommandEnum}
     *
     * @return {@link CommandEnum} enum value with contain command, param pattern, process instance
     */
    public static CommandEnum getCommandOperation(String chunkCommand){
        for(CommandEnum commandEnum : CommandEnum.values()){
            try {
                if((Util.validateForCommand(chunkCommand, commandEnum.getCommand()) && Util.isNotEmpty(chunkCommand))){
                    return commandEnum;
                }
            }catch (Exception x){
               //ignore this one exception for command check with all available command so it will genreate alot exception
            }

        }
        return null;
    }

    /**
     * get process instance from the given command
     *
     * @param filePath file path where file is located with filename and extension
     *
     * @return {@link String} content from particular file path
     */
    public static String readFromFile(String filePath){
        Path path = Path.of(filePath);
        File file = path.toFile();
        if(!file.exists()){
            throw new CommandNotFound(String.format("'%s' file path does not exists or file not found.", filePath), -1);
        }
        // read the file
        String readCommand = null;
        try{
            readCommand = Files.readString(path);
            return readCommand;
        }catch (IOException x){
            throw new CommandNotFound(String.format("'%s' file can not be accessed.",filePath), -1);
        }
    }

    /**
     * get process instance from the given command
     *
     * @param filePath file path where file will be saved with filename and extension
     * @param content instruction/command passed by user
     *
     */
    public static void saveContentToFile(String filePath, String content){
        Path path = Paths.get(filePath);

        File file= path.toFile();
        if(file !=null){
            file.delete();
        }

        try{
            Files.write(path, content.getBytes(StandardCharsets.UTF_8));
        }catch (IOException x){
            x.printStackTrace();
            throw new CommandNotFound(String.format("'%s' filepath can not be created.",filePath), -1);

        }
    }
}
