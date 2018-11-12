package lab20.init;

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

		// Apply annual interest
		for (int index = 0; index < 12; ++index) {
			for (CheckingAccount nextAccount : accounts) {
				if (nextAccount instanceof SavingsAccount) {
					((SavingsAccount) nextAccount).creditInterest();
				}
			}
		}

		System.out.println("Final balances are:");
		for (CheckingAccount nextAccount : accounts) {
			System.out.println(nextAccount);
			System.out.println("======");
		}
		
		// Test for equality
		SavingsAccount savingsAccount = new SavingsAccount(democraticCustomer);
		SavingsAccount savingsAccount2 = new SavingsAccount(democraticCustomer);
		CheckingAccount checkingAccount = new CheckingAccount(republicanCustomer);
		CheckingAccount checkingAccount2 = checkingAccount;
		System.out.println("Is republicanCustomer == democraticCustomer: " + (republicanCustomer == democraticCustomer));
		System.out.println("Is republicanCustomer equal democraticCustomer: " + (republicanCustomer.equals(democraticCustomer)));
		System.out.println("Is republicanCustomer equal republicanCustomer: " + (republicanCustomer.equals(republicanCustomer)));
		System.out.println("Is republicanCustomer equal savingsAccount: " + (republicanCustomer.equals(savingsAccount)));
		System.out.println("Is savingsAccount equal republicanCustomer: " + (savingsAccount.equals(savingsAccount2)));
		System.out.println("Is checkingAccount1 equal checkingAccount2: " + (checkingAccount.equals(checkingAccount2)));
	}
}
