/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contact.view;

import Contact.model.Contact;
import Contact.model.ContactsList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kenny
 */
public class DisplayContactsTest {
    Contact contact1, contact2, contact3;
    ContactsList contactsList;
    DisplayContacts displayContacts;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    public DisplayContactsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
}

    @After
    public void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
}
    
    @Before
    public void setUpContacts() {
        contact1 = new Contact("Greg", "Greg1@google.com", "555-1234");
        contact2 = new Contact("Alice", "Alice2@yahoo.com", "444-4321");
        contact3 = new Contact("Jim", "Jim3@outlook.com", "333-3210");
        contactsList = new ContactsList(contact1);
        contactsList.add(contact2);
        contactsList.add(contact3);
        displayContacts = new DisplayContacts(contactsList);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class DisplayContacts.
     */
    //@Test
    public void testExecute() {
    }

    /**
     * Test of getGetters method, of class DisplayContacts.
     */
    @Test
    public void testGetGetters() {
        Contact tempContact = new Contact("Greg", "Greg@gmail.com", "555,5555");
        ArrayList<Method> tempMethodsList = new ArrayList<>();
        
        try {
            tempMethodsList.add(tempContact.getClass().getDeclaredMethod("getName"));
            tempMethodsList.add(tempContact.getClass().getDeclaredMethod("getEmail"));
            tempMethodsList.add(tempContact.getClass().getDeclaredMethod("getPhoneNumber"));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(DisplayContactsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        assertEquals(tempMethodsList, displayContacts.getGetters(tempContact));
    }
}
