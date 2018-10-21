package lab03.init;

public class BankDemo {

	public static void main(String[] args) {
		CheckingAccount account1 = new CheckingAccount();
		CheckingAccount account2 = new CheckingAccount();
		
		account1.setBalance(10);
		account2.setBalance(10);
		
		account1.setBalance(account1.getBalance() + 10);
		account2.setBalance(account2.getBalance() - 10);
		
		System.out.println("Final balances are:");
		account1.printAccount();
		account2.printAccount();
	}
}
