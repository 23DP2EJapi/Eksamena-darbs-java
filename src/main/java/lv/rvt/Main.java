package lv.rvt;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.time.LocalDate;

public class Main 
{
    public static void main( String[] args ) throws Exception
    {
        /*Gramatas framata = new Gramatas("asdas", "Jony Asdea", 1999, "ABC");
        System.out.println(framata);

        System.out.println(janis);
        Klients.addPerson(janis);
        Gramatas.addBook(framata);*/
        Klients janis = new Klients("Jānis", "Bērziņš", "20202020");
        LocalDate date1 = LocalDate.of(2024, 1, 1);
        LocalDate date2 = LocalDate.now();

        if (date1.isBefore(date2)) {
            System.out.println(date1 + " is before " + date2);
        } else if (date1.isAfter(date2)) {
            System.out.println(date1 + " is after " + date2);
        } else {
            System.out.println("Both dates are the same");
        }

        System.out.println(Klients.getPersonsLists());
        System.out.println(Gramatas.getBookLists());
        System.out.println(Klients.findperson("Jānis"));
       
    
    }
}
