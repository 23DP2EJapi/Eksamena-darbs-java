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

    public String getKontakinfo() {
        return kontakinfo;
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

    public static ArrayList<Klients> shortByFirstNameList() throws Exception {
        ArrayList<Klients> personlist = getPersonsLists();
        personlist.sort(Comparator.comparing(Klients::getFullName));
        return personlist;
    }
    
    public static ArrayList<Klients> shortByLastNameList() throws Exception {
        ArrayList<Klients> personlist = getPersonsLists();
        personlist.sort(Comparator.comparing(Klients::getFullLastName));
        return personlist;
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

    public String getLastnamme(){
        return this.uzvards;
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


    public static void findperson(Klients janis)throws Exception{
        ArrayList<Klients> masivs = getPersonsLists();
        ArrayList<Klients> klienti = new ArrayList<>();

        for (Klients value : masivs) {
  
            if (value.getFullName().equals(janis.getFullName())) {
                klienti.add(value);
            }}
        

        System.out.printf("+----------------------+----------------------+-----------------------------+\n");
        System.out.printf("| Vārds                | Uzvārds              | Kontaktinformācija          |\n");
        System.out.printf("+----------------------+----------------------+-----------------------------+\n");
    
        for (Klients k : klienti) {
            System.out.printf("| %-20s | %-20s | %-27s |\n",
                    k.getname(),
                    k.getLastnamme(),
                    k.getKontakinfo()
            );
        }
    
        System.out.printf("+----------------------+----------------------+-----------------------------+\n");
    }

    public static Boolean findpersonbBoolea (Klients janis)throws Exception{
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

     return vards.equals(klients.vards) && uzvards.equals(klients.uzvards) && kontakinfo.equals(klients.kontakinfo);
}

@Override
public int hashCode() {
    return java.util.Objects.hash(vards, uzvards, kontakinfo);
}

}
