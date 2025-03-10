package lv.rvt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import lv.rvt.tools.Helper;

public class Gramatas {
    private String nosaukums;
    private String autors;
    private int idosana;
    private String izdevejs;

    public Gramatas(String nosaukums, String autors, int Izlaisana, String Izdevejs){
        this.nosaukums = nosaukums;
        this.autors = autors;
        this.idosana = Izlaisana;
        this.izdevejs = Izdevejs;
        
    }

    public static void addBook(Gramatas gramata) throws Exception{
        BufferedWriter writer = Helper.getWriter("Gramatas.csv", StandardOpenOption.APPEND);

        writer.newLine();
        writer.write(gramata.getname(gramata));
        writer.close();

    }

    public static ArrayList<Gramatas> getBookLists() throws  Exception
    {
        BufferedReader reader = Helper.getReader("Gramatas.csv");
        ArrayList<Gramatas> books = new ArrayList<>();
        String line;
        line = reader.readLine();        
        
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");

            Gramatas book = new Gramatas(
                parts[0], parts[1], Integer.valueOf(parts[2]), parts[3] );
                books.add(book);
                
        }

        return books;

            
    }

    public String getname(Gramatas gramata){
        return this.nosaukums + ", " + this.autors + ", " + this.idosana + ", " + this.izdevejs;
    }

    public String toString(){
        return this.nosaukums + ", " + this.autors + ", " + this.idosana + ", " + this.izdevejs;
    }


}
