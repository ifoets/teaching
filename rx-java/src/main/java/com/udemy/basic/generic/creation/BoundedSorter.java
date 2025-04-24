package com.udemy.basic.generic.creation;

import java.util.List;

//Here generic type is bounded by Number so it can use by only by the class who have extended to Number or number it self
public class BoundedSorter<T extends Number> {
	@SuppressWarnings("unused")
	private List<T> list;

	public BoundedSorter(List<T> list) {
		this.list = list;
	}

	public void getSorted(List<T> list) {
		list.sort(null);
		for (T t : list) {
			System.out.println(t);
		}
	}

	// Generic <X> is independent of class level generic
	public static <X extends Number> void getSortedMethod(List<X> list) {
		list.sort(null);
		for (X x : list) {
			System.out.println(x);
		}
	}

	// Generic <Y> is independent of class level generic
	// the class Cbound.java who implements both interface only can use this
	public static <Y extends Ibound1 & Ibound2> void getSortedInter(List<Y> list) {

	}
}

interface Ibound1 {
}

interface Ibound2 {
}
