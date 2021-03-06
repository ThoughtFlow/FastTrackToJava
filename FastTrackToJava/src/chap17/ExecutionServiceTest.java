package chap17;

import java.util.concurrent.*;

public class ExecutionServiceTest {
    public static void main(String... args) {
        {
            ExecutorService service = Executors.newCachedThreadPool();
            service.submit(() -> {System.out.println("Running in a thread: " + Thread.currentThread().getName());});

            service.shutdown();
        }

        {
            ExecutorService service = Executors.newCachedThreadPool();
            Future<Integer> future = service.submit(() -> 1);

            try {
                Integer result = future.get();
                System.out.println("Getting result: " + result);
            } catch (InterruptedException | ExecutionException e) {
                // Deal with error...
            }

            service.shutdown();
        }

        {
            ExecutorService service = Executors.newCachedThreadPool();
            Future<Integer> future = service.submit(() -> 1);

            try {
                Integer result = future.get(10, TimeUnit.SECONDS);
                System.out.println("Getting result: " + result);
            } catch (InterruptedException | TimeoutException | ExecutionException e) {
                // Deal with error...
            }

            service.shutdown();
        }
    }
}
