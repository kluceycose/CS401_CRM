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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class TestAccounts {
    Account account;
    AccountList accountList;

    public TestAccounts(){}

    @Before
    public void setUp(){
        account = new Account(1, 12000, new Date(), "Account 1", 2);
        accountList = new AccountList();
        accountList.addAccount(account);
        account = new Account(2, 16000, new Date(), "Account 2", 1);
        accountList.addAccount(account);
    }

    @Test
    public void testAccounts(){
        assertEquals("Account 1", accountList.getAccount(0).getAccountName());
        assertEquals(1, accountList.getAccount(0).getAccountId());
        assertEquals(12000, accountList.getAccount(0).getAmount());
        assertEquals(2, accountList.getAccount(0).getPrimaryContactId());
    }

    @After
    public void tearDown(){

    }
}
