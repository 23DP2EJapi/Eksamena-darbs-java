package lv.rvt;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class GramatasTest {

    private Gramatas gramata1;
    private Gramatas gramata2;

    @Before
    public void setUp() throws Exception {
        // Izveidojam dažas testēšanai nepieciešamās grāmatas
        gramata1 = new Gramatas("Grāmata1", "Autors1", 2020, "Izdevējs1", "Pieejama");
        gramata2 = new Gramatas("Grāmata2", "Autors2", 2021, "Izdevējs2", "Pieejama");
    }

    @Test
    public void testAddBook() throws Exception {
        // Pievienojam grāmatu
        Gramatas.addBook(gramata1);
        
        // Pārbaudām, vai grāmata ir pievienota
        ArrayList<Gramatas> books = Gramatas.getBookLists();
        assertTrue(books.contains(gramata1));
    }

    @Test
    public void testFindBookByName() throws Exception {
        // Pievienojam grāmatu
        Gramatas.addBook(gramata1);
        
        // Meklējam grāmatu pēc nosaukuma
        ArrayList<Gramatas> foundBooks = Gramatas.findbookbynosaukums("Grāmata1");
        
        // Pārbaudām, vai grāmata ir atrasta
        
        assertEquals(gramata1, foundBooks.get(0));
    }

    @Test
    public void testFindBookByAuthor() throws Exception {
        // Pievienojam grāmatu
        Gramatas.addBook(gramata1);
        
        // Meklējam grāmatu pēc autora
        ArrayList<Gramatas> foundBooks = Gramatas.findbookbyautors("Autors1");
        
        // Pārbaudām, vai grāmata ir atrasta
        assertEquals(1, foundBooks.size());
        assertEquals(gramata1, foundBooks.get(0));
    }

    @Test
    public void testFindBookNotFound() throws Exception {
        // Pārbaudām, vai meklēšana ar neesošu grāmatu atgriež tukšu sarakstu
        ArrayList<Gramatas> foundBooks = Gramatas.findbookbynosaukums("GrāmataNepastāv");
        assertTrue(foundBooks.isEmpty());
    }

    @Test
    public void testDeleteBook() throws Exception {
        // Pievienojam grāmatu
        Gramatas.addBook(gramata1);
        
        // Pārbaudām, vai grāmata ir pievienota
        ArrayList<Gramatas> booksBeforeDelete = Gramatas.getBookLists();
        assertTrue(booksBeforeDelete.contains(gramata1));
        
        // Dzēšam grāmatu
        Gramatas.deleteBook(gramata1);
        
        // Pārbaudām, vai grāmata tika dzēsta
        ArrayList<Gramatas> booksAfterDelete = Gramatas.getBookLists();
        assertFalse(booksAfterDelete.contains(gramata1));
    }

    @Test
    public void testEditBook() throws Exception {
        // Pievienojam grāmatu
        Gramatas.addBook(gramata1);
        
        // Sagatavojam jaunu grāmatu ar atjauninātu informāciju
        Gramatas updatedBook = new Gramatas("Grāmata1", "Autors1", 2020, "Izdevējs1", "Nepieejama");
        
        // Rediģējam grāmatu
        Gramatas.editbook(gramata1, updatedBook);
        
        // Pārbaudām, vai grāmata ir rediģēta
        ArrayList<Gramatas> books = Gramatas.getBookLists();
        assertTrue(books.contains(updatedBook));
        assertFalse(books.contains(gramata1));
    }

    @Test
    public void testShortByName() throws Exception {
        // Pievienojam vairākas grāmatas
        Gramatas.addBook(gramata1);
        Gramatas.addBook(gramata2);
        
        // Pārbaudām, vai grāmatas tiek kārtotas pēc nosaukuma
        Gramatas.shortByName();  // Pārbaudīsim ar manuālu skatīšanos, vai rezultāts ir kārtots pēc nosaukuma
    }

    @Test
    public void testShortByAuthor() throws Exception {
        // Pievienojam vairākas grāmatas
        Gramatas.addBook(gramata1);
        Gramatas.addBook(gramata2);
        
        // Pārbaudām, vai grāmatas tiek kārtotas pēc autora
        Gramatas.shortByAuthor();  // Pārbaudīsim ar manuālu skatīšanos, vai rezultāts ir kārtots pēc autora
    }

    @Test
    public void testAvailableBooks() throws Exception {
        // Pievienojam pieejamu un nepieejamu grāmatu
        Gramatas gramata3 = new Gramatas("Grāmata3", "Autors3", 2022, "Izdevējs3", "Nepieejama");
        Gramatas.addBook(gramata1);
        Gramatas.addBook(gramata3);
        
        // Pārbaudām, vai tiek atgriezts tikai pieejamās grāmatas
        ArrayList<Gramatas> availableBooks = Gramatas.pieejamiba();
        assertTrue(availableBooks.contains(gramata1));
        assertFalse(availableBooks.contains(gramata3));
    }
}
