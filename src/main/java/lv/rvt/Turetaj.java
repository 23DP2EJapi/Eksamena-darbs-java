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

    public Turetaj(String Vards, Gramatas a, LocalDate info, int Termiņš){
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

    public static String takeBook(Gramatas gramata, Klients janis, int ter) throws Exception{
        LocalDate myObj = LocalDate.now();
        if (Klients.findperson(janis) == false) {
            System.out.println("Tādā persona netika atrasta");
            return null;
        } else if (Gramatas.findbook(gramata) == false) {
            System.out.println("Grāmata nav pieejama");
            return null;
        }else 
       if (gramata.Pieejamība().equals("Pieejama")) {
        addPerson(new Turetaj(janis.getFullName() + "," , gramata, myObj, ter));
        
        Gramatas.deleteBook(gramata);
        gramata.pieejamiba = "Nepieejama";
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
