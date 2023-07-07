package com.design.analysis.core.algo.searching.model;

public class FreqWord implements Comparable<FreqWord> {

	public String word;
	public int frq;

	public FreqWord(String word, int frq) {
		super();
		this.word = word;
		this.frq = frq;
	}

	@Override
	public int compareTo(FreqWord arg0) {
		return arg0.frq - this.frq;
	}

	@Override
	public String toString() {
		return "(" + word + "," + frq + ")";
	}
}
