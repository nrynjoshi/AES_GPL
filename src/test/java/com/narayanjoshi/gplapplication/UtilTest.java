package com.narayanjoshi.gplapplication;


import com.narayanjoshi.gplapplication.service.command.CircleCommand;
import com.narayanjoshi.gplapplication.service.command.ResetCommand;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.List;

public class UtilTest {

    //-----------------------------validateCommand---------------------
    @Test
    public void testWithValidUserCommandAndNoArgs_validateCommand(){
        Assertions.assertThrows(
                CommandNotFound.class,
                () -> Util.validateCommand("pen","pen", "<colorName>"),
                "pen <colorName> command parameter is not defined properly."
        );
    }

    @Test
    public void testWithInvalidUserCommandAndArgs_validateCommand(){
        Assertions.assertThrows(
                CommandNotFound.class,
                () -> Util.validateCommand("pen12 red","pen", "<colorName>"),
                "pen <colorName> command parameter is not defined properly."
        );
    }

    @Test
    public void testWithInvalidUserCommandAndNoArgs_validateCommand(){
        Assertions.assertThrows(
                CommandNotFound.class,
                () -> Util.validateCommand("pen12",CommandEnum.PEN.getCommand(), CommandEnum.PEN.getParam()),
                "pen <colorName> command is not defined."
        );
    }

    @Test
    public void testWithValidUserCommandAndArgs_validateCommand(){
        Util.validateCommand("pen red",CommandEnum.PEN.getCommand(), CommandEnum.PEN.getParam());
    }

    @Test
    public void testWithValidateCommand_emptyArgsDefined_validateCommand(){
        Util.validateCommand("pen  ",CommandEnum.PEN.getCommand(), "");
    }

    @Test
    public void testWithValidateCommand_noArgsDefinedButSpace_validateCommand(){
        Util.validateCommand("pen",CommandEnum.PEN.getCommand(), "  ");
    }

    @Test
    public void testWithValidateCommand_nullArgsDefined_validateCommand(){
        Util.validateCommand("pen",CommandEnum.PEN.getCommand(), null);
    }

    //--------------------------isNotEmpty-------------
    @Test
    public void testWithNull_isNotEmpty(){
        Assertions.assertFalse(Util.isNotEmpty(null));
    }
    @Test
    public void testWithEmptyString_isNotEmpty(){
        Assertions.assertFalse(Util.isNotEmpty(""));
    }

    @Test
    public void testWithSpaceInString_isNotEmpty(){
        Assertions.assertFalse(Util.isNotEmpty(" "));
    }

    @Test
    public void testWithValidString_isNotEmpty(){
        Assertions.assertTrue(Util.isNotEmpty("pen"));
    }

    //--------------------------getAllParameterFromCommand-------------
    @Test
    public void testWithNull_getAllParameterFromCommand(){
        List<String> allParameterFromCommand = Util.getAllParameterFromCommand(null);
        Assertions.assertEquals(0, allParameterFromCommand.size());
    }
    @Test
    public void testWithEmptyString_getAllParameterFromCommand(){
        List<String> allParameterFromCommand = Util.getAllParameterFromCommand("");
        Assertions.assertEquals(0, allParameterFromCommand.size());
    }

    @Test
    public void testWithSpaceInString_getAllParameterFromCommand(){
        List<String> allParameterFromCommand = Util.getAllParameterFromCommand("   ");
        Assertions.assertEquals(0, allParameterFromCommand.size());
    }

    @Test
    public void testWithTwoParam_getAllParameterFromCommand(){
        List<String> allParameterFromCommand = Util.getAllParameterFromCommand("rectangle 100,100");
        Assertions.assertEquals(2, allParameterFromCommand.size());
    }

    @Test
    public void testWithNoParam_getAllParameterFromCommand(){
        List<String> allParameterFromCommand = Util.getAllParameterFromCommand("clear");
        Assertions.assertEquals(0, allParameterFromCommand.size());
    }

    @Test
    public void testWithParamAndSpaceBefore_getAllParameterFromCommand(){
        List<String> allParameterFromCommand = Util.getAllParameterFromCommand("  clear");
        Assertions.assertEquals(0, allParameterFromCommand.size());
    }

    @Test
    public void testWithParamAndSpaceAfter_getAllParameterFromCommand(){
        List<String> allParameterFromCommand = Util.getAllParameterFromCommand("clear  ");
        Assertions.assertEquals(0, allParameterFromCommand.size());
    }

    @Test
    public void testWithParamAndSpaceBeforeAndAfter_getAllParameterFromCommand(){
        List<String> allParameterFromCommand = Util.getAllParameterFromCommand("  clear  ");
        Assertions.assertEquals(0, allParameterFromCommand.size());
    }

    //--------------------------getCommandOperation-------------
    @Test
    public void testWithNull_getCommandOperation(){
        Assertions.assertThrows(
                CommandNotFound.class,
                () -> Util.getCommandOperation(null),
                "'null' command does not exist.\n" +
                        "Please check doc file for more information."
        );

    }
    @Test
    public void testWithEmptyString_getCommandOperation(){
        Assertions.assertThrows(
                CommandNotFound.class,
                () -> Util.getCommandOperation(""),
                "'' command does not exist.\n" +
                        "Please check doc file for more information."
        );
    }

    @Test
    public void testWithSpaceInString_getCommandOperation(){
        Assertions.assertThrows(
                CommandNotFound.class,
                () -> Util.getCommandOperation("  "),
                "'  ' command does not exist.\n" +
                        "Please check doc file for more information."
        );
    }

    @Test
    public void testWithValidString_getCommandOperation(){
        CommandEnum commandOperation = Util.getCommandOperation("reset");
        Assertions.assertEquals(new ResetCommand().getClass(),commandOperation.getCommandInstance().getClass(),"Command class does not match");
    }

    @Test
    public void testWithValidStringAndParam_getCommandOperation(){
        CommandEnum commandOperation = Util.getCommandOperation("circle 50");
        Assertions.assertEquals(new CircleCommand().getClass(),commandOperation.getCommandInstance().getClass(),"Command class does not match");

    }
}
