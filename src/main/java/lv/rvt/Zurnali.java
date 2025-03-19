package lv.rvt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import lv.rvt.tools.Helper;

public class Zurnali {

    private String nosaukums;
    private String datums;


    public Zurnali(String Vards, String Datums){
        this.nosaukums = Vards;
        this.datums = Datums;
    }

    public static void addZurnals(Zurnali zurnals) throws Exception{
        BufferedWriter writer = Helper.getWriter("zurnali.csv", StandardOpenOption.APPEND);

        writer.write(zurnals.toString());
        writer.newLine();
        writer.close();

    }

    public static ArrayList<Zurnali> getZurnaliLists() throws  Exception
    {
        BufferedReader reader = Helper.getReader("zurnali.csv");
        ArrayList<Zurnali> books = new ArrayList<>();
        String line;
        line = reader.readLine();        
        
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");

            Zurnali book = new Zurnali(
                parts[0], parts[1] );
                books.add(book);
                
        }

        return books;
    }

    public static ArrayList<Zurnali> findZurnals(String vards)throws Exception{
        ArrayList<Zurnali> masivs = getZurnaliLists();
        ArrayList<Zurnali> mekletajs = new ArrayList<Zurnali>();

        for (Zurnali value : masivs) {
  
            if (value.getname().equals(vards)) {
                
                mekletajs.add(value);
            }}
        return mekletajs;
    }

    public String getname(){
        return this.nosaukums;
    }

    @Override
    public String toString(){
        return this.nosaukums + ", " + this.datums;
    }

}
