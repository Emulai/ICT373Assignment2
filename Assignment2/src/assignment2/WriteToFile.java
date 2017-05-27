/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 *
 * @author jaknd
 */
public class WriteToFile {
    private ObjectOutputStream output;
    
    public WriteToFile()
    {
        
    }
    
    public void OpenFile(String p_fileName) throws IOException
    {
        output = new ObjectOutputStream(
            Files.newOutputStream(Paths.get(p_fileName)));
    }
    
    public void SaveRecord(FamilyTree p_tree) throws IOException
    {
        output.writeObject(p_tree);
    }
    
    public void CloseFile() throws IOException
    {
        if(output != null)
            output.close();
    }
    
}
