import java.util.ArrayList;

public class Outlet {

	private int outletId;
	private String address;
	private ArrayList<Staff> staffList;
	

	public Outlet(int outletId, String address, ArrayList<Staff> staffList) {
		super();
		this.outletId = outletId;
		this.address = address;
		this.staffList = staffList;
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
