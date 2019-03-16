package Accounts.view;

/**
 *
 * @author kluceycose
 */

/*
 * This class will show the account ID and account name of all accounts on file
 */

import Menu.MenuItem;
import Accounts.model.Account;
import Accounts.model.AccountList;

import java.util.List;

public class AccountsSummary implements MenuItem {
    private AccountList accountList;

    public AccountsSummary(AccountList _accountList){
        accountList = _accountList;
    }
    @Override
    public void execute(){
        List<Account> list = accountList.getList();
        for(Account acct: list){
            System.out.println(acct.getAccountId()+". "+acct.getAccountName());
        }
    }

    @Override
    public String toString(){ return "Display a summary list of Accounts"; }
}
