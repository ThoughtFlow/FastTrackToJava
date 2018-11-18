package lab22.fin.customer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testCreation() {
        Customer customer = new Customer("First", "Last", "ssn#");

        assertEquals("First", customer.getFirstName());
        assertEquals("Last", customer.getLastName());
        assertEquals("ssn#", customer.getSsn());
    }

    @Test
    public void testEquality() {
        Customer customer = new Customer("First", "Last", "ssn#");
        Customer customer2 = new Customer("Second", "Last", "ssn#");
        Customer customer3 = new Customer("First", "Last", "ssn#");

        assertNotEquals(customer, customer2);
        assertEquals(customer, customer3);
        assertEquals(customer, customer);
        assertNotEquals(customer, null);
        assertNotEquals(customer, "String");

    }

    @Test
    public void testBadCreation() {
        assertThrows(NullPointerException.class, () -> new Customer(null, "Last", "ssn#"));
        assertThrows(NullPointerException.class, () -> new Customer("First", null, "ssn#"));
        assertThrows(NullPointerException.class, () -> new Customer("First", "Last", null));
    }
}
