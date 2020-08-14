package com.design.analysis.company.operativemedia;

public class ThreadEvenOdd implements Runnable {

	public static int count = 0;

	public static void main(String[] args) throws InterruptedException {
		ThreadEvenOdd teo = new ThreadEvenOdd();

		Thread z = new Thread(teo, "zero");
		z.start();
		Thread e = new Thread(teo, "even");
		e.start();
		Thread o = new Thread(teo, "odd");
		o.start();
	}

	@Override
	public void run() {

		while (count < 11) {
			if (Thread.currentThread().getName() == "zero" && count == 0)
				System.out.println(Thread.currentThread().getName() + "::" + count++);
			else if (Thread.currentThread().getName() == "even" && count % 2 == 0)
				System.out.println(Thread.currentThread().getName() + "::" + count++);
			else if (Thread.currentThread().getName() == "odd" && count % 2 != 0)
				System.out.println(Thread.currentThread().getName() + "::" + count++);
		}
	}

}
