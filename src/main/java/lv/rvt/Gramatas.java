package lv.rvt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;

import lv.rvt.tools.Helper;

public class Gramatas {
    private String nosaukums;
    private String autors;
    private int idosana;
    private String izdevejs;
    protected String pieejamiba;

    public Gramatas(String nosaukums, String autors, int Izlaisana, String Izdevejs, String as){
        this.nosaukums = nosaukums;
        this.autors = autors;
        this.idosana = Izlaisana;
        this.izdevejs = Izdevejs;
        this.pieejamiba = as;
    }

    public static void shortByName() throws Exception{

        ArrayList<Gramatas> personlist = Gramatas.getBookLists();
        personlist.sort(Comparator.comparing(Gramatas::getname));

        for(Gramatas person : personlist){
            System.out.println(person);
        }
    }

    public static void shortByAuthor() throws Exception{

        ArrayList<Gramatas> personlist = Gramatas.getBookLists();
        personlist.sort(Comparator.comparing(Gramatas::getautors));

        for(Gramatas person : personlist){
            System.out.println(person);
        }
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
                parts[0], parts[1], Integer.valueOf(parts[2]), parts[3], parts[4]);
                books.add(book);
                
        }

        return books;

            
    }

    public static ArrayList<Gramatas> findbookbynosaukums(String vards)throws Exception{
        ArrayList<Gramatas> masivs = getBookLists();
        ArrayList<Gramatas> mekletajs = new ArrayList<Gramatas>();

        for (Gramatas value : masivs) {
  
            if (value.getname().equals(vards)) {
                
                mekletajs.add(value);
            }}
        return mekletajs;
    }

    public static ArrayList<Gramatas> findbookbyautors(String vards)throws Exception{
        ArrayList<Gramatas> masivs = getBookLists();
        ArrayList<Gramatas> mekletajs = new ArrayList<Gramatas>();

        for (Gramatas value : masivs) {
  
            if (value.getautors().equals(vards)) {
                
                mekletajs.add(value);
            }}
        return mekletajs;
    }

    public static boolean findbook(Gramatas book)throws Exception{
        ArrayList<Gramatas> masivs = getBookLists();

        for (Gramatas value : masivs) {
  
            if (value.getnosaukums().equals(book.getnosaukums())) {
                
                return true;
            }}
        return false;
    }

    public String getnosaukums(){
        return this.nosaukums + ", " + this.autors + ", " + this.idosana + ", " + this.izdevejs;
    }

    public String getautors(){
        return this.autors;
    }

    public String getname(){
        return this.nosaukums;
    }

    public String Pieejamība(){
        return this.pieejamiba;
    }

    public static ArrayList<Gramatas> pieejamiba() throws Exception{
        ArrayList<Gramatas> masivs = getBookLists();
        ArrayList<Gramatas> mekletajs = new ArrayList<Gramatas>();

        for (Gramatas value : masivs) {
  
            if (value.Pieejamība().equals("Pieejama")) {
                
                mekletajs.add(value);
            }}
        return mekletajs;
    }

    @Override
    public String toString(){
        return this.nosaukums + ", " + this.autors + ", " + this.idosana + ", " + this.izdevejs + ", " + this.pieejamiba;
    }

    public static void deleteBook(Gramatas gramata) throws Exception {
        ArrayList<Gramatas> gramatuSaraksts = getBookLists();
        gramatuSaraksts.remove(gramata); // izmantos equals()
    
        try (BufferedWriter writer = Helper.getWriter("Gramatas.csv", StandardOpenOption.TRUNCATE_EXISTING)) {
            for (Gramatas g : gramatuSaraksts) {
                writer.write(g.toString());
                writer.newLine();
            }
        }
    
        System.out.println("Grāmata dzēsta!");
    }

    public static void editbook(Gramatas persona, Gramatas jaunainformacija) throws  Exception{
        addBook(jaunainformacija);
        deleteBook(persona);
    }

    @Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Gramatas gramata = (Gramatas) o;

    return idosana == gramata.idosana &&
           nosaukums.equals(gramata.nosaukums) &&
           autors.equals(gramata.autors) &&
           izdevejs.equals(gramata.izdevejs) &&
           pieejamiba.equals(gramata.pieejamiba);
}

@Override
public int hashCode() {
    return java.util.Objects.hash(nosaukums, autors, idosana, izdevejs, pieejamiba);
}

}