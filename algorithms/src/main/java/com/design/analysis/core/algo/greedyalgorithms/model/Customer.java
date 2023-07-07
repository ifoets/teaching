package com.design.analysis.core.algo.greedyalgorithms.model;

public class Customer implements Comparable<Customer> {

	public int bagA;
	public int bagB;
	public char customer;

	public Customer(int bagA, int bagB, char customer) {
		super();
		this.bagA = bagA;
		this.bagB = bagB;
		this.customer = customer;
	}

	@Override
	public int compareTo(Customer o) {
		return this.bagA + this.bagB - o.bagA - o.bagB;
	}

	@Override
	public String toString() {
		return "[" + bagA + ",  " + bagB + ", " + customer + "]";
	}

}
