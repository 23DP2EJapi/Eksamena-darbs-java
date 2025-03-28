package lv.rvt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;

import lv.rvt.tools.Helper;

public class Turetaj {
    private Klients vards;
    private Gramatas uzvards;
    private Boolean kontakinfo;

    public Turetaj(Klients Vards, Gramatas a, Boolean info){
        this.vards = Vards;
        this.uzvards = a;
        this.kontakinfo = info;
    }

        public static void addPerson(Turetaj vards) throws Exception{
        BufferedWriter writer = Helper.getWriter("Turetajs.csv", StandardOpenOption.APPEND);
        writer.write(vards.toString());
        writer.newLine();
        writer.close();

    }

    public Boolean pieejamiba(){
      return kontakinfo;
    }

    @Override
    public String toString(){
        return this.vards.toString() + " " + this.uzvards.toString() + ", " + this.kontakinfo;
    } 


}
