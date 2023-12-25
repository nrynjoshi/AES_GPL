package com.narayanjoshi.gplapplication;


import com.narayanjoshi.gplapplication.exception.CommandNotFoundException;
import com.narayanjoshi.gplapplication.service.command.CommandEnum;
import com.narayanjoshi.gplapplication.service.command.draw.CircleCommand;
import com.narayanjoshi.gplapplication.service.command.draw.ResetCommand;


import com.narayanjoshi.gplapplication.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

/**
 * utility class code test
 * */
public class UtilTest {

    //-----------------------------validateCommand---------------------

    /**
     * This test case will validate the validation logic of command as per command part
     * with parameter number and parameter data type
     * This will except exception due to pen command has color parameter and has not passed
     * */
    @Test
    public void testWithValidUserCommandAndNoArgs_validateCommand(){
        Assertions.assertThrows(
                CommandNotFoundException.class,
                () -> Util.validateCommand("pen",Arrays.asList(), CommandEnum.PEN),
                "pen <colorName> command parameter is not defined properly."
        );
    }

    /**
     * This test case will validate the validation logic of command as per command part
     * with parameter number and parameter data type
     * This will except exception due to pen12 is not a defined command, although it has valid value.
     * */
    @Test
    public void testWithInvalidUserCommandAndArgs_validateCommand(){
        Assertions.assertThrows(
                CommandNotFoundException.class,
                () -> Util.validateCommand("pen12 red",Arrays.asList("red"), CommandEnum.PEN),
                "pen <colorName> command parameter is not defined properly."
        );
    }

    /**
     * This test case will validate the validation logic of command as per command part
     * with parameter number and parameter data type
     * This will except exception due to pen12 is not a defined command, although parameter is not present.
     * */
    @Test
    public void testWithInvalidUserCommandAndNoArgs_validateCommand(){
        Assertions.assertThrows(
                CommandNotFoundException.class,
                () -> Util.validateCommand("pen12", Arrays.asList(), CommandEnum.PEN),
                "pen <colorName> command is not defined."
        );
    }

    /**
     * This test case will validate the validation logic of command as per command part
     * with parameter number and parameter data type
     * This will run successfully without any exception because pen command with red color is valid one.
     * */
    @Test
    public void testWithValidUserCommandAndArgs_validateCommand(){
        Util.validateCommand("pen",Arrays.asList("red"), CommandEnum.PEN);
    }

    /**
     * This test case will validate the validation logic of command as per command part
     * with parameter number and parameter data type
     * This will run successfully without any exception because clear command has no param.
     * */
    @Test
    public void testWithValidateCommand_emptyArgsDefined_validateCommand(){
        Util.validateCommand("clear",Arrays.asList(), CommandEnum.CLEAR);
    }

    /**
     * This test case will validate the validation logic of command as per command part
     * with parameter number and parameter data type
     * This will run successfully without any exception because clear command has no param and only space in value will be ignored.
     * */
    @Test
    public void testWithValidateCommand_noArgsDefinedButSpace_validateCommand(){
        Util.validateCommand("clear",Arrays.asList(), CommandEnum.CLEAR);
    }

    /**
     * This test case will validate the validation logic of command as per command part
     * with parameter number and parameter data type
     * This will run successfully without any exception because reset command has no param and null will be considered as no param.
     * */
    @Test
    public void testWithValidateCommand_nullArgsDefined_validateCommand(){
        Util.validateCommand("reset",Arrays.asList(), CommandEnum.RESET);
    }

    //--------------------------isNotEmpty-------------

    /**
     * This test case will validate isNotEmpty function logic with different cases.
     * if null passed as value it should be empty so return value should be false.
     * */
    @Test
    public void testWithNull_isNotEmpty(){
        Assertions.assertFalse(Util.isNotEmpty(null));
    }

    /**
     * This test case will validate isNotEmpty function logic with different cases.
     * if '' passed as value it should be empty so return value should be false.
     * */
    @Test
    public void testWithEmptyString_isNotEmpty(){
        Assertions.assertFalse(Util.isNotEmpty(""));
    }

    /**
     * This test case will validate isNotEmpty function logic with different cases.
     * if ' ' passed as value it should be empty so return value should be false.
     * */
    @Test
    public void testWithSpaceInString_isNotEmpty(){
        Assertions.assertFalse(Util.isNotEmpty(" "));
    }

    /**
     * This test case will validate isNotEmpty function logic with different cases.
     * if 'pen' passed as value it should not be empty so return value should be true.
     * */
    @Test
    public void testWithValidString_isNotEmpty(){
        Assertions.assertTrue(Util.isNotEmpty("pen"));
    }

    //--------------------------getAllParameterFromCommand-------------

    /**
     * This test case validate parameter retrieve logic from full command
     * if null passed as value then there will be no parameter so value should be 0.
     * */
    @Test
    public void testWithNull_getAllParameterFromCommand(){
        List<String> allParameterFromCommand = Util.getAllParameterFromCommand(null);
        Assertions.assertEquals(0, allParameterFromCommand.size());
    }

