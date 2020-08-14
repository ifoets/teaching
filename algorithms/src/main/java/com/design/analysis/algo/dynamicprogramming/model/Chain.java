package com.design.analysis.algo.dynamicprogramming.model;

public class Chain implements Comparable<Chain> {

	public int xi;
	public int xf;

	public Chain(int xi, int xf) {
		this.xi = xi;
		this.xf = xf;
	}

	@Override
	public int compareTo(Chain arg0) {
		return this.xi = arg0.xi;
	}
}
