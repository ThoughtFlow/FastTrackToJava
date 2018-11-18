package chap21;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CalculatorTest {

    @Test
    public void testSquareRootException() throws IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Calculator calc = new Calculator();

            // should trigger exception
            calc.squareRoot(-4.0);
        });
    }

    @Test
    public void testSquareRootExceptionVerified() {
        try {
            Calculator calc = new Calculator();
            calc.squareRoot(-4.0); // should throw IllegalArgumentException

            // if it doesn't, that's a problem – so fail the test
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // verify exceptions's message is correct
            assertEquals("No negatives: -4.0", e.getMessage());
        }
    }
}