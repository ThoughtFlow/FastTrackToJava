package lab05.init;

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
	
	public String getAccountType() {
		return ACCOUNT_TYPE;
	}
	public void creditInterest() {
		double interest = getBalance() * annualInterestRate / 12;
		credit(interest);
	}
}
