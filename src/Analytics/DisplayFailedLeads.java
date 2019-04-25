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

import Lead.Model.*;
import Menu.MenuItem;
public class DisplayFailedLeads implements MenuItem{
    
    
    public LeadList leadHistogramData;
    
    public DisplayFailedLeads (LeadList dat){
        leadHistogramData = dat;
    }
    
    @Override
    public void execute(){

        System.out.print("Failed Leads: ");
        for (int x = 0; x < leadHistogramData.getList().size(); x++){
                System.out.print("*");
            }
            System.out.print(leadHistogramData.getList().size());
        }
    
    @Override
    public String toString(){
        return "Display Failed Leads";
    }
    
    
}