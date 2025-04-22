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

                // Izveidojam klientu
                Klients klients = new Klients("Zane", "Liepa", "20212020");
        
                // Grāmata, kas ir bijusi aizņemta
                Gramatas gramata = new Gramatas("ABC", "Bony Asdea", 1229, "ABC", "Nepieejama");
        
                // Termiņš dienās (piemēram, 14 dienas)
                int termins = 14;
        
                // Atgriežam grāmatu
                String rezultats = Turetaj.returnBook(gramata, klients, termins);
        
                // Izvada rezultātu konsolē
                System.out.println("Rezultāts: " + rezultats);
            
        
    
    
    
    }
}