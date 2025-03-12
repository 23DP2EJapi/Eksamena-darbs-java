package lv.rvt;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.time.LocalDate;

public class Main 
{
    public static void main( String[] args ) throws Exception
    {

        Klients persona = new Klients("Zane", "Liepa", "20212020");
        Klients.deletePerson(persona);

      
    }
}
