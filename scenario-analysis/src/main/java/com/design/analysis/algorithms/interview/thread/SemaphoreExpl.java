package com.design.analysis.algorithms.interview.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreExpl implements Runnable {

	public static Semaphore semaphore = null;
	public static boolean ta[] = new boolean[4];
	public static int i = 1;

	public SemaphoreExpl(int size) {
		semaphore = new Semaphore(size);
		semaphore.tryAcquire(1);
	}

	public static void main(String[] args) {
		SemaphoreExpl see = new SemaphoreExpl(1);
		Thread t1 = new Thread(see, "t1");
		Thread t2 = new Thread(see, "t2");
		Thread t3 = new Thread(see, "t3");
		Thread t4 = new Thread(see, "t4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	public void run() {

		String name = Thread.currentThread().getName();
		try {

			if (name == "t" + i) {
				System.out.println(name + " : acquiring lock...");
				semaphore.acquire();
				ta[i] = true;
				i++;
			}

			try {

				if (name == "t" + i) {
					System.out.println(name + " is performing");
					Thread.sleep(1000);
					ta[i] = true;
					i++;
				}
			} finally {
				System.out.println(name + " : releasing lock...");
				semaphore.release();
			}

		} catch (InterruptedException e) {

			e.printStackTrace();

		}
	}
}
