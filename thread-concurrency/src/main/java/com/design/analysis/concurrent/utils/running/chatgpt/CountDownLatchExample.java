package com.design.analysis.concurrent.utils.running.chatgpt;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        int taskCount = 3;
        CountDownLatch latch = new CountDownLatch(taskCount);

        for (int i = 1; i <= taskCount; i++) {
            int taskId = i;
            new Thread(() -> {
                System.out.println("Task " + taskId + " started");
                try {
                    Thread.sleep(1000L * taskId); // simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Task " + taskId + " completed");
                latch.countDown(); // signal task completion
            }).start();
        }

        System.out.println("Main thread waiting...");
        latch.await(); // wait until all tasks complete
        System.out.println("All tasks completed. Main thread continues.");
    }
}
