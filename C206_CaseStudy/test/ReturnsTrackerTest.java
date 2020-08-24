import static org.junit.Assert.*;

import java.util.ArrayList;

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

	private Transaction t1;
	private Transaction t2;

	ArrayList<Outlet> outletList = new ArrayList<Outlet>();
	ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
	ArrayList<Transaction> archiveList = new ArrayList<Transaction>();
	ArrayList<Product> productList = new ArrayList<Product>();
	ArrayList<Customer> customerList = new ArrayList<Customer>();

	public ReturnsTrackerTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		c1 = new Customer("Bob", "Bob1", "pass");
		c2 = new Customer("Peter", "Peter1", "pass");
		s1 = new Staff("John", 100);
		s2 = new Staff("Donald", 200);
		p1 = new Product("01", "Water", 2.50, "vendor", "");
		p2 = new Product("01", "Water", 2.50, "vendor", "");
		
		t1 = new Transaction("1111", c1, "Top up", s1, p1);
		t2 = new Transaction("2222", c2, "Exchange", s2, p2);
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
		// Test if Transaction list is not null but empty, so that can add a new Transaction
		assertNotNull("Test if there is valid transaction arraylist to add to", transactionList);

		// test if the list of transactions retrieved from the ReturnsTracker is empty
		String alltransaction = ReturnsTracker.retrieveTransactions(transactionList);
		String testOutput = "";
		assertEquals("Check that retrieveTransaction", testOutput, alltransaction);

		// Given an empty list, after adding 2 Transactions, test if the size of the list is 2
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
	
	//--update customer return(policy) history test--//
	@Test
	public void updateReturnHistoryTest() {
		// Test if transaction list is not null, so that the transaction can be added
		assertNotNull("Test if there is valid transaction arraylist to add to", transactionList);
		// Test if the archieve list is not null, so that the transaction can be updated
		assertNotNull("Test if there is valid transaction arraylist to add to", archiveList);
		// Given an empty list, after adding 1 Transaction, the size of the list is 1
		ReturnsTracker.addTransaction(transactionList, t1);
		// Archive transaction, archiveList size = 1, transactionList size = 0
		ReturnsTracker.archiveTransaction(transactionList, archiveList, 0);
		// Given that archieveList size = 1, after update 1 transaction, transactionList size = 1, archieveList size = 0
		ReturnsTracker.updateReturnHistory(transactionList, archiveList);
		assertEquals("Test that transaction arraylist size is 1?", 1, transactionList.size());
		assertEquals("Test that transaction arraylist size is 0?", 0, archiveList.size());
	}
	//--// 

	@After
	public void tearDown() throws Exception {
		c1 = null;
		c2 = null;
		s1 = null;
		s2 = null;
		
		t1 = null;
		t2 = null;
	}

}
