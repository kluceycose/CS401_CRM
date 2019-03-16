package Accounts.view;

/**
 * @author kluceycose
 */

/*
 * This class will create a new submenu for working with accounts
 */

import Accounts.model.AccountList;
import Menu.*;

public class ManageAllAccounts implements MenuItem {
    private Menu mainMenu;
    private MenuStack menus;
    private AccountList accountList;

    public ManageAllAccounts(Menu main, MenuStack stack){
        mainMenu = main;
        menus = stack;
        accountList = new AccountList();
    }
    @Override
    public void execute(){
        Menu submenu = new Menu("Accounts", menus);
        submenu.addOption(new ReturnFromMenu(mainMenu.toString(), menus));
        submenu.addOption(new AccountsSummary(accountList));
        submenu.addOption(new DisplayAccount(accountList));
        submenu.addOption(new AddAccount(accountList));
        submenu.addOption(new AddContact(accountList));
        submenu.execute();
    }

    @Override
    public String toString(){
        return "Manage Accounts";
    }
}
