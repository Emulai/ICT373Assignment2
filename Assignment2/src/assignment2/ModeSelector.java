/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.EOFException;
import java.nio.file.Path;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
/**
 *
 * @author jaknd
 */
public class ModeSelector extends JFrame {
    private FamilyTree m_familyTree;
    private final JButton m_viewMode;
    private final JButton m_editMode;
    
    public ModeSelector()
    {   
        super("Choose Mode -- Family Tree");
        
        InitMenu();
        
        setLayout(new GridLayout(2,1));
        
        m_viewMode = new JButton("View Mode");
        add(m_viewMode);
        
        m_editMode = new JButton("Edit Mode");
        add(m_editMode);
        
        MenuHandler handler = new MenuHandler();
        m_viewMode.addActionListener(handler);
        m_editMode.addActionListener(handler);
    }
    
    public void InitMenu()
    {
        JMenu l_fileMenu = new JMenu("File");
        l_fileMenu.setMnemonic('F');
        
        JMenuItem l_openFile = new JMenuItem("Open...");
        l_openFile.setMnemonic('O');
        l_fileMenu.add(l_openFile);
        FileHandler l_fileHandler = new FileHandler();
        l_openFile.addActionListener(l_fileHandler);
        
        JMenuBar l_menuBar = new JMenuBar();
        setJMenuBar(l_menuBar);
        l_menuBar.add(l_fileMenu);
    }
    
    private class MenuHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if (m_familyTree != null)
            {
                if (event.getSource() == m_viewMode)
                {
                    ViewMode l_vMode = new ViewMode(m_familyTree);
                    l_vMode.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    l_vMode.setVisible(true);
                    dispose();
                }
                else if (event.getSource() == m_editMode)
                {
                    System.out.println("Eat a dick");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select a file before continuing");
            }
        }
    }
    
    private class FileHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            FileSelection l_fileSelect = new FileSelection();
            ReadFromFile l_inFile = new ReadFromFile();
            
            Path l_path = l_fileSelect.GetFile();
            if (l_path != null)
            {
                m_familyTree = null;
                try
                {
                    l_inFile.OpenFile(l_path);
                    m_familyTree = l_inFile.ReadRecord();
                    l_inFile.CloseFile();
                }
                catch (EOFException e)
                {
                    System.err.println(e);
                }
                catch (IOException | ClassNotFoundException e)
                {
                    System.err.println(e);
                }
            }
        }
    }
    
}
