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
		productList.add(new Product("111", "Pan", 20, "PanMaster", ""));

		// North Outlet initialize
		ArrayList<Staff> staffListNorth = new ArrayList<Staff>();
		staffListNorth.add(new Staff("Bob", 341));
		staffListNorth.add(new Staff("Jane", 301));

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
					transactionMenu(transactionList, user, staffListNorth);
				} else {
					System.out.println("Invalid credentials.");
				}

			} else if (option == 2) {
				// Retailer

				int retailerOption = 0;

				while (retailerOption != 4) {
					if (retailerOption == 1) {
						viewTransactions(transactionList);
						
					} else if (retailerOption == 2) {
						archiveMenu(transactionList, archiveList);
						
					} else if (retailerOption == 3) {
						viewTransactions(archiveList);
						
					}

					ReturnsTracker.setHeader("RETAILER MENU");
					System.out.println("1. View transactions");
					System.out.println("2. Archive transactions");
					System.out.println("3. View archive");
					System.out.println("4. Quit");
					retailerOption = Helper.readInt("Enter option: ");
				}
			}

			menu();
			option = Helper.readInt("Enter option: ");
		}
	}

	// Customer login
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
	public static void transactionMenu(ArrayList<Transaction> transactionList, Customer c, ArrayList<Staff> staffList) {
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
		int staffIndex = rand.nextInt(staffList.size());

		Transaction t = new Transaction(Integer.toString(id), c, action, staffList.get(staffIndex));

		addTransaction(transactionList, t);
	}

	public static void addTransaction(ArrayList<Transaction> transactionList, Transaction t) {

		transactionList.add(t);
		System.out.println("Transaction added!");
	}

	public static String retrieveTransactions(ArrayList<Transaction> transactionList) {
		String output = "";
		for (int i = 0; i < transactionList.size(); i++) {
			Transaction t = transactionList.get(i);
			output += String.format("%-5s %-50s", i + 1, t.returnString());
		}
		return output;
	}

	public static void viewTransactions(ArrayList<Transaction> transactionList) {
		ReturnsTracker.setHeader("Transaction List");
		String output = String.format("%-5s %-5s %-10s %-10s %-10s %-10s\n", "No.", "ID", "Customer", "Staff", "Action",
				"Status");
		output += retrieveTransactions(transactionList);
		System.out.println(output);
	}

	public static void archiveMenu(ArrayList<Transaction> transactionList, ArrayList<Transaction> archiveList) {
		viewTransactions(transactionList);

		int option = -1;

		while (option < 1 || option > transactionList.size()) {
			option = Helper.readInt("Enter transaction to archive: ");
		}
		archiveTransaction(transactionList, archiveList, option - 1);

		viewTransactions(archiveList);
	}

	public static void archiveTransaction(ArrayList<Transaction> transactionList, ArrayList<Transaction> archiveList,
			int index) {
		transactionList.get(index).setStatus("Fulfilled");
		archiveList.add(transactionList.remove(index));

		System.out.println("Transaction archived!");
	}

	// Menu
	public static void menu() {
		ReturnsTracker.setHeader("Diso Tracking System");
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
