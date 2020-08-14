package com.design.analysis.algorithms.interview.thread;

import java.util.ArrayList;
import java.util.List;

/*1.	100 Resource and 10 thread how can run all thread so that 1 thread used to take the resource 0,10,20…ect and 2nth thread 1,11,21..so on resource*/
public class UtilizeSpecificThread implements Runnable {

	public static List<Integer> li = new ArrayList<>();

	public static int count = 0;

	public static void main(String[] args) throws InterruptedException {
		UtilizeSpecificThread uth = new UtilizeSpecificThread();

		for (int i = 0; i <= 15; li.add(i), i++)
			;
		Thread z = new Thread(uth, "one");
		z.start();
		Thread e = new Thread(uth, "two");
		e.start();
		Thread o = new Thread(uth, "three");
		o.start();

	}

	@Override
	public void run() {

		while (count <= 15) {
			if (Thread.currentThread().getName() == "one" && count % 3 == 0)
				System.out.println(Thread.currentThread().getName() + " :: " + li.get(count++));
			else if (Thread.currentThread().getName() == "two" && count % 3 == 1)
				System.out.println(Thread.currentThread().getName() + " :: " + li.get(count++));
			else if (Thread.currentThread().getName() == "three" && count % 3 == 2)
				System.out.println(Thread.currentThread().getName() + " :: " + li.get(count++));
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	}

}
