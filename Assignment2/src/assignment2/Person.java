/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author jaknd
 */
public class Person implements Serializable {
    private String m_firstName;
    private String m_lastName;
    private String m_maritalName;
    private String m_gender;
    private String m_description;
    private Person m_mother;
    private Person m_father;
    private ArrayList<Person> m_spouse = new ArrayList();
    private ArrayList<Person> m_child = new ArrayList();
    private ArrayList<Person> m_grandChild = new ArrayList();
    private Address m_address;
    
    public Person()
    {
        this("", "", "", "", "",null, null, null, null, null, null);
    }
    
    public Person (String name)
    {
        this(name, "", "", "", "", null, null, null, null, null, null);
    }
    
    public Person(String p_fName, String p_lName,
                  String p_mName, String p_gender, String p_description,
                  Person p_mother, Person p_father,
                  Person p_spouse, Person p_child, 
                  Person p_grandChild, Address p_address)
    {
        this.m_firstName = p_fName;
        this.m_lastName = p_lName;
        this.m_maritalName = p_mName;
        this.m_gender = p_gender;
        this.m_description = p_description;
        this.m_mother = p_mother;
        this.m_father = p_father;
        this.m_spouse.add(p_spouse);
        this.m_child.add(p_child);
        this.m_grandChild.add(p_grandChild);
        this.m_address = p_address;
    }
    
    public void SetMother(Person p_mother)
    {
        this.m_mother = p_mother;
    }
    
    public void SetFather(Person p_father)
    {
        this.m_father = p_father;
    }
    
    public void AddSpouse(Person p_spouse)
    {
        this.m_spouse.add(p_spouse);
    }
    
    public void AddChild(Person p_child)
    {
        this.m_child.add(p_child);
    }
    
    public void AddGrandChild(Person p_gChild)
    {
        this.m_grandChild.add(p_gChild);
    }
    
    public void SetAddress(Address p_address)
    {
        this.m_address = p_address;
    }
    
    public String GetFirstName()
    {
        return this.m_firstName;
    }
    
    public String GetLastName()
    {
        return this.m_lastName;
    }
    
    public String GetMaritalName()
    {
        return this.m_maritalName;
    }
    
    public String GetGender()
    {
        return this.m_gender;
    }
    
    public String GetDescription()
    {
        return this.m_description;
    }
    
    public Person GetMother()
    {
        return this.m_mother;
    }
    
    public Person GetFather()
    {
        return this.m_father;
    }
    
    public ArrayList<Person> GetSpouse()
    {
        return this.m_spouse;
    }
    
    public ArrayList<Person> GetChild()
    {
        return this.m_child;
    }
    
    public ArrayList<Person> GetGrandChild()
    {
        return this.m_grandChild;
    }
    
    public Address GetAddress()
    {
        return m_address;
    }
    
    @Override
    public String toString()
    {
        String l_string = m_firstName + " " + m_lastName + " " + m_maritalName + " " +
                          m_gender + " " + m_description + "\n" +
                          "Mother: " + m_mother.GetFirstName() + 
                          " Father: " + m_father.GetFirstName() + "\n";
        
        for (Person spouse : m_spouse)
        {
            l_string += "Spouse: " + spouse.GetFirstName() + " ";
        }
        
        l_string += "\n";
        
        for (Person child : m_child)
        {
            l_string += "Child: " + child.GetFirstName() + " ";
        }
        
        l_string += "\n";
        
        for (Person gChild : m_grandChild)
        {
            l_string += "GrandChild: " + gChild.GetFirstName() + " ";
        }
        
        l_string += "\n";
        l_string += m_address;
        
        return l_string;
    }
    
}
