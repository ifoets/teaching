package com.design.analysis.concurrent.utils.running.joinandfork;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class ForkJoinRecursiveAction extends RecursiveAction implements Runnable {

	private static final long serialVersionUID = 1L;
	private long workLoad = 0;

	public ForkJoinRecursiveAction(long workLoad) {
		this.workLoad = workLoad;
	}

	@Override
	public void run() {
		compute();

	}

	@Override
	public void compute() {

		// if work is above threshold, break tasks up into smaller tasks
		if (this.workLoad > 16) {
			System.out.println("Splitting workLoad : " + this.workLoad);

			List<ForkJoinRecursiveAction> subtasks = new ArrayList<>();

			subtasks.addAll(createSubtasks());

			for (RecursiveAction subtask : subtasks) {
				subtask.fork();
			}

		} else {
			System.out.println("Doing workLoad myself: " + this.workLoad);
		}
	}

	private List<ForkJoinRecursiveAction> createSubtasks() {
		List<ForkJoinRecursiveAction> subtasks = new ArrayList<ForkJoinRecursiveAction>();

		ForkJoinRecursiveAction subtask1 = new ForkJoinRecursiveAction(this.workLoad / 2);
		ForkJoinRecursiveAction subtask2 = new ForkJoinRecursiveAction(this.workLoad / 2);

		subtasks.add(subtask1);
		subtasks.add(subtask2);

		return subtasks;
	}
}
