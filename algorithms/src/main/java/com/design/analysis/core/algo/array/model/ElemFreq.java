package com.design.analysis.core.algo.array.model;

public class ElemFreq implements Comparable<ElemFreq> {

	public int ele;
	public int frq;

	public ElemFreq(int elem, int frq) {
		this.ele = elem;
		this.frq = frq;
	}

	@Override
	public int compareTo(ElemFreq arg0) {

		if (this.frq == arg0.frq) {
			return arg0.ele - this.ele;
		} else
			return arg0.frq - this.frq;
	}

}
