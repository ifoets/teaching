package com.design.analysis.concurrent.utils.running.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class SynchronousQueueConsumer implements Runnable {

	public BlockingQueue<String> queue;

	public SynchronousQueueConsumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String event = queue.take();
				System.out.printf("[%s] consumed event : %s %n", Thread.currentThread().getName(), event);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
