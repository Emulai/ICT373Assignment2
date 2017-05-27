/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 *
 * @author jaknd
 */
public class ReadFromFile {
    private ObjectInputStream input;
    
    public ReadFromFile()
    {
        
    }
    
    public void OpenFile(String p_fileName) throws IOException
    {
        input = new ObjectInputStream(
            Files.newInputStream(Paths.get(p_fileName)));
    }
    
    public FamilyTree ReadRecord() throws EOFException, 
                                          ClassNotFoundException, 
                                          IOException
    {
        FamilyTree l_fTree = (FamilyTree) input.readObject();
        return l_fTree;
    }
    
    public void CloseFile() throws IOException
    {
        if (input != null)
            input.close();
    }
    
}
