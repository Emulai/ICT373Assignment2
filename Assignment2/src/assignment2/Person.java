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
    private String m_role;
    private Person m_mother;
    private Person m_father;
    private ArrayList<Person> m_spouse = new ArrayList();
    private ArrayList<Person> m_child = new ArrayList();
    private ArrayList<Person> m_grandChild = new ArrayList();
    private Address m_address;
    
    public Person()
    {
        this("", "", "", "", "", "",null, null, null, null, null, null);
    }
    
    public Person (String name)
    {
        this(name, "", "", "", "", "", null, null, null, null, null, null);
    }
    
    public Person(String p_fName, String p_lName, String p_mName, 
                  String p_gender, String p_description, String p_role,
                  Person p_mother, Person p_father,
                  Person p_spouse, Person p_child, 
                  Person p_grandChild, Address p_address)
    {
        this.m_firstName = p_fName;
        this.m_lastName = p_lName;
        this.m_maritalName = p_mName;
        this.m_gender = p_gender;
        this.m_description = p_description;
        this.m_role = p_role;
        this.m_mother = p_mother;
        this.m_father = p_father;
        this.m_spouse.add(p_spouse);
        this.m_child.add(p_child);
        this.m_grandChild.add(p_grandChild);
        this.m_address = p_address;
    }
    
    public void SetFirstName(String p_name)
    {
        this.m_firstName = p_name;
    }
    
    public void SetLastName(String p_name)
    {
        this.m_lastName = p_name;
    }
    
    public void SetMaritalName(String p_name)
    {
        this.m_maritalName = p_name;
    }
    
    public void SetGender(String p_gender)
    {
        this.m_gender = p_gender;
    }
    
    public void SetDescription(String p_description)
    {
        this.m_description = p_description;
    }
    
    public void SetRole(String p_role)
    {
        this.m_role = p_role;
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
    
    public String GetRole()
    {
        return this.m_role;
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
        String l_string = "Name: " + m_firstName;
        if (!"".equals(m_maritalName))
            l_string += " " + m_maritalName + "\nMaiden Name: " + m_lastName;
        else
            l_string += " " + m_lastName;
        l_string += "\nGender: " + m_gender;
        if (m_mother != null)
            l_string += "\nMother: " + m_mother.GetFirstName() + " " + m_mother.GetMaritalName();
        else
            l_string += "\nMother: Unknown";
        if (m_father != null)
            l_string += "\nFather: " + m_father.GetFirstName() + " " + m_father.GetLastName();
        else
            l_string += "\nFather: Unknown";
        
        for (Person spouse : m_spouse)
        {
            if (spouse != null)
            {
                l_string += "\nSpouse: " + spouse.GetFirstName() + " ";
                if (!"".equals(spouse.GetMaritalName()))
                    l_string += spouse.GetMaritalName();
                else
                    l_string += spouse.GetLastName();
            }
        }
        
        for (Person child : m_child)
        {
            if (child != null)
            {
                l_string += "\nChild: " + child.GetFirstName() + " ";
                if (!"".equals(child.GetMaritalName()))
                    l_string += child.GetMaritalName();
                else
                    l_string += child.GetLastName();
            }
        }
        
        for (Person gChild : m_grandChild)
        {
            if (gChild != null)
            {
                l_string += "\nGrandChild: " + gChild.GetFirstName() + " ";
                if (!"".equals(gChild.GetMaritalName()))
                    l_string += gChild.GetMaritalName();
                else
                    l_string += gChild.GetLastName();
            }
        }
        
        l_string += m_address;
        
        return l_string;
    }
    
}
