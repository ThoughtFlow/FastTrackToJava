package lab06.init.account;

import lab06.init.customer.Customer;

public class CheckingAccount {

	private static final String ACCOUNT_TYPE = "Checking";
	private static int nextNumber = 0;

	private final Customer customer;
	private final int number;
	private double balance = 0;

	public CheckingAccount(Customer customer, double initialBalance) {
		number = ++nextNumber;
		this.customer = customer;
		balance = initialBalance;
	}

	public CheckingAccount(Customer customer) {
		this(customer, 0);
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
	
	public String getAccountType() {
		return ACCOUNT_TYPE;
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
