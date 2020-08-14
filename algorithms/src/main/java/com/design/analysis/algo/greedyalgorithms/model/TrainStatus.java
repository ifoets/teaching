package com.design.analysis.algo.greedyalgorithms.model;

public class TrainStatus implements Comparable<TrainStatus> {

	public int arrTime;
	public int depTime;
	public int platFormNo;

	public TrainStatus(int arrTime, int depTime, int platFormNo) {
		super();
		this.arrTime = arrTime;
		this.depTime = depTime;
		this.platFormNo = platFormNo;
	}

	@Override
	public int compareTo(TrainStatus o) {
		if (this.arrTime == o.arrTime)
			return this.depTime - o.depTime;
		return this.arrTime - o.arrTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + arrTime;
		result = prime * result + depTime;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainStatus other = (TrainStatus) obj;
		if (arrTime != other.arrTime)
			return false;
		if (depTime != other.depTime)
			return false;
		return true;
	}
}
