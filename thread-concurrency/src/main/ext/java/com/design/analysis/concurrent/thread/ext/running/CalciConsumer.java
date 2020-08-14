package com.design.analysis.concurrent.thread.ext.running;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class CalciConsumer implements Runnable {

	public BlockingQueue<Integer> sharedQueue;
	String sign = null;
	Scanner in = new Scanner(System.in);
	int a;
	int b;
	int result;

	public CalciConsumer(BlockingQueue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				try {
					while (sharedQueue.size() != 0)
						wait();
					/*System.out.println("Enter First integer");
					a = in.nextInt();
					System.out.println("Enter Second integer ");

					b = in.nextInt();
					System.out.println("Enter Sign for calculating");
					sign = in.next();*/

					a=10;
					b=14;
					sign="+";
					switch (sign) {
					case "+":
						result = a + b;
						break;
					case "-":
						result = a - b;
						break;
					case "*":
						result = a * b;
						break;
					case "/":
						result = a / b;
						break;
					}
					sharedQueue.add(result);
					notify();
					//Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
