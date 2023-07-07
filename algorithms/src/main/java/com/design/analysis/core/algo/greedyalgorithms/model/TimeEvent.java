package com.design.analysis.core.algo.greedyalgorithms.model;

public class TimeEvent implements Comparable<TimeEvent> {

	public int time;
	public boolean arrDepr;

	public TimeEvent(int time, boolean arrDepr) {
		super();
		this.time = time;
		this.arrDepr = arrDepr;
	}

	@Override
	public int compareTo(TimeEvent arg0) {
		return this.time - arg0.time;
	}
	
	@Override
	public String toString() {
		return "timeEvent [time=" + time + ", arrDepr=" + arrDepr + "]";
	}

}
