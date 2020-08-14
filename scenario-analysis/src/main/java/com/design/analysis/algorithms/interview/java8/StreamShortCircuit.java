package com.design.analysis.algorithms.interview.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamShortCircuit {

	/** Employee class **/
	static class Employee {
		int id;
		String name;

		public Employee(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return this.id;
		}

		public String getName() {
			return this.name;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		List<Employee> employees = new ArrayList<>();
		for (int i = 1; i < 10000000; i++) {
			employees.add(new StreamShortCircuit.Employee(i, "name_" + i));
		}
		/**
		 * Only Intermediate Operations; it will just create another streams and will
		 * not perform any operations
		 **/
		Stream<String> employeeNameStreams = employees.stream().filter(e -> e.getId() % 2 == 0).map(employee -> {
			System.out.println("In Map - " + employee.getName());
			return employee.getName();
		});
		long streamStartTime = System.currentTimeMillis();
		/** Terminal operation with short-circuit operation: limit **/
		employeeNameStreams.limit(100).collect(Collectors.toList());
		System.out.println(System.currentTimeMillis() - streamStartTime);
	}
}
