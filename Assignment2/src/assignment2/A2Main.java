/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

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
        
        Person m = new Person("Mum");
        Person d = new Person("Dad");
        Person s = new Person("Gabe");
        Person c1 = new Person("Frank");
        Person c2 = new Person("Kate");
        Person c3 = new Person("Fred");
        Person gC1 = new Person("Lisa");
        Address a = new Address(50, "Herald Street", "Narrogin", 6351);
        Person test = new Person("Mary", "Gibbs", "Larson", "Female", "Mother of three",
                                 m, d, s, c1, gC1, a);
        test.AddChild(c2);
        test.AddChild(c3);
        
        System.out.println(test);
        
    }
    
}
