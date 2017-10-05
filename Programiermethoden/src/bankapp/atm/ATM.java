package bankapp.atm;

import java.util.ArrayList;
import java.util.Scanner;

import bankapp.account.Account;
import bankapp.bank.AccountType;
import bankapp.bank.Bank;

/**
 * The class ATM implements the user interface of an automated teller machine.
 * 
 * @author Samuel Pulfer
 *
 */
public class ATM {
	/**
	 * The bank to which the ATM is connected.
	 */
	private Bank bank;
	/**
	 * The scanner used to read the console input.
	 */
	private Scanner scanner;

	/**
	 * Construct an automated teller machine.
	 * 
	 * @param bank
	 *            - the bank to which the ATM is connected
	 */
	public ATM(Bank bank) {
		this.bank = bank;
	}

	/**
	 * Closes a bank account.
	 */
	private void closeAccount() {
		System.out.println("\n\n\n\n\n");
		System.out.println("Enter your Account Nr.");
		int accountnr;
		while(true) {
			String nr = scanner.nextLine();
			try {
				accountnr = Integer.parseInt(nr);
				break;
			} catch (NumberFormatException e) {
				System.out.println("This wasn't a number...\n Try again!");
			}
		}
		System.out.println("Enter your PIN");
		String pin = scanner.nextLine();
		System.out.println("Are you sure you want to close the account with number: " + accountnr + " ?\n (yes/no)");
		if (scanner.nextLine().equals("yes")) {
			if (!bank.closeAccount(accountnr, pin))
				System.out.println("An error occurred...");
		} else {
			System.out.println("Abort operation");
		}
	}

	/**
	 * Deposits money to a bank account.
	 */
	private void deposit() {
		System.out.println("\n\n\n\n\n");
		System.out.println("Enter your Account Nr.");
		int accountnr;
		while(true) {
			String nr = scanner.nextLine();
			try {
				accountnr = Integer.parseInt(nr);
				break;
			} catch (NumberFormatException e) {
				System.out.println("This wasn't a number...\n Try again!");
			}
		}
		System.out.println("Enter the money you like to deposit");
		double money;
		while(true) {
			String moneystring = scanner.nextLine();
			try {
				money = Double.parseDouble(moneystring);
				break;
			} catch (NumberFormatException e) {
				System.out.println("This wasn't a double...\n Try again!");
			}
		}
		if (bank.deposit(accountnr, money) == false) {
			System.out.println("Account not available");
		}

	}

	/**
	 * Withdraws money from a bank account.
	 */
	private void withdraw() {
		System.out.println("\n\n\n\n\n");
		System.out.println("Enter your Account Nr.");
		int accountnr;
		while(true) {
			String nr = scanner.nextLine();
			try {
				accountnr = Integer.parseInt(nr);
				break;
			} catch (NumberFormatException e) {
				System.out.println("This wasn't a number...\n Try again!");
			}
		}
		System.out.println("Enter your PIN");
		String pin = scanner.nextLine();
		System.out.println("Enter the money you like to withdraw");
		double money;
		while(true) {
			String moneystring = scanner.nextLine();
			try {
				money = Double.parseDouble(moneystring);
				break;
			} catch (NumberFormatException e) {
				System.out.println("This wasn't a double...\n Try again!");
			}
		}
		if (bank.withdraw(accountnr, pin, money) == false) {
			System.out.println("Account not available, wrong pin or withdraw limit reached");
		}
	}

	/**
	 * Gets the balance of a bank account.
	 */
	private void getBalance() {
		System.out.println("\n\n\n\n\n");
		System.out.println("Enter your Account Nr.");
		int accountnr;
		while(true) {
			String nr = scanner.nextLine();
			try {
				accountnr = Integer.parseInt(nr);
				break;
			} catch (NumberFormatException e) {
				System.out.println("This wasn't a number...\n Try again!");
			}
		}
		System.out.println("Enter your PIN");
		String pin = scanner.nextLine();
		Double balance = bank.getBalance(accountnr, pin);
		if (balance == null) {
			System.out.println("Account not available or wrong pin");
		} else {
			System.out.println("Your current balance: " + balance);
		}
	}

	/**
	 * Lists the bank accounts.
	 */
	private void listAccounts() {
		System.out.println("\n\n\n\n\n");
		ArrayList<Account> accounts = bank.getAccounts();
		if (accounts.size() == 0)
			System.out.println("Currently no accounts available");
		for (Account account : accounts) {
			System.out.println(account.toString());
		}

	}

	/**
	 * Opens a bank account.
	 */
	private void openAccount() {
		System.out.println("\n\n\n\n\n");
		System.out.println("Please choose your account type");
		System.out.println("personal - Personal account");
		System.out.println("savings - Savings account");
		String acctype = scanner.nextLine();
		if (acctype.equals("personal")) {
			System.out.println("Please enter a PIN for your new Account");
			String pin = scanner.nextLine();
			System.out.println("Your new account number: " + bank.openAccount(AccountType.PERSONAL, pin, 0));
		} else if (acctype.equals("savings")) {
			System.out.println("Please enter a PIN for your new Account");
			String pin = scanner.nextLine();
			System.out.println("Your new account number: " + bank.openAccount(AccountType.SAVINGS, pin, 0));
		} else
			System.out.println("Unknown account type.\nAborting...");
	}

	/**
	 * Displays a menu of possible bank transactions and executes the selected
	 * transactions.
	 */
	public void run() {
		boolean quit = false;
		scanner = new Scanner(System.in);
		while (quit == false) {
			while (true) {
				System.out.println("\n\n\n\n\n");
				System.out.println("What would you like to do?");
				System.out.println("list - lists all Accounts");
				System.out.println("open - opens an Account");
				System.out.println("close - close an Account");
				System.out.println("check - check the balance of your Account");
				System.out.println("deposit - deposit money");
				System.out.println("withdraw - withdraw money");
				System.out.println("quit - Shutdown the ATM");
				String input = scanner.nextLine();
				if (input.equals("quit")) {
					quit = true;
					break;
				} else if (input.equals("list"))
					listAccounts();
				else if (input.equals("open"))
					openAccount();
				else if (input.equals("close"))
					closeAccount();
				else if (input.equals("check"))
					getBalance();
				else if (input.equals("deposit"))
					deposit();
				else if (input.equals("withdraw"))
					withdraw();
				else {
					System.out.println("No valid input");
					break;
				}
			}
		}
		scanner.close();
	}
}
