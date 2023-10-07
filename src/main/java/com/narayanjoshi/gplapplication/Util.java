package com.narayanjoshi.gplapplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Util {

    public static void validateCommand(String inputCommand, String validCommand, String validParam){

        if(!checkBothCommandStartWithSameWord(inputCommand, validCommand)){
            throw new CommandNotFound( String.format("%s command is not defined.", validCommand +" "+validParam), -1);
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
            throw new CommandNotFound( String.format("%s command parameter is not defined properly.", validCommand +" "+validParam), -1);
        }

    }

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

    private static boolean checkBothCommandStartWithSameWord(String command1, String command2) {
        // Split the strings into words
        String[] words1 = command1.split("\\s+");

        // Check if both arrays have at least one word and if the first words are the same
        return (words1.length > 0 && !command2.isEmpty() && words1[0].equals(command2));
    }

    public static boolean isEmpty(String content){
        return !isNotEmpty(content);
    }

    public static boolean isNotEmpty(String content){
        return content != null && !content.trim().isEmpty();
    }


    private static boolean validateForCommand(String inputCommand, String validCommand){
        String inputCommandSplit = inputCommand.toLowerCase().split("\\s+")[0];
        String validCommandSplit = validCommand.toLowerCase().split("\\s+")[0];
        return inputCommandSplit.startsWith(validCommandSplit);
    }

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
}
