package com.design.analysis.concurrent.utils.running.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class SynchronousQueueProducer implements Runnable {

	public BlockingQueue<String> queue;
	int count = 0;

	public SynchronousQueueProducer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (count < 10) {
			String event = "FOUR" + count;
			try {
				queue.put(event);
				System.out.printf("[%s] published event : %s %n", Thread.currentThread().getName(), event);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			++count;
		}
	}
}
