package com.design.analysis.algorithms.interview.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.design.analysis.algorithms.interview.java8.model.Student;

public class StreamUseImpl implements IStreamUse {

	/** find unique string in list of string */
	public List<String> listOfUniqueStr(List<String> ls) {
		return ls.stream().distinct().collect(Collectors.toList());
	}

	/** find list of even pos element */
	public List<Integer> listOfEvenPos(List<Integer> l) {

		return IntStream.range(0, l.size()).filter(i -> i % 2 == 0).mapToObj(i -> l.get(i))
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		StreamUseImpl sui = new StreamUseImpl();
		sui.useManyFunction();
	}

	public void useManyFunction() {
		List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		// sum of even element
		System.out.println(list.stream()
				.collect(Collectors.partitioningBy(i -> i % 2 == 0, Collectors.summingInt(Integer::intValue))));

		// sum of all eleemnt
		System.out.println(list.stream().collect(
				Collectors.partitioningBy(i -> i % 2 == 0 || i % 2 != 0, Collectors.summingInt(Integer::intValue))));

		System.out.println(list.stream().collect(
				Collectors.partitioningBy(i -> i % 2 == 0 || i % 2 != 0, Collectors.summingInt(Integer::intValue))));

	}

	public List<String> getEvenIndexedStrings(String[] names) {
		return IntStream.range(0, names.length).filter(i -> i % 2 == 0).mapToObj(i -> names[i])
				.collect(Collectors.toList());
	}

	public boolean allMatch(List<Student> list) {
		Predicate<Student> p1 = s -> s.stuName.startsWith("A");
		return list.stream().allMatch(p1);
	}

	public boolean anyMatch(List<Student> list) {
		Predicate<Student> p2 = s -> s.stuAge >= 30;
		return list.stream().anyMatch(p2);
	}

	public boolean noMatch(List<Student> list) {
		Predicate<Student> p3 = s -> s.stuAge < 40 && s.stuName.startsWith("P");
		return list.stream().anyMatch(p3);
	}

	public List<Integer> collectX(List<Integer> list) {
		return null;
	}

	public List<Integer> collectY(List<Integer> list) {
		return null;
	}
}