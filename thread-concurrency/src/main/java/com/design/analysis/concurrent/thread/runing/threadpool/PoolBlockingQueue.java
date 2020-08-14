package com.design.analysis.concurrent.thread.runing.threadpool;

import java.util.LinkedList;
import java.util.List;

public class PoolBlockingQueue implements Runnable {
	private List<Object> queue = new LinkedList<>();
	private int limit = 10;
	public boolean inquOrDeq = false;
	Integer item = 0;

	public PoolBlockingQueue(int limit) {
		this.limit = limit;
	}

	public synchronized void enqueue(Object item) throws InterruptedException {
		while (this.queue.size() == this.limit) {
			wait();
		}
		if (this.queue.size() == 0) {
			notifyAll();
		}
		this.queue.add(item);
		System.out.println(Thread.currentThread().getName() + " enqueue::" + (Integer) item);
	}

	public synchronized Object dequeue() throws InterruptedException {
		while (this.queue.size() == 0) {
			wait();
		}
		if (this.queue.size() == this.limit) {
			notifyAll();
		}

		Object obj = this.queue.remove(0);
		System.out.println(Thread.currentThread().getName() + " dequeue::" + (Integer) obj);
		return obj;
	}

	@Override
	public void run() {
		try {
			if (!inquOrDeq)
				enqueue(++item);
			else
				dequeue();
			inquOrDeq = !inquOrDeq;

		} catch (InterruptedException e) {
		}
		;
	}
}
