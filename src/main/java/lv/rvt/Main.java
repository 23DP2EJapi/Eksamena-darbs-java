package lv.rvt;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Main 
{
    public static void main( String[] args ) throws Exception
    {
        Gramatas framata = new Gramatas("asdas", "Jony Asdea", 1999, "ABC");
        System.out.println(framata);

        Klients janis = new Klients("Jānis", "Bērziņš", "20202020");
        System.out.println(janis);
        Klients.addPerson(janis);
        Gramatas.addBook(framata);
    
    }
}
