package Opportunities;

import java.util.Calendar;
import java.util.Scanner;

import Menu.MenuItem;

public class DisplayOpportunity  implements MenuItem {
    opportunityList OpportunityList;
    
    
    public DisplayOpportunity(opportunityList _OpportunityList){
    	OpportunityList = _OpportunityList;
    }

    public void execute(){
        Scanner STDIN = new Scanner(System.in);
        System.out.println("Enter opportunityid to find the associated opportunities to it  ");
       int id = STDIN.nextInt();
       opportunity Opportunity = OpportunityList.getOpportunity(id);
       if(Opportunity != null){
           System.out.println("opportunity ID: "+Opportunity.getOpportunityid()+
                   "\n Account Name: "+ Opportunity.getAccountName()+
                   "\n Amount: "+Opportunity.getAmount()+
                   "\nClose Date: "+Opportunity.getCloseDate().get(Calendar.DAY_OF_MONTH) +
                   "\\"+ Opportunity.getCloseDate().get(Calendar.MONTH)+
                   "\\"+ Opportunity.getCloseDate().get(Calendar.YEAR)+
                   "\n contract: "+Opportunity.getContract() +
                   "\n createdBy: "+Opportunity.getCreatedBy() +
                   "\n Description: "+Opportunity.getDescription()+
                   "\n ExpectedRevenue: "+Opportunity.getExpectedRevenue() +
                   "\n OpporutnityName: "+Opportunity.getOpporutnityName() +
                   "\n OpporutnityOwner: "+Opportunity.getOpporutnityOwner() +
                   "\n primaryCampaignSource: "+Opportunity.getPrimaryCampaignSource() +
                   "\n Stage: "+Opportunity.getStage() +
                   "\n Type: "+Opportunity.getType());

                   

       }
   }

   @Override
   public String toString(){
       return "Display the required Opportunity";
   }
}
   
