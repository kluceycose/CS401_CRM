/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsoleKit;
import Menu.*;
import Accounts.view.*;
import Opportunities.AddOpportunity;
import Opportunities.DisplayOpportunity;
import Opportunities.OpportunitySummary;
import Opportunities.opportunityList;
import sun.awt.geom.AreaOp;

/**
 *
 * @author Jomar
 */
public class CRM {
    public static void main(String[] args){
      //Initialize Menus and MenuStack
      MenuStack menus = new MenuStack();
      Menu mainMenu = new Menu("Main Menu", menus);
      opportunityList opList = new opportunityList();
      
        //Adding options to Menu
        mainMenu.addOption(new ManageAllAccounts(mainMenu, menus));
        mainMenu.addOption(new OpportunitySummary(opList));
        mainMenu.addOption(new DisplayOpportunity(opList));
        mainMenu.addOption(new AddOpportunity(opList));
        mainMenu.addOption(new QuitOption());
        System.out.println("CRM, version 0.1");
        while (true)
            //Run Menu
            menus.run();
        
    }
}
