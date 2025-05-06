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

    public static ArrayList<Gramatas> getBookLists() throws Exception {
        try (BufferedReader reader = Helper.getReader("Gramatas.csv")) {
            ArrayList<Gramatas> books = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                // Sadalām tikai 5 daļās, ne vairāk, ne mazāk
                String[] parts = line.split(", ", 5);
                if (parts.length < 5) {
                    System.err.println("IGNORED malformed line: " + line);
                    continue;
                }
    
                String title      = parts[0];
                String author     = parts[1];
                int year;
                try {
                    year = Integer.parseInt(parts[2]);
                } catch (NumberFormatException nfe) {
                    System.err.println("INVALID year in line: " + line);
                    continue;
                }
                String publisher  = parts[3];
                String availability = parts[4];
    
                books.add(new Gramatas(title, author, year, publisher, availability));
            }
            return books;
        }
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
public String toString() {
    return nosaukums + ", " + autors + ", " + idosana + ", " + izdevejs + ", " + pieejamiba;
}

    public static boolean deleteBook(Gramatas gramata) throws Exception {
        ArrayList<Gramatas> saraksts = getBookLists();
        boolean removed = saraksts.remove(gramata);  // uses equals()
    
        try (BufferedWriter writer = Helper.getWriter("Gramatas.csv", StandardOpenOption.TRUNCATE_EXISTING)) {
            for (Gramatas g : saraksts) {
                writer.write(g.toString());
                writer.newLine();
            }
        }
    
        if (removed) {
            System.out.println("Grāmata dzēsta!");
        } else {
            System.err.println("Grāmata netika atrasta: " + gramata);
        }
        return removed;
    }
    

    public static void editbook(Gramatas persona, Gramatas jaunainformacija) throws  Exception{
        deleteBook(persona);
        addBook(jaunainformacija);
    }

    @Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Gramatas gramata = (Gramatas) o;

    return idosana == gramata.idosana &&
           nosaukums.equals(gramata.nosaukums) &&
           autors.equals(gramata.autors) &&
           izdevejs.equals(gramata.izdevejs) ;
}

@Override
public int hashCode() {
    return java.util.Objects.hash(nosaukums, autors, idosana, izdevejs, pieejamiba);
}

}