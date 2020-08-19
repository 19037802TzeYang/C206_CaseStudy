import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManageCusTest {
	private Customer cObj1;
	private Customer cObj2;
	private ArrayList<Customer> customerList;

	@Before
	public void setUp() throws Exception {
		cObj1 = new Customer("c1", "Name01", "123");
		cObj2 = new Customer("c2", "Name02", "321");
		customerList = new ArrayList<Customer>();
	}

	@After
	public void tearDown() throws Exception {
		cObj1 = null;
		cObj2 = null;
		customerList = null;
	}

	@Test
	public void c206_testAddCus() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
		//test if customerList is not null - boundary
		assertNotNull("Check if there is vlaid Customer in arrayList to add to", customerList);
		//given an empty list, after adding 1 customer, the list's size is 1 - normal
		ManageCus.addCustomer(customerList, cObj1);
		assertEquals("Check arrayList size is 1", 1, customerList.size());
		//add another customer to test if the list's size is 2 - normal
		ManageCus.addCustomer(customerList, cObj2);
		assertEquals("Check arrayList size is 2", 2, customerList.size());
	}
	
	@Test
	public void c206_testViewCus() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
		//test if customerList is not null - boundary
		assertNotNull("Check if there is valid Customer in arrayList to view", customerList);
		//test if the list of customer retrieved is empty - boundary
		String allCustomer = ManageCus.retriveAllCustomer(customerList);
		String empStr = "";
		assertEquals("check if customerList is empty", empStr, allCustomer);
		//given an empty list, after adding 2 customer, test if the size of the list is 2 - normal
		ManageCus.addCustomer(customerList, cObj1);
		ManageCus.addCustomer(customerList, cObj2);
		assertEquals("Check arrayList size is 2", 2, customerList.size());
	}
	
	@Test
	public void c206_testDeleteCus() {
		//fail("Not yet implemented"); 
		//test if customerList is not null - boundary
		assertNotNull("Check if there is valid Customer in arrayList to delete", customerList);
		assertTrue("C206_CaseStudy_SampleTest ",true);
		//test if the given customer is successfully removed from the given username - normal
		ManageCus.addCustomer(customerList, cObj1);
		Boolean success = ManageCus.removeCustomer(customerList, "Name01");
		assertTrue("check if customer is removed from a given username", success);
	}   
} 
