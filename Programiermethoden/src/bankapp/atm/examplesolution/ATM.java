package bankapp.atm.examplesolution;

import java.util.List;
import java.util.Scanner;

import bankapp.account.Account;
import bankapp.atm.AccountComparator;
import bankapp.bank.AccountType;
import bankapp.bank.Bank;
import bankapp.bank.BankException;

/**
 * The class ATM implements the user interface of an automated teller machine.
 */
public class ATM {

	/** The bank to which the ATM is connected. */
	private Bank bank;

	/** The scanner used to read the console input. */
	private Scanner scanner = new Scanner(System.in);

	/**
	 * Construct an automated teller machine.
	 *
	 * @param bank the bank to which the ATM is connected
	 */
	public ATM(Bank bank) {
		this.bank = bank;
	}

	/**
	 * Displays a menu of possible bank transactions and executes the selected transactions.
	 */
	public void run() {
		while (true) {
			System.out.println("   A   TTTTTTT M     M");
			System.out.println("  A A     T    MM   MM");
			System.out.println(" AAAAA    T    M M M M");
			System.out.println("A     A   T    M  M  M");
			System.out.println();
			System.out.println("A  Open Account");
			System.out.println("B  Get Balance");
			System.out.println("C  Deposit");
			System.out.println("D  Withdraw");
			System.out.println("E  Close Account");
			System.out.println("X  Exit");
			System.out.println();
			System.out.print("> ");
			String choice = scanner.nextLine().toUpperCase();
			try {
				switch (choice) {
				case "A":
					openAccount();
					break;
				case "B":
					getBalance();
					break;
				case "C":
					deposit();
					break;
				case "D":
					withdraw();
					break;
				case "E":
					closeAccount();
					break;
				case "X":
					listAccounts();
					System.exit(0);
				default:
					System.out.println("Invalid input");
				}
			} catch (BankException ex) {
				System.out.println("Error: " + ex.getMessage());
			} catch (NumberFormatException ex) {
				System.out.println("Invalid amount");
			} catch (RuntimeException ex) {
				System.out.println("Unexpected system error");
			}
			System.out.println("Hit Enter to continue...");
			scanner.nextLine();
		}
	}

	/**
	 * Opens a bank account.
	 */
	private void openAccount() {
		System.out.print("Type (Personal/Savings): ");
		char type = scanner.nextLine().toUpperCase().charAt(0);
		System.out.print("PIN: ");
		String pin = scanner.nextLine();
		int nr;
		if (type == 'P')
			nr = bank.openAccount(AccountType.PERSONAL, pin, 0.0);
		else if (type == 'S')
			nr = bank.openAccount(AccountType.SAVINGS, pin, 0.0);
		else {
			System.out.println("Invalid account type");
			return;
		}
		System.out.println("Account with number " + nr + " opened");
	}

	/**
	 * Gets the balance of a bank account.
	 */
	private void getBalance() throws BankException {
		System.out.print("Account Nr: ");
		int nr = Integer.parseInt(scanner.nextLine());
		System.out.print("PIN: ");
		String pin = scanner.nextLine();
		double balance = bank.getBalance(nr, pin);
		System.out.println("Balance is " + balance);
	}

	/**
	 * Deposits money to a bank account.
	 */
	private void deposit() throws BankException {
		System.out.print("Account Nr: ");
		int nr = Integer.parseInt(scanner.nextLine());
		System.out.print("Amount: ");
		double amount = Double.parseDouble(scanner.nextLine());
		bank.deposit(nr, amount);
		System.out.println("Amount deposited");
	}

	/**
	 * Withdraws money from a bank account.
	 */
	private void withdraw() throws BankException {
		System.out.print("Account Nr: ");
		int nr = Integer.parseInt(scanner.nextLine());
		System.out.print("PIN: ");
		String pin = scanner.nextLine();
		System.out.print("Amount: ");
		double amount = Double.parseDouble(scanner.nextLine());
		bank.withdraw(nr, pin, amount);
		System.out.println("Amount withdrawn");
	}

	/**
	 * Closes a bank account.
	 */
	private void closeAccount() throws BankException {
		System.out.print("Account Nr: ");
		int nr = Integer.parseInt(scanner.nextLine());
		System.out.print("PIN: ");
		String pin = scanner.nextLine();
		bank.closeAccount(nr, pin);
		System.out.println("Account closed");
	}

	/**
	 * Lists the bank accounts.
	 */
	private void listAccounts() {
		List<Account> accounts = bank.getAccounts();
		accounts.sort(new AccountComparator());
		System.out.format("%-10s%-4s%12s\n", "Type", "Nr", "Balance");
		for (Account account : accounts)
			System.out.format("%-10s%-4d%+12.2f\n", account.getType(), account.getNr(), account.getBalance());
	}
}
