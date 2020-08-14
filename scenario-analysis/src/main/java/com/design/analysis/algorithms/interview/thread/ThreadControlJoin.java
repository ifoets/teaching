package com.design.analysis.algorithms.interview.thread;

public class ThreadControlJoin implements Runnable {

	public static void main(String[] args) {

		ThreadControlJoin tcj = new ThreadControlJoin();
		Thread t1 = new Thread(tcj, "x");
		Thread t2 = new Thread(tcj, "y");
		Thread t3 = new Thread(tcj, "z");
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t2.join();
		} catch (InterruptedException auther) {
			// TODO Auto-generated catch block
			auther.printStackTrace();
		}
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());

	}

}
