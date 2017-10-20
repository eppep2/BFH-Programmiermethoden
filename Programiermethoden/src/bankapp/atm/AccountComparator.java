package bankapp.atm;

import java.util.Comparator;

import bankapp.account.Account;

/**
 * The class AccountComparator is used to compare bank accounts.
 * @author Samuel Pulfer
 *
 */
public class AccountComparator implements Comparator<Account> {

	/**
	 * Compares two bank accounts regarding their balance.
	 * @param account1 the first account
	 * @param account2 the second account
	 * @return negative integer, zero, or a positive integer as the balance of the first account is less than, equal to, or greater than the balance of the second account
	 */
	@Override
	public int compare(Account account1, Account account2) {
		return Double.compare(account1.getBalance(), account2.getBalance());
	}

}
