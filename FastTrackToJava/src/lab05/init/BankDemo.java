package lab05.init;

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
			nextAccount.printAccount();
			System.out.println("======");
		}
	}
}
