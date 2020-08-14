package com.design.analysis.algo.string.node;

public class Anag implements Comparable<Anag> {

	public String org;
	public String sorted;

	public Anag(String org, String sorted) {
		this.org = org;
		this.sorted = sorted;

	}

	@Override
	public int compareTo(Anag o) {
		return this.sorted.compareTo(o.sorted);
	}

	@Override
	public String toString() {
		return "(" + org + ", " + sorted + ")";
	}

}
