package com.design.analysis.concurrent.utils.running.chatgpt;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        int numberOfWorkers = 3;

        CyclicBarrier barrier = new CyclicBarrier(numberOfWorkers, () -> {
            System.out.println("All workers reached the barrier. Proceeding to next phase...");
        });

        for (int i = 1; i <= numberOfWorkers; i++) {
            int workerId = i;
            new Thread(() -> {
                try {
                    System.out.println("Worker " + workerId + " is doing phase 1 work...");
                    Thread.sleep(1000L * workerId);
                    System.out.println("Worker " + workerId + " reached barrier.");
                    barrier.await(); // waits until all reach here

                    System.out.println("Worker " + workerId + " starting phase 2...");
                    Thread.sleep(1000);
                    System.out.println("Worker " + workerId + " finished phase 2.");
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
                }
            }).start();
        }
    }
}
