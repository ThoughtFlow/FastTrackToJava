package chap22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class TestMiscFeatures {

    @Disabled
    public void testDisabled() {
        // This test is disabled
        assertTrue(true);
    }

    @Test
    public void testTimeout() throws InterruptedException {
        Assertions.assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(10));
    }

    @Test
    public void testAssertAll() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        assertAll("List is not incremental",
                () -> Assertions.assertEquals(list.get(0).intValue(), 1),
                () -> Assertions.assertEquals(list.get(1).intValue(), 2),
                () -> Assertions.assertEquals(list.get(2).intValue(), 3));
    }

    @Test
    public void testWithEnvwhenEnvironment() {
        assumingThat(System.getenv("JAVA_HOME") != null,
                () -> {
                    // Only check if the environment variable has been set
                    assertTrue("/Library/Java/JavaVirtualMachines/jdk-11.jdk/Contents/Home".equals(System.getenv("JAVA_HOME")));
                });
    }
}