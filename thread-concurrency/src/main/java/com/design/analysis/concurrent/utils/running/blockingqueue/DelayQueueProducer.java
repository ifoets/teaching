package com.design.analysis.concurrent.utils.running.blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class DelayQueueProducer implements Runnable {

	protected BlockingQueue<DelayElement> blockingQueue;
	final Random random = new Random();
	int counter = 0;

	public DelayQueueProducer(BlockingQueue<DelayElement> queue) {
		this.blockingQueue = queue;
	}

	@Override
	public void run() {
		while (counter < 10) {
			try {
				int delay = random.nextInt(1000);
				DelayElement delayElement = new DelayElement(counter + "", delay);
				System.out.println(Thread.currentThread().getName()+ " Put: " + delayElement);
				blockingQueue.put(delayElement);
				// Thread.sleep(500);
				counter++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
