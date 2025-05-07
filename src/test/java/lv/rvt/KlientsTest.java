package lv.rvt;

import org.junit.Before;
import org.junit.Test;

import lv.rvt.tools.Helper;

import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class KlientsTest {

    @Before
    public void clearFile() throws Exception {
        
        BufferedWriter writer = Helper.getWriter("Klienti.csv", StandardOpenOption.TRUNCATE_EXISTING);
        writer.write("");
        writer.close();
    }

    @Test
    public void testAddPerson() throws Exception {
        
        Klients client = new Klients("Jānis", "Bērziņš", "123456789");
        Klients.addPerson(client);

        
        ArrayList<Klients> results = Klients.findperson("Jānis");
        assertEquals(1, results.size());
        assertEquals("Jānis Bērziņš", results.get(0).getFullName());
    }

    @Test
    public void testFindPerson() throws Exception {
       
        Klients client1 = new Klients("Jānis", "Bērziņš", "123456789");
        Klients client2 = new Klients("Anna", "Ozoliņa", "987654321");
        Klients.addPerson(client1);
        Klients.addPerson(client2);

    
        ArrayList<Klients> results1 = Klients.findperson("Jānis");
        assertEquals(1, results1.size());
        assertEquals("Jānis Bērziņš", results1.get(0).getFullName());

        ArrayList<Klients> results2 = Klients.findperson("Anna");
        assertEquals(1, results2.size());
        assertEquals("Anna Ozoliņa", results2.get(0).getFullName());

        ArrayList<Klients> results3 = Klients.findperson("Pēteris");
        assertEquals(0, results3.size());
    }

    @Test
    public void testEditPerson() throws Exception {

        Klients original = new Klients("Jānis", "Bērziņš", "123456789");
        Klients.addPerson(original);

        Klients updated = new Klients("Jānis", "Bērziņš", "111223344");
        Klients.editPerson(original, updated);

        ArrayList<Klients> results = Klients.findperson("Jānis");
        assertEquals(1, results.size());
        assertEquals("Jānis Bērziņš", results.get(0).getFullName());
        assertEquals("111223344", results.get(0).getKontakinfo());
    }

    @Test
    public void testDeletePerson() throws Exception {
  
        Klients client = new Klients("Jānis", "Bērziņš", "123456789");
        Klients.addPerson(client);

        Klients.deletePerson(client);

        ArrayList<Klients> results = Klients.findperson("Jānis");
        assertEquals(0, results.size());
    }

    @Test
    public void testShortByFirstName() throws Exception {

        Klients client1 = new Klients("Zane", "Kalniņa", "111223344");
        Klients client2 = new Klients("Anna", "Ozoliņa", "987654321");
        Klients client3 = new Klients("Jānis", "Bērziņš", "123456789");
        Klients.addPerson(client1);
        Klients.addPerson(client2);
        Klients.addPerson(client3);
    
   
        ArrayList<Klients> expected = new ArrayList<>();
        expected.add(client2); // Anna
        expected.add(client3); // Jānis
        expected.add(client1); // Zane
    

        ArrayList<Klients> actual = Klients.shortByFirstNameList();
    
        assertEquals(expected, actual);
    }
    
    @Test
    public void testShortByLastName() throws Exception {
   
        Klients client1 = new Klients("Zane", "Kalniņa", "111223344");
        Klients client2 = new Klients("Anna", "Ozoliņa", "987654321");
        Klients client3 = new Klients("Jānis", "Bērziņš", "123456789");
        Klients.addPerson(client1);
        Klients.addPerson(client2);
        Klients.addPerson(client3);
    
      
        ArrayList<Klients> expected = new ArrayList<>();
        expected.add(client3); // Bērziņš
        expected.add(client1); // Kalniņa
        expected.add(client2); // Ozoliņa
    
        
        ArrayList<Klients> actual = Klients.shortByLastNameList();
    
        assertEquals(expected, actual);
    }
    
    @Test
    public void testFindPersonByFullName() throws Exception {
    
        Klients client1 = new Klients("Jānis", "Bērziņš", "123456789");
        Klients client2 = new Klients("Anna", "Ozoliņa", "987654321");
        Klients.addPerson(client1);
        Klients.addPerson(client2);


        assertTrue(Klients.findpersonbBoolea(client1));
        assertTrue(Klients.findpersonbBoolea(client2));
    }
}
