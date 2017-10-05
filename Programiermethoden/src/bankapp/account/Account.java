package bankapp.account;

/**
 * The class Account represents bank accounts.
 * @author Samuel Pulfer
 *
 */
public class Account {
	// Constructor
	/**
	 * @param nr - the account number
	 * @param pin - the PIN of the account
	 */
	public Account (int nr, String pin) {
		this(nr,pin,0.0);
	}
	/**
	 * @param nr - the account number
	 * @param pin - the PIN of the account
	 * @param balance - the initial balance
	 */
	public Account (int nr, String pin, double balance) {
		this.balance = balance;
		this.nr = nr;
		this.pin = pin;
		
	}
	
	/**
	 * The account balance.
	 */
	private double balance;
	/**
	 * The number of the account.
	 */
	private int nr;
	/**
	 * The PIN of the account
	 */
	private String pin = "";
	
	
	// Methods
	/**
	 * Checks the PIN of the account.
	 * @param pin - the PIN to check
	 * @return true if the PIN is valid, false otherwise
	 */
	public boolean checkPIN(String pin) {
		if (pin.equals(this.pin)) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Deposits money into the account.
	 * @param amount - the amount of money to deposit
	 * @return true if the deposit was successful, false otherwise
	 */
	public boolean deposit(double amount) {
		if (amount >= 0) {
			balance = Math.round(100 * (balance + amount)) / 100.0;
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Checks if the account is equal to an another object by the AccountNr.
	 * @param object - the other object
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
		return getClass().getSimpleName() + " {nr=" + nr + ", balance=" + balance + "}";
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
	 * @param amount - the amount of money to withdraw
	 * @return true if the withdrawal was successful, false otherwise
	 */
	public boolean withdraw(double amount) {
		if (amount > 0) {
			System.out.println(amount);
			balance = Math.round(100 * (balance - amount)) / 100.0;
			System.out.println(balance);
			return true;
		} else {
			return false;
		}
	}
	public boolean withdraw(int amount) {
		return withdraw((double) amount);
	}
	

}
