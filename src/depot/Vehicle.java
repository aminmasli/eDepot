package depot;
import java.util.Date;

public class Vehicle {
	
	String Make;
	String Model;
	int Weight;
	String regNo;
	boolean availablity;
	WorkSchedule schedule;
	
	public Vehicle() {
	
	}

	public Vehicle(String make, String model, int weight, String regNo) {
		super();
		Make = make;
		Model = model;
		Weight = weight;
		this.regNo = regNo;
	}

	public boolean isAvailable() {
		return this.availablity;
	}
		
	public void setSchedule(String client, Date startDate, Date endDate) {
		this.schedule = new WorkSchedule(client,startDate,endDate);
	}

	public String getMake() {
		return Make;
	}

	public void setMake(String make) {
		Make = make;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public int getWeight() {
		return Weight;
	}

	public void setWeight(int weight) {
		Weight = weight;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public boolean isAvailablity() {
		return availablity;
	}

	public void setAvailablity(boolean availablity) {
		this.availablity = availablity;
	}
		
}