package com.design.analysis.algorithms.interview.thread;

import java.util.ArrayList;
import java.util.List;

/** consumer producer in single class */
public class ProducerConsumer implements Runnable {
	int count = 0;
	List<Integer> list = new ArrayList<>(1);

	public static void main(String[] args) {

		ProducerConsumer cp = new ProducerConsumer();
		Thread pro = new Thread(cp, "con");
		Thread con = new Thread(cp, "pro");
		pro.start();
		con.start();
	}

	@Override
	public void run() {

		try {
			while (Thread.currentThread().getName() == "con") {
				synchronized (this) {
					while (list.isEmpty())
						wait();
					System.out.println(list.remove(0));
					notify();
					Thread.sleep(100);
				}
			}

			while (Thread.currentThread().getName() == "pro") {
				synchronized (this) {
					while (list.size() == 1)
						wait();
					list.add(count++);
					notify();
					Thread.sleep(100);
				}
			}

		} catch (InterruptedException e) {
		}
	}

}
