/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProGApp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Formatter;
import org.json.JSONObject;

/**
 *
 * @author DUONG.BuiQuang
 */
public class FileService {
  public static void writeFile(JSONObject payload) throws IOException {
    try (FileWriter myWriter = new FileWriter("payload")) {
      myWriter.write(payload.toString());  
      System.out.println(payload.toString());
      System.out.println("write file successfully");
    }
  }
  
  public static boolean checkFileExists() {
    File file = new File("payload");
    return file.exists();
  }
  
  public static void createFile() throws IOException {
    File file = new File("payload");
    file.createNewFile();
  }  
  public static JSONObject readFile() throws FileNotFoundException {
    String data = null;
    File myObj = new File("payload");
    try (Scanner myReader = new Scanner(myObj)) {
      while (myReader.hasNextLine()) {
        data = myReader.nextLine();
      }
    }
    return new JSONObject(data);
  }
  
  public static void deleteFile() {
    File myObj = new File("payload"); 
    if (myObj.delete()) { 
      System.out.println("Deleted the file: " + myObj.getName());
    } else {
      System.out.println("Failed to delete the file.");
    }
  }
}
