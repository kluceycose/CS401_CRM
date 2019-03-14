package view;

/**
 *
 * @author kluceycose
 */

import Menu.Menu;
import Menu.MenuItem;
import Menu.MenuStack;
import model.AccountList;

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
        submenu.add(new QuitCmd());
        submenu.add(new ReturnfromMenu(mainMenu.toString(), menus));
        submenu.add(new AccountsSummary(accountList));
        submenu.add(new DisplayAccount(accountList));
        submenu.add(new AddAccount(accountList));
        submenu.execute();
    }

    @Override
    public String toString(){
        return "Manage Accounts";
    }
}
