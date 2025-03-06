package lv.rvt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import lv.rvt.tools.Helper;

public class Klients {
    
    private String vards;
    private String uzvards;
    private String kontakinfo;
    private static final String delimiter = ", ";

    public Klients(String Vards, String Uzvards, String info){
        this.vards = Vards;
        this.uzvards = Uzvards;
        this.kontakinfo = info;
    }

    public static void addPerson(Klients vards) throws Exception{
        BufferedWriter writer = Helper.getWriter("Klienti.csv", StandardOpenOption.APPEND);

        writer.newLine();
        writer.write(vards.getname(vards));
        writer.close();

    }

    public String getname(Klients andris){
        return this.vards + ", " + this.uzvards + ", " + this.kontakinfo;
    }

    public Klients findperson(Klients vards){
        return vards; 
    }

    public static ArrayList<Klients> getPersonsLists() throws  Exception
    {
        BufferedReader reader = Helper.getReader("Klienti.csv");
        ArrayList<Klients> persons = new ArrayList<>();
        String line;
        line = reader.readLine();        
        
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");

            Klients person = new Klients(
                parts[0], parts[1], parts[2] );
                persons.add(person);
                
        }

        return persons;

            
    }

    @Override
    public String toString(){
        return this.vards + ", " + this.uzvards + ", " + this.kontakinfo;
    }

}
