package Accounts.model;

/**
 *
 * @author kluceycose
 */

/*
 * This class holds all the relevant information for an Account
 */

import Contact.model.Contact;
import Contact.model.ContactsList;

import java.util.Calendar;

public class Account {
    private int accountId;
    private int amount;
    private Calendar closeDate;
    private String accountName;
    private ContactsList contactsList;

    //Constructors
    public Account(){
        accountId = amount = -1;
        contactsList = new ContactsList();
    }
    public Account(int _id, int _amount, Calendar _closeDate, String _accountName){
        accountId = _id;
        amount = _amount;
        closeDate = _closeDate;
        accountName = _accountName;
        contactsList = new ContactsList();
    }

    //Setters
    public void setAccountId(int _id)               { accountId = _id; }
    public void setAmount(int _amount)              { amount = _amount; }
    public void setCloseDate(Calendar _date)            { closeDate = _date; }
    public void setAccountName(String _name)        { accountName = _name; }
    public void addContact(Contact contact) { contactsList.add(contact); }

    //Getters
    public int getAccountId()           { return accountId; }
    public int getAmount()              { return amount; }
    public Calendar getCloseDate()          { return closeDate; }
    public String getAccountName()      { return accountName; }
    public ContactsList getContactsList()     { return contactsList; }
    public String getPrimaryContact()    { return contactsList.getContactsList().get(0).getName(); }
}
