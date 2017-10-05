package bankapp.account;

/** The class SavingsAccount represents savings bank accounts.
 * @author Samuel Pulfer
 *
 */
public class SavingsAccount extends Account{

	/**
	 * The withdraw limit.
	 */
	static double WITHDRAW_LIMIT = 2000;
	
	/** Constructs a savings bank account.
	 * @param nr - the account number
	 * @param pin - the PIN of the account
	 * @param balance - the initial balance
	 */
	public SavingsAccount(int nr, String pin, double balance) {
		super(nr, pin, balance);
	}
	
	/** Withdraws money from the account.
	 * @param amount - the amount of money to withdraw
	 * @return true if the withdrawal was successful, false otherwise
	 */
	@Override
	public boolean withdraw(double amount) {
		if (amount > super.balance)
			return false;
		else if(amount > WITHDRAW_LIMIT)
			return false;
		else {
			return super.withdraw(amount);
		}
	}
}
