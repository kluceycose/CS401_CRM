package Opportunities;
import java.util.ArrayList;
import java.util.List;

public class opportunityList {
    private static List<opportunity> opportunities;

    public opportunityList()
    {
    	opportunities =new ArrayList<>();
    }

  //Setter
    public void addOpportunity(opportunity opportunity) {
        opportunities.add(opportunity);
    }

    //Getters
    public opportunity getOpportunity(int opportunityNum){
        return opportunities.get(opportunityNum);
    }
    public static List<opportunity> getList(){
        return opportunities;
    }
   
}
