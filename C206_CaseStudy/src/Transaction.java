
public class Transaction {
	private String transactionId;
	private Customer customerInfo;
	private String status;
	private String action;
	private Staff staffInfo;
	private Product productInfo;

	/**
	 * @param transactionId
	 * @param customerInfo
	 * @param status
	 * @param action
	 * @param staffInfo
	 */
	public Transaction(String transactionId, Customer customerInfo, String action, Staff staffInfo, Product productInfo) {
		super();
		this.transactionId = transactionId;
		this.customerInfo = customerInfo;
		this.action = action;
		this.status = "Pending";
		this.staffInfo = staffInfo;
		this.productInfo = productInfo;
	}

	/**
	 * @return the productInfo
	 */
	public Product getProductInfo() {
		return productInfo;
	}

	/**
	 * @param productInfo the productInfo to set
	 */
	public void setProductInfo(Product productInfo) {
		this.productInfo = productInfo;
	}

	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the customerInfo
	 */
	public Customer getCustomerInfo() {
		return customerInfo;
	}

	/**
	 * @param customerInfo the customerInfo to set
	 */
	public void setCustomerInfo(Customer customerInfo) {
		this.customerInfo = customerInfo;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the staffInfo
	 */
	public Staff getStaffInfo() {
		return staffInfo;
	}

	/**
	 * @param staffInfo the staffInfo to set
	 */
	public void setStaffInfo(Staff staffInfo) {
		this.staffInfo = staffInfo;
	}

	public String returnString() {
		String output = String.format("%-5s %-10s %-10s %-20s %-10s %-10s\n", transactionId, customerInfo.getName(),
				staffInfo.getName(), productInfo.getName(), action, status);
		return output;
	}

}
