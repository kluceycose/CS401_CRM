package Accounts.view;

/**
 * @author kluceycose
 */

/*
 * This class will get the info for and add a new Contact to an Account
 */

import Accounts.model.AccountList;
import Contact.model.Contact;
import Menu.MenuItem;

import java.util.Scanner;

public class AddContact implements MenuItem {
    private AccountList accountList;

    AddContact(AccountList accountList){
        this.accountList = accountList;
    }

    public void execute(){
        String name, email, phone;
        int accountNum;
        Scanner scan = new Scanner(System.in);
        System.out.println("Accounts:");
        AccountsSummary summary = new AccountsSummary(accountList);
        summary.execute();
        System.out.println("Enter account number: ");
        accountNum = Integer.parseInt(scan.nextLine());
        System.out.println("Enter Contact name:");
        name = scan.nextLine();
        System.out.println("Enter email: ");
        email = scan.nextLine();
        System.out.println("Enter phone number: ");
        phone = scan.nextLine();
        Contact contact = new Contact(name, email, phone);
        accountList.getAccount(accountNum).addContact(contact);
    }

    @Override
    public String toString(){
        return "Add a Contact to an Account";
    }
}
