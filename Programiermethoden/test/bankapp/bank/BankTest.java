package bankapp.bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BankTest {

	private static final String PIN = "12345";
	private static final double BALANCE = 5000.0;
	private static final double AMOUNT = 1000.0;
	private static final double DELTA = 0.01;

	private Bank bank;
	private int accountNr;

	@Before
	public void init() throws Exception {
		bank = new Bank();
		accountNr = bank.openAccount(PIN, BALANCE);
	}

	@Test
	public void testOpen() {
		assertNotNull(accountNr);
	}

	@Test
	public void testBalance() {
		assertEquals(BALANCE, bank.getBalance(accountNr, PIN), DELTA);
	}

	@Test
	public void testBalanceInvalidNr() {
		assertNull(bank.getBalance(-1, PIN));
	}

	@Test
	public void testBalanceInvalidPIN() {
		assertNull(bank.getBalance(accountNr, ""));
	}

	@Test
	public void testDeposit() {
		assertTrue(bank.deposit(accountNr, AMOUNT));
		assertEquals(BALANCE + AMOUNT, bank.getBalance(accountNr, PIN), DELTA);
	}

	@Test
	public void testDepositInvalidNr() {
		assertFalse(bank.deposit(-1, AMOUNT));
		assertEquals(BALANCE, bank.getBalance(accountNr, PIN), DELTA);
	}

	@Test
	public void testWithdraw() {
		assertTrue(bank.withdraw(accountNr, PIN, AMOUNT));
		assertEquals(BALANCE - AMOUNT, bank.getBalance(accountNr, PIN), DELTA);
	}

	@Test
	public void testWithdrawInvalidNr() {
		assertFalse(bank.withdraw(-1, PIN, AMOUNT));
		assertEquals(BALANCE, bank.getBalance(accountNr, PIN), DELTA);
	}

	@Test
	public void testWithdrawInvalidPIN() {
		assertFalse(bank.withdraw(accountNr, "", AMOUNT));
		assertEquals(BALANCE, bank.getBalance(accountNr, PIN), DELTA);
	}

	@Test
	public void testWithdrawInvalidAmount() {
		assertFalse(bank.withdraw(accountNr, PIN, -AMOUNT));
		assertEquals(BALANCE, bank.getBalance(accountNr, PIN), DELTA);
	}

	@Test
	public void testClose() {
		assertTrue(bank.closeAccount(accountNr, PIN));
		assertNull(bank.getBalance(accountNr, PIN));
	}

	@Test
	public void testCloseInvalidNr() {
		assertFalse(bank.closeAccount(-1, PIN));
		assertNotNull(bank.getBalance(accountNr, PIN));
	}

	@Test
	public void testCloseInvalidPIN() {
		assertFalse(bank.closeAccount(accountNr, ""));
		assertNotNull(bank.getBalance(accountNr, PIN));
	}
}