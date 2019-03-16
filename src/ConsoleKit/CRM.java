/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsoleKit;
import Menu.*;
import Accounts.view.*;

/**
 *
 * @author Jomar
 */
public class CRM {
    public static void main(String[] args){
      //Initialize Menus and MenuStack
      MenuStack menus = new MenuStack();
      Menu mainMenu = new Menu("Main Menu", menus);
      ManageAllAccounts manageAccounts = new ManageAllAccounts(mainMenu, menus);
      
        //Adding options to Menu
        mainMenu.addOption(manageAccounts);
        mainMenu.addOption(new QuitOption());
        System.out.println("CRM, version 0.1");
        while (true)
            //Run Menu
            menus.run();
        
    }
}
