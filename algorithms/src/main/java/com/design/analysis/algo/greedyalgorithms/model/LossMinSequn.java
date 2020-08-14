package com.design.analysis.algo.greedyalgorithms.model;

public class LossMinSequn implements Comparable<LossMinSequn> {

	public String jobId;
	public int loss;
	public int deadLine;

	public LossMinSequn(String jobId, int loss, int deadLine) {
		super();
		this.jobId = jobId;
		this.loss = loss;
		this.deadLine = deadLine;
	}

	@Override
	public int compareTo(LossMinSequn o) {

		if (this.deadLine == o.deadLine)
			return o.loss - this.loss;
		return this.deadLine - o.deadLine;
	}

	@Override
	public String toString() {
		return "LossMin [jobId=" + jobId + ", loss=" + loss + ", deadLine=" + deadLine + "]";
	}
}
