package com.design.analysis.algorithms.interview.thread;

public class EvenOddControl implements Runnable {

	public static int count = 0;

	public static void main(String[] args) {
		EvenOddControl eo = new EvenOddControl();
		Thread e = new Thread(eo, "even");
		Thread o = new Thread(eo, "odd");
		e.start();
		o.start();
	}

	@Override
	public void run() {
		try {
			while (Thread.currentThread().getName() == "even" && count < 10) {
				synchronized (this) {
					while (count % 2 != 0)// this is wait only
						// wait();
						System.out.println(Thread.currentThread().getName() + "::" + count++);
					notify();
					Thread.sleep(100);
				}
			}

			while (Thread.currentThread().getName() == "odd" && count < 11) {
				synchronized (this) {
					while (count % 2 == 0)// this is wait only
						// wait();
						System.out.println(Thread.currentThread().getName() + "::" + count++);
					notify();
					Thread.sleep(100);

				}
			}

		} catch (

		InterruptedException e) {
		}
	}
}
