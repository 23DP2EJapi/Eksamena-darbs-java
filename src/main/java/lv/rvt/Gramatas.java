package lv.rvt;
//Nosaukums, Autors, Izlaisanas gads, Izdevejs
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

    public String toString(){
        return this.nosaukums + ", " + this.autors + ", " + this.idosana + ", " + this.izdevejs;
    }


}
