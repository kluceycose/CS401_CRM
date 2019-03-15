import java.util.Date;

public class opportunity {

	  private String accountName;
	    private int amount;
	    private Date closeDate;
	    private String contract;
	    private String createdBy;
	    private String CustomLinks;
	    private String Description;
	    private int ExpectedRevenue;
	    private String OpporutnityName;
	    private String OpporutnityOwner;
	    private String primaryCampaignSource;
	    private String Stage;
	    private String type;
	    
	    
	  public opportunity
	  ( String accountName,
	  int amount,
	    Date closeDate,
	    String contract,
	    String createdBy,
	    String CustomLinks,
	    String Description,
	    int ExpectedRevenue,
	    String OpporutnityName,
	     String OpporutnityOwner,
	    String primaryCampaignSource,
	    String Stage,
	    String type){
		  accountName = accountName;	       
		  amount= amount;
				    closeDate=closeDate;
				     contract=contract;
				     createdBy=createdBy;
				     CustomLinks=CustomLinks;
				     Description=Description;
				    ExpectedRevenue=ExpectedRevenue;
				     OpporutnityName=OpporutnityName;
				      OpporutnityOwner=OpporutnityOwner;
				     primaryCampaignSource=primaryCampaignSource;
				     Stage=Stage;
				     type=type;

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


	public Date getCloseDate() {
		return closeDate;
	}


	public void setCloseDate(Date closeDate) {
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


	public String getCustomLinks() {
		return CustomLinks;
	}


	public void setCustomLinks(String customLinks) {
		CustomLinks = customLinks;
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
