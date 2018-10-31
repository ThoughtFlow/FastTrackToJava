package lab07.fin;


import lab07.fin.account.CheckingAccount;
import lab07.fin.account.NonSufficientFundsException;
import lab07.fin.account.SavingsAccount;
import lab07.fin.customer.Customer;

/**
 * This is the main program that exercises the classes in the lab.
 * 
 * @author Nick Maiorano
 * @version 1.0
 */
public class BankDemo {

	/**
	 * Main method that starts everything.
	 * 
	 * @param args Command line arguments - not used
	 */
	public static void main(String[] args) {

		// Test with null values
		try {
			new CheckingAccount(null);
		}
		catch (NullPointerException npe) {
			System.err.println(npe.getMessage());
		}
		
		// Test with null values
		try {
			new SavingsAccount(null);
		}
		catch (NullPointerException npe) {
			System.err.println(npe.getMessage());
		}
		
		// Test with null values
		try {
			new Customer(null, null, null);
		}
		catch (NullPointerException npe) {
			System.err.println(npe.getMessage());
		}
		
		try {
			Customer republicanCustomer = new Customer("Donald", "Trump", "123456789");
			Customer democraticCustomer = new Customer("Hillary", "Clinton", "234567890");
			CheckingAccount republicanAccount = new CheckingAccount(republicanCustomer);
			CheckingAccount democraticAccount = new CheckingAccount(democraticCustomer);

			republicanAccount.credit(10);
			democraticAccount.credit(10);
			
			republicanAccount.debit(1000);

			republicanAccount.transferTo(democraticAccount, 100);
		}
		catch (NonSufficientFundsException nsfe) {
			System.err.println(nsfe.getMessage());
		}
		catch (IllegalArgumentException | NullPointerException iae) {
			System.err.println(iae.getMessage());
		}
	}
}
