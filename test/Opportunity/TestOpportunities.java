package Opportunities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;


public class TestOpportunities{
    opportunity Opportunity;
    opportunityList OpportunityList;

    public TestOpportunities(){}

    @Before
    public void setUp(){
    	Opportunity = new opportunity("Account abc",1,10000,
    			new GregorianCalendar(),"contract abc","created abc",
    			"Des abc",39000,"Opp abc ",
    			"Opp owner","source abc","Stage xyz", "Type 1");
    	
    	OpportunityList = new opportunityList();
    	OpportunityList.addOpportunity(Opportunity);
    	Opportunity = new opportunity("Account abcd",2,20000,
    			new GregorianCalendar(),"contract abcd","created abcd",
    			"Des abc",39001,"Opp abcd ",
    			"Opp owner2","source abcd","Stage xyz2", "Type 2");    
    	OpportunityList.addOpportunity(Opportunity);
    }

    @Test
    public void testAccounts(){
        assertEquals("Opp abc", OpportunityList.getOpportunity(0).getOpporutnityName());
       
    }

    @After
    public void tearDown(){

    }
}