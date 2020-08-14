package com.design.analysis.concurrent.utils.running.joinandfork;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class ForkJoinRecursiveTask extends RecursiveTask<Long> implements Runnable {

	private static final long serialVersionUID = 1L;
	private long workLoad = 0;

	public ForkJoinRecursiveTask(long workLoad) {
		this.workLoad = workLoad;
	}

	@Override
	public void run() {
		compute();
	}

	@Override
	public Long compute() {

		// if work is above threshold, break tasks up into smaller tasks
		if (this.workLoad > 16) {
			System.out.println("Splitting workLoad : " + this.workLoad);

			List<ForkJoinRecursiveTask> subtasks = new ArrayList<>();
			subtasks.addAll(createSubtasks());

			for (ForkJoinRecursiveTask subtask : subtasks) {
				subtask.fork();
			}

			long result = 0;
			for (ForkJoinRecursiveTask subtask : subtasks) {
				result += subtask.join();
			}
			return result;

		} else {
			System.out.println("Doing workLoad myself: " + this.workLoad);
			return workLoad * 3;
		}
	}

	private List<ForkJoinRecursiveTask> createSubtasks() {
		List<ForkJoinRecursiveTask> subtasks = new ArrayList<ForkJoinRecursiveTask>();

		ForkJoinRecursiveTask subtask1 = new ForkJoinRecursiveTask(this.workLoad / 2);
		ForkJoinRecursiveTask subtask2 = new ForkJoinRecursiveTask(this.workLoad / 2);

		subtasks.add(subtask1);
		subtasks.add(subtask2);

		return subtasks;
	}
}
