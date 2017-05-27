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
public class FamilyTree implements Serializable {
    private ArrayList<Person> m_familyMembers;
    
    public FamilyTree()
    {
        m_familyMembers = new ArrayList();
    }
    
    public Person NewPerson()
    {
        Person l_person = new Person();
        m_familyMembers.add(l_person);
        return l_person;
    }
    
    public void AddPerson(Person p_person)
    {
        m_familyMembers.add(p_person);
    }
    
    public ArrayList<Person> GetPeople()
    {
        return m_familyMembers;
    }
    
    public Person GetPerson(Person p_person)
    {
        return m_familyMembers.get(m_familyMembers.indexOf(p_person));
    }
    
    @Override
    public String toString()
    {
        String l_string = "Tree: \n";
        
        for (Person person : m_familyMembers)
        {
            if (person != null)
                l_string += person.toString();
        }
        
        return l_string;
    }
    
}
