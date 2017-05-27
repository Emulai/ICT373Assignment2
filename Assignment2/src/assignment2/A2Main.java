/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
import java.io.IOException;
import java.io.EOFException;
/**
 *
 * @author jaknd
 */
public class A2Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Person            <-- Class -->
        //Person has:
        //--Mother
        //--Father
        //--Spouse 0-->n
        //--Child  0-->n
        //--GChild 0-->n
        //--FirstName
        //--LastName
        //--MaritalName
        //--Gender
        //--Description
        //--Address         <-- Class -->
        // -->StreetNumber
        // -->StreetName
        // -->Suburb
        // -->PostCode
        
        ReadFromFile inFile = new ReadFromFile();
        FamilyTree fTree = new FamilyTree();
        try
        {
            inFile.OpenFile("tree.ser");
            fTree = inFile.ReadRecord();
            inFile.CloseFile();
        }
        catch (EOFException e)
        {
            System.err.println(e);
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.err.println(e);
        }
        
        System.out.println(fTree);
        
        /*
        Person m = new Person("Mum");
        Person d = new Person("Dad");
        Person s = new Person("Gabe");
        Person c1 = new Person("Frank");
        Person c2 = new Person("Kate");
        Person c3 = new Person("Fred");
        Person gC1 = new Person("Lisa");
        Address a = new Address(50, "Herald Street", "Narrogin", 6351);
         */
        /*
        Person test = new Person("Mary", "Gibbs", "Larson", "Female", "Mother of three",
        m, d, s, c1, gC1, a);
        test.AddChild(c2);
        test.AddChild(c3);
        System.out.println(test);
         */
        /*
        FamilyTree fTree = new FamilyTree();
        Person lPerson = fTree.NewPerson();
        lPerson.SetFirstName("Mary");
        lPerson.SetLastName("Gibbs");
        lPerson.SetMaritalName("Larson");
        lPerson.SetGender("Female");
        lPerson.SetDescription("Mother of three");
        lPerson.SetMother(m);
        lPerson.SetFather(d);
        lPerson.AddSpouse(s);
        lPerson.AddChild(c1);
        lPerson.AddChild(c2);
        lPerson.AddChild(c3);
        lPerson.AddGrandChild(gC1);
        lPerson.SetAddress(a);
        System.out.println(fTree);
        WriteToFile outFile = new WriteToFile();
        try
        {
        outFile.OpenFile();
        outFile.SaveRecord(fTree);
        outFile.CloseFile();
        }
        catch (IOException e)
        {
        System.err.println(e);
        }
         */ 
        /*
        Person m = new Person("Mum");
        Person d = new Person("Dad");
        Person s = new Person("Gabe");
        Person c1 = new Person("Frank");
        Person c2 = new Person("Kate");
        Person c3 = new Person("Fred");
        Person gC1 = new Person("Lisa");
        Address a = new Address(50, "Herald Street", "Narrogin", 6351);
        */
        /*
        Person test = new Person("Mary", "Gibbs", "Larson", "Female", "Mother of three",
                                 m, d, s, c1, gC1, a);
        test.AddChild(c2);
        test.AddChild(c3);
        System.out.println(test);
        */
        /*
        FamilyTree fTree = new FamilyTree();
        Person lPerson = fTree.NewPerson();
        lPerson.SetFirstName("Mary");
        lPerson.SetLastName("Gibbs");
        lPerson.SetMaritalName("Larson");
        lPerson.SetGender("Female");
        lPerson.SetDescription("Mother of three");
        lPerson.SetMother(m);
        lPerson.SetFather(d);
        lPerson.AddSpouse(s);
        lPerson.AddChild(c1);
        lPerson.AddChild(c2);
        lPerson.AddChild(c3);
        lPerson.AddGrandChild(gC1);
        lPerson.SetAddress(a);
        
        System.out.println(fTree);
        
        WriteToFile outFile = new WriteToFile();
        try
        {
            outFile.OpenFile("tree.ser");
            outFile.SaveRecord(fTree);
            outFile.CloseFile();
        }
        catch (IOException e)
        {
            System.err.println(e);
        }
        */
    }
    
}
