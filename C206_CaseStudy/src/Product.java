public class Product {
	private String productId;
	private String name;
	private String category;
	private Boolean returnProduct;
	/**
	 * @param productId
	 * @param name
	 * @param price
	 * @param vendorName
	 */
	public Product(String productId, String name, double price, String vendorName, String category, Boolean returnProduct) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.vendorName = vendorName;
		this.category = category;
		this.returnProduct = returnProduct;
	}
	
	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}
	
	public Boolean getreturnProduct() {
		return returnProduct;
	}
	
	public Boolean setreturnProduct(Boolean returnProduct) {
		return returnProduct;
	}
	
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the vendorName
	 */
	public String getVendorName() {
		return vendorName;
	}
	/**
	 * @param vendorName the vendorName to set
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	/**
	 * @return the conditions
	 */
	public String getConditions() {
		return conditions;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @param conditions the conditions to set
	 */
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	private double price;
	private String vendorName;
	private String conditions;
	public void setAction(String action) {
		// TODO Auto-generated method stub
		
	}

	public void setStatus(String status) {
		// TODO Auto-generated method stub
		
	}

	public Object getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
