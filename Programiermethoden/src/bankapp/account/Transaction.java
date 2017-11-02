package bankapp.account;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The class Transaction represents a bank transaction.
 * @author Samuel Pulfer
 *
 */
public class Transaction implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//** The amount of the transaction. */
	private double amount;
	//** The current account balance. */
	private double balance;
	//** The valuta of the transaction. */
	private Date valuta;
	
	/**
	 * Constructs a bank transaction.
	 * @param amount the amount of the transaction
	 * @param balance the current account balance
	 */
	public Transaction(double amount, double balance) {
		this.amount = amount;
		this.balance = balance;
		this.valuta = new Date();
	}
	
	/**
	 * Gets the amount of the transaction.
	 * @return the amount of the transaction
	 */
	public double getAmount() {
		return amount;
	}
	
	/**
	 * Gets the current account balance.
	 * @return the current account balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Gets the valuta of the transaction.
	 * @return the valuta of the transaction
	 */
	public Date getValuta() {
		return valuta;
	}
	
	/** Generates a string representation of the transaction.
	 * @return a string representation of the transaction
	 */
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#0.00");
		return new SimpleDateFormat("yyyy.MM.dd hh:MM:ss").format(valuta) + "\tAmount: " + df.format(amount) + "\tBalance: " + df.format(balance);
	}
}
