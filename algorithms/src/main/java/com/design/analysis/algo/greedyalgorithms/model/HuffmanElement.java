package com.design.analysis.algo.greedyalgorithms.model;

public class HuffmanElement implements Comparable<HuffmanElement>{

	public char c;
	public int frq;

	public HuffmanElement(char c, int frq) {
		super();
		this.c = c;
		this.frq = frq;
	}

	@Override
	public int compareTo(HuffmanElement o) {
		return o.frq-this.frq;
	}
}
