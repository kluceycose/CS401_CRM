/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contact.model;

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
public class ContactsListTest {
    Contact contact;
    
    public ContactsListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        contact = new Contact("Tim", "Tim@gmail.com", "555-5555");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class ContactsList.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        assertEquals("Tim", contact.getName());
        assertEquals("Tim@gmail.com", contact.getEmail());
        assertEquals("555-5555", contact.getPhoneNumber());
    }
}
