import java.util.ArrayList;

public class Outlet {

	private int outletId;
	private String outletName;
	private String address;
	private ArrayList<Staff> staffList;
	private ArrayList<Transaction> transactionList;
	private ArrayList<Transaction> archiveList;
	

	public Outlet(int outletId, String outletName, String address, ArrayList<Staff> staffList, ArrayList<Transaction> transactionList, ArrayList<Transaction> archiveList) {
		this.outletId = outletId;
		this.outletName = outletName;
		this.address = address;
		this.staffList = staffList;
		this.transactionList = transactionList;
		this.archiveList = archiveList;
	}
	
	public Outlet(int outletId, String outletName, String address, ArrayList<Staff> staffList, ArrayList<Transaction> transactionList) {
		this.outletId = outletId;
		this.outletName = outletName;
		this.address = address;
		this.staffList = staffList;
		this.transactionList = transactionList;
		this.archiveList = new ArrayList<Transaction>();
	}
	
	/**
	 * @return the archiveList
	 */
	public ArrayList<Transaction> getArchiveList() {
		return archiveList;
	}

	/**
	 * @param archiveList the archiveList to set
	 */
	public void setArchiveList(ArrayList<Transaction> archiveList) {
		this.archiveList = archiveList;
	}

	/**
	 * @return the transactionList
	 */
	public ArrayList<Transaction> getTransactionList() {
		return transactionList;
	}

	/**
	 * @param transactionList the transactionList to set
	 */
	public void setTransactionList(ArrayList<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

	/**
	 * @return the outletName
	 */
	public String getOutletName() {
		return outletName;
	}

	/**
	 * @param outletName the outletName to set
	 */
	public void setOutletName(String outletName) {
		this.outletName = outletName;
	}

	public int getOutletId() {
		return outletId;
	}

	public void setOutletId(int outletId) {
		this.outletId = outletId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Staff> getStaffList() {
		return staffList;
	}
	
	public void setStaffList(ArrayList<Staff> staffList) {
		this.staffList = staffList;
	}
	
	public void addStaff(Staff newStaff) {
		staffList.add(newStaff);
	}
	
	public void deleteStaff(int id) {
		
		for (Staff staff : staffList) {
			if (id == staff.getStaffId()) {
				staffList.remove(id);
				break;
			}
		}
	}
	
}
