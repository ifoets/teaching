package com.design.analysis.concurrent.utils.running.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExecute {
	public ExecutorService executorService = Executors.newSingleThreadExecutor();

	public void excute() {

		executorService.execute(new Runnable() {
			public void run() {
				String tn = Thread.currentThread().getName();
				System.out.println(tn);
			}
		});
		executorService.shutdown();
	}
}
