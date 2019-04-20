/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analytics.view;

/**
 *
 * @author Jomar
 */
import Menu.MenuItem;
import Accounts.model.*;
public class DisplayAccountSales implements MenuItem{
    
    public AccountList HistogramData;
    
    public DisplayAccountSales (AccountList dat){
        HistogramData = dat;
    }
            
    
    @Override
    public void execute(){
        int accountSales = 0;
        for (int x = 0; x < HistogramData.getList().size(); x++){
            System.out.print(HistogramData.getList().get(x).getAccountName());
            for(int y = 0; y < HistogramData.getList().get(x).getContactsList().getContactsList().size(); y++){
            accountSales += HistogramData.getList().get(x).getContactsList().getContactsList().get(x).getProductsBought();
            }
                for(int z = 0; z < accountSales; z++){
                    System.out.print("*");
                }
            accountSales = 0;
            System.out.println("");
        }
    }

    @Override
    public String toString(){
        return "Display Sales Based on Accounts";
    }
    
}
