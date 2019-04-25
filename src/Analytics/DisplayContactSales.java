/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analytics.view;

import Contact.model.*;
import Menu.MenuItem;
/**
 *
 * @author Jomar
 */
public class DisplayContactSales implements MenuItem{
    
    public ContactsList histogramData;
    
    public DisplayContactSales (ContactsList dat){
        histogramData = dat;
    }
    
    @Override
    public void execute(){
        for (int x = 0; x < histogramData.getContactsList().size(); x++){
            System.out.print(histogramData.getContactsList().get(x).getName() + "\t\t");
            for (int y = 0; y < histogramData.getContactsList().get(y).getProductsBought(); y++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    
    @Override
    public String toString(){
        return "Display Contacts Sales";
    }
    
    
}
