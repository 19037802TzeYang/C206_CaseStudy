import java.util.ArrayList;
import java.util.Random;

public class ReturnsTracker {
	private static final int ADDCUS = 1;
	private static final int VIEWCUS = 2;
	private static final int DELETECUS = 3;

	public static void main(String[] args) {

		// Global Store
		ArrayList<Outlet> outletList = new ArrayList<Outlet>();
		ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
		ArrayList<Transaction> archiveList = new ArrayList<Transaction>();
		ArrayList<Product> productList = new ArrayList<Product>();
		ArrayList<Customer> customerList = new ArrayList<Customer>();

		Customer c1 = new Customer("test", "testuser", "pass");
		Customer c2 = new Customer("test2", "testuser2", "pass");
		customerList.add(c1);
		customerList.add(c2);
		productList.add(new Product("111", "Pan", 20, "PanMaster", ""));

		// Outlet initialize
		ArrayList<Staff> staffList = new ArrayList<Staff>();
		Staff s1 = new Staff("Bob", 100);
		Staff s2 = new Staff("Jane", 200);

		staffList.add(s1);
		staffList.add(s2);

		Product p1 = new Product("ID1331", "Heron Preston", 35.0, "Heron Preston Johnson", "Clothing");
		Product p2 = new Product("ID1111", "Beer", 35.0, "Hein", "Beverage");
		productList.add(p1);

		transactionList.add(new Transaction("1000", c1, "Top Up", s1, p1));
		transactionList.add(new Transaction("2000", c2, "Refund", s2, p2));

		Outlet outlet1 = new Outlet(1, "North Outlet", "North Avenue 9", staffList, transactionList);

		outletList.add(outlet1);

		// Program
		int option = 0;

		while (option != 4) {

			if (option == 1) {
				// Customers
				Customer user = customerLogin(customerList);

				if (user != null) {
					System.out.println("Login success!");

					int customerOption = 0;

					while (customerOption != 4) {
						setHeader("Customer Menu");
						System.out.println("1. Return product");
						System.out.println("2. View returns history");
						System.out.println("3. View reward points");
						System.out.println("4. Quit");
						customerOption = Helper.readInt("Enter option: ");

						if (customerOption == 1) {
							transactionMenu(transactionList, user, staffList);

						} else if (customerOption == 2) {
							ArrayList<Transaction> userList = new ArrayList<Transaction>();

							for (Transaction t : transactionList) {
								if (t.getCustomerInfo().getUsername().equals(user.getUsername())) {
									userList.add(t);
								}
							}

							viewTransactions(userList);

						} else if (customerOption == 3) {
							System.out.println("Username: " + user.getUsername());
							System.out.println("Reward Points: " + user.getRewardPoints());
						}
					}

				} else {
					System.out.println("Invalid credentials.");
				}

			} else if (option == 2) {
				// Retailer
				viewOutlet(outletList);

				Outlet retailOutlet = null;
				System.out.println("Choose Outlet");
				int outletId = Helper.readInt("Enter outlet ID > ");

				for (Outlet o : outletList) {
					if (outletId == o.getOutletId()) {
						retailOutlet = o;
						break;
					}
				}

				if (retailOutlet != null) {
					ArrayList<Transaction> outletTransactionList = retailOutlet.getTransactionList();
					ArrayList<Staff> outletStaffList = retailOutlet.getStaffList();

					int retailOption = 0;

					while (retailOption != 4) {
						ReturnsTracker.setHeader("RETAILER MENU");
						System.out.println("1. Manage transactions");
						System.out.println("2. Manage products");
						System.out.println("3. Manage staff");
						System.out.println("6. Quit");
						retailOption = Helper.readInt("Enter option: ");

						// Transactions Menu
						if (retailOption == 1) {

							int transactionOption = 0;
							while (transactionOption != 6) {
								ReturnsTracker.setHeader("TRANSACTIONS MENU");
								System.out.println("1. View transactions");
								System.out.println("2. Archive transactions");
								System.out.println("3. View archive");
								System.out.println("4. Update return history");
								System.out.println("5. Update transaction");
								System.out.println("6. Quit");
								transactionOption = Helper.readInt("Enter option: ");

								if (transactionOption == 1) {
									viewTransactions(outletTransactionList);

								} else if (transactionOption == 2) {
									archiveMenu(outletTransactionList, archiveList);

								} else if (transactionOption == 3) {
									viewTransactions(archiveList);

								} else if (transactionOption == 4) {
									// --update customer return(policy) history--//
									updateReturnHistory(outletTransactionList, archiveList);
									// --//
								} else if (transactionOption == 5) {
									viewTransactions(outletTransactionList);

									int choice = Helper.readInt("Select transaction to update: ");
									updateTransaction(outletTransactionList.get(choice - 1), outletStaffList);
								}
							}

							// Product menu
						} else if (retailOption == 2) {
														

						} else if (retailOption == 3) {
							
						}
					}

				} else {
					System.out.println("Retail outlet not found");
				}

			} else if (option == 3) {
				// Administrator
				// --Manage Customer (add customer, view customer, delete customer)--//
				int adminOption = 0;
				while (adminOption != 4) {

					setHeader("Admin Menu");
					System.out.println("1. Manage customers");
					System.out.println("2. Manage outlets");
					System.out.println("3. Misc.");
					adminOption = Helper.readInt("Enter option > ");

					if (adminOption == 1) {
						manageCustomers(customerList);
					} else if (adminOption == 2) {
						manageOutlets(outletList);
					}

				}
				// --//
			}

			menu();
			option = Helper.readInt("Enter option: ");
		}

	}

