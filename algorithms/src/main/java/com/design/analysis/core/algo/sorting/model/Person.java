package com.design.analysis.core.algo.sorting.model;

public class Person {

	private int id;
	private float salary;
	private Object someBigObject = new Object();

	public Person(int id, float salary) {
		this.id = id;
		this.salary = salary;
	}

	public float getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Person{" + "id=" + id + ", salary=" + salary + ", someBigObject=" + someBigObject + '}';
	}
}
