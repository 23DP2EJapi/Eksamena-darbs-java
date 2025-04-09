package lv.rvt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

import lv.rvt.tools.Helper;

public class Turetaj {
    private String vards;
    private Gramatas uzvards;
    private LocalDate kontakinfo;
    private int Termiņš;

    public Turetaj(String Vards, Gramatas a,LocalDate info, int Termiņš){
        this.vards = Vards;
        this.uzvards = a;
        this.kontakinfo = info;
        this.Termiņš = Termiņš;
        
    }

        public static void addPerson(Turetaj vards) throws Exception{
        BufferedWriter writer = Helper.getWriter("Turetajs.csv", StandardOpenOption.APPEND);
        writer.write(vards.toString());
        writer.newLine();
        writer.close();

    }

    public static ArrayList<Turetaj> getLists() throws  Exception
    {
        BufferedReader reader = Helper.getReader("Turetajs.csv");
        ArrayList<Turetaj> persons = new ArrayList<>();
        String line;
        
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");

            Turetaj person = new Turetaj(
                parts[0] + ",", new Gramatas(parts[1],  parts[2], Integer.valueOf(parts[3]), parts[4], parts[5]),LocalDate.parse(parts[6]), Integer.valueOf(parts[7]));
                persons.add(person);
                
        }
        return persons;
            
    }

    public static void deletePerson(Turetaj persona) throws Exception {
        ArrayList<Turetaj> Glabātuve = getLists();
        ArrayList<Turetaj> helper = new ArrayList<>();
    
        for (Turetaj klients : Glabātuve) {
            if (!klients.toString().equals(persona.toString())) {
                helper.add(klients);
            }
        }
    
        BufferedWriter writer = Helper.getWriter("Turetajs.csv", StandardOpenOption.TRUNCATE_EXISTING);
        for (Turetaj klients : helper) {
            writer.write(klients.toString());
            writer.newLine();
        }
        writer.close();
    }

    public static String takeBook(Gramatas gramata, Klients janis, int ter) throws Exception{
        LocalDate myObj = LocalDate.now();
        if (Klients.findperson(janis) == false) {
            System.out.println("Tādā persona netika atrasta");
            return null;
        } else if (Gramatas.findbook(gramata) == false) {
            System.out.println("Grāmata nav pieejama");
            return null;
        }else 
        for (Gramatas book : Gramatas.pieejamiba()) {

            if (book.toString().equals(gramata.toString())) {
                
                addPerson(new Turetaj(janis.getFullName() + "," , gramata, myObj, ter));
        
                Gramatas.deleteBook(gramata);
                gramata.pieejamiba = "Nepieejama";
                Gramatas.addBook(gramata);     

                System.out.println("Grāmata paņemta veiksmīgi");
                 return "Grāmata paņemta veiksmīgi";
            }
            
        }
       System.out.println("nevar saņemt");
      return "nevar saņemt";
    }
    
    public static String returnBook(Gramatas gramata, Klients janis, int ter) throws Exception{
        LocalDate myObj = LocalDate.now();
        if (Klients.findperson(janis) == false) {
            System.out.println("Tādā persona netika atrasta");
            return null;
        } else if (Gramatas.findbook(gramata) == false) {
            System.out.println("Grāmata nav pieejama");
            return null;
        }else 
        if (gramata.Pieejamība().equals("Nepieejama")) {
            deletePerson(new Turetaj(janis.getFullName() + "," , gramata, myObj, ter));
            Gramatas.deleteBook(gramata);
            gramata.pieejamiba = "Pieejama";
            Gramatas.addBook(gramata);     
            
            System.out.println("Grāmata paņemta veiksmīgi");
            return "Grāmata paņemta veiksmīgi";
        } else{
            System.out.println("Grāmata nav paņemta");
            return "Grāmata nav paņemta";
        }
    }
    public LocalDate pieejamiba(){
      return this.kontakinfo;
    }
    
    @Override
    public String toString(){
        return this.vards.toString() + " " + this.uzvards.toString() + ", " + this.kontakinfo + ", " + this.Termiņš;
    } 
    
    
}