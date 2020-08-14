package com.design.analysis.algorithms.interview.thread;

import java.util.concurrent.CountDownLatch;

public class CountDoneLatchExmpl implements Runnable {

	public CountDownLatch latch = null;

	public CountDoneLatchExmpl(int size) {
		latch = new CountDownLatch(size);
	}

	public static void main(String[] args) {

		CountDoneLatchExmpl cnl = new CountDoneLatchExmpl(3);
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
				this.latch.countDown();
				System.out.println("1 count down");
				Thread.sleep(1000);
				this.latch.countDown();
				System.out.println("2 count down");
				Thread.sleep(1000);
				this.latch.countDown();
				System.out.println("3 count down");
				System.out.println("Now water can start the job");
			}

			if (Thread.currentThread().getName() == "waiter") {
				System.out.println("Waiter now waiting");
				latch.await();
				System.out.println("Waiter Released");
			}
		} catch (InterruptedException e) {
		}
	}
}

