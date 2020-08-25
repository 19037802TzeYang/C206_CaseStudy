import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//--19037802tzeyang--//
public class ManageCustomerTest {
	private Product p1;
	private Product p2;
	private Customer cObj1;
	private Customer cObj2;
	private Customer cObjtest;
	private ArrayList<Customer> customerList;

	@Before
	public void setUp() throws Exception {
		p1 = new Product("01", "Water", 2.50, "vendor", "", false);
		p2 = new Product("02", "Book", 2.50, "vendor", "", false);
		cObj1 = new Customer("n1", "u1", "pass1", "return", p1);
		cObj2 = new Customer("n2", "u2", "pass2", "refund", p2);
		cObjtest = new Customer("n1", "u1", "pass1", "exchange", p2);
		customerList = new ArrayList<Customer>();
	}

	@After
	public void tearDown() throws Exception {
		cObj1 = null;
		cObj2 = null;
		customerList = null;
	}

	//--Manage Customer test (add customer, view customer, delete customer)--//
	@Test
	public void c206_testAddCus() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
		// test if customerList is not null - boundary
		assertNotNull("Check if there is vlaid Customer in arrayList to add to", customerList);
		// given an empty list, after adding 1 customer, the list's size is 1 - normal
		ReturnsTracker.addCustomer(customerList, cObj1);
		assertEquals("Check arrayList size is 1", 1, customerList.size());
		// add another customer to test if the list's size is 2 - normal
		ReturnsTracker.addCustomer(customerList, cObj2);
		assertEquals("Check arrayList size is 2", 2, customerList.size());
	}

	@Test
	public void c206_testViewCus() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
		// test if customerList is not null - boundary
		assertNotNull("Check if there is valid Customer in arrayList to view", customerList);
		// test if the list of customer retrieved is empty - boundary
		String allCustomer = ReturnsTracker.retriveAllCustomer(customerList);
		String empStr = "";
		assertEquals("check if customerList is empty", empStr, allCustomer);
		// given an empty list, after adding 2 customer, test if the size of the list is
		// 2 - normal
		ReturnsTracker.addCustomer(customerList, cObj1);
		ReturnsTracker.addCustomer(customerList, cObj2);
		assertEquals("Check arrayList size is 2", 2, customerList.size());
	}

	@Test
	public void c206_testDeleteCus() {
		// fail("Not yet implemented");
		// test if customerList is not null - boundary
		assertNotNull("Check if there is valid Customer in arrayList to delete", customerList);
		assertTrue("C206_CaseStudy_SampleTest ", true);
		// test if the given customer is successfully removed from the given username -
		// normal
		ReturnsTracker.addCustomer(customerList, cObj1);
		Boolean success = ReturnsTracker.removeCustomer(customerList, "u1");
		assertTrue("check if customer is removed from a given username", success);
	}
	//--//
	
	//--update customer return history test--//
	@Test
	public void updateReturnHistoryTest() {
		// Test if transaction list is not null, so that the transaction can be added
		assertNotNull("Test if there is valid customer arraylist to add to", customerList);
		// given an empty list, after adding 1 customer, the list's size is 1 - normal
		ReturnsTracker.addCustomer(customerList, cObj1);
		assertEquals("Check arrayList size is 1", 1, customerList.size());
		
		// Test if the expected updated output string is the same as the expected test output
		String testOutput = String.format("%-7s %-60s", "1", cObjtest.returnString());
		ReturnsTracker.updateReturnHistory(customerList);
		String updatedList = ReturnsTracker.retriveAllCustomer(customerList);
		assertEquals("Check that list", testOutput, updatedList);
	}
	//19037802tzeyang--// 
}
