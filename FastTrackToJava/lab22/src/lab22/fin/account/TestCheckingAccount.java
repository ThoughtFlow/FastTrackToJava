package lab22.fin.account;

import lab22.fin.customer.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCheckingAccount {

    private Customer testCustomer;

    @BeforeEach
    public void setup() {
        testCustomer = new Customer("First", "Last", "123456789");
    }

    @Test
    public void testCreation() {
        CheckingAccount account1 = new CheckingAccount(testCustomer, 10);


        assertEquals(1, account1.getNumber());
        assertEquals(10, account1.getBalance());
        assertEquals("Checking", account1.getAccountType());
        assertEquals(testCustomer, account1.getCustomer());

        CheckingAccount account2 = new CheckingAccount(testCustomer, 20);
        assertTrue(account2.getNumber() > account1.getNumber());

        CheckingAccount account3 = new CheckingAccount(testCustomer);
        assertEquals(0, account3.getBalance());

        CheckingAccount account4 = new CheckingAccount(testCustomer, 10, "NewType");
        assertEquals("NewType", account4.getAccountType());

        CheckingAccount account5 = new CheckingAccount(testCustomer, "NewType");
        assertEquals("NewType", account5.getAccountType());
        assertEquals(0, account5.getBalance());
    }

    @Test
    public void testInteraction() {
        CheckingAccount account1 = new CheckingAccount(testCustomer, 10);
        CheckingAccount account2 = new CheckingAccount(testCustomer, 20);

        account1.credit(10);
        assertEquals(20, account1.getBalance());

        try {
            account1.debit(5);
            assertEquals(15, account1.getBalance());
        }
        catch (NonSufficientFundsException e) {
            fail("Caught unexpected error: " + e.getMessage());
        }

        try {
            account1.debit(-1);
            fail("Should have thrown " + IllegalArgumentException.class.getName());
        }
        catch (IllegalArgumentException e) {
            assertEquals(15, account1.getBalance());
        }
        catch (NonSufficientFundsException e) {
            fail("Caught unexpected error: " + e.getMessage());
        }

        try {
            account1.debit(100)  ;
            fail("Should have thrown " + NonSufficientFundsException.class.getName());
        }
        catch (NonSufficientFundsException e) {
            // Expected error
            assertEquals(15, account1.getBalance());
        }

        try {
            account1.transferTo(account2, 10);
            assertEquals(5, account1.getBalance());
            assertEquals(30, account2.getBalance());
        }
        catch (NonSufficientFundsException e) {
            fail("Caught unexpected error: " + e.getMessage());
        }

        try {
            account1.transferTo(account2, -1);
            fail("Should have thrown " + IllegalArgumentException.class.getName());
        }
        catch (IllegalArgumentException e) {
            assertEquals(5, account1.getBalance());
            assertEquals(30, account2.getBalance());
        }
        catch (NonSufficientFundsException e) {
            fail("Caught unexpected error: " + e.getMessage());
        }

        try {
            account1.transferTo(account2, 100);
            fail("Should have thrown " + NonSufficientFundsException.class.getName());
        }
        catch (NonSufficientFundsException e) {
            assertEquals(5, account1.getBalance());
            assertEquals(30, account2.getBalance());
        }

    }

    @Test
    public void testBadCreation() {
        try {
            CheckingAccount account1 = new CheckingAccount(null, 10);
            fail("Should have thrown an exception");
        }
        catch (Throwable e) {
            assertEquals(e.getClass(), NullPointerException.class);
        }

        try {
            CheckingAccount account1 = new CheckingAccount(null);
            fail("Should have thrown an exception");
        }
        catch (Throwable e) {
            assertEquals(e.getClass(), NullPointerException.class);
        }

        try {
            CheckingAccount account1 = new CheckingAccount(null, 10d, "Checking");
            fail("Should have thrown an exception");
        }
        catch (Throwable e) {
            assertEquals(e.getClass(), NullPointerException.class);
        }

        try {
            CheckingAccount account1 = new CheckingAccount(null, "Checking");
            fail("Should have thrown an exception");
        }
        catch (Throwable e) {
            assertEquals(e.getClass(), NullPointerException.class);
        }
    }

    @Test
    public void testEquality() {
        CheckingAccount account1 = new CheckingAccount(testCustomer, 10);
        CheckingAccount account2 = new CheckingAccount(testCustomer, 20);

        assertTrue(account1.equals(account1));
        assertFalse(account1.equals(account2));
        assertFalse(account1.equals(testCustomer));
        assertFalse(account1.equals(null));
    }
}
