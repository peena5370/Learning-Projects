package com.learning.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ParallelStringAppend {

    // Number of iterations in the loop
    private static final int TOTAL_ITERATIONS = 1000;
    // Number of threads to use in the pool
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // 1. Create an ExecutorService (thread pool)
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        List<Future<String>> futures = new ArrayList<>();

        long startTime = System.nanoTime();

        // 2. Divide the work and submit tasks
        int chunkSize = TOTAL_ITERATIONS / NUM_THREADS;
        for (int i = 0; i < NUM_THREADS; i++) {
            Callable<String> task = getStringCallable(i, chunkSize);
            futures.add(executor.submit(task)); // Submit the task and get a Future
        }

        // 3. Collect and combine results in order
        StringBuilder finalResult = new StringBuilder();
        for (Future<String> future : futures) {
            // future.get() blocks until the corresponding task is complete
            // The order here matters for the final string's sequence
            finalResult.append(future.get());
        }

        long endTime = System.nanoTime();

        executor.shutdown(); // Important: Shut down the executor service
        executor.awaitTermination(1, TimeUnit.MINUTES); // Wait for tasks to complete

        System.out.println("Time taken: " + (endTime - startTime) / 1_000_000.0 + " ms");
        System.out.println("Final String length: " + finalResult.length());
        // System.out.println(finalResult.toString()); // Uncomment to see the full result
    }

    private static Callable<String> getStringCallable(int i, int chunkSize) {
        final int start = i * chunkSize;
        // Ensure the last chunk gets any remainder
        final int end = (i == NUM_THREADS - 1) ? TOTAL_ITERATIONS : (i + 1) * chunkSize;

        // Create a Callable task for each chunk
        Callable<String> task = () -> {
            StringBuilder localStringBuilder = new StringBuilder(); // Each thread has its own StringBuilder
            for (int j = start; j < end; j++) {
                localStringBuilder.append(Thread.currentThread().getName()).append("-").append(j).append("\n");
            }
            return localStringBuilder.toString(); // Return the partial string
        };
        return task;
    }
}
