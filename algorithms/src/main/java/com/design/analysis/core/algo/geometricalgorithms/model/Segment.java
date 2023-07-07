package com.design.analysis.core.algo.geometricalgorithms.model;

public class Segment implements Comparable<Segment> {

	public int st, end;

	public Segment(int st, int end) {
		super();
		this.st = st;
		this.end = end;
	}

	@Override
	public int compareTo(Segment o) {
		return this.st - o.st;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}
