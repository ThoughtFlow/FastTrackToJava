package lab22.fin.account;

import lab22.fin.customer.Customer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSavingsAccount {

    private Customer testCustomer;

    @BeforeAll
    public static void setupBeforeAll() {
        SavingsAccount.setAnnualInterestRate(.10);
    }

    @BeforeEach
    public void setupBeforeEach() {
        testCustomer = new Customer("First", "Last", "123456789");
    }

    @Test
    public void testCreation() {
        SavingsAccount account = new SavingsAccount(testCustomer, 10);


        assertEquals(10, account.getBalance());
        assertEquals("Savings", account.getAccountType());
        assertEquals(testCustomer, account.getCustomer());

        SavingsAccount account2 = new SavingsAccount(testCustomer);
        assertEquals(0, account2.getBalance());
    }

    @Test
    public void testInteraction() {
        SavingsAccount account = new SavingsAccount(testCustomer, 10);

        account.creditInterest();
        // Round off
        double newBalance = (int) (account.getBalance() * 100);
        assertEquals(10.08, newBalance / 100);
    }

    @Test
    public void testBadCreation() {
        try {
            new SavingsAccount(null, 10);
            fail("Should have thrown an exception");
        }
        catch (Throwable e) {
            assertEquals(e.getClass(), NullPointerException.class);
        }

        try {
            new SavingsAccount(null);
            fail("Should have thrown an exception");
        }
        catch (Throwable e) {
            assertEquals(e.getClass(), NullPointerException.class);
        }
    }

    @Test
    public void testEquality() {
        SavingsAccount account1 = new SavingsAccount(testCustomer, 10);
        SavingsAccount account2 = new SavingsAccount(testCustomer, 20);

        assertEquals(account1, account1);
        assertNotEquals(account1, account2);
        assertNotEquals(account1, testCustomer);
        assertNotEquals(null, account1);
    }
}
