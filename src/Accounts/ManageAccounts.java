package Accounts;

/**
 * @author kluceycose
 */

/*
 * This class will create a new submenu for working with accounts
 */

import Menu.Menu;
import Menu.MenuItem;
import Menu.MenuStack;

public class ManageAccounts implements MenuItem {
    Menu mainMenu;
    MenuStack menus;
    AccountList accountList;

    public ManageAccounts(Menu main, MenuStack stack){
        mainMenu = main;
        menus = stack;
    }

    public void execute(){
        Menu submenu = new Menu("Accounts", menus);
        //submenu.add(new ReturnfromMenu(mainMenu.toString(), menus));
        submenu.addOption(new AccountsSummary(accountList));
        submenu.addOption(new DisplayAccount(accountList));
        submenu.addOption(new AddAccount(accountList));
        submenu.execute();
    }

    @Override
    public String toString(){
        return "Manage Accounts";
    }
}
