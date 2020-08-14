package com.design.analysis.algo.common;

public class ActivityTime implements Comparable<ActivityTime> {

	int startTime;
	int endTime;

	public ActivityTime(int startTime, int endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	@Override
	public String toString() {
		return "ActivityTime [startTime=" + startTime + ", endTime=" + endTime + "]";
	}

	@Override
	public int compareTo(ActivityTime arg0) {
		return this.endTime - arg0.endTime;
	}
}
