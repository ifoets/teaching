package com.udemy.basic.reactive.input.utils;

import java.util.List;

import com.udemy.basic.reactive.model.Employee;

public class RxInputUtils {

	public static List<Employee> getEmployees() {
		List<Employee> list = List.of(new Employee(101, "Alexa", 60000, 4.0), new Employee(123, "Dhwanit", 94000, 4.7),
				new Employee(236, "Mike", 65000, 4.0), new Employee(155, "Ella", 85000, 4.4),
				new Employee(443, "George", 50000, 3.6), new Employee(127, "Shreeja", 85000, 4.5),
				new Employee(509, "Daniel", 60000, 4.0), new Employee(344, "Lucy", 94000, 4.7),
				new Employee(509, "Harry", 75000, 4.3), new Employee(344, "Emma", 55000, 3.7));
		return list;
	}
}
