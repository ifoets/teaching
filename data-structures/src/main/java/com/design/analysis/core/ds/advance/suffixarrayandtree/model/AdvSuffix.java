package com.design.analysis.core.ds.advance.suffixarrayandtree.model;

public class AdvSuffix implements Comparable<AdvSuffix> {

	public int ind;
	public String sfix;
	public int rank[];

	public AdvSuffix(int ind, String sfix) {
		super();
		this.ind = ind;
		this.sfix = sfix;
		this.rank = new int[2];
	}

	@Override
	public int compareTo(AdvSuffix arg0) {
		return (this.rank[0] == arg0.rank[0]) ? (this.rank[1] < arg0.rank[1] ? 1 : 0)
				: (this.rank[0] < arg0.rank[0] ? 1 : 0);
	}

	@Override
	public String toString() {
		return "Suffix [ind=" + ind + ", sfix=" + sfix + "]";
	}
}
