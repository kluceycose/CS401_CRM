package Accounts;

/**
 *
 * @author kluceycose
 */

/*
 * This class holds all the relevant information for an Account
 */

import java.util.Calendar;

public class Account {
    private int accountId;
    private int amount;
    private Calendar closeDate;
    private String accountName;
    private int primaryContactId;

    //Constructors
    public Account(){
        accountId = amount = primaryContactId = -1;
    }
    public Account(int _id, int _amount, Calendar _closeDate, String _accountName, int _ContactId){
        accountId = _id;
        amount = _amount;
        closeDate = _closeDate;
        accountName = _accountName;
        primaryContactId = _ContactId;
    }

    //Setters
    public void setAccountId(int _id)               { accountId = _id; }
    public void setAmount(int _amount)              { amount = _amount; }
    public void setCloseDate(Calendar _date)            { closeDate = _date; }
    public void setAccountName(String _name)        { accountName = _name; }
    public void setPrimaryContactId(int _contactId) { primaryContactId = _contactId; }

    //Getters
    public int getAccountId()           { return accountId; }
    public int getAmount()              { return amount; }
    public Calendar getCloseDate()          { return closeDate; }
    public String getAccountName()      { return accountName; }
    public int getPrimaryContactId()    { return primaryContactId; }
}
