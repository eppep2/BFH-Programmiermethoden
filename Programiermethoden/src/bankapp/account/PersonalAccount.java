package bankapp.account;

/**
 * The class Account represents personal bank accounts.
 * @author Samuel Pulfer
 *
 */
public class PersonalAccount extends Account {

	/** Constructs a personal bank account.
	 * @param nr - the account number
	 * @param pin - the PIN of the account
	 * @param balance - the initial balance
	 */
	public PersonalAccount(int nr, String pin, double balance) {
		super(nr, pin, balance);
	}

}