	/**
	 * @param outletList
	 * @param option
	 */
	private static void manageOutlets(ArrayList<Outlet> outletList) {
		int option = -1;
		while (option != 4) {
			manageOutletMenu();
			option = Helper.readInt("Enter option > ");

			if (option == 1) {
				Outlet outlet = inputOutlet();
				addOutlet(outletList, outlet);
			} else if (option == 2) {
				viewOutlet(outletList);
			} else if (option == 3) {
				deleteOutlet(outletList);
			}
		}
	}

	/**
	 * @param customerList
	 */
	private static void manageCustomers(ArrayList<Customer> customerList) {
		int option = -1;

		while (option != 4) {
			manageCusMenu();
			option = Helper.readInt("Enter option > ");

			if (option == ADDCUS) {
				Customer cObj = inputCustomer();
				addCustomer(customerList, cObj);
			} else if (option == VIEWCUS) {
				viewCustomer(customerList);
			} else if (option == DELETECUS) {
				deleteCustomer(customerList);
			} else if (option == 4) {
				System.out.println("GoodBye");
			}
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
		Product p2 = new Product("ID1111", "Beer", 35.0, "Hein", "Beverage");

		Transaction t = new Transaction(Integer.toString(id), c, action, staffList.get(staffIndex), p2);

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
			output += String.format("%-5s %-60s", i + 1, t.returnString());
		}
		return output;
	}

