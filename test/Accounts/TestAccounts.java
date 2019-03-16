package Accounts;

/**
 *
 * @author kluceycose
 */

/*
 * Test class for the Account and AccountList classes
 */

import Accounts.model.Account;
import Accounts.model.AccountList;
import Contact.model.Contact;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class TestAccounts {
    Account account;
    AccountList accountList;

    public TestAccounts(){}

    @Before
    public void setUp(){
        account = new Account(1, 12000, new GregorianCalendar(), "Account 1");
        accountList = new AccountList();
        accountList.addAccount(account);
        account = new Account(2, 16000, new GregorianCalendar(), "Account 2");
        accountList.addAccount(account);
    }

    @Test
    public void testAccounts(){
        assertEquals("Account 1", accountList.getAccount(0).getAccountName());
        assertEquals(1, accountList.getAccount(0).getAccountId());
        assertEquals(12000, accountList.getAccount(0).getAmount());
    }

    @Test
    public void testAddContact(){
        Contact contact = new Contact("John Nabaretti",
                "jnabaretti@business.com",
                "919-625-3324");
        accountList.getAccount(0).addContact(contact);
        assertEquals("John Nabaretti", accountList.getAccount(0).getPrimaryContact());
    }

    @After
    public void tearDown(){

    }
}
