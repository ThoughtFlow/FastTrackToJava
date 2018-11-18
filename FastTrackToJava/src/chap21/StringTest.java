package chap21;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// static import typically used
public class StringTest {

    @Test
    public void testLength() {
        String msg = "hello";
        assertEquals(5, msg.length());

        assertTrue(5 == msg.length()); // alternative assertion
    }
}