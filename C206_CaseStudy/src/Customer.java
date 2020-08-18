public class Customer extends Person {
	private String username;
	private int rewardPoints;
	private String password;
	
	public Customer(String name, String username, String password) {
		super(name);
		this.username = username;
		this.password = password;
		this.rewardPoints = 0;
	}

	public int getRewardPoints() {
		return rewardPoints;
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

	public String getUsername() {
		return username;
	}
}
