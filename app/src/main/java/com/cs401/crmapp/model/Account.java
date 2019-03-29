package com.cs401.crmapp.model;

/**
 *
 * @author kluceycose
 */

/*
 * This class holds all the relevant information for an Account
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class Account implements Serializable {
    private UUID accountId;
    private String amount;
    private Calendar closeDate;
    private String accountName;
    private List<Contact> contactsList;

    //Constructors
    public Account(){
        accountId = UUID.randomUUID();
        amount = "$0";
        contactsList = new ArrayList<>();
    }
    public Account(String _accountName, String _amount, Calendar _closeDate){
        accountId = UUID.randomUUID();
        accountName = _accountName;
        amount = _amount;
        closeDate = _closeDate;
        contactsList = new ArrayList<>();
    }

    //Setters
    public void setAmount(String _amount)       { amount = _amount; }
    public void setCloseDate(Calendar _date)    { closeDate = _date; }
    public void setAccountName(String _name)    { accountName = _name; }
    public void addContact(Contact contact)     { contactsList.add(contact); }

    //Getters
    public UUID getId()                 { return accountId; }
    public String getAmount()           { return amount; }
    public Calendar getCloseDate()      { return closeDate; }
    public String getName()             { return accountName; }
    public List<Contact> getContacts()  { return contactsList; }
}
