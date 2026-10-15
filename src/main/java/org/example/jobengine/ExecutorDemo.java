package org.example.jobengine;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        runTenJobs();
        calculateSum();
    }

    private static void runTenJobs() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 10; i++) {
            int jobId = i;

            executor.submit(() -> {
                String workerName = Thread.currentThread().getName();
                System.out.println(workerName + " processing job " + jobId);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                System.out.println(workerName + " finished job " + jobId);
            });
        }

        executor.shutdown();
        while (!executor.awaitTermination(1, TimeUnit.DAYS)) {
            // Continue waiting until every submitted job has completed.
        }
    }

    private static void calculateSum() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> result = executor.submit(() -> {
            int sum = 0;
            for (int number = 1; number <= 100; number++) {
                sum += number;
            }
            return sum;
        });

        executor.shutdown();
        System.out.println("Sum: " + result.get());
    }
}
