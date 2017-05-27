/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
import java.io.IOException;
import java.io.EOFException;
import java.nio.file.Path;
import javax.swing.JFrame;
import java.util.ArrayList;
/**
 *
 * @author jaknd
 */
public class A2Main {
    public static ArrayList<Person> members = new ArrayList();
    public static FamilyTree tree = new FamilyTree();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        ModeSelector mSelect = new ModeSelector();
        mSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mSelect.setSize(300, 300);
        mSelect.setVisible(true);
        mSelect.setLocationRelativeTo(null);
        
        /*
        LoadTree();
        
        System.out.println(tree);
        
        WriteToFile outFile = new WriteToFile();
        try
        {
        outFile.OpenFile("tree.tree");
        outFile.SaveRecord(tree);
        outFile.CloseFile();
        }
        catch (IOException e)
        {
        System.err.println(e);
        }
        */
        
    }
    
    public static void LoadTree()
    {
        InitPeople();
        AddNames();
        AddGenders();
        AddDescriptions();
        AddMothers();
        AddFathers();
        AddSpouses();
        AddChildren();
        AddGrandChildren();
        AddAddresses();
        AddRoles();
    }
    
    public static void InitPeople()
    {
        Person temp = new Person();
        members.add(temp);
        tree.AddPerson(members.get(0));
        temp = new Person();
        members.add(temp);
        tree.AddPerson(members.get(1));
        temp = new Person();
        members.add(temp);
        tree.AddPerson(members.get(2));
        temp = new Person();
        members.add(temp);
        tree.AddPerson(members.get(3));
        temp = new Person();
        members.add(temp);
        tree.AddPerson(members.get(4));
        temp = new Person();
        members.add(temp);
        tree.AddPerson(members.get(5));
        temp = new Person();
        members.add(temp);
        tree.AddPerson(members.get(6));
        temp = new Person();
        members.add(temp);
        tree.AddPerson(members.get(7));
        temp = new Person();
        members.add(temp);
        tree.AddPerson(members.get(8));
        temp = new Person();
        members.add(temp);
        tree.AddPerson(members.get(9));
        temp = new Person();
        members.add(temp);
        tree.AddPerson(members.get(10));
        temp = new Person();
        members.add(temp);
        tree.AddPerson(members.get(11));
        temp = new Person();
        members.add(temp);
        tree.AddPerson(members.get(12));
        temp = new Person();
        members.add(temp);
        tree.AddPerson(members.get(13));
    }
    
    public static void AddNames()
    {
        members.get(0).SetFirstName("Bob"); members.get(0).SetLastName("Holt");
        members.get(1).SetFirstName("Sarah"); members.get(1).SetLastName("Smith"); members.get(1).SetMaritalName("Holt");
        members.get(2).SetFirstName("Marshall"); members.get(2).SetLastName("Jones");
        members.get(3).SetFirstName("Fiona"); members.get(3).SetLastName("Doe"); members.get(3).SetMaritalName("Jones");
        members.get(4).SetFirstName("Jack"); members.get(4).SetLastName("Holt");
        members.get(5).SetFirstName("John"); members.get(5).SetLastName("Holt");
        members.get(6).SetFirstName("Mary"); members.get(6).SetLastName("Holt"); members.get(6).SetMaritalName("Jones");
        members.get(7).SetFirstName("Jacob"); members.get(7).SetLastName("Jones");
        members.get(8).SetFirstName("Raymond"); members.get(8).SetLastName("Holt");
        members.get(9).SetFirstName("Sue"); members.get(9).SetLastName("Holt"); members.get(9).SetMaritalName("Grey");
        members.get(10).SetFirstName("Jerry"); members.get(10).SetLastName("Holt");
        members.get(11).SetFirstName("Killian"); members.get(11).SetLastName("Grey");
        members.get(12).SetFirstName("Robert"); members.get(12).SetLastName("Grey");
        members.get(13).SetFirstName("Jessica"); members.get(13).SetLastName("Grey");
    }
    
    public static void AddGenders()
    {
        members.get(0).SetGender("Male");
        members.get(1).SetGender("Female");
        members.get(2).SetGender("Male");
        members.get(3).SetGender("Female");
        members.get(4).SetGender("Male");
        members.get(5).SetGender("Male");
        members.get(6).SetGender("Female");
        members.get(7).SetGender("Male");
        members.get(8).SetGender("Male");
        members.get(9).SetGender("Female");
        members.get(10).SetGender("Male");
        members.get(11).SetGender("Male");
        members.get(12).SetGender("Male");
        members.get(13).SetGender("Female");
    }
    
    public static void AddDescriptions()
    {
        members.get(0).SetDescription("Retired case worker");
        members.get(1).SetDescription("Owned Smiths Chips for 3 decades");
        members.get(2).SetDescription("Killed his uncle");
        members.get(3).SetDescription("Leader of organised crime");
        members.get(4).SetDescription("Once ate 200 dollars");
        members.get(5).SetDescription("Dropped contact with his brother after he ate 200 dollars");
        members.get(6).SetDescription("Used car saleswoman");
        members.get(7).SetDescription("Owns 20 cats");
        members.get(8).SetDescription("Captain of a police precinct");
        members.get(9).SetDescription("Really likes mandarins");
        members.get(10).SetDescription("Inherited a love for crime");
        members.get(11).SetDescription("Orphan, grew up on the streets");
        members.get(12).SetDescription("Recently said \"Dada\"");
        members.get(13).SetDescription("Attends the third grade");
    }
    
    public static void AddMothers()
    {
        members.get(4).SetMother(members.get(1));
        members.get(5).SetMother(members.get(1));
        members.get(6).SetMother(members.get(3));
        members.get(7).SetMother(members.get(3));
        members.get(8).SetMother(members.get(6));
        members.get(9).SetMother(members.get(6));
        members.get(10).SetMother(members.get(6));
        members.get(12).SetMother(members.get(9));
        members.get(13).SetMother(members.get(9));
    }
    
    public static void AddFathers()
    {
        members.get(4).SetFather(members.get(0));
        members.get(5).SetFather(members.get(0));
        members.get(6).SetFather(members.get(2));
        members.get(7).SetFather(members.get(2));
        members.get(8).SetFather(members.get(5));
        members.get(9).SetFather(members.get(5));
        members.get(10).SetFather(members.get(5));
        members.get(12).SetFather(members.get(11));
        members.get(13).SetFather(members.get(11));
    }
    
    public static void AddSpouses()
    {
        members.get(0).AddSpouse(members.get(1));
        members.get(1).AddSpouse(members.get(0));
        members.get(2).AddSpouse(members.get(3));
        members.get(3).AddSpouse(members.get(2));
        members.get(5).AddSpouse(members.get(6));
        members.get(6).AddSpouse(members.get(5));
        members.get(9).AddSpouse(members.get(11));
        members.get(11).AddSpouse(members.get(9));
    }
    
    public static void AddChildren()
    {
        members.get(0).AddChild(members.get(4));members.get(0).AddChild(members.get(5));
        members.get(1).AddChild(members.get(4));members.get(1).AddChild(members.get(5));
        members.get(2).AddChild(members.get(6));members.get(2).AddChild(members.get(7));
        members.get(3).AddChild(members.get(6));members.get(3).AddChild(members.get(7));
        members.get(5).AddChild(members.get(8));members.get(5).AddChild(members.get(9));members.get(5).AddChild(members.get(10));
        members.get(6).AddChild(members.get(8));members.get(6).AddChild(members.get(9));members.get(6).AddChild(members.get(10));
        members.get(9).AddChild(members.get(12));members.get(9).AddChild(members.get(13));
        members.get(11).AddChild(members.get(12));members.get(11).AddChild(members.get(13));
    }
    
    public static void AddGrandChildren()
    {
        members.get(0).AddGrandChild(members.get(8));members.get(0).AddGrandChild(members.get(9));members.get(0).AddGrandChild(members.get(10));
        members.get(1).AddGrandChild(members.get(8));members.get(1).AddGrandChild(members.get(9));members.get(1).AddGrandChild(members.get(10));
        members.get(2).AddGrandChild(members.get(8));members.get(2).AddGrandChild(members.get(9));members.get(2).AddGrandChild(members.get(10));
        members.get(3).AddGrandChild(members.get(8));members.get(3).AddGrandChild(members.get(9));members.get(3).AddGrandChild(members.get(10));
        members.get(5).AddGrandChild(members.get(12));members.get(5).AddGrandChild(members.get(13));
        members.get(6).AddGrandChild(members.get(12));members.get(6).AddGrandChild(members.get(13));
    }
    
    public static void AddAddresses()
    {
        Address a = new Address();
        a = new Address(70, "Apple Way", "Pembrooke", 6273);
        members.get(0).SetAddress(a);
        a = new Address(70, "Apple Way", "Pembrooke", 6273);
        members.get(1).SetAddress(a);
        a = new Address(23, "Flag Lane", "Rockingham", 6997);
        members.get(2).SetAddress(a);
        a = new Address(23, "Flag Lane", "Rockingham", 6997);
        members.get(3).SetAddress(a);
        a = new Address(87, "Elm Street", "Northbridge", 6666);
        members.get(4).SetAddress(a);
        a = new Address(188, "Strange Way", "Canning Vale", 6155);
        members.get(5).SetAddress(a);
        a = new Address(188, "Strange Way", "Canning Vale", 6155);
        members.get(6).SetAddress(a);
        a = new Address(91, "Blue Walk", "Subiaco", 6236);
        members.get(7).SetAddress(a);
        a = new Address(1, "Avenue Boulevard", "Armadale", 6543);
        members.get(8).SetAddress(a);
        a = new Address(9, "Serious Loop", "Scarborough Beach", 6775);
        members.get(9).SetAddress(a);
        a = new Address(90, "South Street", "Murdoch", 6150);
        members.get(10).SetAddress(a);
        a = new Address(9, "Serious Loop", "Scarborough Beach", 6775);
        members.get(11).SetAddress(a);
        a = new Address(9, "Serious Loop", "Scarborough Beach", 6775);
        members.get(12).SetAddress(a);
        a = new Address(9, "Serious Loop", "Scarborough Beach", 6775);
        members.get(13).SetAddress(a);
    }
    
    public static void AddRoles()
    {
        members.get(0).SetRole("GrandParent");
        members.get(1).SetRole("GrandParent");
        members.get(2).SetRole("GrandParent");
        members.get(3).SetRole("GrandParent");
        members.get(4).SetRole("Parent");
        members.get(5).SetRole("Parent");
        members.get(6).SetRole("Parent");
        members.get(7).SetRole("Parent");
        members.get(8).SetRole("Child");
        members.get(9).SetRole("Child");
        members.get(10).SetRole("Child");
        members.get(11).SetRole("Child");
        members.get(12).SetRole("GrandChild");
        members.get(13).SetRole("GrandChild");
    }
    
}
