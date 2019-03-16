package Accounts.view;

import Accounts.model.AccountList;
import Contact.model.Contact;
import Menu.MenuItem;

import java.util.Scanner;

public class AddContact implements MenuItem {
    AccountList accountList;

    public AddContact(AccountList accountList){
        this.accountList = accountList;
    }

    public void execute(){
        String name, email, phone;
        int accountNum;
        Scanner scan = new Scanner(System.in);
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
}
