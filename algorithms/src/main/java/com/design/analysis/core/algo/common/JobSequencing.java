package com.design.analysis.core.algo.common;

public class JobSequencing implements Comparable<JobSequencing> {

	public String jobId;
	public int deadLine;
	public int profit;

	public JobSequencing(String jobId, int deadLine, int profit) {
		super();
		this.jobId = jobId;
		this.deadLine = deadLine;
		this.profit = profit;
	}

	@Override
	public int compareTo(JobSequencing o) {
		return o.profit - this.profit;
	}
}
