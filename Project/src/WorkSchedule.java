import java.util.Date;

public class WorkSchedule {

	
	String client;
	Date StartDate;
	Date EndDate;
	
	
	
	
	
	
	public WorkSchedule() {
		
	}
	
	
	
	public WorkSchedule(String client, Date startDate, Date endDate) {
		this.client = client;
		StartDate = startDate;
		EndDate = endDate;
	}
	
	
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	
	
	
	
	
	
}
