package com.cs401.crmapp.model;

import android.content.Context;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

public class AccountLab implements Serializable {
    private static AccountLab sAccountLab;
    private List<Account> mAccounts;

    private AccountLab(Context context){
        mAccounts = new ArrayList<>();
        mAccounts.add(new Account("BlackHawk International", "$20000",
                new GregorianCalendar()));
        mAccounts.get(0).addContact(new Contact("Ted",
                                                "ted@workemail.com",
                                                "9391758204"));
        mAccounts.get(0).addContact(new Contact("Dave",
                                                "dave@davedavidson.com",
                                                "5182940295"));
        mAccounts.add(new Account("Interminable Industries", "$45000",
                new GregorianCalendar()));
        mAccounts.get(1).addContact(new Contact("Zorklu",
                                                "zorklu@interminableindustries.com",
                                                "5928590385"));
        mAccounts.get(1).addContact(new Contact("Snago",
                                                "snago@interminableindustries.com",
                                                "2384827459"));
    }

    public static AccountLab get(Context context){
        if(sAccountLab == null){
            sAccountLab = new AccountLab(context);
        }
        return sAccountLab;
    }

    public List<Account> getAccounts(){
        return mAccounts;
    }

    public Account getAccount(UUID id){
        for(Account account: mAccounts){
            if(account.getId().equals(id))
                return account;
        }
        return null;
    }

}
