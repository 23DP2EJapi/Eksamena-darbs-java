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

        Gramatas gramata = new Gramatas("Grāmata1", "Autors1", 2023, "Fiction", "Pieejama");
        Klients klients = new Klients("Jānis", "Bērziņš", "12345678901");            
        Gramatas.addBook(gramata);
        Klients.addPerson(klients);
    
    
    }
}