package com.design.analysis.algo.common;

public class EgyptianFraction {

	public int nr;
	public int dr;
	public EgyptianFraction(int nr, int dr) {
		super();
		this.dr = dr;
		this.nr = nr;
	}
	@Override
	public String toString() {
		return "["+ nr + "/" + dr + "]";
	}
}