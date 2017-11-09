package bankapp.bank;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import bankapp.account.Account;
import bankapp.account.PersonalAccount;
import bankapp.account.SavingsAccount;
import bankapp.account.Transaction;

/**
 * The class Bank manages bank accounts and executes bank transactions.
 * 
 * @author Samuel Pulfer
 *
 */
public class BankImpl extends Thread implements Bank {

	/**
	 * The bank accounts associated to their numbers.
	 */
	private Map<Integer,Account> accounts;
	/**
	 * The last account number.
	 */
	private int lastAccountNr;
	/**
	 * Value to compare double to zero.
	 */
	//private final double EPSILON = Math.ulp(1.0);
	//** The interest period (in milliseconds). */
	private static long INTEREST_PERIOD = 5000;
	/**
	 * The name of the data file.
	 */
	private static String DATA_FILE = "C:/Temp/BankImpl.data";

	public BankImpl() {
		Paths.get(DATA_FILE).getParent().toFile().mkdirs();
		loadData();
		setDaemon(true);
		start();
	}

	/**
	 * Closes an account.
	 * 
	 * @param nr the account number
	 * @param pin the PIN of the account
	 * @throws BankException if the account does not exist or the amount could not be deposited
	 */
	public void closeAccount(int nr, String pin) throws BankException {
		Account account = findAccount(nr);
		account.checkPIN(pin);
		// It souldn't be possible to close Accounts with money on it...
		// if (account.getBalance() >= 0 - EPSILON && account.getBalance() <= 0 +
		// EPSILON)
		accounts.remove(nr);
		saveData();
	}

	/**
	 * Deposits money into an account.
	 * 
	 * @param nr the account number
	 * @param amount the amount of money to deposit
	 * @throws BankException if the account does not exist or the amount could not be deposited
	 */
	public void deposit(int nr, double amount) throws BankException {
		Account account = findAccount(nr);
		if (account == null)
			throw new BankException("Account does not exist");
		account.deposit(amount);
		saveData();
	}

	/**
	 * Finds an account.
	 * 
	 * @param nr the account number
	 * @return the account, or null if the account does not exist
	 * @throws BankException if the account does not exist
	 */
	private Account findAccount(int nr) throws BankException {
		Account account = accounts.get(nr);
		if (account != null)
			return account;
		throw new BankException("Account does not exist");
	}

	/**
	 * Gets the bank accounts.
	 * 
	 * @return the bank accounts
	 */
	public List<Account> getAccounts() {
		return new ArrayList<Account>(accounts.values());
	}

	/**
	 * Gets the balance of an account.
	 * 
	 * @param nr the account number
	 * @param pin the PIN of the account
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
	 * @param type the account type
	 * @param pin the PIN of the account
	 * @param balance the initial balance
	 * @return the account number
	 */
	public int openAccount(AccountType type, String pin, double balance) {
		lastAccountNr += 1;
		if(type == AccountType.PERSONAL)
			accounts.put(lastAccountNr, new PersonalAccount(lastAccountNr, pin, balance));
		else if(type == AccountType.SAVINGS) {
			accounts.put(lastAccountNr, new SavingsAccount(lastAccountNr, pin, balance));
		} else {
			//this will never happen!!!
		}
		saveData();
		return lastAccountNr;
	}

	/**
	 * Withdraw money from an account.
	 * 
	 * @param nr the account number
	 * @param pin the PIN of the account
	 * @param amount the amount of money to withdraw
	 * @throws BankException if the account does not exist or the pin is invalid or the amount could not be withdrawn
	 */
	public void withdraw(int nr, String pin, double amount) throws BankException {
		Account account = findAccount(nr);
		if (account == null)
			throw new BankException("Account does not exist");
		account.checkPIN(pin);
		account.withdraw(amount);
		saveData();
	}
	

	/* (non-Javadoc)
	 * @see bankapp.bank.Bank#getTransactions(int, java.lang.String)
	 */
	public List<Transaction> getTransactions(int nr, String pin) throws BankException{
		Account account = findAccount(nr);
		account.checkPIN(pin);
		return account.getTransactions();

	}
	
	/**
	 * Loads the data of the bank from a file.
	 */
	@SuppressWarnings("unchecked")
	private void loadData() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_FILE))){
			//BankImpl restore = (BankImpl) in.readObject();
			lastAccountNr = in.readInt();
			accounts = (Map<Integer, Account>) in.readObject();
			//this.accounts = restore.accounts;
			//this.lastAccountNr = restore.lastAccountNr;
		} catch (IOException | ClassNotFoundException e) {
			lastAccountNr = 0;
			accounts = new HashMap<Integer,Account>();
		}
	}
	
	/**
	 * Saves the data of the bank to a file.
	 */
	private synchronized void saveData() {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE))){
			//out.writeObject(this);
			out.writeInt(lastAccountNr);
			out.writeObject(accounts);
		} catch (IOException e) {
			// Nothing to do here...
		}
	}
	
	/**
	 * Periodically pays interests to the bank accounts.
	 */
	@Override
	public void run() {
		try {
			while(!interrupted()) {
				Thread.sleep(INTEREST_PERIOD);
				System.out.println("Paying interests");
				Iterator<Entry<Integer, Account>> iter = accounts.entrySet().iterator();
				while (iter.hasNext()) {
					iter.next().getValue().payInterests();
				}
				saveData();
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
