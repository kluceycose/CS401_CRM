package Accounts.view;

/**
 *
 * @author kluceycose
 */

/*
 * This class will display the details of a single account
 */

import Menu.MenuItem;
import Accounts.model.Account;
import Accounts.model.AccountList;

import java.util.Calendar;
import java.util.Scanner;

public class DisplayAccount implements MenuItem {
    AccountList accountList;

    public DisplayAccount(AccountList _accountList){
        accountList = _accountList;
    }
    @Override
    public void execute(){
        Scanner STDIN = new Scanner(System.in);
        System.out.println("Enter Account ID: ");
        int id = STDIN.nextInt();
        Account account = accountList.getAccount(id);
        if(account != null){
            System.out.println("Account ID: "+account.getAccountId()+
                    "\nAccount Name: "+account.getAccountName()+
                    "\nAmount: $"+account.getAmount()+
                    "\nClose Date: "+account.getCloseDate().get(Calendar.DAY_OF_MONTH) +
                    "\\"+ account.getCloseDate().get(Calendar.MONTH)+
                    "\\"+ account.getCloseDate().get(Calendar.YEAR)+
                    "\nPrimary Contact: "+account.getPrimaryContact());
        }
    }

    @Override
    public String toString(){
        return "Display an Account's Details";
    }
}
