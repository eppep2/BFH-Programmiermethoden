package bankapp.account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PersonalAccountTest {

	private static final int NR = 1;
	private static final String PIN = "12345";
	private static final double BALANCE = 2000.0;
	private static final double AMOUNT = 1000.0;
	private static final double DELTA = 0.01;

	private Account account;

	@Before
	public void init() {
		account = new PersonalAccount(NR, PIN, BALANCE);
	}

	@Test
	public void testNr() {
		assertEquals(NR, account.getNr());
	}

	@Test
	public void testPIN() {
		assertTrue(account.checkPIN(PIN));
	}

	@Test
	public void testInvalidPIN() {
		assertFalse(account.checkPIN(""));
	}

	@Test
	public void testBalance() {
		assertEquals(BALANCE, account.getBalance(), DELTA);
	}

	@Test
	public void testDeposit() {
		assertTrue(account.deposit(AMOUNT));
		assertEquals(BALANCE + AMOUNT, account.getBalance(), DELTA);
	}

	@Test
	public void testDepositInvalidAmount() {
		assertFalse(account.deposit(-AMOUNT));
		assertEquals(BALANCE, account.getBalance(), DELTA);
	}

	@Test
	public void testWithdraw() {
		assertTrue(account.withdraw(AMOUNT));
		assertEquals(BALANCE - AMOUNT, account.getBalance(), DELTA);
	}

	@Test
	public void testWithdrawInvalidAmount() {
		assertFalse(account.withdraw(-AMOUNT));
		assertEquals(BALANCE, account.getBalance(), DELTA);
	}

	@Test
	public void testOverdraw() {
		assertTrue(account.withdraw(2 * BALANCE));
		assertEquals(-BALANCE, account.getBalance(), DELTA);
	}
}