package Opportunities;
import java.util.Calendar;
import java.util.Date;

public class opportunity {

	  private String accountName;
	    private int opportunityid;

	    private int amount;
	    private Calendar  closeDate;
	    private String contract;
	    private String createdBy;
	    private String Description;
	    private int ExpectedRevenue;
	    private String OpporutnityName;
	    private String OpporutnityOwner;
	    private String primaryCampaignSource;
	    private String Stage;
	    private String type;
	  // constructor   
	   public opportunity()
	   {
		   amount=-1;
	   }
	   
	   
	  public opportunity
	  ( String accountName,
			  int opportunityid,
	    int amount,
	    Date closeDate,
	    String contract,
	    String createdBy,
	    String Description,
	    int ExpectedRevenue,
	    String OpporutnityName,
	     String OpporutnityOwner,
	    String primaryCampaignSource,
	    String Stage,
	    String type){
		  accountName = accountName;
		 opportunityid =opportunityid;
		  amount= amount;
				    closeDate=closeDate;
				     contract=contract;
				     createdBy=createdBy;
				     Description=Description;
				    ExpectedRevenue=ExpectedRevenue;
				     OpporutnityName=OpporutnityName;
				      OpporutnityOwner=OpporutnityOwner;
				     primaryCampaignSource=primaryCampaignSource;
				     Stage=Stage;
				     type=type;

	    }


	public int getOpportunityid() {
		return opportunityid;
	}


	public void setOpportunityid(int opportunityid) {
		this.opportunityid = opportunityid;
	}


	public String getAccountName() {
		return accountName;
	}


	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public Calendar  getCloseDate() {
		return closeDate;
	}


	public void setCloseDate(Calendar  closeDate) {
		this.closeDate = closeDate;
	}


	public String getContract() {
		return contract;
	}


	public void setContract(String contract) {
		this.contract = contract;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}






	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public int getExpectedRevenue() {
		return ExpectedRevenue;
	}


	public void setExpectedRevenue(int expectedRevenue) {
		ExpectedRevenue = expectedRevenue;
	}


	public String getOpporutnityName() {
		return OpporutnityName;
	}


	public void setOpporutnityName(String opporutnityName) {
		OpporutnityName = opporutnityName;
	}


	public String getOpporutnityOwner() {
		return OpporutnityOwner;
	}


	public void setOpporutnityOwner(String opporutnityOwner) {
		OpporutnityOwner = opporutnityOwner;
	}


	public String getPrimaryCampaignSource() {
		return primaryCampaignSource;
	}


	public void setPrimaryCampaignSource(String primaryCampaignSource) {
		this.primaryCampaignSource = primaryCampaignSource;
	}


	public String getStage() {
		return Stage;
	}


	public void setStage(String stage) {
		Stage = stage;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	 

	    
	    
	    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
