package com.design.analysis.algorithms.interview.thread;

import java.util.concurrent.Semaphore;

public class EvenOddControlShemaphore implements Runnable {

	public static int count = 0;
	Semaphore sem = new Semaphore(1);

	public static void main(String[] args) {

		EvenOddControlShemaphore eo = new EvenOddControlShemaphore();
		Thread e = new Thread(eo, "even");
		Thread o = new Thread(eo, "odd");
		e.start();
		o.start();
	}

	@Override
	public void run() {
		try {
			while (Thread.currentThread().getName() == "even" && count < 10) {
				while (count % 2 == 0)
					sem.acquire();
				System.out.println(Thread.currentThread().getName() + "::" + count++);
				sem.release();
				Thread.sleep(100);
			}
			while (Thread.currentThread().getName() == "odd" && count < 11) {
					while (count % 2 != 0)
						sem.acquire();
					System.out.println(Thread.currentThread().getName() + "::" + count++);
					sem.release();
					Thread.sleep(100);
			}

		} catch (InterruptedException e) {
		}
	}
}
