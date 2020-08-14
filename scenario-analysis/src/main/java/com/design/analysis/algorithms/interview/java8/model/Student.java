package com.design.analysis.algorithms.interview.java8.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
	public int stuId;
	public int stuAge;
	public String stuName;

	Student(int id, int age, String name) {
		this.stuId = id;
		this.stuAge = age;
		this.stuName = name;
	}

	public int getStuId() {
		return stuId;
	}

	public int getStuAge() {
		return stuAge;
	}

	public String getStuName() {
		return stuName;
	}

	public static List<Student> getStudents() {
		List<Student> list = new ArrayList<>();
		list.add(new Student(11, 28, "Lucy"));
		list.add(new Student(28, 27, "Tim"));
		list.add(new Student(32, 30, "Daniel"));
		list.add(new Student(49, 27, "Steve"));
		return list;
	}
}