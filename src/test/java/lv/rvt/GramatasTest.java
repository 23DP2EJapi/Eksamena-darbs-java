package lv.rvt;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import lv.rvt.tools.Helper;

import static org.junit.Assert.assertEquals;

public class GramatasTest {

    @Before
public void clearFile() throws Exception {
    BufferedWriter writer = Helper.getWriter("Gramatas.csv", StandardOpenOption.TRUNCATE_EXISTING);
    writer.write("");
    writer.close();
}

    @Test
    public void testFindBookByTitle() throws Exception {
        Gramatas book1 = new Gramatas("Grāmata A", "Autors A", 2001, "Izdevējs A", "Pieejama");
        Gramatas book2 = new Gramatas("Grāmata B", "Autors B", 2002, "Izdevējs B", "Nepieejama");
        Gramatas book3 = new Gramatas("Grāmata C", "Autors C", 2003, "Izdevējs C", "Pieejama");

        Gramatas.addBook(book1);
        Gramatas.addBook(book2);
        Gramatas.addBook(book3);

        assertEquals(1, Gramatas.findbookbynosaukums("Grāmata A").size());
        assertEquals(1, Gramatas.findbookbynosaukums("Grāmata B").size());
        assertEquals(0, Gramatas.findbookbynosaukums("Neeksistē").size());
    }

@Test
public void testFindBookByAuthor() throws Exception {
    
    Helper.getWriter("Gramatas.csv", java.nio.file.StandardOpenOption.TRUNCATE_EXISTING).close();

   
    Gramatas.addBook(new Gramatas("Grāmata 1", "Autors A", 2001, "Izdevējs 1", "Pieejama"));
    Gramatas.addBook(new Gramatas("Grāmata 2", "Autors B", 2002, "Izdevējs 2", "Pieejama"));
    Gramatas.addBook(new Gramatas("Grāmata 3", "Autors C", 2003, "Izdevējs 3", "Nepieejama"));

    
    assertEquals(1, Gramatas.findbookbyautors("Autors A").size());
    assertEquals(1, Gramatas.findbookbyautors("Autors C").size());
    assertEquals(0, Gramatas.findbookbyautors("Nezināms Autors").size());
}


@Test
public void testFindBook() throws Exception {
    
    BufferedWriter writer = Helper.getWriter("Gramatas.csv", StandardOpenOption.TRUNCATE_EXISTING);
    writer.write("");
    writer.close();

    
    Gramatas book1 = new Gramatas("Grāmata A", "Autors A", 2001, "Izdevējs A", "Pieejama");
    Gramatas book2 = new Gramatas("Grāmata C", "Autors C", 2003, "Izdevējs C", "Pieejama");
    Gramatas book3 = new Gramatas("Nav Grāmata", "Neviens", 1999, "???", "Pieejama");

    Gramatas.addBook(book1);
    Gramatas.addBook(book2);

    
    assertTrue(Gramatas.findbook(book1));
    assertTrue(Gramatas.findbook(book2));
    assertFalse(Gramatas.findbook(book3)); 
}

    @Test
    public void testAddBookAndDeleteBook() throws Exception {
        Gramatas book = new Gramatas("Test Grāmata", "Tests", 2020, "Testētājs", "Pieejama");

        Gramatas.addBook(book);
        assertTrue(Gramatas.findbook(book));

        assertTrue(Gramatas.deleteBook(book));
        assertFalse(Gramatas.findbook(book));
    }

    @Test
    public void testEditBook() throws Exception {
        Gramatas original = new Gramatas("Rediģētā", "Autors", 2018, "Old Pub", "Pieejama");
        Gramatas.addBook(original);
    
        Gramatas jauna = new Gramatas("Rediģētā", "Autors", 2018, "Old Pub", "Nepieejama");
        Gramatas.editbook(original, jauna); 
    
        ArrayList<Gramatas> results = Gramatas.findbookbynosaukums("Rediģētā");
        assertEquals(1, results.size());
        assertEquals("Nepieejama", results.get(0).Pieejamība());
    }

    @Test
    public void testPieejamiba() throws Exception {
        Gramatas book1 = new Gramatas("P1", "A1", 2000, "Iz1", "Pieejama");
        Gramatas book2 = new Gramatas("P2", "A2", 2000, "Iz2", "Nepieejama");
        Gramatas book3 = new Gramatas("P3", "A3", 2000, "Iz3", "Pieejama");

        Gramatas.addBook(book1);
        Gramatas.addBook(book2);
        Gramatas.addBook(book3);

        ArrayList<Gramatas> list = Gramatas.pieejamiba();
        assertTrue(list.stream().anyMatch(g -> g.getname().equals("P1")));
        assertTrue(list.stream().anyMatch(g -> g.getname().equals("P3")));
        assertFalse(list.stream().anyMatch(g -> g.getname().equals("P2")));
    }
}
