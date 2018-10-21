package lab06.init.account;

import lab06.init.customer.Customer;

public class SavingsAccount extends CheckingAccount {

	private static final String ACCOUNT_TYPE = "Savings";
	private static double annualInterestRate;
	
	public SavingsAccount(Customer customer, double balance) {
		super(customer, balance);
	}
	
	public SavingsAccount(Customer customer) {
		super(customer);
	}

	public static void setAnnualInterestRate(double annualInterestRate) {
		SavingsAccount.annualInterestRate = annualInterestRate;
	}
	
	@Override
	public String getAccountType() {
		return ACCOUNT_TYPE;
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
