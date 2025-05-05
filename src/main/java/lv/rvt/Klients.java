package lv.rvt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;

import lv.rvt.tools.Helper;

public class Klients {
    
    private String vards;
    private String uzvards;
    private String kontakinfo;


    public Klients(String Vards, String Uzvards, String info){
        this.vards = Vards;
        this.uzvards = Uzvards;
        this.kontakinfo = info;
    }

    public static void addPerson(Klients vards) throws Exception{
        BufferedWriter writer = Helper.getWriter("Klienti.csv", StandardOpenOption.APPEND);
        writer.write(vards.toString());
        writer.newLine();
        writer.close();

    }

    public String getname(){
        return this.vards;
    }

    public static ArrayList<Klients> findperson(String vards)throws Exception{
        ArrayList<Klients> masivs = getPersonsLists();
        ArrayList<Klients> mekletajs = new ArrayList<Klients>();

        for (Klients value : masivs) {
  
            if (value.getname().equals(vards)) {
                mekletajs.add(value);
            }}
        return mekletajs;
    }



    public static ArrayList<Klients> getPersonsLists() throws  Exception
    {
        BufferedReader reader = Helper.getReader("Klienti.csv");
        ArrayList<Klients> persons = new ArrayList<>();
        String line;
        
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");

            Klients person = new Klients(
                parts[0], parts[1], parts[2] );
                persons.add(person);
                
        }
        return persons;
            
    }

    public static void shortByFirstName() throws Exception{

        ArrayList<Klients> personlist = Klients.getPersonsLists();
        personlist.sort(Comparator.comparing(Klients::getFullName));

        for(Klients person : personlist){
            System.out.println(person);
        }
    }

    public static void shortByLastName() throws Exception{

        ArrayList<Klients> personlist = Klients.getPersonsLists();
        personlist.sort(Comparator.comparing(Klients::getFullLastName));

        for(Klients person : personlist){
            System.out.println(person);
        }
    }

    public static void deletePerson(Klients persona) throws Exception {
        ArrayList<Klients> klienti = getPersonsLists();
        klienti.remove(persona); 
        
        try (BufferedWriter writer = Helper.getWriter("Klienti.csv", StandardOpenOption.TRUNCATE_EXISTING)) {
            for (Klients klients : klienti) {
                writer.write(klients.toString());
                writer.newLine();
            }
        }
    
        System.out.println("Klients dzēsts!");
    }
    
    

    public static void editPerson(Klients persona, Klients jaunainformacija) throws  Exception{
        deletePerson(persona);
        addPerson(jaunainformacija);
    }

    public String getFullName(){
        return this.vards + " " + this.uzvards;
    }

    public String getFullLastName(){
        return this.uzvards + " " + this.vards;
    }

    @Override
    public String toString(){
        return this.vards + ", " + this.uzvards + ", " + this.kontakinfo;
    }


    public static Boolean findperson(Klients janis)throws Exception{
        ArrayList<Klients> masivs = getPersonsLists();
        

        for (Klients value : masivs) {
  
            if (value.getFullName().equals(janis.getFullName())) {
                return true;
            }}
        return false;
    }

    @Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Klients klients = (Klients) o;

    return vards.equals(klients.vards) &&
           uzvards.equals(klients.uzvards) &&
           kontakinfo.equals(klients.kontakinfo);
}

@Override
public int hashCode() {
    return java.util.Objects.hash(vards, uzvards, kontakinfo);
}

}
