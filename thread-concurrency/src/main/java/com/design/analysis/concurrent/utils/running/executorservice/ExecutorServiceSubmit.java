package com.design.analysis.concurrent.utils.running.executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceSubmit {
	public ExecutorService executor = Executors.newSingleThreadExecutor();

	public String runnable() throws InterruptedException, ExecutionException {
		Future<String> future = executor.submit(() -> {
			Thread.sleep(2000);
			return "Hello from Runnable";
		});

		while (!future.isDone()) {
			System.out.println("Task is still not done...");
			Thread.sleep(200);
		}

		System.out.println("Task completed! Retrieving the result");
		String result = future.get();
		System.out.println(result);

		executor.shutdown();
		return result;
	}

	public String callable() throws InterruptedException, ExecutionException {

		Callable<String> callable = () -> {
			// Perform some computation
			System.out.println("Entered Callable");
			Thread.sleep(2000);
			return "Hello from Callable";
		};

		System.out.println("Submitting Callable");
		Future<String> future = executor.submit(callable);

		// This line executes immediately
		System.out.println("Do something else while callable is getting executed");

		System.out.println("Retrieve the result of the future");
		// Future.get() blocks until the result is available
		String result = future.get();
		System.out.println(result);

		executor.shutdown();
		return result;
	}
}
