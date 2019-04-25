/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsoleKit;
import Menu.*;
import Accounts.view.*;
import Accounts.model.*;
import Opportunities.Model.*;
import Opportunities.View.*;
import Lead.Model.*;
import Contact.model.*;
import Analytics.view.*;
    
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
      ContactsList clist = new ContactsList();
      AccountList alist = new AccountList();
      LeadList llist = new LeadList();
      
      
        //Adding options to Menu
        mainMenu.addOption(new ManageAllAccounts(mainMenu, menus));
        mainMenu.addOption(new OpportunitySummary(opList));
        mainMenu.addOption(new DisplayOpportunity(opList));
        mainMenu.addOption(new AddOpportunity(opList));
        mainMenu.addOption(new DisplayContactSales(clist));
        mainMenu.addOption(new DisplayAccountSales(alist));
        mainMenu.addOption(new DisplayFailedLeads(llist));
        
        
        mainMenu.addOption(new QuitOption());
        System.out.println("CRM, version 0.1");
        while (true)
            //Run Menu
            menus.run();
        
    }
}
