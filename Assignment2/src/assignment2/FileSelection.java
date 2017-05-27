/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
import java.io.File;
import java.nio.file.Path;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
/**
 *
 * @author jaknd
 */
public class FileSelection extends JFrame {
    
    public FileSelection()
    {
        super("ChooseFile");
    }
    
    public Path GetFile()
    {
        JFileChooser l_fileChooser = new JFileChooser();
        File l_dir = new File(System.getProperty("user.dir"));
        l_fileChooser.setCurrentDirectory(l_dir);
        l_fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int l_result = l_fileChooser.showOpenDialog(this);
        
        if (l_result == JFileChooser.CANCEL_OPTION)
            return null;
        
        return l_fileChooser.getSelectedFile().toPath();
    }
    
}