    /**
     * This test case validate parameter retrieve logic from full command
     * if '' passed as value then there will be no parameter so value should be 0.
     * */
    @Test
    public void testWithEmptyString_getAllParameterFromCommand(){
        List<String> allParameterFromCommand = Util.getAllParameterFromCommand("");
        Assertions.assertEquals(0, allParameterFromCommand.size());
    }

    /**
     * This test case validate parameter retrieve logic from full command
     * if '  ' passed as value then there will be no parameter so value should be 0.
     * */
    @Test
    public void testWithSpaceInString_getAllParameterFromCommand(){
        List<String> allParameterFromCommand = Util.getAllParameterFromCommand("   ");
        Assertions.assertEquals(0, allParameterFromCommand.size());
    }

    /**
     * This test case validate parameter retrieve logic from full command
     * if 'rectangle 100,150' passed as value then there will be two parameter.
     * */
    @Test
    public void testWithTwoParam_getAllParameterFromCommand(){
        List<String> allParameterFromCommand = Util.getAllParameterFromCommand("rectangle 100,150");
        Assertions.assertEquals(2, allParameterFromCommand.size());
        Assertions.assertEquals("100", allParameterFromCommand.get(0), "First parameter does not match");
        Assertions.assertEquals("150", allParameterFromCommand.get(1), "Second parameter does not match");

    }
    /**
     * This test case validate parameter retrieve logic from full command
     * if 'clear' passed as value then there will be no parameter so value should be 0.
     * */
    @Test
    public void testWithNoParam_getAllParameterFromCommand(){
        List<String> allParameterFromCommand = Util.getAllParameterFromCommand("clear");
        Assertions.assertEquals(0, allParameterFromCommand.size());
    }

    /**
     * This test case validate parameter retrieve logic from full command
     * if ' clear' passed as value then there will be no parameter so value should be 0, although it has space in front.
     * */
    @Test
    public void testWithParamAndSpaceBefore_getAllParameterFromCommand(){
        List<String> allParameterFromCommand = Util.getAllParameterFromCommand("  clear");
        Assertions.assertEquals(0, allParameterFromCommand.size());
    }

    /**
     * This test case validate parameter retrieve logic from full command
     * if ' clear' passed as value then there will be no parameter so value should be 0, although it has space at end.
     * */
    @Test
    public void testWithParamAndSpaceAfter_getAllParameterFromCommand(){
        List<String> allParameterFromCommand = Util.getAllParameterFromCommand("clear  ");
        Assertions.assertEquals(0, allParameterFromCommand.size());
    }

    /**
     * This test case validate parameter retrieve logic from full command
     * if ' clear ' passed as value then there will be no parameter so value should be 0, although it has space in between.
     * */
    @Test
    public void testWithParamAndSpaceBeforeAndAfter_getAllParameterFromCommand(){
        List<String> allParameterFromCommand = Util.getAllParameterFromCommand("  clear  ");
        Assertions.assertEquals(0, allParameterFromCommand.size());
    }

    //--------------------------getCommandOperation-------------
    /**
     * This test case validate command enum operation value if different command passed to process
     * if null passed as command, then  it will except exception with command not exist error message.
     * */
    @Test
    public void testWithNull_getCommandOperation(){
        Assertions.assertThrows(
                CommandNotFoundException.class,
                () -> Util.getCommandOperation(null),
                "'null' command does not exist.\n" +
                        "Please check doc file for more information."
        );

    }

    /**
     * This test case validate command enum operation value if different command passed to process
     * if '' passed as command, then  it will except exception with command not exist error message.
     * */
    @Test
    public void testWithEmptyString_getCommandOperation(){
        Assertions.assertThrows(
                CommandNotFoundException.class,
                () -> Util.getCommandOperation(""),
                "'' command does not exist.\n" +
                        "Please check doc file for more information."
        );
    }

    /**
     * This test case validate command enum operation value if different command passed to process
     * if '  ' passed as command, then  it will except exception with command not exist error message.
     * */
    @Test
    public void testWithSpaceInString_getCommandOperation(){
        Assertions.assertThrows(
                CommandNotFoundException.class,
                () -> Util.getCommandOperation("  "),
                "'  ' command does not exist.\n" +
                        "Please check doc file for more information."
        );
    }

    /**
     * This test case validate command enum operation value if different command passed to process
     * if 'reset' passed as command, then  it will except Rest Command instance from particular commandEnum.getCommandInstance()
     * */
    @Test
    public void testWithValidString_getCommandOperation(){
        CommandEnum commandOperation = Util.getCommandOperation("reset");
        Assertions.assertEquals(new ResetCommand().getClass(),commandOperation.getCommandInstance().getClass(),"Command class does not match");
    }

    /**
     * This test case validate command enum operation value if different command passed to process
     * if 'circle 50' passed as command, then  it will except Circle Command instance from particular commandEnum.getCommandInstance()
     * */
    @Test
    public void testWithValidStringAndParam_getCommandOperation(){
        CommandEnum commandOperation = Util.getCommandOperation("circle 50");
        Assertions.assertEquals(new CircleCommand().getClass(),commandOperation.getCommandInstance().getClass(),"Command class does not match");

    }
}
