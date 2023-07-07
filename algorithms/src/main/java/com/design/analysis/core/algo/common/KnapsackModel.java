package com.design.analysis.core.algo.common;

public class KnapsackModel implements Comparable<KnapsackModel> {

	int value;
	int weight;

	public KnapsackModel(int value, int weight) {
		super();
		this.value = value;
		this.weight = weight;
	}

	public int getValue() {
		return value;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "KnapsackModel [value=" + value + ", weight=" + weight + "]";
	}

	@Override
	public int compareTo(KnapsackModel o) {
		return o.weight - this.weight;
	}

}
