/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contact.view;

import Contact.model.Contact;
import Contact.model.ContactsList;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

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

    //Prints out the contents of each Contact from contactsList
    //Pre: contactsList must have at least 1 contact in it
    //Post: Prints out details of each Contact in contactsList
    @Override
    public void execute() {
        getContactsList().getContactsList().forEach((Contact contact) -> {
            ArrayList<Method> methodsList;
            methodsList = getGetters(contact);
            ArrayList<Object> detailList = getContactsDetails(methodsList, contact);
            int counter = methodsList.size();
            
            for (Object g : detailList) {
                System.out.print(g + " ");
                
                // Prints newline after all getters for one contact is invoked
                if (counter <= 1) {
                    System.out.println();
                    counter = methodsList.size();
                } else {
                    counter--;
                }
            }
        });
    }

    //Traverses methodList(which is a list of getters)
    //and invokes each getter method in contact
    //Pre: methodsList contains Method objects and contact is initialized
    //Post: returns ArrayList of Objects that are the invoked getter methods
    public ArrayList<Object> getContactsDetails(ArrayList<Method> methodsList, Contact contact) {
        ArrayList<Object> details = new ArrayList<>();

        for (Method method : methodsList) {
            try {
                Object g = method.invoke(contact);
                details.add(g);
            } catch (IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return details;
    }

    //Gets all the getter methods from a Contact object using Reflection library
    //Pre: a Contact object with all getters initialized
    //Post: Returns an ArrayList with methods from Contact object
    public ArrayList<Method> getGetters(Contact contact) {
        Method[] methods = contact.getClass().getDeclaredMethods();
        ArrayList<Method> methodslist = new ArrayList<>();

        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                methodslist.add(method);
            }
        }
        return methodslist;
    }

    // Getters and Setters below
    public ContactsList getContactsList() {
        return contactsList;
    }

    public void setContactsList(ContactsList contactsList) {
        this.contactsList = contactsList;
    }

}
