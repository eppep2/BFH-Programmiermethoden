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
public class Bank {
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

	public Bank() {
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
	 * @return true if the account has been closed, or false if an error occurred
	 */
	public boolean closeAccount(int nr, String pin) {
		Account account = findAccount(nr);
		if (account == null)
			return false;
		if (account.checkPIN(pin))
			// It souldn't be possible to close Accounts with money on it...
			// if (account.getBalance() >= 0 - EPSILON && account.getBalance() <= 0 +
			// EPSILON)
			return accounts.remove(account);
		return false;
	}

	/**
	 * Deposits money into an account.
	 * 
	 * @param nr
	 *            - the account number
	 * @param amount
	 *            - the amount of money to deposit
	 * @return true if the amount has been deposited, or false if an error occurred
	 */
	public boolean deposit(int nr, double amount) {
		Account account = findAccount(nr);
		if (account == null)
			return false;
		return account.deposit(amount);
	}

	/**
	 * Finds an account.
	 * 
	 * @param nr
	 *            - the account number
	 * @return the account, or null if the account does not exist
	 */
	private Account findAccount(int nr) {
		for (Account account : accounts) {
			if (account.getNr() == nr) {
				return account;
			}
		}
		return null;
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
	 */
	public Double getBalance(int nr, String pin) {
		Account account = findAccount(nr);
		if (account == null)
			return null;
		if (account.checkPIN(pin)) {
			return account.getBalance();
		}
		return null;
	}

	/**
	 * Opens a personal bank account.
	 * 
	 * @param pin
	 *            - the PIN of the account
	 * @param balance
	 *            - the initial balance
	 * @return the account number
	 */
	public int openPersonalAccount(String pin, double balance) {
		lastAccountNr += 1;
		accounts.add(new PersonalAccount(lastAccountNr, pin, balance));
		return lastAccountNr;
	}

	/**
	 * Opens a savings bank account.
	 * 
	 * @param pin
	 *            - the PIN of the account
	 * @param balance
	 *            - the initial balance
	 * @return the account number
	 */
	public int openSavingsAccount(String pin, double balance) {
		lastAccountNr += 1;
		accounts.add(new SavingsAccount(lastAccountNr, pin, balance));
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
	 * @return true if the amount has been withdrawn, or false if an error occurred
	 */
	public boolean withdraw(int nr, String pin, double amount) {
		Account account = findAccount(nr);
		if (account == null)
			return false;
		if (account.checkPIN(pin))
			return account.withdraw(amount);
		return false;
	}
}
