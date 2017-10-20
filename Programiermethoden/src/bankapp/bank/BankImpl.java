package bankapp.bank;

import java.util.ArrayList;

import bankapp.account.Account;
import bankapp.account.PersonalAccount;
import bankapp.account.SavingsAccount;

/**
 * The class Bank manages bank accounts and executes bank transactions.
 * 
 * @author Samuel Pulfer
 *
 */
public class BankImpl implements Bank{
	/**
	 * The bank accounts.
	 */
	private ArrayList<Account> accounts;
	/**
	 * The last account number.
	 */
	private int lastAccountNr;
	/**
	 * Value to compare double to zero.
	 */
	//private final double EPSILON = Math.ulp(1.0);

	public BankImpl() {
		lastAccountNr = 0;
		accounts = new ArrayList<Account>();
	}

	/**
	 * Closes an account.
	 * 
	 * @param nr
	 *            - the account number
	 * @param pin
	 *            - the PIN of the account
	 * @throws BankException - if the account does not exist or the amount could not be deposited
	 */
	public void closeAccount(int nr, String pin) throws BankException {
		Account account = findAccount(nr);
		if (account == null)
			throw new BankException("Account does not exist");
		account.checkPIN(pin);
		// It souldn't be possible to close Accounts with money on it...
		// if (account.getBalance() >= 0 - EPSILON && account.getBalance() <= 0 +
		// EPSILON)
		accounts.remove(account);
	}

	/**
	 * Deposits money into an account.
	 * 
	 * @param nr
	 *            - the account number
	 * @param amount
	 *            - the amount of money to deposit
	 * @throws BankException - if the account does not exist or the amount could not be deposited
	 */
	public void deposit(int nr, double amount) throws BankException {
		Account account = findAccount(nr);
		if (account == null)
			throw new BankException("Account does not exist");
		account.deposit(amount);
	}

	/**
	 * Finds an account.
	 * 
	 * @param nr
	 *            - the account number
	 * @return the account, or null if the account does not exist
	 * @throws BankException - if the account does not exist
	 */
	private Account findAccount(int nr) throws BankException {
		for (Account account : accounts) {
			if (account.getNr() == nr) {
				return account;
			}
		}
		throw new BankException("Account does not exist");
	}

	/**
	 * Gets the bank accounts.
	 * 
	 * @return the bank accounts
	 */
	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	/**
	 * Gets the balance of an account.
	 * 
	 * @param nr
	 *            - the account number
	 * @param pin
	 *            - the PIN of the account
	 * @return the account balance, or null if an error occurred
	 * @throws BankException - if the account does not exist or the pin is invalid
	 */
	public double getBalance(int nr, String pin) throws BankException {
		Account account = findAccount(nr);
		if (account == null)
			throw new BankException("Account does not exist");
		account.checkPIN(pin);
		return account.getBalance();
	}

	/**
	 * @param type - the account type
	 * @param pin - the PIN of the account
	 * @param balance - the initial balance
	 * @return the account number
	 */
	public int openAccount(AccountType type, String pin, double balance) {
		lastAccountNr += 1;
		if(type == AccountType.PERSONAL)
			accounts.add(new PersonalAccount(lastAccountNr, pin, balance));
		else if(type == AccountType.SAVINGS) {
			accounts.add(new SavingsAccount(lastAccountNr, pin, balance));
		} else {
			//this will never happen!!!
		}
		return lastAccountNr;
	}

	/**
	 * Withdraw money from an account.
	 * 
	 * @param nr
	 *            - the account number
	 * @param pin
	 *            - the PIN of the account
	 * @param amount
	 *            - the amount of money to withdraw
	 * @throws BankException - if the account does not exist or the pin is invalid or the amount could not be withdrawn
	 */
	public void withdraw(int nr, String pin, double amount) throws BankException {
		Account account = findAccount(nr);
		if (account == null)
			throw new BankException("Account does not exist");
		account.checkPIN(pin);
		account.withdraw(amount);
	}
}
