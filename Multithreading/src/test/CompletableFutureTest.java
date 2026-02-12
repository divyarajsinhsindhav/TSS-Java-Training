package test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class CompletableFutureTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5,
                new ThreadFactory() {
                    private int count = 1;

                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        t.setName("my-executor-" + count++);
                        return t;
                    }
                });

//        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> {
//            System.out.println(Thread.currentThread().getName());
//            return 10;
//        }, executorService);
//
//        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
//            System.out.println(Thread.currentThread().getName());
//            return 20;
//        }, executorService);
//
//        CompletableFuture<Void> result =
//                cf.thenCombineAsync(cf1,
//                                (a, b) -> {
//                                    System.out.println(Thread.currentThread().getName());
//                                    return a + b;
//                                },
//                                executorService)
//                        .thenAcceptAsync(sum ->
//                                {
//                                    System.out.println(Thread.currentThread().getName());
//                                    System.out.println(sum);
//                                },
//                                executorService);
//        executorService.shutdown();

        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> 10, executorService);
        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> 20, executorService);

        CompletableFuture<Object> fastest =
                CompletableFuture.anyOf(f1, f2);

        System.out.println(fastest.join());

        executorService.shutdown();
    }
}
