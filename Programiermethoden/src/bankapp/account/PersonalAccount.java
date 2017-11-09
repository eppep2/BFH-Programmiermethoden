package bankapp.account;

import bankapp.bank.AccountType;

/**
 * The class Account represents personal bank accounts.
 * @author Samuel Pulfer
 *
 */
public class PersonalAccount extends Account {

	//** The interest rate. */
	private static double INTEREST_RATE = 0.00125;
	/** Constructs a personal bank account.
	 * @param nr the account number
	 * @param pin the PIN of the account
	 * @param balance the initial balance
	 */
	public PersonalAccount(int nr, String pin, double balance) {
		super(nr, pin, balance);
	}
	/**
	 * Gets the type of the account.
	 * @return the account type
	 */
	public AccountType getType() {
		return AccountType.PERSONAL;
	}
	
	/** Gets the interest rate.
	 * @return the interest rate
	 */
	public double getInterestRate() {
		return INTEREST_RATE;
	}

}
