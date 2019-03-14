package model;

/**
 *
 * @author kluceycose
 */

import java.util.Date;

public class Account {
    private int accountId;
    private int amount;
    private Date closeDate;
    private String accountName;
    private int primaryContactId;

    //Constructors
    public Account(){
        accountId = amount = primaryContactId = -1;
    }
    public Account(int _id, int _amount, Date _closeDate, String _accountName, int _ContactId){
        accountId = _id;
        amount = _amount;
        closeDate = _closeDate;
        accountName = _accountName;
        primaryContactId = _ContactId;
    }

    //Setters
    public void setAccountId(int _id)               { accountId = _id; }
    public void setAmount(int _amount)              { amount = _amount; }
    public void setCloseDate(Date _date)            { closeDate = _date; }
    public void setAccountName(String _name)        { accountName = _name; }
    public void setPrimaryContactId(int _contactId) { primaryContactId = _contactId; }

    //Getters
    public int getAccountId()           { return accountId; }
    public int getAmount()              { return amount; }
    public Date getCloseDate()          { return closeDate; }
    public String getAccountName()      { return accountName; }
    public int getPrimaryContactId()    { return primaryContactId; }
}
