package lab20.fin.com.mycorp.account;

import lab20.fin.com.mycorp.customer.Customer;

/**
 * Using the name mycorp.com as the fictitious company name (Lab06 as the prefix is only to store these files under
 * the lab structure. Normal practice is to use com.companyname.)
 */
public class CheckingAccount {

	private static final String ACCOUNT_TYPE = "Checking";
	private static int nextNumber = 0;

	private final String accountType;
	private final Customer customer;
	private final int number;
	
	private double balance = 0;

	// This constructor now calls the protected constructor where all the initialization is centralized
	public CheckingAccount(Customer customer, double initialBalance) {
		this(customer, initialBalance, ACCOUNT_TYPE);
	}
	
	// This constructor now calls the protected constructor where all the initialization is centralized
	public CheckingAccount(Customer customer) {
		this(customer, 0);
	}
	
	// Central constructor that set the account type. Can only be called by this class or subclasses.
	protected CheckingAccount(Customer customer, double initialBalance, String accountType) {
		number = ++nextNumber;
		this.customer = customer;
		balance = initialBalance;
		this.accountType = accountType;
	}
	
	// This constructor can only be called by this class or subclass.
	protected CheckingAccount(Customer customer, String accountType) {
		this(customer, 0, accountType);
	}
	
	public double credit(double amountToCredit) {
		balance += amountToCredit;
		return balance;
	}
	
	public double debit(double amountToDebit) {
		balance -= amountToDebit;
		return balance;
	}
	
	public void transferTo(CheckingAccount targetAccount, double amount) {
		debit(amount);
		targetAccount.credit(amount);
	}
	
	public int getNumber() {
		return number;
	}

	public double getBalance() {
		return balance;
	}
	
	// This is now final so that subclasses can no longer override the method
	public final String getAccountType() {
		return accountType;
	}

	public Customer getCustomer() {
		return customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CheckingAccount other = (CheckingAccount) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (number != other.number)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CheckingAccount [customer=" + customer + ", number=" + number + ", balance=" + balance + "]";
	}
}
