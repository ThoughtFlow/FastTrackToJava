package lab07.fin.account;


import lab07.fin.customer.Customer;

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
	 * @throws NullPointerException Thrown if customer is null.
	 */
	public CheckingAccount(Customer customer, double initialBalance) throws NullPointerException {
		this(customer, initialBalance, ACCOUNT_TYPE);
	}
	
	/**
	 * Overloaded constructor to create a checking account with zero balance.
	 * 
	 * @param customer The customer attached to this checking account.
	 * @throws NullPointerException Thrown if customer is null.
	 */
	public CheckingAccount(Customer customer) throws NullPointerException {
		this(customer, 0);
	}
	
	/**
	 * Central constructor that set the account type. Can only be called by this class or subclasses.
	 * 
	 * @param customer The customer attached to this checking account.
	 * @param initialBalance The initial balance to give to the account.
	 * @param accountType The type of account.
	 * @throws NullPointerException Thrown if customer is null.
	 */
	protected CheckingAccount(Customer customer, double initialBalance, String accountType) throws NullPointerException {
		if (customer != null) {
			number = ++nextNumber;
			this.customer = customer;
			balance = initialBalance;
			this.accountType = accountType;
		}
		else {
			throw new NullPointerException("Customer cannot be null");
		}
	}
	
	/**
	 * Overloaded constructor to create a checking account with zero balance.
	 * 
	 * @param customer The customer attached to this checking account.
	 * @param accountType The type of account.
	 * @throws NullPointerException Thrown if customer is null.
	 */
	protected CheckingAccount(Customer customer, String accountType) throws NullPointerException {
		this(customer, 0, accountType);
	}
	
	/**
	 * Adds the given amount to the account's balance.
	 * 
	 * @param amountToCredit The amount to credit.
	 * @return The new balance.
	 * @throws IllegalArgumentException if amountToCredit is less than 0.
	 */
	public double credit(double amountToCredit) throws IllegalArgumentException {
		if (amountToCredit >= 0) {
		   balance += amountToCredit;
		   return balance;
		}
		else
		{
			throw new IllegalArgumentException("Amount must be positive. Received: " + amountToCredit);
		}
	}
	
	/**
	 * Subtracts the given amount to the account's balance.
	 * 
	 * @param amountToDebit The amount to subtract.
	 * @return The new balance.
	 * @throws IllegalArgumentException if amountToDebit is less than 0.
	 * @throws NonSufficientFundsException If the amountToDebit is greater than the balance.
	 */
	public double debit(double amountToDebit) throws IllegalArgumentException, NonSufficientFundsException {
		if (amountToDebit >= 0) {
			if (amountToDebit <= balance) {
				balance -= amountToDebit;
				return balance;
			}
			else
			{
				throw new NonSufficientFundsException(balance, amountToDebit);
			}
		}
		else
		{
			throw new IllegalArgumentException("Amount must be positive. Received: " + amountToDebit);
		}
	}
	
	/**
	 * Transfers the amount from this account to the given account.
	 * 
	 * @param targetAccount The account to which to transfer the amount.
	 * @param amount The amount to transfer.
	 * @throws IllegalArgumentException if amount is less than 0.
	 * @throws NullPointerException If the target account is blank. You wouldn't normally declare NullPointerException on the method as this can happen for any method.
	 * @throws NonSufficientFundsException If the amountToDebit is greater than the balance.
	 */
	public void transferTo(CheckingAccount targetAccount, double amount) throws IllegalArgumentException, NullPointerException, NonSufficientFundsException {
		if (targetAccount != null) {
		   debit(amount);
		   targetAccount.credit(amount);
		}
		else
		{
			throw new NullPointerException("TargetAccount cannot be null");
		}
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
