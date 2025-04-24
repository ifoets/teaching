package com.udemy.basic.generic.creation;

import java.util.List;

/*here  there is no any bound for T, T can be any type*/

public class UnboundedSorter<T> {

	@SuppressWarnings("unused")
	private List<T> list;

	public UnboundedSorter(List<T> list) {
		this.list = list;
	}

	public void getSorted(List<T> list) {
		list.sort(null);
		for (T t : list) {
			System.out.println(t);
		}
	}

}
