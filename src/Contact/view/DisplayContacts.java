/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contact.view;

import Contact.model.Contact;
import Contact.model.ContactsList;

/**
 *
 * @author kenny
 *
 * Prints out details of all Contacts from a ContactsList
 */
public class DisplayContacts implements ContactsView {

    private ContactsList contactsList;

    // Constructor
    public DisplayContacts(ContactsList contactsList) {
        this.contactsList = contactsList;
    }

    // Gets ContactsList and prints out each contact on a newline
    // Pre: ContactsList is initialized with contacts.
    // Post: Contact details are printed to console.
    @Override
    public void execute() {
        getContactsList().getContactsList().forEach((Contact contact) -> {
            System.out.println(contact.toString());
        });
    }

    // Getters and Setters below
    public ContactsList getContactsList() {
        return contactsList;
    }

    public void setContactsList(ContactsList contactsList) {
        this.contactsList = contactsList;
    }

}
