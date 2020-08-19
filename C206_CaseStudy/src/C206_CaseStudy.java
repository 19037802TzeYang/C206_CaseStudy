import java.util.ArrayList;

public class C206_CaseStudy {
	
	private static ArrayList<Outlet> outletList = new ArrayList<Outlet>();
	
	private static ArrayList<Staff> staffList;

	public static void outlets(String outlets) {
	
		//add some data to the list
		Outlet Outlet1 = new Outlet(01 , "Ang Mo Kio Hub", staffList );
		Outlet Outlet2 = new Outlet(02, "Junction 8", staffList);
		Outlet Outlet3 = new Outlet(03, "Toa Payoh Hub", staffList);
	}
	
	public static void delOutlet(String Outlet) {
		//clean up the data in the list
		for (int i = 0; i < outletList.size(); i++) {
			outletList.clear();
		}
	}
	
	
	public static void menuChoice() {
		//show outlet menu, ask user for input, process the choice
		int subOption = 0;
//
		// Enter input 
		subOption = Helper.readInt("Enter Choice : ");
		
		System.out.println("Choice : " + subOption);
	}
	
	public static void showOutletMenu() {
		//Display the menu
		System.out.println("===================");
		System.out.println("Outlet Menu");
		System.out.println("===================");
		System.out.println("Option 1 - View All Outlets");
		System.out.println("Option 2 - Add Outlets");
		System.out.println("Option 3 - Delete Outlets");
	}	
	
	public static void processOption(int subOption) {
			
		while (subOption != 4) {
			if (subOption == 1) {
				// View all outlets
			
				viewOutlet();
		
			} else if (subOption  == 2) {
				// Add an outlet
				addOutlet(null);
		
			} else if (subOption  == 3) {
				// Delete an outlet
			//	delOutlet();
							
			}else {
				//invalid option
				System.out.println("Invalid type");
			}
			
			//show the menu again & ask for option
			showOutletMenu();
			menuChoice();
			
		}
	
	}
	

	//==========Option 1 ==============
	public static void viewOutlet() {
		//display all bikes in the list
		for (int i = 1; i < outletList.size(); i++) {
			System.out.println(String.format("%-5d, %-5s", i+1, outletList.get(i).getOutletId()));
		}
	}
	
	
	//==========Option 2 ==============
	public static void inputOutletDetails() {
		//request user for the outlet to be added to the list
		int outletToAdd; 
		String toAddDesc;
		// Enter input 
		outletToAdd= Helper.readInt("Enter outlet: "); 
		toAddDesc = Helper.readString("Enter outlet address: "); 

		Outlet new1 = new Outlet(outletToAdd, toAddDesc, staffList);
		addOutlet(new1);
	}
	
	public static void addOutlet(Outlet outlet) {
		//add bike to list
		outletList.add(outlet);
	}
	
		
	//==========Option 3 ==============
	public static int selectOutlet() {
		int toDel;
		// Enter input 
		toDel = Helper.readInt("Enter Outlet No. : "); 
		int finalDel = toDel - 1;
		
		delOutlet(finalDel);

		return finalDel;
		//request the user to select outlet for process
	}
	
	public static void delOutlet(int OutletId) {
		//remove outlet from list
		for (int i = 0; i < outletList.size(); i++) {
			outletList.remove(OutletId); //removes the outlet with the id outlet
		}
	}
	
	
	//==============Helper Functions=======
	public static int getOutletSize() {
		return outletList.size();
	}
	
	public static String getOutletDesc(int OutletId) {
		return null;
		//format and return the string
	}
}
