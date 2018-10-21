package lab02.fin;

public class CheckingAccount {

	private static int nextNumber = 0;
	
	// Don't need to explicitly set the values as they default to 0 
	private int number = ++nextNumber;
	private double balance = 0;
	

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void printAccount() {
		System.out.println("Account: " + number);
		System.out.println("Balance: " + balance);
	}
}
