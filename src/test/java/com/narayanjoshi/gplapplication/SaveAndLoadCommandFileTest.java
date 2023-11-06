
package com.narayanjoshi.gplapplication;

import java.io.File;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.scene.canvas.Canvas;

public class SaveAndLoadCommandFileTest{

    String save_file_path = "C:\\Users\\USLEGAL\\OneDrive - Leeds Beckett University\\Advance Software Engineering\\assignment 1\\save_program.txt";
	String read_file_path = "C:\\Users\\USLEGAL\\OneDrive - Leeds Beckett University\\Advance Software Engineering\\assignment 1\\read_program.txt";

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
    
    
    @Test
    public void testReadFromFile(){
    	String readCommand = Util.readFromFile(read_file_path);
    	Assertions.assertEquals(cmd, readCommand, "File read content and save content not matched.");
    }
 
    @Test
    public void testSaveToFile(){
	 	Util.saveContentToFile(save_file_path, cmd);
    }
    
}
