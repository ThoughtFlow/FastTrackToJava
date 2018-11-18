package chap21;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTestWithFixtures {
    private String msg;

    @BeforeEach
    public void setup() {
        msg = "hello";
    }

    @AfterEach
    public void tearDown() {
        // Some code to release resources
        System.out.println("Shared resources torn down");
    }

    @Test
    public void testLength() {
        assertEquals(5, msg.length());
    }

    @Test
    public void testSubstring() {
        assertEquals("he", msg.substring(0, 2));
    }
}