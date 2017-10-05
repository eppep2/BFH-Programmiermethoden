package bankapp;

import bankapp.account.PersonalAccount;
import bankapp.atm.ATM;
import bankapp.bank.AccountType;
import bankapp.bank.BankImpl;

public class Main {
	
	/**
	 * Erzeugt ein Bankkonto, zahlt Geldbetrag ein, hebt Geldbetrag ab und gibt Kontostand aus.
	 */
	public static void bank1() {
		// Create Account
		PersonalAccount account = new PersonalAccount(42,"1234", 0);
		// Deposit 100
		account.deposit(100);
		// Withdraw 50
		account.withdraw(50);
		// print Balance
		System.out.println("Balance: " + account.getBalance());
	}
	
	/**
	 * Erzeugt Bank-Objekt, eröffnet Bankkonto, zahlt Geldbetrag ein, hebt Geldbetrag ab, gibt Kontostand aus und schliesst Konto.
	 */
	public static void bank2() {
		// Create Bank
		BankImpl bank = new BankImpl();
		// Open Account
		int accountnr = bank.openAccount(AccountType.PERSONAL,"1234", 0);
		// Deposit 100
		bank.deposit(accountnr, 100);
		// Withdraw 50
		bank.withdraw(accountnr, "1234", 50);
		// print Balance
		System.out.println("Balance: " + bank.getBalance(accountnr, "1234"));
		// Close Account
		bank.closeAccount(accountnr, "1234");
	}
	/**
	 * Startet den ATM
	 */
	public static void bank3() {
		BankImpl bank = new BankImpl();
		ATM atm = new ATM(bank);
		atm.run();
	}

	public static void main(String[] args) {
		bank3();

	}

}
