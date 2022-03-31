import java.util.Date;

public class Driver {

	String username;
	String password;
	WorkSchedule work;
	boolean avail;
	
	
	
	
	
	public Driver() {
		
	}
	
	
	
	public Driver(String username, String password) {
		
		this.username = username;
		this.password = password;
	}
	
	
	public boolean CheckPassword(String x) {
		if(this.password.contentEquals(x)) {
			return true;
		}
		return false;
	}
	
	public boolean isAvailable() {
		if(this.avail==true) {
			return true;
		}
		return false;
	}
	
	
	public void SetSchedule(String client, Date startDate, Date endDate) {
		work=new WorkSchedule(client,  startDate,  endDate);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public WorkSchedule getWork() {
		return work;
	}
	public void setWork(WorkSchedule work) {
		this.work = work;
	}
	public boolean isAvail() {
		return avail;
	}
	public void setAvail(boolean avail) {
		this.avail = avail;
	}
	
	
	
	
	
	
}
