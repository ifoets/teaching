package com.design.analysis.core.ds.advance.suffixarrayandtree.model;

public class Suffix implements Comparable<Suffix> {

	public int ind;
	public String sfix;

	public Suffix(int ind, String sfix) {
		super();
		this.ind = ind;
		this.sfix = sfix;
	}

	@Override
	public int compareTo(Suffix arg0) {
		return this.sfix.compareTo(arg0.sfix);
	}

	@Override
	public String toString() {
		return "Suffix [ind=" + ind + ", sfix=" + sfix + "]";
	}
}
