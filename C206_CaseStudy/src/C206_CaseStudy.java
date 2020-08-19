import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ArrayList<Product> productList = new ArrayList<Product>();
			ArrayList<Product> beverageList = new ArrayList<Product>();
			productList.add(new Product("ID1331", "Heron Preston", 35.0, "Heron Preston Johnson", "clothing"));
			beverageList.add(new Product("ID13131313", "Wine", 100.0, "dqdqwd", "beverage"));
			
			int option = -1;
			int inputoption = -1;
			
			while (option != 5) {

				C206_CaseStudy.menu();
				option = Helper.readInt("Enter an option > ");
				
				if (option == 1) {
					// Select Clothing Category
					C206_CaseStudy.Clothingmenu();
					inputoption = Helper.readInt("Enter an option > ");
					
					if (inputoption == 1) {
						Product p = C206_CaseStudy.inputProduct("clothing");
						C206_CaseStudy.addProduct(productList, p);
						
					} else if (inputoption == 2) {
						C206_CaseStudy.viewAllCategory(productList, "clothing");
						
					} else if (inputoption == 3) {
						C206_CaseStudy.deleteALLProducts(productList, "clothing");
					}
					
					
				} else if (option == 2) {
					// Select Beverage Category
				
					C206_CaseStudy.Beveragemenu();
					inputoption = Helper.readInt("Enter an option > ");
					
					if (inputoption == 1) {
						Product b = C206_CaseStudy.inputProduct("beverage");
						C206_CaseStudy.addProduct(beverageList, b);
						
					} else if (inputoption == 2) {
						C206_CaseStudy.viewAllCategory(beverageList, "beverage");
						
					} else if (inputoption == 3) {
						
						C206_CaseStudy.deleteALLProducts(productList, "beverage");
					}

				}
			}
	}
	
			
					
	public static void menu() {
		System.out.println("Select Category");
		System.out.println("1. Clothing");
		System.out.println("2. Beverage");
		Helper.line(80, "-");

	}
	
	public static void Clothingmenu() {
		System.out.println("Product section");
		System.out.println("1. Add a new clothing");
		System.out.println("2. View all clothings");
		System.out.println("3. Delete existing clothing");
		Helper.line(80, "-");

	}
	
	public static void Beveragemenu() {
		System.out.println("Beverage section");
		System.out.println("1. Add a new beverage"); 
		System.out.println("2. View all beverage");
		System.out.println("3. Delete existing beverage");
		Helper.line(80, "-");

	}
	
	public static Product enterCat() {
		System.out.println("Select Category");
		return null;
	}
	
	//================================= Option 1 View Category=================================
	public static void viewAllCategory(ArrayList<Product> productList, String category) {
		C206_CaseStudy.setHeader("List of category");
		System.out.println(productList);
		
		// for loop, get .getCategory equals "beverage"
		String output = "";
		for (int i = 0; i < productList.size(); i++) {
			Product p = productList.get(i);
			if (p.getCategory().equals(category)) {
				output += String.format("Product ID: %10s \n Product Name: %10s \n Product Price: %-10f \n "
						+ "Vendor Name: %-10s \n Category: %10s\n \n \n", productList.get(i).getProductId(),
					productList.get(i).getName(), productList.get(i).getPrice(), productList.get(i).getVendorName(),
					productList.get(i).getCategory());
			}
		}
		System.out.println(output);
	}
	
	
	private static void setHeader(String string) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void addProduct(ArrayList<Product> productList, Product product) {
		
		productList.add(product);
		System.out.println("product added");
	}

	public static Product inputProduct(String category) {
		
		String ID = Helper.readString("Enter product ID > ");
		String name = Helper.readString("Enter product name > ");
		Double price = Helper.readDouble("Enter product price > ");
		String venName = Helper.readString("Enter vendorName> ");

		
		Product cc = new Product(ID, name, price, venName, category);
		return cc;
		
	}
	
    
	public static boolean deleteProduct(ArrayList<Product> productList, String id) {
	        boolean isDelete = false;


	        for (int i = 0; i < productList.size(); i++) {
	            if (id.equalsIgnoreCase(productList.get(i).getProductId())) {
	            	productList.remove(i);
	                isDelete = true;
	            }
	        }
	        return isDelete;


	    }


	public static void deleteALLProducts(ArrayList<Product> productList, String category) {
	        C206_CaseStudy.viewAllCategory(productList, category);
	        String id = Helper.readString("Enter ID > ");
	        Boolean isDelete = deleteProduct(productList, id);

	        
	        if (isDelete == false) {
	            System.out.println("Invalid ID");
	        } else {
	            System.out.println(id + " has been deleted");
	        }
	    }
	
	}
