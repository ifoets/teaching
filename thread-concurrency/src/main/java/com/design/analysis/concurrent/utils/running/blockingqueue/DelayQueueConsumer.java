package com.design.analysis.concurrent.utils.running.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class DelayQueueConsumer implements Runnable {

	protected BlockingQueue<DelayElement> blockingQueue;
	int counter = 0;

	public DelayQueueConsumer(BlockingQueue<DelayElement> queue) {
		this.blockingQueue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				DelayElement delayElement = blockingQueue.take();
				System.out.println(Thread.currentThread().getName() + " take(): " + delayElement.toString());
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}