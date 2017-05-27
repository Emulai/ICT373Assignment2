/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.io.IOException;
import java.io.EOFException;
import java.nio.file.Path;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
/**
 *
 * @author jaknd
 */
public class ViewMode extends JFrame {
    private FamilyTree m_familyTree;
    
    private JSplitPane splitPane;
    private JSplitPane treePane;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel treePanel;
    private JPanel descriptionPanel;
    private JPanel gPPanel;
    private JPanel pPanel;
    private JPanel cPanel;
    private JPanel gCPanel;
    
    private ArrayList<JButton> grandParent;
    private ArrayList<JButton> parent;
    private ArrayList<JButton> child;
    private ArrayList<JButton> grandChild;
    
    private JScrollPane detailScroll;
    private JScrollPane descriptionScroll;
    private JTextArea tree;
    private JTextArea description;
    private JTextArea details;
    
    private JPanel m_panel;
    
    private JMenuItem m_changeMode;
    private JMenuItem m_exit;
    
    public ViewMode(FamilyTree p_familyTree)
    {
        super("Family Tree");
        
        m_familyTree = p_familyTree;
        
        InitMenu();
        
        InitPanes();
    }
    
    private void InitMenu()
    {
        JMenu l_fileMenu = new JMenu("File");
        l_fileMenu.setMnemonic('F');
        
        m_changeMode = new JMenuItem("Change Modes...");
        m_changeMode.setMnemonic('C');
        l_fileMenu.add(m_changeMode);
        
        m_exit = new JMenuItem("Exit");
        m_exit.setMnemonic('X');
        l_fileMenu.add(m_exit);
        
        MenuHandler l_menuHandler = new MenuHandler();
        m_changeMode.addActionListener(l_menuHandler);
        m_exit.addActionListener(l_menuHandler);
        
        JMenuBar l_menuBar = new JMenuBar();
        setJMenuBar(l_menuBar);
        l_menuBar.add(l_fileMenu);
    }
    
    private void InitPanes()
    {
        splitPane = new JSplitPane();
        treePane = new JSplitPane();
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        treePanel = new JPanel();
        descriptionPanel = new JPanel();
        gPPanel = new JPanel();
        pPanel = new JPanel();
        cPanel = new JPanel();
        gCPanel = new JPanel();
        
        grandParent = new ArrayList<>();
        parent = new ArrayList<>();
        child = new ArrayList<>();
        grandChild = new ArrayList<>();
        
        detailScroll = new JScrollPane();
        descriptionScroll = new JScrollPane();
        tree = new JTextArea();
        description = new JTextArea();
        details = new JTextArea();
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setLayout(new GridLayout());
        getContentPane().add(splitPane);
        
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setResizeWeight(1.0);
        splitPane.setLeftComponent(treePane);
        splitPane.setRightComponent(rightPanel);
        
        treePane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        treePane.setResizeWeight(1.0);
        treePane.setTopComponent(treePanel);
        treePane.setBottomComponent(descriptionPanel);
        treePane.setMinimumSize(new Dimension(800, 600));
        
        treePanel.setLayout(new GridLayout(4,1));
        treePanel.setMinimumSize(new Dimension(450, 500));
        treePanel.add(gPPanel);
        treePanel.add(pPanel);
        treePanel.add(cPanel);
        treePanel.add(gCPanel);
        
        LoadTree();
        
        descriptionPanel.setLayout(new GridLayout());
        descriptionPanel.setMinimumSize(new Dimension(450, 300));
        descriptionPanel.add(descriptionScroll);
        descriptionScroll.setViewportView(description);
        description.setEditable(false);
        
        rightPanel.setLayout(new GridLayout());
        rightPanel.setMinimumSize(new Dimension (400, 600));
        rightPanel.add(detailScroll);
        detailScroll.setViewportView(details);
        details.setEditable(false);
        
        pack();
    }
    
    private void LoadTree()
    {
        for (Person person : m_familyTree.GetPeople())
        {
            ButtonHandler handler = new ButtonHandler();
            String l_string = person.GetFirstName() + " " + person.GetLastName();
            if (!"".equals(person.GetMaritalName()))
                l_string += " " + person.GetMaritalName();
            JButton l_newButton = new JButton(l_string);
            l_newButton.putClientProperty("person", person);
            l_newButton.addActionListener(handler);
            if ("GrandParent".equals(person.GetRole()))
                grandParent.add(l_newButton);
            else if ("Parent".equals(person.GetRole()))
                parent.add(l_newButton);
            else if ("Child".equals(person.GetRole()))
                child.add(l_newButton);
            else if ("GrandChild".equals(person.GetRole()))
                grandChild.add(l_newButton);
        }
        
        PlaceTree();
    }
    
    private void PlaceTree()
    {
        for (JButton button : grandParent)
        {
            gPPanel.add(button);
        }
        
        for (JButton button : parent)
        {
            pPanel.add(button);
        }
        
        for (JButton button : child)
        {
            cPanel.add(button);
        }
        
        for (JButton button : grandChild)
        {
            gCPanel.add(button);
        }
    }
    
    private class ButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            JButton source = (JButton)event.getSource();
            Person id = (Person) source.getClientProperty("person");
            description.setText(id.GetDescription());
            
            /*String l_string = "Name: " + id.GetFirstName();
            if (!"".equals(id.GetMaritalName()))
                l_string += " " + id.GetMaritalName() + "\nMaiden Name: " + id.GetLastName();
            else
                l_string += " " + id.GetLastName();
            l_string += "\nGender: " + id.GetGender();
            if (id.GetMother() != null)
                l_string += "\nMother: " + id.GetMother().GetFirstName() + " " + id.GetMother().GetMaritalName();
            else
                l_string += "\nMother: Unknown";
            if (id.GetFather() != null)
                l_string += "\nFather: " + id.GetFather().GetFirstName() + " " + id.GetFather().GetLastName();
            else
                l_string += "\nFather: Unknown";
            if (id.GetSpouse() != null)
            {
                for (Person person : id.GetSpouse())
                {
                    l_string += "\nSpouse: " + person.GetFirstName();
                    if (!"".equals(person.GetMaritalName()))
                        l_string += " " + person.GetMaritalName();
                    else
                        l_string += " " + person.GetLastName();
                }
            }
            if (id.GetChild() != null)
            {
                l_string += "\nChildren: ";
                for (Person person : id.GetChild())
                {
                    l_string += person.GetFirstName();
                    if (!"".equals(person.GetMaritalName()))
                        l_string += person.GetMaritalName();
                    else
                        l_string += person.GetLastName();
                    l_string += ", ";
                }
            }
            if (id.GetGrandChild() != null)
            {
                l_string += "\nGrandChildren: ";
                for (Person person : id.GetGrandChild())
                {
                    l_string += person.GetFirstName();
                    if (!"".equals(person.GetMaritalName()))
                        l_string += person.GetMaritalName();
                    else
                        l_string += person.GetLastName();
                    l_string += ", ";
                }
            }
            l_string += "\nAddress: " + id.GetAddress().toString();*/
            
            details.setText(id.toString());
        }
    }
    
    private class MenuHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == m_changeMode)
            {
                ModeSelector l_mSelect = new ModeSelector();
                l_mSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                l_mSelect.setSize(300, 300);
                l_mSelect.setVisible(true);
                l_mSelect.setLocationRelativeTo(null);
                setVisible(false);
                //dispose();
            }
            else if (event.getSource() == m_exit)
            {
                System.exit(0);
            }
        }
    }
}
