package lv.rvt;

import static org.junit.Assert.*;

import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;

public class TuretajTest {

    @Test
    public void testTakeBookSuccessfully() throws Exception {
        // Sagatavojam datu testam
        Gramatas gramata = new Gramatas("Grāmata1", "Autors1", 2023, "Fiction", "Pieejama");
        Klients klients = new Klients("Jānis", "Bērziņš", "12345678901");
        
        // Pārbaudām, vai grāmata tiek veiksmīgi paņemta
        String result = Turetaj.takeBook(gramata, klients, 14);
        
        assertEquals("Grāmata paņemta veiksmīgi.", result);

        // Pārbaudām, vai grāmata ir pieejama pēc paņemšanas
        assertEquals("Nepieejama", gramata.pieejamiba);
        
        // Pārbaudām, vai datu ieraksts ir izveidots pareizi
        ArrayList<Turetaj> persons = Turetaj.getLists();
        assertFalse(persons.isEmpty());
        Turetaj lastPerson = persons.get(persons.size() - 1);
        assertEquals(klients.getFullName(), lastPerson.vards);
        assertEquals(gramata.toString(), lastPerson.gramata.toString());
    }

    @Test
    public void testTakeBookClientNotFound() throws Exception {
        // Sagatavojam datu testam
        Gramatas gramata = new Gramatas("Grāmata1", "Autors1", 2023, "Fiction", "Pieejama");
        Klients klients = new Klients("Māris", "Kļaviņš", "98765432101");  // Klients, kas nav reģistrēts
        
        // Pārbaudām, vai tiek atgriezts pareizs ziņojums, ja klients netiek atrasts
        String result = Turetaj.takeBook(gramata, klients, 14);
        
        assertEquals("Klients netika atrasts.", result);
    }

    @Test
    public void testTakeBookBookNotAvailable() throws Exception {
        // Sagatavojam datu testam
        Gramatas gramata = new Gramatas("Grāmata1", "Autors1", 2023, "Fiction", "Nepieejama");
        Klients klients = new Klients("Jānis", "Bērziņš", "12345678901");
        
        // Pārbaudām, vai tiek atgriezts pareizs ziņojums, ja grāmata nav pieejama
        String result = Turetaj.takeBook(gramata, klients, 14);
        
        assertEquals("Grāmata nav pieejama.", result);
    }

    @Test
    public void testReturnBookSuccessfully() throws Exception {
        // Sagatavojam datu testam
        Gramatas gramata = new Gramatas("Grāmata1", "Autors1", 2023, "Fiction", "Nepieejama");
        Klients klients = new Klients("Jānis", "Bērziņš", "12345678901");
        
        // Paņemam grāmatu
        Turetaj.takeBook(gramata, klients, 7);
        
        // Atgriežam grāmatu
        String result = Turetaj.returnBook(gramata, klients, 7);
        
        assertEquals("Grāmata veiksmīgi atgriezta.", result);

        // Pārbaudām, vai grāmata ir atgriezta un pieejama
        assertEquals("Pieejama", gramata.pieejamiba);
    }

    @Test
    public void testReturnBookLate() throws Exception {
        // Sagatavojam datu testam
        Gramatas gramata = new Gramatas("Grāmata1", "Autors1", 2023, "Fiction", "Nepieejama");
        Klients klients = new Klients("Jānis", "Bērziņš", "12345678901");
        
        // Paņemam grāmatu
        Turetaj.takeBook(gramata, klients, 5);
        
        // Simulējam kavēšanos, piemēram, atgriežot grāmatu pēc 10 dienām
        LocalDate now = LocalDate.now();
        LocalDate returnDate = now.plusDays(10);  // Ja klients atgriež grāmatu 10 dienas vēlāk
        
        // Atgriežam grāmatu ar kavējumu
        Turetaj.returnBook(gramata, klients, 5);
        
        // Pārbaudām, vai tika aprēķināta soda nauda (ja kavēts vairāk nekā uz termiņu)
    }

    @Test
    public void testDeletePerson() throws Exception {
        // Sagatavojam datu testam
        Gramatas gramata = new Gramatas("Grāmata1", "Autors1", 2023, "Fiction", "Pieejama");
        Klients klients = new Klients("Jānis", "Bērziņš", "12345678901");
        
        // Pievienojam personu
        Turetaj.takeBook(gramata, klients, 7);
        
        // Iegūstam sarakstu pirms dzēšanas
        ArrayList<Turetaj> personsBeforeDelete = Turetaj.getLists();
        int sizeBeforeDelete = personsBeforeDelete.size();
        
        // Dzēšam personu
        Turetaj.deletePerson(personsBeforeDelete.get(0));
        
        // Pārbaudām, vai saraksts samazinājies
        ArrayList<Turetaj> personsAfterDelete = Turetaj.getLists();
        int sizeAfterDelete = personsAfterDelete.size();
        
        assertEquals(sizeBeforeDelete - 1, sizeAfterDelete);
    }
}
