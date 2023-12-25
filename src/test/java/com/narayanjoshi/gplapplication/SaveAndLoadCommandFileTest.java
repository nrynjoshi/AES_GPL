
package com.narayanjoshi.gplapplication;

import com.narayanjoshi.gplapplication.exception.CommandNotFound;
import com.narayanjoshi.gplapplication.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * save file and open file test
 * */
public class SaveAndLoadCommandFileTest{

	/**
	 * file path where command string will be saved for testing purpose
	 * */
    String save_file_path = "C:\\Users\\USLEGAL\\OneDrive - Leeds Beckett University\\Advance Software Engineering\\assignment 1\\save_program.txt";
	/**
	 * file path from where command will be retrieved for testing purpose
	 * */
	String read_file_path = "C:\\Users\\USLEGAL\\OneDrive - Leeds Beckett University\\Advance Software Engineering\\assignment 1\\read_program.txt";

	/**
	 * command which will be saved to save and compared with read file command
	 * */
	String cmd = "clear\r\n"
 			+ "pen red\r\n"
 			+ "moveTo 5,5\r\n"
 			+ "rectangle 150,100\r\n"
 			+ "pen gray\r\n"
 			+ "moveTo 150,100\r\n"
 			+ "circle 50\r\n"
 			+ "pen yellow\r\n"
 			+ "moveTo 50, 50\r\n"
 			+ "fill on\r\n"
 			+ "triangle 100,100\r\n"
 			+ "// new\r\n"
 			+ "fill off\r\n"
 			+ "pen blue\r\n"
 			+ "moveto 0, 200\r\n"
 			+ "rectangle 80,80\r\n"
 			+ "circle 80\r\n"
 			+ "moveto 25,205\r\n"
 			+ "triangle 50,50";

	/**
	 * read a command from valid file path
	 * */
    @Test
    public void testReadFromFile(){
    	String readCommand = Util.readFromFile(read_file_path);
    	Assertions.assertEquals(cmd, readCommand, "File read content and save content not matched.");
    }

	/**
	 * save a command to a valid file path
	 * */
    @Test
    public void testSaveToFile(){
	 	Util.saveContentToFile(save_file_path, cmd);
    }

	/**
	 * read a command from invalid file path
	 * */
	@Test
	public void testReadFromFileWithInvalidPath(){

		Assertions.assertThrows(
				CommandNotFound.class,
				() -> Util.readFromFile("d:\\njoshi\\test.txt"),
				"'d:\\njoshi\\test.txt' file path does not exists or file not found.");
	}

	/**
	 * save a command to invalid file path
	 * */
	@Test
	public void testSaveToFileWithInvalidPath(){
		Assertions.assertThrows(
				CommandNotFound.class,
				() -> Util.saveContentToFile("d:\\njoshi\\test.txt", cmd),
				"'d:\\njoshi\\test.txt' filepath can not be created.");
		;
	}
    
}
