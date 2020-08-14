package com.design.analysis.concurrent.thread.runing;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue implements Runnable {
	private List<Integer> queue = new LinkedList<>();
	private int limit = 10;

	public BlockingQueue(int limit) {
		this.limit = limit;
	}

	public synchronized void enqueue(Integer item) throws InterruptedException {
		while (this.queue.size() == this.limit) {
			wait();
		}
		if (this.queue.size() == 0) {
			notifyAll();
		}
		System.out.println(Thread.currentThread().getName() + " enqueue::"+item);
		this.queue.add(item);
	}

	public synchronized void dequeue() throws InterruptedException {
		while (this.queue.size() == 0) {
			wait();
		}
		if (this.queue.size() == this.limit) {
			notifyAll();
		}
		System.out.println(Thread.currentThread().getName() + " dequeue::" + this.queue.remove(0));
	}

	@Override
	public void run() {
		String str = Thread.currentThread().getName();

		try {
			switch (str) {
			case "a":
				enqueue(1);
				break;
			case "b":
				enqueue(2);
				break;
			case "c":
				enqueue(3);
				break;
			case "d":
				enqueue(4);
				break;
			case "e":
				enqueue(5);
				break;
			case "f":
				enqueue(6);
				break;

			case "a1":
				dequeue();
				break;
			case "b1":
				dequeue();
				break;
			case "c1":
				dequeue();
				break;
			case "d1":
				dequeue();
				break;
			case "e1":
				dequeue();
				break;
			case "f1":
				dequeue();
				break;
			}
		} catch (InterruptedException e) {
		}
	}

}
