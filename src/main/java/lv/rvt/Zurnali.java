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

    @Override
    public String toString(){
        return this.nosaukums + ", " + this.datums;
    }

}
