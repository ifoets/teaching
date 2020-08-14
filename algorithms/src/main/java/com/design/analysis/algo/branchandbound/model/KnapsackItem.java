package com.design.analysis.algo.branchandbound.model;

public class KnapsackItem implements Comparable<KnapsackItem> {

	public float weight;
	public int value;

	public KnapsackItem(float weight, int value) {
		this.value = value;
		this.weight = weight;
	}

	@Override
	public int compareTo(KnapsackItem o) {
		return (int) ((o.value / o.weight) - (this.value / this.weight));
	}

	@Override
	public String toString() {
		return "KnapsackItem [weight=" + weight + ", value=" + value + "]";
	}

}