	public static void viewTransactions(ArrayList<Transaction> transactionList) {
		ReturnsTracker.setHeader("Transaction List");
		String output = String.format("%-5s %-5s %-10s %-10s %-20s %-10s %-10s\n", "No.", "ID", "Customer", "Staff",
				"Product", "Action", "Status");
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

	public static void updateTransaction(Transaction t, ArrayList<Staff> staffList) {
		setHeader("UPDATE TRANSACTION");

		ArrayList<Transaction> viewList = new ArrayList<Transaction>();
		viewList.add(t);

		viewTransactions(viewList);

		int option = -1;

		while (option != 4) {
			System.out.println("1. Change return type");
			System.out.println("2. Change staff");
			System.out.println("3. Change status");
			System.out.println("4. EXIT");
			option = Helper.readInt("Enter option: ");

			if (option == 1) {
				String action = Helper.readString("Enter new return type (Refund/Exchange/Top Up): ");
				t.setAction(action);
			} else if (option == 2) {
				viewStaff(staffList);
				int choice = Helper.readInt("Enter new staff No. : ");
				t.setStaffInfo(staffList.get(choice - 1));

			} else if (option == 3) {
				String status = Helper.readString("Enter new status: ");
				t.setStatus(status);
			}
			viewTransactions(viewList);
		}
	}

	// Staff
	public static String retrieveStaff(ArrayList<Staff> staffList) {
		String output = "";
		for (int i = 0; i < staffList.size(); i++) {
			Staff s = staffList.get(i);
			output += String.format("%-5s %-15s", i + 1, s.returnString());
		}
		return output;
	}

	public static void viewStaff(ArrayList<Staff> staffList) {
		ReturnsTracker.setHeader("Staff List");
		String output = String.format("%-5s %-5s %-10s\n", "No.", "ID", "Name");
		output += retrieveStaff(staffList);
		System.out.println(output);
	}

	// public static void

	// --update customer return(policy) history--//
	public static void updateReturnHistory(ArrayList<Transaction> transactionList, ArrayList<Transaction> archiveList) {

		int no = 0;
		do {
			setHeader("UPDATE RETURN HISTORY");
			viewTransactions(archiveList);
			// take input from available transactions if input is -1 loop will stop
			no = Helper.readInt("Enter No to update or -1 to cancel > ");
			// if no is -1 exit from loop
			if (no == -1) {
				break;
			} else if (no < 1 || no > archiveList.size()) {
				System.out.println("Invalid!");
			} else {
				// if transaction no is valid take updated values
				int updationOption = 0;
				// check if transaction is updated in order to move transaction from archive
				boolean updated = false;

				while (updationOption != 3) {
					System.out.println("\nUPDATE MENU");
					System.out.println("Enter 1 to update Policy ");
					System.out.println("Enter 2 to update Product Name ");
					System.out.println("Enter 3 to Quit \n");
					updationOption = Helper.readInt("Choose Option > ");

					if (updationOption == 1) {
						updatePolicy(archiveList, no - 1);
						updated = true;
					} else if (updationOption == 2) {
						updateProductName(archiveList, no - 1);
						updated = true;
					} else if(updationOption == 3) {
						if(updated == true) {
							archiveList.get(no - 1).setStatus("Pending");
							moveToTransactionList(transactionList, archiveList, no - 1);
						}
					}
				}
			}
		} while (no != -1);
	}

	private static void updateProductName(ArrayList<Transaction> archiveList, int index) {
		String productName = Helper.readString("Enter Product name to update > ");
		archiveList.get(index).getProductInfo().setName(productName);
		System.out.println("Transaction updated!\n");

	}

	private static void updatePolicy(ArrayList<Transaction> archiveList, int index) {
		String action = Helper.readString("Enter policy to update > ");
		// set the policy in particular archive list
		archiveList.get(index).setAction(action);
		System.out.println("Transaction updated!\n");

	}

	private static void moveToTransactionList(ArrayList<Transaction> transactionList, ArrayList<Transaction> archiveList, int index) {
		transactionList.add(archiveList.remove(index));
		System.out.println("Transaction Moved from Archive!\n");
	}
	//--//

	//--manage customer (add customer, view customer, delete customer)--//
	// return customer object
	public static Customer inputCustomer() {
		Helper.line(40, "-");
		System.out.println("ADD NEW CUSTOMER");
		String name = Helper.readString("Enter Name > ");
		String userName = Helper.readString("Enter User Name > ");
		String password = Helper.readString("Enter Password No > ");

		Customer cObj = new Customer(name, userName, password);
		return cObj;
	}

	public static void addCustomer(ArrayList<Customer> customerList, Customer cObj) {
		customerList.add(cObj);
		System.out.println("Customer Added!");
	}

	// return customer string
	public static String retriveAllCustomer(ArrayList<Customer> customerList) {
		String output = "";
		for (Customer c : customerList) {
			output += String.format("%-10s %-10s %-16s %s\n", c.getName(), c.getUsername(), c.getPassword(),
					c.getRewardPoints());
		}
		return output;
	}

	public static void viewCustomer(ArrayList<Customer> customerList) {
		Helper.line(50, "-");
		String output = String.format("%-10s %-10s %-16s %s\n", "NAME", "USERNAME", "PASSWORD", "REWARD POINTS");
		output += retriveAllCustomer(customerList);
		System.out.println(output);
	}

	// return boolean value if customerList is removed
	public static boolean removeCustomer(ArrayList<Customer> customerList, String username) {
		boolean isRemoved = false;
		for (int i = 0; i < customerList.size(); i++) {
			if (username.contentEquals(customerList.get(i).getUsername())) {
				customerList.remove(i);
				isRemoved = true;
			}
		}
		return isRemoved;
	}

	public static void deleteCustomer(ArrayList<Customer> customerList) {
		viewCustomer(customerList);
		String username = Helper.readString("Enter username to remove customer > ");
		Boolean isRemoved = removeCustomer(customerList, username);
		if (isRemoved) {
			System.out.println("Customer Removed!");
		} else {
			System.out.println("Username not found!");
		}
	}
	// --//

	public static Outlet inputOutlet() {
		Helper.line(40, "-");
		System.out.println("ADD NEW OUTLET");
		int id = Helper.readInt("Enter outlet ID > ");
		String name = Helper.readString("Enter name > ");
		String address = Helper.readString("Enter address > ");

		Outlet outlet = new Outlet(id, name, address, new ArrayList<Staff>(), new ArrayList<Transaction>());
		return outlet;
	}

	public static void addOutlet(ArrayList<Outlet> outletList, Outlet outlet) {
		outletList.add(outlet);
		System.out.println("Outlet Added!");
	}

	// return customer string
	public static String retriveAllOutlet(ArrayList<Outlet> outletList) {
		String output = "";
		for (Outlet o : outletList) {
			output += String.format("%-5s %-15s %-20s %-5s\n", o.getOutletId(), o.getOutletName(), o.getAddress(),
					o.getStaffList().size());
		}
		return output;
	}

	public static void viewOutlet(ArrayList<Outlet> outletList) {
		Helper.line(50, "-");
		String output = String.format("%-5s %-15s %-20s %-5s\n", "ID", "Outlet Name", "Address", "Staff Count");
		output += retriveAllOutlet(outletList);
		System.out.println(output);
	}

	// return boolean value if customerList is removed
	public static boolean removeOutlet(ArrayList<Outlet> outletList, int id) {
		boolean isRemoved = false;
		for (int i = 0; i < outletList.size(); i++) {
			if (id == outletList.get(i).getOutletId()) {
				outletList.remove(i);
				isRemoved = true;
			}
		}
		return isRemoved;
	}

	public static void deleteOutlet(ArrayList<Outlet> outletList) {
		viewOutlet(outletList);
		int id = Helper.readInt("Enter Outlet ID to remove > ");
		Boolean isRemoved = removeOutlet(outletList, id);
		if (isRemoved) {
			System.out.println("Outlet Removed!");
		} else {
			System.out.println("Outlet not found!");
		}
	}

	public static void getMostProducts(ArrayList<Transaction> transactionList) {

		for (Transaction t : transactionList) {

		}
	}

	// Menu
	public static void menu() {
		ReturnsTracker.setHeader("Diso Tracking System");
		System.out.println("1. Customer");
		System.out.println("2. Retailer");
		System.out.println("3. Administrator");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}

	// --manage customer menu--//
	public static void manageCusMenu() {
		ReturnsTracker.setHeader("Manage Customer Menu");
		System.out.println("1. Add Customer");
		System.out.println("2. View Customer");
		System.out.println("3. Delete Customer");
		System.out.println("4. Quit");
	}
	// --//

	public static void manageOutletMenu() {
		ReturnsTracker.setHeader("Manage Outlet Menu");
		System.out.println("1. Add Outlet");
		System.out.println("2. View Outlet");
		System.out.println("3. Delete Outlet");
		System.out.println("4. Quit");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
}
