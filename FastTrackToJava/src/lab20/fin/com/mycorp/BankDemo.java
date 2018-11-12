package lab20.fin.com.mycorp;

import lab20.fin.com.mycorp.account.CheckingAccount;
import lab20.fin.com.mycorp.account.SavingsAccount;
import lab20.fin.com.mycorp.customer.Customer;

/**
 * Using the name mycorp.com as the fictitious company name (Lab06 as the prefix is only to store these files under
 * the lab structure. Normal practice is to use com.companyname.)
 *
 * BankDemo is now in a separate package
 */
public class BankDemo {

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

		// Apply annual interest. Use the account type to determine whether or not to apply interest.
        // Could also be refactored to let the class itself decide whether or not to apply interest.
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
