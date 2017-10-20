package bankapp.account;

import bankapp.bank.AccountType;

/**
 * The class Account represents personal bank accounts.
 * @author Samuel Pulfer
 *
 */
public class PersonalAccount extends Account {

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

}
