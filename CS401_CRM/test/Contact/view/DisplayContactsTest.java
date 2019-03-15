/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contact.view;

import Contact.model.Contact;
import Contact.model.ContactsList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author kenny
 */
public class DisplayContactsTest {
    Contact contact1;
    ContactsList contactsList;
    
    public DisplayContactsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUpContacts() {
        contact1 = new Contact("Greg", "Greg1@google.com", "555-1234");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class DisplayContacts.
     */
    @Test
    public void testExecute() {
        assertEquals("Greg Greg1@google.com 555-1234", contact1.toString());
    }
}
