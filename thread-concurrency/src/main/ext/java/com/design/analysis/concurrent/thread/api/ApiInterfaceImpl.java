package com.design.analysis.concurrent.thread.api;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

import com.design.analysis.concurrent.thread.ext.running.Calcir;
import com.design.analysis.concurrent.thread.ext.running.CalciPoducer;

public class ApiInterfaceImpl implements IApiInterface {

	/* producer consumer commmunication */
	public void producerConsumerIntr() throws InterruptedException {
		BlockingQueue<Integer> queue = new SynchronousQueue<>();

		CalciPoducer producer = new CalciPoducer(queue);
		CalciConsumer consumer = new CalciConsumer(queue);

		new Thread(producer).start();
		new Thread(consumer).start();

		//Thread.sleep(4000);
	}
}
