package com.example.gplapplication;

import java.util.ArrayList;
import java.util.Arrays;
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

        // check first with first one and other rest as param
        String[] words1 = inputCommand.split("\\s+");
        List<String> al = Arrays.asList(words1);
        if(al.size()>1){
            al.remove(0);
        }


        List<String> actualParamValue = new ArrayList<>();
        for (int i = 0; i < al.size(); i++) {
            String arg = al.get(i);
            String[] paramValues = arg.split(",");
            actualParamValue.addAll(Arrays.asList(paramValues));
        }

        actualParamValue = actualParamValue.stream().filter(data -> isNotEmpty(data)).map(data -> data.trim()).collect(Collectors.toList());

        if(validCommandParamCount != actualParamValue.size()){
            throw new CommandNotFound("Command is not valid or parameter is not defined properly.");
        }

        for (String str: actualParamValue) {
            System.out.println("---- Actual param split ----");
            System.out.println(" -> "+str);
        }
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
        return inputCommand.toLowerCase().startsWith(validCommand.toLowerCase());
    }

    public static List<String> fetchParameterFromCommand(String inputStatement, String command){

        return null;
    }
}
