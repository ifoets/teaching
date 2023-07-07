package com.design.analysis.core.algo.greedyalgorithms.model;

public class JobSequen implements Comparable<JobSequen> {

	public String jobId;
	public int deadLine;
	public int profit;

	public JobSequen(String jobId, int deadLine, int profit) {
		super();
		this.jobId = jobId;
		this.deadLine = deadLine;
		this.profit = profit;
	}

	@Override
	public int compareTo(JobSequen o) {
		if (this.deadLine == o.deadLine) {
			return o.profit - this.profit;
		}
		return this.deadLine - o.deadLine;
	}

	@Override
	public String toString() {
		return "JobSequen [jobId=" + jobId + ", deadLine=" + deadLine + ", profit=" + profit + "]";
	}
}
