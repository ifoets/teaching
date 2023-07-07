package com.design.analysis.core.algo.greedyalgorithms.model;

public class LossMin{

	public String jobId;
	public int loss;
	public int deadLine;

	public LossMin(String jobId, int loss, int deadLine) {
		super();
		this.jobId = jobId;
		this.loss = loss;
		this.deadLine = deadLine;
	}

	

	@Override
	public String toString() {
		return "LossMin [jobId=" + jobId + ", loss=" + loss + ", deadLine=" + deadLine + "]";
	}

}
