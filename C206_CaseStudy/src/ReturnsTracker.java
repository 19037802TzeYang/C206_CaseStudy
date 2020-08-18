import java.util.ArrayList;
import java.util.Random;

public class ReturnsTracker {

	public static void main(String[] args) {

		// Global Store
		ArrayList<Outlet> outletList = new ArrayList<Outlet>();
		ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
		ArrayList<Transaction> archiveList = new ArrayList<Transaction>();
		ArrayList<Product> productList = new ArrayList<Product>();
		ArrayList<Customer> customerList = new ArrayList<Customer>();

		customerList.add(new Customer("test", "testuser", "pass"));
		productList.add(new Product("111", "Pan", 20, "PanMaster"));

		// North Outlet initialize
		ArrayList<Staff> staffListNorth = new ArrayList<Staff>();
		staffListNorth.add(new Staff("Bob", 341));
		staffListNorth.add(new Staff("Jane", 301));

		ArrayList<Product> productListNorth = new ArrayList<Product>();
		productListNorth.add(new Product("111", "Pan", 20, "PanMaster"));

		Outlet northOutlet = new Outlet(0, "North Avenue 9", staffListNorth);

		outletList.add(northOutlet);

		// Program
		int option = 0;

		while (option != 3) {

			if (option == 1) {
				// Customers
				ReturnsTracker.setHeader("CUSTOMER MENU");
				
				Customer user = customerLogin(customerList);

				if (user != null) {
					System.out.println("Login success!");
					addTransaction(transactionList, user, staffListNorth);
				} else {
					System.out.println("Invalid credentials.");
				}

			} else if (option == 2) {
				// Retailer
				ReturnsTracker.setHeader("RETAILER MENU");
				System.out.println("1. View outlets");
				System.out.println("2. View transactions");
				System.out.println("3. Archive transactions");
				System.out.println("4. View archive");

				int retailerOption = Helper.readInt("Enter option: ");

				if (retailerOption == 1) {
					viewOutlets(outletList, 1);

				} else if (retailerOption == 2) {
					viewTransactions(transactionList);
				} else if (retailerOption == 3){
					archiveTransaction(transactionList, archiveList);
				} else {
					viewTransactions(archiveList);
				}
			}

			menu();
			option = Helper.readInt("Enter option: ");
		}
	}

	// Customer handling
	public static Customer customerLogin(ArrayList<Customer> customerList) {
		Customer result = null;
		// Enter accountNo
		System.out.println("LOGIN");
		String username = Helper.readString("Enter username: ");
		String password = Helper.readString("Enter password: ");

		for (Customer c : customerList) {
			if (username.equals(c.getUsername()) && password.equals(c.getPassword())) {
				result = c;
				break;
			}
		}
		return result;
	}

	// Methods for Transactions
	public static void addTransaction(ArrayList<Transaction> transactionList, Customer c, ArrayList<Staff> staffList) {
		setHeader("RETURN PRODUCT");
		System.out.println("1. Refund");
		System.out.println("2. Exchange");
		System.out.println("3. Top up");

		int option = Helper.readInt("Choose option: ");
		String action = "";

		if (option == 1) {
			action = "Refund";
		} else if (option == 2) {
			action = "Exchange";
		} else {
			action = "Top up";
		}

		Random rand = new Random();
		int id = rand.nextInt(5000);

		transactionList.add(new Transaction(Integer.toString(id), c, action, staffList.get(0)));
	}

	public static void viewTransactions(ArrayList<Transaction> transactionList) {
		String output = String.format("%-5s %-10s %-10s %-10s %-10s\n", "ID", "Customer", "Staff", "Action", "Status");
		for (Transaction t : transactionList) {
			output += t.returnString();
		}
		System.out.println(output);
	}
	
	public static void archiveTransaction(ArrayList<Transaction> transactionList, ArrayList<Transaction> archiveList) {
		viewTransactions(transactionList);
		
		int option = Helper.readInt("Enter transaction to archive: ");
		
		archiveList.add(transactionList.remove(option - 1));
		
		viewTransactions(archiveList);
	}

	// Return outlets
	public static void viewOutlets(ArrayList<Outlet> outletList, int option) {
		String output = "";
		if (option == 1) {
			output = String.format("%-5s %-20s\n", "ID", "ADDRESS");
			for (int i = 0; i < outletList.size(); i++) {
				Outlet o = outletList.get(i);
				output += String.format("%-5d %-20s\n", o.getOutletId(), o.getAddress());
			}
		} else {

		}
		System.out.println(output);
	}

	// Menu
	public static void menu() {
		ReturnsTracker.setHeader("RETURNS TRACKER APP");
		System.out.println("1. Customer");
		System.out.println("2. Retailer");
		System.out.println("3. Quit");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
}
