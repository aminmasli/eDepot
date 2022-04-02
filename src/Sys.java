import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import depot.*; 

public class Sys {
	
	private final Scanner myScanner = new Scanner(System.in);
	private MongoDatabase db;
	private String currentUser;


	// NOTE : Constructor
	public Sys() {
		connectDB();
	}

	
	// NOTE : Main function to authenticate and redirect users
	public void entryMenu() {
		System.out.println("WELCOME TO THE E-DEPOT SYSTEM");
		String username;
		String password;

		do {
			System.out.println("\nPlease login");
			System.out.print("- Username: ");
			username = myScanner.nextLine().toLowerCase();
			
			// NOTE : Exit if user presses q
			if (username.equals("q")) {
				break;
			}
			
			System.out.print("- Password (create one if it's your 1st time): ");
			password = myScanner.nextLine();
			
			login(username, password);
			if (currentUser == null) {
				System.out.println("*Failed to login! Try again or press \"q\" to exit");
				continue;
			}
			
			switch(currentUser) {
				case "admin":
					admin();
					break;
				case "manager":
					manager();
					break;
				case "driver":
					driver();
					break;
			}
			
		} while (!username.equals("q"));
		
		System.out.println("Bye Bye !");
    }
	
	
	public void connectDB() {
		try {
			MongoClient client =  MongoClients.create("mongodb+srv://some-user:NOTsecurePWD@cluster0.zkqlf.mongodb.net/eDepot?retryWrites=true&w=majority");
			db = client.getDatabase("eDepot");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
	
	
	public void admin() {
		
		if(!currentUser.equals("admin")) {
			return;
		}
		
		System.out.println("\nWelcome to the admin dashboard");
		
		String choice;
		do {
			System.out.println();
			System.out.println("CHOOSE AN OPTION:");
			System.out.println("- 1: Register manager");
			System.out.println("- 2: Register driver");
			System.out.println("- 3: Logout");

			System.out.print("Enter an option: ");
			choice = myScanner.nextLine().toLowerCase();
					
			switch(choice) {
				case "1":
					registerManager();
					break;
				case "2":
					registerDriver();
					break;
				case "3":
					logout();
					break;
			}
			
		} while(!choice.equals("3")); // NOTE : Exit the loop on logout
		return;
	}
	
	
	public void registerManager() {
		System.out.print("\nRegister username for manager: ");
		String username = myScanner.nextLine().toLowerCase();
		
		try {
			MongoCollection managers = db.getCollection("Managers");
			Document managerDoc = new Document("username", username);
			managers.insertOne(managerDoc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
	
	
	public void registerDriver() {
		System.out.print("\nRegister username for driver: ");
		String username = myScanner.nextLine().toLowerCase();
		
		try {
			MongoCollection drivers = db.getCollection("Drivers");
			Document driverDoc = new Document("username", username);
			drivers.insertOne(driverDoc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
	
	
	
	
	
	
	
	
	
	public void manager() {
		
		// ToDo : If user not manager exit function
		
		System.out.println("Hello {name}, to your manager's dashboard");
		
		String choice;
		do {
			System.out.println();
			System.out.println("CHOOSE AN OPTION:");
			System.out.println("- 1: Setup work schedule");
			System.out.println("- 2: Move vehicle");
			System.out.println("- 3: Logout");

			System.out.print("Enter an option: ");
			
			choice = myScanner.nextLine().toLowerCase();
					
			switch(choice) {
				case "1":
					// ToDo : Send to setup work schedule function
					break;
				case "2":
					// ToDo : Send to move vehicle function
					break;
				case "3":
					logout();
					break;
			}
			
		} while(!choice.equals("3")); // NOTE : Exit the loop on logout
		return;
	}
	
	
	public void driver() {
		
		// ToDo : If user not driver exit function

		System.out.println("Hello {name}, to your driver's dashboard");
		
		String choice;
		do {
			System.out.println();
			System.out.println("CHOOSE AN OPTION:");
			System.out.println("- 1: View work schedule");
			System.out.println("- 2: Logout");

			System.out.print("Enter an option: ");
			
			choice = myScanner.nextLine().toLowerCase();
					
			switch(choice) {
				case "1":
					// ToDo : Send to view work schedule function
					break;
				case "2":
					logout();
					break;
			}
			
		} while(!choice.equals("2")); // NOTE : Exit the loop on logout
		return;
	}
	
	
	
	
	
	
	
	// NOTE : Common functions
	
	
	public void login(String username, String password) {
		
		if(username.equals("admin") && password.equals("admin")) {
			currentUser = "admin";
			return;
		}
		
		try {
			// ToDo : Compare user name and password to value in database
			// ToDo : if match, return current user
		} catch (Exception e) {
			e.printStackTrace();		
		}
		
		currentUser = null;
		return;
	}
	
	
	public void logout() {
		currentUser = null;
		return;
	}
	
}
