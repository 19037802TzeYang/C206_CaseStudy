//--19037802tzeyang--//
public class Customer {
	private String name;
	private String username;
	private int rewardPoints;
	private String password;
	private String action;
	private Product productInfo;
	
	public Customer(String name, String username, String password, String action, Product productInfo) {
		this.name = name; 
		this.username = username;
		this.password = password;
		this.rewardPoints = 0;
		this.action = action;
		this.productInfo = productInfo;
	}

	public int getRewardPoints() {
		return rewardPoints;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Product getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(Product productInfo) {
		this.productInfo = productInfo;
	}

	public String getUsername() {
		return username;
	}
	
	public String returnString() {
		String output = String.format("%-8s %-12s %-14s %-16s %-10s %s\n", name, username,
				password, rewardPoints, action, productInfo.getName());
		return output;
	} 
}
//--19037802tzeyang--//
