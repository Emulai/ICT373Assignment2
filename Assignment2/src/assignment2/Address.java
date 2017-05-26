/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
import java.io.Serializable;
/**
 *
 * @author jaknd
 */
public class Address implements Serializable {
    private int m_streetNumber;
    private String m_streetName;
    private String m_suburb;
    private int m_postCode;
    
    public Address()
    {
        this(0, "", "", 0);
    }
    
    public Address(int p_sNumber, String p_sName, String p_sub, int p_pCode)
    {
        this.m_streetNumber = p_sNumber;
        this.m_streetName = p_sName;
        this.m_suburb = p_sub;
        this.m_postCode = p_pCode;
    }
    
    public void SetStreetNumber(int p_sNumber)
    {
        this.m_streetNumber = p_sNumber;
    }
    
    public int GetStreetNumber()
    {
        return this.m_streetNumber;
    }
    
    public void SetStreetName(String p_sName)
    {
        this.m_streetName = p_sName;
    }
    
    public String GetStreetName()
    {
        return this.m_streetName;
    }
    
    public void SetSuburb(String p_sub)
    {
        this.m_suburb = p_sub;
    }
    
    public String GetSuburb()
    {
        return this.m_suburb;
    }
    
    public void SetPostCode(int p_pCode)
    {
        this.m_postCode = p_pCode;
    }
    
    public int GetPostCode()
    {
        return this.m_postCode;
    }
    
    @Override
    public String toString()
    {
        String l_string = "Address: " + m_streetNumber + " " +
                          m_streetName + " " + m_suburb +
                          " " + m_postCode;
        return l_string;
    }
    
}
