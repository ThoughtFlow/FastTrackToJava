package lab22.init.account;


import lab22.init.customer.Customer;

/**
 * This class represents the Savings account. It is derived from CheckingAccount.
 * 
 * @author Nick Maiorano
 * @version 1.0
 */
public class SavingsAccount extends CheckingAccount {

	private static final String ACCOUNT_TYPE = "Savings";
	private static double annualInterestRate;
	
	/**
	 * Creates an instance with a given customer and balance. Sets the account type to "Savings".
	 * 
	 * @param customer The customer attached to this account.
	 * @param balance The initial balance.
	 * @throws NullPointerException Thrown if customer is null.
	 */
	public SavingsAccount(Customer customer, double balance) throws NullPointerException {
		super(customer, balance, ACCOUNT_TYPE);
	}
	
	/**
	 * Creates an instance with a given customer and zero balance. Sets the account type to "Savings".
	 * 
	 * @param customer The customer attached to this account.
	 * @throws NullPointerException Thrown if customer is null.
	 */
	public SavingsAccount(Customer customer) throws NullPointerException {
		super(customer, ACCOUNT_TYPE);
	}

	/**
	 * Sets the interest rate.
	 * 
	 * @param annualInterestRate Rate to set.
	 */
	public static void setAnnualInterestRate(double annualInterestRate) {
		SavingsAccount.annualInterestRate = annualInterestRate;
	}
	
	/**
	 * Credits the account with the interest accrued. 
	 */
	public void creditInterest() {
		double interest = getBalance() * annualInterestRate / 12;
		credit(interest);
	}

	/**
	 * {@inheritDoc} 
	 * 
	 * Additional comments go here.
	 */
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	/**
	 * {@inheritDoc} 
	 * 
	 * Additional comments go here.
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * {@inheritDoc} 
	 * 
	 * Additional comments go here.
	 */
	@Override
	public String toString() {
		return "SavingsAccount [Customer=" + getCustomer() + " Number=" + getNumber() + ", Balance()=" + getBalance() + "]";
	}
}