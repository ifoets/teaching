package com.design.analysis.algorithms.interview.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchExmpl implements Runnable {

	public CountDownLatch latch = null;
	List<Integer> list = new ArrayList<>();

	public CountDownLatchExmpl(int size) {
		latch = new CountDownLatch(size);
	}

	public static void main(String[] args) {

		CountDownLatchExmpl cnl = new CountDownLatchExmpl(3);
		Thread t1 = new Thread(cnl, "decremental");
		Thread t2 = new Thread(cnl, "waiter");
		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		try {
			if (Thread.currentThread().getName() == "decremental") {
				Thread.sleep(1000);
				list.add(10);
				this.latch.countDown();
				System.out.println("1 count down 10 added to list");
				Thread.sleep(1000);
				list.add(20);
				this.latch.countDown();
				System.out.println("2 count down 20 added to list");
				Thread.sleep(1000);
				list.add(30);
				this.latch.countDown();
				System.out.println("3 count down 30 added to list");
				System.out.println("Now waiter can start the job");
				Thread.sleep(1000);
				System.out.println("4 count down 40 added to list");
				list.add(40);
			}

			if (Thread.currentThread().getName() == "waiter") {
				System.out.println("Waiter now waiting");
				latch.await();
				System.out.println("Waiter Released");
				int sum = 0;
				System.out.println("Sum of list: " + list.stream().reduce((x, y) -> x + y).get());
			}
		} catch (InterruptedException e) {
		}
	}
}
