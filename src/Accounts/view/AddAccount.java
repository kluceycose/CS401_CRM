package Accounts.view;

/**
 *
 * @author kluceycose
 */

/*
 * This class will ask for the details to create a new Account, and
 * add it to the AccountList
 */

import Menu.MenuItem;
import Accounts.model.Account;
import Accounts.model.AccountList;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class AddAccount implements MenuItem {
    private AccountList accountList;

    public AddAccount(AccountList _accountList){
        accountList = _accountList;
    }

    public void execute(){
        Scanner STDIN = new Scanner(System.in);
        String name, stringDate;
        int amount, id = accountList.getList().size(), contactId = -1;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Calendar date = new GregorianCalendar();
        System.out.println("Enter Account name: ");
        name = STDIN.nextLine();
        System.out.println("Enter Account value: ");
        amount = Integer.parseInt(STDIN.nextLine());
        System.out.println("Enter Close Date:\nDay (dd): ");
        date.set(Calendar.DAY_OF_MONTH, Integer.parseInt(STDIN.nextLine()));
        System.out.println("Month (mm): ");
        date.set(Calendar.MONTH, Integer.parseInt(STDIN.nextLine()));
        System.out.println("Year (yyyy): ");
        date.set(Calendar.YEAR, Integer.parseInt(STDIN.nextLine()));
        Account account;
        if(contactId != -1){
            account = new Account(id, amount, date, name);
        }
        else{
            account = new Account();
            account.setAccountId(id);
            account.setAccountName(name);
            account.setAmount(amount);
            account.setCloseDate(date);
        }
        accountList.addAccount(account);
    }

    @Override
    public String toString()    { return "Add an Account"; }
}
