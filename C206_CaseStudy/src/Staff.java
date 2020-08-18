public class Staff extends Person {

	private int staffId;

	/**
	 * @param name
	 * @param personId
	 */
	public Staff(String name, int staffId) {
		super(name);
		this.staffId = staffId;
	}

	/**
	 * @return the staffId
	 */
	public int getStaffId() {
		return staffId;
	}

}
