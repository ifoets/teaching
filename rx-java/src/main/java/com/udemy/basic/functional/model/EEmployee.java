package com.udemy.basic.functional.model;

public class EEmployee {
	private String name;
	private int salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public EEmployee(String name, int salary) {

		this.name = name;
		this.salary = salary;
	}

}
