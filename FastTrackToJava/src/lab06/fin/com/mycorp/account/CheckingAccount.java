package lab06.fin.com.mycorp.account;

import lab06.fin.com.mycorp.customer.Customer;

/**
 * This class models the checking account. It also acts as a base class for other types of accounts. 
 * 
 * @author Nick Maiorano
 * @version 1.0
 */
public class CheckingAccount {

	private static final String ACCOUNT_TYPE = "Checking";
	private static int nextNumber = 0;

	private final String accountType;
	private final Customer customer;
	private final int number;
	
	private double balance = 0;

	/**
	 * This constructor calls the protected constructor where all the initialization is centralized.
	 * 
	 * @param customer The customer attached to this checking account.
	 * @param initialBalance The initial balance to give to the account.
	 */
	public CheckingAccount(Customer customer, double initialBalance) {
		this(customer, initialBalance, ACCOUNT_TYPE);
	}
	
	/**
	 * Overloaded constructor to create a checking account with zero balance.
	 * 
	 * @param customer The customer attached to this checking account.
	 */
	public CheckingAccount(Customer customer) {
		this(customer, 0);
	}
	
	/**
	 * Central constructor that set the account type. Can only be called by this class or subclasses.
	 * 
	 * @param customer The customer attached to this checking account.
	 * @param initialBalance The initial balance to give to the account.
	 * @param accountType The type of account.
	 */
	protected CheckingAccount(Customer customer, double initialBalance, String accountType) {
		number = ++nextNumber;
		this.customer = customer;
		balance = initialBalance;
		this.accountType = accountType;
	}
	
	/**
	 * Overloaded constructor to create a checking account with zero balance.
	 * 
	 * @param customer The customer attached to this checking account.
	 * @param accountType The type of account.
	 */
	protected CheckingAccount(Customer customer, String accountType) {
		this(customer, 0, accountType);
	}
	
	/**
	 * Adds the given amount to the account's balance.
	 * 
	 * @param amountToCredit The amount to credit.
	 * @return The new balance.
	 */
	public double credit(double amountToCredit) {
		balance += amountToCredit;
		return balance;
	}
	
	/**
	 * Subtracts the given amount to the account's balance.
	 * 
	 * @param amountToDebit The amount to subtract.
	 * @return The new balance.
	 */
	public double debit(double amountToDebit) {
		balance -= amountToDebit;
		return balance;
	}
	
	/**
	 * Transfers the amount from this account to the given account.
	 * 
	 * @param targetAccount The account to which to transfer the amount.
	 * @param amount The amount to transfer.
	 */
	public void transferTo(CheckingAccount targetAccount, double amount) {
		debit(amount);
		targetAccount.credit(amount);
	}
	
	/**
	 * Returns the account number.
	 * 
	 * @return The account number.
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Returns the balance.
	 * 
	 * @return The balance.
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Returns the account type.
	 * 
	 * @return The account type.
	 */
	public final String getAccountType() {
		return accountType;
	}

	/**
	 * Returns the customer object.
	 * 
	 * @return The customer.
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * {@inheritDoc} 
	 * 
	 * Additional comments go here.
	 */
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

	/**
	 * {@inheritDoc} 
	 * 
	 * Additional comments go here.
	 */
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

	/**
	 * {@inheritDoc} 
	 * 
	 * Additional comments go here.
	 */
	@Override
	public String toString() {
		return "CheckingAccount [customer=" + customer + ", number=" + number + ", balance=" + balance + "]";
	}
}
