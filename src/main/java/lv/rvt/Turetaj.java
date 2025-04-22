package lv.rvt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;

import lv.rvt.tools.Helper;

public class Turetaj {
    private String vards;
    private Gramatas gramata;
    private LocalDate datums;
    private int termins;

    public Turetaj(String vards, Gramatas gramata, LocalDate datums, int termins) {
        this.vards = vards;
        this.gramata = gramata;
        this.datums = datums;
        this.termins = termins;
    }

    public static void addPerson(Turetaj turetajs) throws Exception {
        BufferedWriter writer = Helper.getWriter("Turetajs.csv", StandardOpenOption.APPEND);
        writer.write(turetajs.toString());
        writer.newLine();
        writer.close();
    }

    public static ArrayList<Turetaj> getLists() throws Exception {
        BufferedReader reader = Helper.getReader("Turetajs.csv");
        ArrayList<Turetaj> persons = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");

            Turetaj person = new Turetaj(
                parts[0],
                new Gramatas(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4], parts[5]),
                LocalDate.parse(parts[6]),
                Integer.parseInt(parts[7])
            );
            persons.add(person);
        }
        reader.close();
        return persons;
    }

    public static void deletePerson(Turetaj persona) throws Exception {
        ArrayList<Turetaj> all = getLists();
        ArrayList<Turetaj> updated = new ArrayList<>();

        for (Turetaj t : all) {
            if (!t.toString().equals(persona.toString())) {
                updated.add(t);
            }
        }

        BufferedWriter writer = Helper.getWriter("Turetajs.csv", StandardOpenOption.TRUNCATE_EXISTING);
        for (Turetaj t : updated) {
            writer.write(t.toString());
            writer.newLine();
        }
        writer.close();
    }

    public static String takeBook(Gramatas gramata, Klients klients, int termins) throws Exception {
        LocalDate today = LocalDate.now();

        if (!Klients.findperson(klients)) {
            return "Klients netika atrasts.";
        }
        if (!Gramatas.findbook(gramata)) {
            return "Grāmata nav pieejama.";
        }

        for (Gramatas g : Gramatas.pieejamiba()) {
            if (g.toString().equals(gramata.toString())) {
                Turetaj newEntry = new Turetaj(klients.getFullName(), gramata, today, termins);
                addPerson(newEntry);

                Gramatas.deleteBook(gramata);
                gramata.pieejamiba = "Nepieejama";
                Gramatas.addBook(gramata);

                return "Grāmata paņemta veiksmīgi.";
            }
        }

        return "Grāmata nav pieejama.";
    }

    public static String returnBook(Gramatas gramata, Klients klients, int termins) throws Exception {
        LocalDate today = LocalDate.now();

        if (!Klients.findperson(klients)) {
            return "Klients netika atrasts.";
        }

        ArrayList<Turetaj> saraksts = getLists();
        for (Turetaj t : saraksts) {
            if (t.vards.equals(klients.getFullName()) && t.gramata.toString().equals(gramata.toString())) {
                long dienasPagajusas = ChronoUnit.DAYS.between(t.datums, today);
                long kavetas = dienasPagajusas - t.termins;

                if (kavetas > 0) {
                    double sods = kavetas * 0.50;
                    System.out.printf("Grāmata tika nodota %d dienas par vēlu. Soda nauda: %.2f EUR\n", kavetas, sods);
                } else {
                    System.out.println("Grāmata nodota laikā. Soda naudas nav.");
                }

                deletePerson(t);
                Gramatas.deleteBook(gramata);
                gramata.pieejamiba = "Pieejama";
                Gramatas.addBook(gramata);

                return "Grāmata veiksmīgi atgriezta.";
            }
        }

        return "Nav atrasts atbilstošs ieraksts.";
    }

    @Override
    public String toString() {
        return this.vards + ", " + this.gramata.toString() + ", " + this.datums + ", " + this.termins;
    }
}