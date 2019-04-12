package com.cs401.crmapp.model;

import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author kenny
 * Modified by:
 * @author kluceycose
 *
 * Class stores the information of a Contact.
 */
public class Contact implements Serializable {

    private String name;
    private String email;
    private String phoneNumber;
    private UUID contactId;

    //Constructor
    public Contact(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        contactId = UUID.randomUUID();
    }

    public Contact(){
        contactId = UUID.randomUUID();
    }

    // Getters and Setter below
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UUID getId(){ return contactId; }

    // Returns all fields of Contact
    @Override
    public String toString() {
        return (getName() + " " + getEmail() + " " + getPhoneNumber());
    }
}
