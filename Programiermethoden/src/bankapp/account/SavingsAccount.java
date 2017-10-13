package bankapp.account;

import bankapp.bank.AccountType;
import bankapp.bank.BankException;

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
	 * @throws BankException - if the withdrawal failed
	 */
	@Override
	public void withdraw(double amount) throws BankException{
		if (amount > super.balance)
			throw new BankException("Amount is higher than balance");
		else if(amount > WITHDRAW_LIMIT)
			throw new BankException("Amount is higher than withdraw limit");
		else {
			super.withdraw(amount);
		}
	}
	/**
	 * Gets the type of the account.
	 * @return the account type
	 */
	public AccountType getType() {
		return AccountType.SAVINGS;
	}
}
