/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contact.model;

import java.util.ArrayList;

/**
 *
 * @author kenny
 * 
 * Holds a list of contacts.
 * Will often we associated with an Account.
 */
public class ContactsList {

    private final ArrayList<Contact> contactsList;
    private String listName;

    // Default constructor
    public ContactsList(){
        contactsList = new ArrayList<>();
    }
    // Constructor for single Contact
    public ContactsList(Contact contact) {
        contactsList = new ArrayList<>();
        contactsList.add(contact);
    }

    // Constructor for list of Contacts
    public ContactsList(ArrayList<Contact> contactList) {
        this.contactsList = contactList;
    }
    
    // Adds a Contact object to the list
    public void add(Contact contact) {
        getContactsList().add(contact);
    }
    
    // Getters and setters below
    public ArrayList<Contact> getContactsList() {
        return contactsList;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
    
}
