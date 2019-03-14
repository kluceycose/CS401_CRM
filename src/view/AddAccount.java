package view;

/**
 *
 * @author kluceycose
 */

import Menu.MenuItem;
import model.Account;
import model.AccountList;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
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
        Date date;
        System.out.println("Enter Account name: ");
        name = STDIN.nextLine();
        System.out.println("Enter Account value: ");
        amount = STDIN.nextInt();
        System.out.println("Enter Close Date (dd/mm/yy): ");
        try {
            date = DateFormat.getDateInstance().parse(STDIN.nextLine());
        }
        catch(ParseException pe){
            System.out.println("Parse Error: "+pe);
            date = new Date();
        }
        System.out.println("Known contact? (y/n): ");
        if(STDIN.next().equals("y")){
                System.out.println("Enter Contact ID: ");
                contactId = STDIN.nextInt();
        }
        Account account;
        if(contactId != -1){
            account = new Account(id, amount, date, name, contactId);
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
