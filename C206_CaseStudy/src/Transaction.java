
public class Transaction {
	private String transactionId;
	private Customer customerInfo;
	private String status;
	private String action;
	private Staff staffInfo;

	/**
	 * @param transactionId
	 * @param customerInfo
	 * @param status
	 * @param action
	 * @param staffInfo
	 */
	public Transaction(String transactionId, Customer customerInfo, String action, Staff staffInfo) {
		super();
		this.transactionId = transactionId;
		this.customerInfo = customerInfo;
		this.action = action;
		this.status = "";
		this.staffInfo = staffInfo;
	}

	public String returnString() {
		String output = String.format("%-5s %-10s %-10s %-10s %-10s\n", transactionId, customerInfo.getName(),
				staffInfo.getName(), status, action);
		return output;
	}

}
