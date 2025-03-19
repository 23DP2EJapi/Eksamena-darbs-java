package lv.rvt;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.time.LocalDate;

public class Main 
{
    public static void main( String[] args ) throws Exception
    {

        //Klients persona = new Klients("Zane", "Liepa", "20212020");
        //Klients.addPerson(persona);
        //Klients persona2 = new Klients("Zane", "Liepa", "22222222");
        //Klients.deletePerson(persona);
        //Gramatas a = new Gramatas("Bubieris", "Jony Asdea", 1999, "ABC"); 
        //Gramatas b = new Gramatas("ABC", "Jony Asdea", 1999, "ABC");
        //Gramatas.addBook(a);
        //Gramatas.deleteBook(a);
        //Klients.editPerson(persona, persona2);
        //Zurnali zurnals = new Zurnali("skljjfnkl", "10.12.2007");
        //Zurnali.addZurnals(zurnals);
        //System.out.println(Zurnali.getZurnaliLists());
       
        //Zurnali.deletezurnals(zurnals);
        //System.out.println(Zurnali.getZurnaliLists());

        System.out.println(Gramatas.findbookbyautors("Jony Asdea"));

        

      
    }
}
