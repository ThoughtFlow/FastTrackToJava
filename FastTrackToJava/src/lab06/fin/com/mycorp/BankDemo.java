package lab06.fin.com.mycorp;


import lab06.fin.com.mycorp.account.CheckingAccount;
import lab06.fin.com.mycorp.account.SavingsAccount;
import lab06.fin.com.mycorp.customer.Customer;

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
		SavingsAccount.setAnnualInterestRate(0.02);
		Customer republicanCustomer = new Customer("Donald", "Trump", "123456789");
		Customer democraticCustomer = new Customer("Hillary", "Clinton", "234567890");

		CheckingAccount[] accounts = new CheckingAccount[10];
		for (int index = 0; index < 5; ++index) {
			accounts[index] = new CheckingAccount(republicanCustomer, 10);
		}

		for (int index = 5; index < accounts.length; ++index) {
			accounts[index] = new SavingsAccount(democraticCustomer, 10);
		}

		for (int index = 0; index < 12; ++index) {
			for (CheckingAccount nextAccount : accounts) {
				if (nextAccount.getAccountType().equals("Savings")) {
					((SavingsAccount) nextAccount).creditInterest();
				}
			}
		}

		System.out.println("Final balances are:");
		for (CheckingAccount nextAccount : accounts) {
			System.out.println(nextAccount);
			System.out.println("======");
		}
	}
}
