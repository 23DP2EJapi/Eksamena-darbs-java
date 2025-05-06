package lv.rvt;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;

public class TuretajTest {

    @Before
    public void setUp() throws Exception {
        
        Files.write(Paths.get("Turetajs.csv"), "".getBytes());
        Files.write(Paths.get("Gramatas.csv"), "".getBytes());
        Files.write(Paths.get("Klienti.csv"), "".getBytes());
    }

    @Test
    public void testReturnBookLaicīgi() throws Exception {
        Gramatas g = new Gramatas("Atdodamā", "Autors", 2023, "Izdevējs", "Nepieejama");
        Klients k = new Klients("Marta", "Liepa", "marta@epasts.lv");

        Klients.addPerson(k);
        Gramatas.addBook(new Gramatas("Atdodamā", "Autors", 2023, "Izdevējs", "Nepieejama"));

        Turetaj t = new Turetaj("Marta Liepa", g, LocalDate.now().minusDays(3), 5);
        Turetaj.addPerson(t);

        String rezultats = Turetaj.returnBook(g, k, 5);
        assertEquals("Grāmata veiksmīgi atgriezta.", rezultats);
    }

    @Test
    public void testReturnBookArKavējumu() throws Exception {
        Gramatas g = new Gramatas("Vecā", "Autors", 2020, "Izdevējs", "Nepieejama");
        Klients k = new Klients("Rūdolfs", "Mežs", "rudolfs@epasts.lv");

        Klients.addPerson(k);
        Gramatas.addBook(new Gramatas("Vecā", "Autors", 2020, "Izdevējs", "Nepieejama"));

        Turetaj t = new Turetaj("Rūdolfs Mežs", g, LocalDate.now().minusDays(10), 5);
        Turetaj.addPerson(t);

        String rezultats = Turetaj.returnBook(g, k, 5);
        assertEquals("Grāmata veiksmīgi atgriezta.", rezultats);
    }

}
