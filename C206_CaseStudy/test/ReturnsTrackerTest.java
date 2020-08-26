import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReturnsTrackerTest {
	private Customer c1;
	private Customer c2;

	private Staff s1;
	private Staff s2;

	private Product p1;
	private Product p2;
	private Product p3;
	private Product p4;

	private Transaction t1;
	private Transaction t2;
	private Transaction t3;
	private Transaction t4;

	ArrayList<Outlet> outletList = new ArrayList<Outlet>();
	ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
	ArrayList<Transaction> archiveList = new ArrayList<Transaction>();
	ArrayList<Product> productList = new ArrayList<Product>();
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	ArrayList<Staff> staffList = new ArrayList<Staff>();

	public ReturnsTrackerTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		c1 = new Customer("Bob", "Bob1", "pass", "", p1);
		c2 = new Customer("Peter", "Peter1", "pass", "", p2);
		s1 = new Staff("John", 100);
		s2 = new Staff("Donald", 200);

		p1 = new Product("01", "Water", 2.50, "vendor", "", true);
		p2 = new Product("02", "Tea", 2.50, "vendor", "", true);
		p3 = new Product("ID1331", "Heron Preston", 35.0, "Heron Preston Johnson", "Clothing", true);
		p4 = new Product("ID1111", "Beer", 35.0, "Hein", "Beverage", false);

		t1 = new Transaction("1111", c1, "Top up", s1, p4);
		p1 = new Product("01", "Water", 2.50, "vendor", "", false);
		p2 = new Product("01", "Water", 2.50, "vendor", "", false);
		p3 = new Product("ID1331", "Heron Preston", 35.0, "Heron Preston Johnson", "Clothing", false);
		p4 = new Product("ID1111", "Beer", 35.0, "Hein", "Beverage", false);
		
		t1 = new Transaction("1111", c1, "Top up", s1, p1);
		t2 = new Transaction("2222", c2, "Exchange", s2, p2);
		t3 = new Transaction("3333", c1, "Refund", s2, p4);
		t4 = new Transaction("4444", c1, "Exchange", s2, p4);

		staffList.add(s1);
		staffList.add(s2);
	}

	@Test
	public void addTransactionTest() {
		// Transaction list is not null, so that can add a new Transaction
		assertNotNull("Test if there is valid transaction arraylist to add to", transactionList);

		// Given an empty list, after adding 1 Transaction, the size of the list is 1
		ReturnsTracker.addTransaction(transactionList, t1);
		assertEquals("Test if that transaction arraylist size is 1?", 1, transactionList.size());

		// The Transaction just added is as same as the first Transaction of the list
		assertSame("Test that transaction is added same as 1st Transaction of the list?", t1, transactionList.get(0));

		// Add another Transaction. test The size of the list is 2?
		ReturnsTracker.addTransaction(transactionList, t2);
		assertEquals("Test that transaction arraylist size is 2?", 2, transactionList.size());
	}

	@Test
	public void retrieveTransactionTest() {
		// Test if Transaction list is not null but empty, so that can add a new
		// Transaction
		assertNotNull("Test if there is valid transaction arraylist to add to", transactionList);

		// test if the list of transactions retrieved from the ReturnsTracker is empty
		String alltransaction = ReturnsTracker.retrieveTransactions(transactionList);
		String testOutput = "";
		assertEquals("Check that retrieveTransaction", testOutput, alltransaction);

		// Given an empty list, after adding 2 Transactions, test if the size of the
		// list is 2
		ReturnsTracker.addTransaction(transactionList, t1);
		ReturnsTracker.addTransaction(transactionList, t2);
		assertEquals("Test if that transaction arraylist size is 2?", 2, transactionList.size());

		// test if the expected output string same as the list of transactions retrieved
		// from the ReturnsTracker
		alltransaction = ReturnsTracker.retrieveTransactions(transactionList);

		testOutput = String.format("%-5s %-50s", "1", t1.returnString());
		testOutput += String.format("%-5s %-50s", "2", t2.returnString());

		assertEquals("Check that ViewAlltransactionlist", testOutput, alltransaction);

	}

	@Test
	public void archiveTransactionTest() {
		// Transaction list is not null, so that can add a new Transaction
		assertNotNull("Test if there is valid transaction arraylist to add to", transactionList);

		// Transaction list is not null, so that can add a new Transaction
		assertNotNull("Test if there is valid transaction arraylist to add to", archiveList);

		// Given an empty list, after adding 1 Transaction, the size of the list is 1
		ReturnsTracker.addTransaction(transactionList, t1);
		assertEquals("Test if that transaction arraylist size is 1?", 1, transactionList.size());

		// The Transaction just added is as same as the first Transaction of the list
		assertSame("Test that transaction is added same as 1st Transaction of the list?", t1, transactionList.get(0));

		// Archive transaction, archiveList size = 1, transactionList size = 0
		ReturnsTracker.archiveTransaction(transactionList, archiveList, 0);

		assertEquals("Test that transaction arraylist size is 0?", 0, transactionList.size());
		assertEquals("Test that transaction arraylist size is 1?", 1, archiveList.size());

		assertSame("Test that transaction is added same as 1st archived list?", t1, archiveList.get(0));
	}

	@Test
	public void getMostReturnsTest() {
		// Transaction list is not null, so that can add a new Transaction
		assertNotNull("Test if there is valid transaction arraylist to add to", transactionList);

		// Given an empty list, after adding 1 Transaction, the size of the list is 1
		ReturnsTracker.addTransaction(transactionList, t2);
		assertEquals("Test if that transaction arraylist size is 1?", 1, transactionList.size());

		// Add two more Transaction. test The size of the list is 3
		ReturnsTracker.addTransaction(transactionList, t3);
		ReturnsTracker.addTransaction(transactionList, t4);
		assertEquals("Test that transaction arraylist size is 3?", 3, transactionList.size());

		// Test if product with most return is Beer
		String testOutput = "Product with most returns: Beer (2)";
		assertEquals("Test if product matches testOutput", ReturnsTracker.getMostReturns(transactionList, 1),
				(testOutput));

		// Test if customer with most return is c1 "Bob"
		String testOutput2 = "Customer with most returns: Bob1 (2)";
		assertEquals("Test if product matches testOutput", ReturnsTracker.getMostReturns(transactionList, 2),
				(testOutput2));
	}

	@Test
	public void updateTransactionTest() {
		String data = "1" + "\nExchange" + "\n2" + "\n2" + "\n4" + "\n5";

		System.setIn(new ByteArrayInputStream(data.getBytes()));
		Scanner scanner = new Scanner(System.in);

		ReturnsTracker.updateTransaction(t1, staffList);
		scanner.close();

		// Test change action is updated, matches test input
		assertTrue("Test change action is updated?", "Exchange".equals(t1.getAction()));
		// Test change staff is updated, matches test input
		assertTrue("Test change staff is updated?", "Donald".equals(t1.getStaffInfo().getName()));
		// Test change status is updated, matches test input
		assertTrue("Test change status is updated?", "Fulfilled".equals(t1.getStatus()));
		// Test reward points updated is updated, points > 0
		assertTrue("Customer points added", t1.getCustomerInfo().getRewardPoints() > 0);
	}

	@After
	public void tearDown() throws Exception {
		c1 = null;
		c2 = null;
		s1 = null;
		s2 = null;

		t1 = null;
		t2 = null;

		p1 = null;
		p2 = null;
	}

}
