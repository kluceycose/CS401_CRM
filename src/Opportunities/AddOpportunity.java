package Opportunities;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import Menu.MenuItem;
import Opportunities.opportunity;
import Opportunities.opportunityList;

public class AddOpportunity implements MenuItem {
	private opportunityList OpportunityList;
	

	
public AddOpportunity(opportunityList _OpportunityList)
{

 OpportunityList = _OpportunityList;
}

public void execute(){
	String name,creation,description,contract,OpporutnityName,OpporutnityOwner,
    primaryCampaignSource,Stage,Type,stringDate;

    int amount,ExpectedRevenue;
    Scanner STDIN = new Scanner(System.in);
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    Calendar date = new GregorianCalendar();

    // Adding account name 
    System.out.println("Enter Account name: ");
    name = STDIN.nextLine();
    
    // Adding Amount
    System.out.println("Enter Account value: ");
    amount = Integer.parseInt(STDIN.nextLine());
    
    // Adding close Date  
    System.out.println("Enter Close Date:\nDay (dd): ");
    date.set(Calendar.DAY_OF_MONTH, Integer.parseInt(STDIN.nextLine()));
    System.out.println("Month (mm): ");
    date.set(Calendar.MONTH, Integer.parseInt(STDIN.nextLine()));
    System.out.println("Year (yyyy): ");
    date.set(Calendar.YEAR, Integer.parseInt(STDIN.nextLine()));
    
   // Adding contract
    System.out.println("Enter contract");
    contract = STDIN.nextLine();

    
    // Adding createdBy
    
    System.out.println("Enter opportunity created by ");
    creation = STDIN.nextLine();

    
    
    // Adding Description

    System.out.println("Enter the description ");
    description = STDIN.nextLine();
    
    // Adding ExpectedRevenue 
    
    System.out.println("Enter ExpectedRevenue: ");
    ExpectedRevenue = Integer.parseInt(STDIN.nextLine());

// Adding OpporutnityName
    System.out.println("Enter the OpporutnityName ");
    OpporutnityName = STDIN.nextLine();
    
// Adding OpporutnityOwner
    System.out.println("Enter the OpporutnityOwner ");
    OpporutnityOwner = STDIN.nextLine();
    
// Adding primaryCampaignSource
    System.out.println("Enter the primaryCampaignSource ");
    primaryCampaignSource = STDIN.nextLine();
    
// Adding Stage
    System.out.println("Enter the Stage ");
    Stage = STDIN.nextLine();
    
// Adding Type
    System.out.println("Enter the Type ");
    Type = STDIN.nextLine();
    
    
    opportunity Opportun= new opportunity(); 
	
    Opportun.setAccountName(name);
    Opportun.setAmount(amount);
    Opportun.setCloseDate(date);
    Opportun.setContract(contract);
    Opportun.setCreatedBy(creation);
    Opportun.setDescription(description);
    Opportun.setExpectedRevenue(ExpectedRevenue);
    Opportun.setOpporutnityName(OpporutnityName);
    Opportun.setOpporutnityOwner(OpporutnityOwner);
    Opportun.setStage(Stage);
    Opportun.setType(Type);
    OpportunityList.addOpportunity(Opportun);

}

@Override
public String toString()  
{ 
	return "Create an Opportunity";
	}
}





