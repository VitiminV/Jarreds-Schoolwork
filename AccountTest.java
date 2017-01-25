
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class AccountTest {
	private Account account;
	@Before
	public void setUp () {
		 account = new Account(1000, "John Doe");
	}
	
	@Test
	public void testPartialConstructor() {
		assertEquals("id was not properly set", 1000, account.getId());
		assertEquals("name was not properly set", "John Doe", account.getName());
		assertEquals("balance was not properly set", 0, account.getBalance(), 0);

	}
	
	@Test
	public void testFullConstructor() {
		Account account1 = new Account(1000, "John Doe", 5000);
		
		assertEquals("id was not properly set", 1000, account1.getId());
		assertEquals("name was not properly set", "John Doe", account1.getName());
		assertEquals("balance was not properly set", 5000, account1.getBalance(), 0);
	}
	
	@Test
	public void testSetBalance() {
		account.setBalance(5000);
		assertEquals("balance was not properly set", 5000, account.getBalance(), 0);
	}
	
	@Test
	public void testDeposit() {
		account.setBalance(5000);
		
		account.deposit(-1000);
		assertEquals("deposition of negative amount was not handled correctly", 5000, account.getBalance(), 0);
	
		account.deposit(500);
		assertEquals("deposition was not handled correctly ", 5500, account.getBalance(), 0);

	}
	
	@Test
	public void testWithDrawal() {
		account.setBalance(5000);
		
		account.withdraw(-1000);
		assertEquals("withdrawal of negative amount was not handled correctly ", 5000, account.getBalance(), 0);
	
		account.withdraw(6000);
		assertEquals("withdrawal of  amount that exceeds balance was not handled correctly", 5000, account.getBalance(), 0);
	
		account.withdraw(4500);
		assertEquals("withdrawal was not handled correctly  ", 500, account.getBalance(), 0);
	}
	
	@Test
	public void testTransferTo() {
		Account account1 = new Account(1001, "Jane Doe");
		account.setBalance(5000);
		
		account.transferTo(account1, -1000);
		assertEquals("fromAccount - transfer of negative amount was not handled correctly", 5000, account.getBalance(), 0);
		assertEquals("toAccount - transfer of negative amount was not handled correctly", 0, account1.getBalance(), 0);

		account.transferTo(account1, 6000);
		assertEquals("fromAccount - transfer of amount that exceeds balance was not handled correctly ", 5000, account.getBalance(), 0);
		assertEquals("toAccount - transfer of amount that exceeds balance was not handled correctly", 0, account1.getBalance(), 0);

		account.transferTo(null, 6000);
		assertEquals("fromAccount - code did not handle null case for account to be transferred to", 5000, account.getBalance(), 0);
		assertEquals("toAccount - money was transfered into the account given a null account", 0, account1.getBalance(), 0);

		account.transferTo(account1, 4000);
		assertEquals("code did not withdraw the money from the account after transferring", 1000, account.getBalance(), 0);
		assertEquals("code did not deposit the money to the account passed as parameter", 4000, account1.getBalance(), 0);

	}
}
