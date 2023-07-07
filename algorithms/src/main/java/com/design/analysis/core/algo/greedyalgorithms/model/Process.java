package com.design.analysis.core.algo.greedyalgorithms.model;

public class Process implements Comparable<Process> {

	public int pid;/// process id
	public int bt; // brust time, time used in running

	public Process(int pid, int bt) {
		this.pid = pid;
		this.bt = bt;
	}

	@Override
	public int compareTo(Process arg0) {
		return this.bt - arg0.bt;
	}
}
