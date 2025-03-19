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

        writer.write(gramata.toString());
        writer.newLine();
        writer.close();

    }

    public static ArrayList<Gramatas> getBookLists() throws  Exception
    {
        BufferedReader reader = Helper.getReader("Gramatas.csv");
        ArrayList<Gramatas> books = new ArrayList<>();
        String line;
       
        
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");

            Gramatas book = new Gramatas(
                parts[0], parts[1], Integer.valueOf(parts[2]), parts[3] );
                books.add(book);
                
        }

        return books;

            
    }

    public static ArrayList<Gramatas> findbook(String vards)throws Exception{
        ArrayList<Gramatas> masivs = getBookLists();
        ArrayList<Gramatas> mekletajs = new ArrayList<Gramatas>();

        for (Gramatas value : masivs) {
  
            if (value.getname().equals(vards)) {
                
                mekletajs.add(value);
            }}
        return mekletajs;
    }

    public String getnosaukums(Gramatas gramata){
        return this.nosaukums + ", " + this.autors + ", " + this.idosana + ", " + this.izdevejs;
    }


    public String getname(){
        return this.nosaukums;
    }
    @Override
    public String toString(){
        return this.nosaukums + ", " + this.autors + ", " + this.idosana + ", " + this.izdevejs;
    }

    public static void deleteBook(Gramatas persona) throws  Exception{
        ArrayList<Gramatas> Glabātuve = getBookLists();
        ArrayList<Gramatas> helper = new ArrayList<>();

        BufferedWriter writer = Helper.getWriter("Gramatas.csv", StandardOpenOption.TRUNCATE_EXISTING);
       
        for (Gramatas klients : Glabātuve) {
            if (klients.getname().equals(persona.getname())) {
                
            }else{
                helper.add(klients);
            }

            
        }
        
        
        int b = helper.size();
        for(int a = 0; a<=b;a++ ){
            addBook(helper.get(a));
        }
     
        
    }




}
