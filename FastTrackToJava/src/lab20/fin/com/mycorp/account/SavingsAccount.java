package lab20.fin.com.mycorp.account;

import lab20.fin.com.mycorp.customer.Customer;

/**
 * Using the name mycorp.com as the fictitious company name (Lab06 as the prefix is only to store these files under
 *  * the lab structure. Normal practice is to use com.companyname.)
 *
 * This class no longer implements the getAccount.
 */
public class SavingsAccount extends CheckingAccount {

	private static final String ACCOUNT_TYPE = "Savings";
	private static double annualInterestRate;
	
	// Calls the protected constructor and set the account type.
	public SavingsAccount(Customer customer, double balance) {
		super(customer, balance, ACCOUNT_TYPE);
	}
	
	// Calls the protected constructor and set the account type.
	public SavingsAccount(Customer customer) {
		super(customer, ACCOUNT_TYPE);
	}
	
	// Could also have been package-private (default visibility) so that only classes within the lab06.com.mycorp.account package set this value. 
	public static void setAnnualInterestRate(double annualInterestRate) {
		SavingsAccount.annualInterestRate = annualInterestRate;
	}
	
	public void creditInterest() {
		double interest = getBalance() * annualInterestRate / 12;
		credit(interest);
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "SavingsAccount [Customer=" + getCustomer() + " Number=" + getNumber() + ", Balance()=" + getBalance() + "]";
	}
}