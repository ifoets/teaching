package com.design.analysis.algo.array.model;

public class AbsSmallDiff implements Comparable<AbsSmallDiff> {

	public int x;
	public int y;
	public int absDiff;

	public AbsSmallDiff(int x, int y) {
		this.x = x;
		this.y = y;
		this.absDiff = Math.abs(x - y);
	}

	@Override
	public int compareTo(AbsSmallDiff arg0) {
		return this.absDiff - arg0.absDiff;
	}
}
