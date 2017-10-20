package bankapp.bank;

/**
 * The exception BankException is thrown if a bank error occurs.
 * 
 * @author Samuel Pulfer
 *
 */
public class BankException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a bank exception.
	 * @param message the error message
	 */
	public BankException(String message) {
		super(message);
	}
}
