package com.design.analysis.core.algo.sorting.model;

public class Element implements Comparable<Element> {

	public int ele;// element
	public int count;

	public Element(int ele, int count) {
		this.ele = ele;
		this.count = count;
	}

	@Override
	public int compareTo(Element arg0) {
		return this.count - arg0.count;
	}
}
