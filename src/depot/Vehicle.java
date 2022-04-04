package depot;
import static com.mongodb.client.model.Filters.eq;

import java.time.LocalDate;
import java.util.Date;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Vehicle {
	
	String Make;
	String Model;
	int Weight;
	String regNo;

	public Vehicle(String make, String model, int weight, String regNo) {
		super();
		Make = make;
		Model = model;
		Weight = weight;
		this.regNo = regNo;
	}
	
	public Vehicle(String regNo) {
		super();
		this.regNo = regNo;
	}

	public boolean isAvailable() {
		MongoClient client =  MongoClients.create("mongodb+srv://some-user:NOTsecurePWD@cluster0.zkqlf.mongodb.net/eDepot?retryWrites=true&w=majority");
		MongoDatabase db = client.getDatabase("eDepot");
		MongoCollection<Document> vehicles = db.getCollection("Vehicles");
		String endDateStr = (String) vehicles.find(eq("regNo", this.regNo)).first().get("endDate");
		
		LocalDate endDate = LocalDate.parse(endDateStr);
		
		if(LocalDate.now().isAfter(endDate)) {
			return true;
		} 
		
		return false;
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

		
}
