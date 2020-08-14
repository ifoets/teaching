package com.design.analysis.company.hakarrank.visa.model;

public class VPoint implements Comparable<VPoint> {

	public int x;
	public int y;

	public VPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
  
	@Override
	public int compareTo(VPoint o) {
		return (int) Math.abs(Math.pow(this.x, 2) + Math.pow(this.y, 2))
				- (int) Math.abs(Math.pow(o.x, 2) + Math.pow(o.y, 2));

	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
