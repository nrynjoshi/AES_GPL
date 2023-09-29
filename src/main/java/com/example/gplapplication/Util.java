package com.example.gplapplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Util {

    public static void validateCommand(String inputCommand, String validCommand){

        if(!checkBothCommandStartWithSameWord(inputCommand, validCommand)){
            return;
        }

        //split into multiple command
        String regex = "<[^>]+>";
        Matcher validCommandMatcher = Pattern.compile(regex).matcher(validCommand);
        int validCommandParamCount = 0;
        while (validCommandMatcher.find()) {
            validCommandParamCount++;
        }

        List<String> actualParamValue = getAllParameterFromCommand(inputCommand);

        if(validCommandParamCount != actualParamValue.size()){
            throw new CommandNotFound("Command is not valid or parameter is not defined properly.");
        }

    }

    public static List<String> getAllParameterFromCommand(String inputCommand){

        // check first with first one and other rest as param
        String[] words1 = inputCommand.split("\\s+");
        List<String> al = Arrays.asList(words1);


        List<String> actualParamValue = new ArrayList<>();
        for (int i = 1; i < al.size(); i++) {
            String arg = al.get(i);
            String[] paramValues = arg.split(",");
            actualParamValue.addAll(Arrays.asList(paramValues));
        }

        actualParamValue = actualParamValue.stream().filter(data -> isNotEmpty(data)).map(data -> data.trim()).collect(Collectors.toList());

        return actualParamValue;
    }

    public static boolean checkBothCommandStartWithSameWord(String command1, String command2) {
        // Split the strings into words
        String[] words1 = command1.split("\\s+");
        String[] words2 = command2.split("\\s+");

        // Check if both arrays have at least one word and if the first words are the same
        return (words1.length > 0 && words2.length > 0 && words1[0].equals(words2[0]));
    }

    public static boolean isNotEmpty(String content){
        return content != null && !content.trim().isEmpty();
    }

    public static boolean equalsIgnoreCase(String inputCommand, String validCommand){
        return inputCommand.equalsIgnoreCase(validCommand);
    }

    public static boolean startWithIgnoreCase(String inputCommand, String validCommand){
        String inputCommandSplit = inputCommand.toLowerCase().split("\\s+")[0];
        String validCommandSplit = validCommand.toLowerCase().split("\\s+")[0];
        return inputCommandSplit.startsWith(validCommandSplit);
    }

}
