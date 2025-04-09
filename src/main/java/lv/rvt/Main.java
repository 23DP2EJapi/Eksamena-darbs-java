package lv.rvt;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main 
{
    public static void main( String[] args ) throws Exception
    {

        Klients persona = new Klients("Zane", "Liepa", "20212020");
        //Klients.addPerson(persona);
        Klients persona2 = new Klients("Zzsdhn", "Liesd", "ZaneLiepa@gmail.com");
        //Klients.deletePerson(persona);
        Gramatas a = new Gramatas("Bubieris", "Jony Asdea", 1999, "ABC", "Pieejama"); 
        Gramatas b = new Gramatas("ABC", "Bony Asdea", 1229, "ABC", "Pieejama");
        //Gramatas.addBook(a);
        //Gramatas.deleteBook(a);
        //Gramatas.editbook(a, b);
        //Klients.editPerson(persona, persona2);
        //Zurnali zurnals = new Zurnali("skljjfnkl", "10.12.2007");
        //Zurnali.addZurnals(zurnals);
        //System.out.println(Zurnali.getZurnaliLists());
        //Zurnali zurnals1 = new Zurnali("Abwc", "10.12.2007");
        //Zurnali.editZurnals(zurnals, zurnals1);
        //Zurnali.deletezurnals(zurnals);
        //System.out.println(Zurnali.getZurnaliLists();

        //Klients.addPerson(persona2);
        //Klients.deletePerson(persona2);

        //Klients.shortByFirstName();
        //Klients.shortByLastName();

        //Gramatas.shortByName();
        //Gramatas.shortByAuthor();

        //Zurnali.shortByName();
        //Zurnali.shortByIzdosana();
        //Klients.addPerson(persona);

        LocalDate myObj = LocalDate.now();
        int asd = 14;
        //System.out.println(a.Pieejamība());

        Turetaj ab = new Turetaj(persona.getFullName()+",", new Gramatas("Ābols", "Aony Asdea", 1999, "ABC", "Pieejama"),  myObj, asd);
        //System.out.println(ab);
        //Turetaj.addPerson(ab);
       // Turetaj.deletePerson(ab);
       Turetaj.takeBook(a, persona2, asd);
       //Turetaj.returnBook(b, persona, asd);
       //System.out.println(Gramatas.pieejamiba());
        //Turetaj.takeBook(a, persona2, asd);

        //Turetaj.deletePerson(ab);
        //System.out.println(Turetaj.getLists());



        //Turetaj.takeBook(a, persona2, 14);


  
        
    }
    
    
    
           /*  int abc = 99;
    
            LocalDate myObj = LocalDate.now();
            LocalDate myObj1 = myObj.plusDays(abc);
            System.out.println(myObj);
    
            System.out.println(myObj1);
            long daysBetween = ChronoUnit.DAYS.between(myObj, myObj1);
            System.out.println(daysBetween);*/
}