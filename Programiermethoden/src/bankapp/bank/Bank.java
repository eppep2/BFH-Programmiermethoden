package bankapp.bank;

import java.util.List;

import bankapp.account.Account;
import bankapp.account.Transaction;

/**
 * The interface Bank defines the transaction methods of a bank.
 * @author Samuel Pulfer
 *
 */
public interface Bank {
	/**
	 * Closes an account.
	 * @param nr the account number
	 * @param pin the PIN of the account
	 * @throws BankException if the account does not exist or the pin is invalid
	 */
	void closeAccount(int nr, String pin) throws BankException;
	/**
	 * Deposits money into an account.
	 * @param nr the account number
	 * @param amount the amount of money to deposit
	 * @throws BankException if the account does not exist or the amount could not be deposited
	 */
	void deposit(int nr, double amount) throws BankException;
	/**
	 * Gets the bank accounts.
	 * @return the bank accounts
	 */
	List<Account> getAccounts();
	/**
	 * Gets the balance of an account.
	 * @param nr the account number
	 * @param pin the PIN of the account
	 * @return the account balance, or null if an error occurred
	 * @throws BankException if the account does not exist or the pin is invalid
	 */
	double getBalance(int nr, String pin) throws BankException;
	/**
	 * Opens a bank account.
	 * @param type the account type
	 * @param pin the PIN of the account
	 * @param balance the initial balance
	 * @return the account number
	 */
	int openAccount(AccountType type, String pin, double balance);
	/**
	 * Withdraw money from an account.
	 * @param nr the account number
	 * @param pin the PIN of the account
	 * @param amount the amount of money to withdraw
	 * @throws BankException if the account does not exist or the pin is invalid or the amount could not be withdrawn
	 */
	void withdraw(int nr, String pin, double amount) throws BankException;
	
	/**
	 * Gets the transactions of an account.
	 * @param nr the account number
	 * @param pin the PIN of the account
	 * @return the account transactions
	 * @throws BankException if the account does not exist or the pin is invalid
	 */
	List<Transaction> getTransactions(int nr, String pin) throws BankException;
	
}
