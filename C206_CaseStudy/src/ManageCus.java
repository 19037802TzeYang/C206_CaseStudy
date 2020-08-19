import java.util.ArrayList;
public class ManageCus {
	private static final int ADDCUS = 1;
	private static final int VIEWCUS = 2;
	private static final int DELETECUS = 3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				ArrayList<Customer> customerList = new ArrayList<Customer>();
				int option = -1;
				while (option != 5) {
					menu();
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
			
			public static void menu() {
				Helper.line(50, "-");
				System.out.println("MENU");
				Helper.line(50, "-");
				System.out.println("1. Add Customer");
				System.out.println("2. View Customer");
				System.out.println("3. Delete Customer");
				System.out.println("5. Quit");
				Helper.line(50, "-");
			}
			
			//--return customer object--//
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
			//--//
				
			//--return customer string --//
			public static String retriveAllCustomer(ArrayList<Customer> customerList) {
				String output = "";
				for (Customer c : customerList) { 	
					output += String.format("%-10s %-10s %-16s %s\n",
							c.getName(),
							c.getUsername(),
							c.getPassword(),
							c.getRewardPoints()
							);
				}
				return output;
			}
			
			public static void viewCustomer(ArrayList<Customer> customerList) {
				Helper.line(50, "-");
				String output = String.format("%-10s %-10s %-16s %s\n",
						"NAME", "USERNAME", "PASSWORD", "REWARD POINTS");
				output += retriveAllCustomer(customerList);
				System.out.println(output);
			}
			//--//
			
			//--return boolean value if customerList is removed--//
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
				ManageCus.viewCustomer(customerList);
				String username = Helper.readString("Enter username to remove customer > ");
				Boolean isRemoved = removeCustomer(customerList, username);
				if (isRemoved) {
					System.out.println("Customer Removed!");
				} else {
					System.out.println("Username not found!");
				}
			}
			//--// 
	}