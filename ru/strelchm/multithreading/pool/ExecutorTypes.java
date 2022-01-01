package ru.strelchm.multithreading.pool;

import java.util.concurrent.*;

public class ExecutorTypes {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Execute test...");
        executeTest();

        Thread.sleep(2000L);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Submit test...");
        submitTest();

        Thread.sleep(2000L);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Submit test...");
        submitWithCallableTest();
    }

    private static void submitWithCallableTest() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> future = executorService.submit((Callable) () -> {
            Thread.sleep(10000L);
            System.out.println("Async [submit with callable] task...");
            return "Thread result";
        });
        System.out.println("future.get() = " + future.get());
        executorService.shutdown();
    }

    private static void submitTest() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future future = executorService.submit(() -> {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Async [submit] task...");
//            throw new RuntimeException("Exception 4 get result...");
        });
        System.out.println("future.get() = " + future.get()); // null if task is ended successfully
        executorService.shutdown();
    }

    private static void executeTest() {
        System.out.println("newSingleThreadExecutor");
        executeTest(Executors.newSingleThreadExecutor()); // 1 thread
        System.out.println("newFixedThreadPool");
        executeTest(Executors.newFixedThreadPool(10)); // 10 - fixed size
        System.out.println("newCachedThreadPool");
        executeTest(Executors.newCachedThreadPool()); // dynamic resizing...
    }

    private static void executeTest(ExecutorService executorService) {
        executorService.execute(() -> System.out.println("Async task..."));
        executorService.shutdown();
    }
}
