package test;

import java.util.concurrent.*;

public class ExecutorServiceTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);

//        Callable<Integer> task = () -> {
//            Thread.sleep(3000);
//            return 67;
//        };
//        Callable<Integer> task2 = () -> {
//            Thread.sleep(4000);
//            return 101;
//        };
//        Future<Integer> future = executorService.submit(task);
//        Future<Integer> future1 = executorService.submit(task2);

        completionService.submit(() -> {
            Thread.sleep(4000);
            return 67;
        });

        completionService.submit(() -> {
            Thread.sleep(3000);
            return 101;
        });
        try {
//            Integer result = future.get();
//            System.out.println(result);
//            Integer result1 = future1.get();
//            System.out.println(result1);

            for (int i = 0; i < 2; i++) {
                Future<Integer> completedFuture = completionService.take();
                System.out.println(completedFuture.get());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        executorService.shutdown();
    }
}
