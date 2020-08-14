package com.design.analysis.company.hakarrank.visa.model;

public class VDPoint implements Comparable<VDPoint> {

	public VPoint p;
	public long d;

	public VDPoint(VPoint p, long d) {
		this.p = p;
		this.d = d;
	}

	@Override
	public int compareTo(VDPoint o) {
		return (int) (this.d - o.d);
	}

}
