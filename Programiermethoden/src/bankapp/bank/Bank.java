package bankapp.bank;

import java.util.ArrayList;

import bankapp.account.Account;

/**
 * The interface Bank defines the transaction methods of a bank.
 * @author Samuel Pulfer
 *
 */
public interface Bank {
	/**
	 * Closes an account.
	 * @param nr - the account number
	 * @param pin - the PIN of the account
	 * @return true if the account has been closed, or false if an error occurred
	 */
	boolean closeAccount(int nr, String pin);
	/**
	 * Deposits money into an account.
	 * @param nr - the account number
	 * @param amount - the amount of money to deposit
	 * @return true if the amount has been deposited, or false if an error occurred
	 */
	boolean deposit(int nr, double amount);
	/**
	 * Gets the bank accounts.
	 * @return the bank accounts
	 */
	ArrayList<Account> getAccounts();
	/**
	 * Gets the balance of an account.
	 * @param nr - the account number
	 * @param pin - the PIN of the account
	 * @return the account balance, or null if an error occurred
	 */
	Double getBalance(int nr, String pin);
	/**
	 * Opens a bank account.
	 * @param type - the account type
	 * @param pin - the PIN of the account
	 * @param balance - the initial balance
	 * @return the account number
	 */
	int openAccount(AccountType type, String pin, double balance);
	/**
	 * Withdraw money from an account.
	 * @param nr - the account number
	 * @param pin - the PIN of the account
	 * @param amount - the amount of money to withdraw
	 * @return true if the amount has been withdrawn, or false if an error occurred
	 */
	boolean withdraw(int nr, String pin, double amount);
	
}
