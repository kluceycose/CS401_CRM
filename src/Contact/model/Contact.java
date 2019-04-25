/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contact.model;

/**
 *
 * @author kenny
 *
 * Class stores the information of a Contact.
 * Will often be inside a ContactsList.
 */
public class Contact {

    private String name;
    private String email;
    private String phoneNumber;
    private int productsBought;

    //Constructor
    public Contact(String name, String email, String phoneNumber, String pB) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.productsBought = pB;
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
    
    // Returns all fields of Contact
    @Override
    public String toString() {
        return (getName() + " " + getEmail() + " " + getPhoneNumber());
    }
    public void setProductsBought(int _productsBought) {
    this.productsBought = _productsBought;
    }
    public int getProductsBought(){
        return productsBought;
    }
}
