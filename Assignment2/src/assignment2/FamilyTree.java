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
    
    public void SetMother(Person p_person, Person p_mother) throws IndexOutOfBoundsException
    {
        m_familyMembers.get(m_familyMembers.indexOf(p_person)).SetMother(p_mother);
    }
    
    public void SetFather(Person p_person, Person p_father) throws IndexOutOfBoundsException
    {
        m_familyMembers.get(m_familyMembers.indexOf(p_person)).SetMother(p_father);
    }
    
    public void AddSpouse(Person p_person, Person p_spouse) throws IndexOutOfBoundsException
    {
        m_familyMembers.get(m_familyMembers.indexOf(p_person)).AddSpouse(p_spouse);
    }
    
    public void AddChild(Person p_person, Person p_child) throws IndexOutOfBoundsException
    {
        m_familyMembers.get(m_familyMembers.indexOf(p_person)).AddChild(p_child);
    }
    
    public void AddGrandChild(Person p_person, Person p_gChild) throws IndexOutOfBoundsException
    {
        m_familyMembers.get(m_familyMembers.indexOf(p_person)).AddGrandChild(p_gChild);
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
