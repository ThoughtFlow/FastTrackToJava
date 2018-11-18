package lab22.fin.account;

import lab22.fin.customer.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestNonSufficientFundsException {

    private Customer testCustomer;

    @Test
    public void testCreation() {
        NonSufficientFundsException exception = new NonSufficientFundsException(10, 20);


        assertEquals(10, exception.getAvailable());
        assertEquals(20, exception.getRequired());
        assertEquals(10, exception.getDifference());
    }
}
