package bankapp.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import bankapp.bank.AccountType;
import bankapp.bank.BankException;

/**
 * The class Account represents bank accounts.
 * @author Samuel Pulfer
 *
 */
public abstract class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Constructs an empty bank account.
	 * @param nr the account number
	 * @param pin the PIN of the account
	 */
	public Account (int nr, String pin) {
		this(nr,pin,0.0);
	}
	/**
	 * Constructs a bank account.
	 * @param nr the account number
	 * @param pin the PIN of the account
	 * @param balance the initial balance
	 */
	public Account (int nr, String pin, double balance) {
		this.balance = balance;
		this.nr = nr;
		this.pin = pin;
		transactions = new ArrayList<Transaction>();
		transactions.add(new Transaction(balance, balance));
		
	}
	
	/**
	 * The account balance.
	 */
	protected double balance;
	/**
	 * The number of the account.
	 */
	protected int nr;
	/**
	 * The PIN of the account
	 */
	protected String pin = "";
	/**
	 * The transactions of the account.
	 */
	private List<Transaction> transactions;
	
	
	// Methods
	/**
	 * Checks the PIN of the account.
	 * @param pin the PIN to check
	 * @throws BankException if the PIN is invalid
	 */
	public void checkPIN(String pin) throws BankException{
		if (!pin.equals(this.pin))
			throw new BankException("Pin is invalid");
	}
	/**
	 * Deposits money into the account.
	 * @param amount the amount of money to deposit
	 * @throws BankException if the deposit failed
	 */
	public synchronized void deposit(double amount) throws BankException {
		if (amount >= 0) {
			balance = Math.round(100 * (balance + amount)) / 100.0;
			transactions.add(new Transaction(amount, balance));
		} else {
			throw new BankException("Deposit failed");
		}
	}
	/**
	 * Checks if the account is equal to an another object by the AccountNr.
	 * @param object the other object
	 * @return true if the accounts are equal, false otherwise
	 */
	@Override
	public boolean equals(Object object) {
		if (object == null)
			return false;
		if (object instanceof Account) {
			Account other = (Account)object;
			if (object != null && other.nr == this.nr) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Gets the balance of the account.
	 * @return the account balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * Gets the number of the account.
	 * @return the account number
	 */
	public int getNr() {
		return nr;
	}
	/**
	 * Takes the AccountNr as hash code.
	 * @return returns the AccountNr as hash code.
	 */
	@Override
	public int hashCode() {
		return nr;
	}
	/** 
	 * Generates a string representation of the account
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + " {nr=" + nr + ", balance=" + balance + ", type=" + getType() + "}";
		/*
		StringBuilder sb = new StringBuilder();
		sb.append("AccountNr: " + nr);
		sb.append("\nBalance: " + balance);
		sb.append("\nPIN: " + pin);
		return sb.toString();
		*/
	}
	/**
	 * Withdraws money from the account.
	 * @param amount the amount of money to withdraw
	 * @throws BankException if the withdrawal failed
	 */
	public synchronized void withdraw(double amount) throws BankException {
		if (amount > 0) {
			balance = Math.round(100 * (balance - amount)) / 100.0;
			transactions.add(new Transaction(0.0 - amount, balance));
		} else {
			throw new BankException("Withdrawal failed");
		}
	}
	/**
	 * Withdraws money from the account.
	 * @param amount the amount of money to withdraw
	 * @throws BankException if the withdrawal failed
	 */
	public synchronized void withdraw(int amount) throws BankException {
		withdraw((double) amount);
	}
	/**
	 * Gets the type of the account.
	 * @return the account type
	 */
	public abstract AccountType getType();
	
	/**
	 * Gets the transactions of the account.
	 * @return the account transactions
	 */
	public List<Transaction> getTransactions(){
		return transactions;
	}
	
	/** Gets the interest rate.
	 * @return the interest rate
	 */
	public abstract double getInterestRate();
	
	public synchronized void payInterests() {
		try {
			if (balance >= 0)
				deposit(balance * getInterestRate());
			else
				withdraw(0.0 - balance * getInterestRate());
		} catch (BankException e) {
			// This should never happen.
			System.out.println("Can't pay interests " + e.getMessage());
		}
	}
}
