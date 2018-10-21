package lab05.init;

public class BankDemo {

	public static void main(String[] args) {
		Customer republicanCustomer = new Customer("Donald", "Trump", "123456789");
		Customer democraticCustomer = new Customer("Hillary", "Clinton", "234567890");
		CheckingAccount republicanAccount = new CheckingAccount(republicanCustomer);
		CheckingAccount democraticAccount = new CheckingAccount(democraticCustomer);
		
		republicanAccount.credit(10);
		democraticAccount.credit(10);
		
		republicanAccount.transferTo(democraticAccount, 10);
		
		System.out.println("Final balances are:");
		republicanAccount.printAccount();
		democraticAccount.printAccount();
	}
}
