package com.design.analysis.algorithms.interview.thread;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CntDnLatch {

    public static void main(String[] args) throws InterruptedException {
    CountDownLatch latch = new CountDownLatch(3);
    List<String> list = new ArrayList<>();
    Worker worker1 = new Worker("worker1", latch, list);
    Worker worker2 = new Worker("worker2", latch, list);
    Worker worker3 = new Worker("worker3", latch, list);

    worker1.start();
    worker2.start();
    worker3.start();
    latch.await();
    System.out.println("I/Main thread was waiting for collect all names of the threads");
    System.out.println(list.get(0) +","+ list.get(1) +","+list.get(2));
    }
}

class Worker extends Thread {
    CountDownLatch cnt;
    String name;
    List<String> list;

    public Worker(String name, CountDownLatch latch, List<String> list) {
        this.cnt = latch;
        this.name = name;
        this.list = list;
    }

    public void run() {
        try {
            System.out.println("Thread :"+ name +" executed");
            Thread.sleep(1000);
            list.add(name);
            cnt.countDown();
        } catch (Exception e) {
            System.out.println("Thread interrupted");
            {
            }
        }
    }
}