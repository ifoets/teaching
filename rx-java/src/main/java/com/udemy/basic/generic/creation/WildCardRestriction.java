package com.udemy.basic.generic.creation;

import java.util.ArrayList;
import java.util.List;

//public class WildCardRestriction<?> not valid on header class level

public class WildCardRestriction<T> {

	// it does not support multiple bound as Type parameter support
	// private List<? extends Number & Runnable> list;

	// take care write operation it not supported usually, very rare place it
	// supported

	public void displayData(List<?> list) {
		for (Object t : list) {
			System.out.println(t);
		}
		// we don,t know the type of element here only we can read
		// list.add("BasicStrong ");
	}

	public void displayDataUpperBound(List<? extends Number> list) {
		for (Object t : list) {
			System.out.println(t);
		}
		// we don,t know the type of element here holding ? ,so only we can read
		// list.add(10);
	}

	// Lower bound work for write and read both since we know what super type and
	// super type reference can hold the
	// sub type reference
	public void displayDataLowerBound(List<? super Number> list) {
		for (Object t : list) {
			System.out.println(t);
		}
		// we can add here there reference of Number can hold the reference of Integer
		// and Double
		list.add(10);
		list.add(10.5);
	}

	/** the above 3 points also valid when instantiate object using wild card */
	public void objectInstantiateWildCardExmpl() {

		// wild card can not use right hand side on object instantiation
		// List<Number> l1 = new ArrayList<?>();

		@SuppressWarnings("unused")
		List<?> l1 = new ArrayList<Integer>();
		// we can't don't know the type parameter
		// l1.add(10);

		@SuppressWarnings("unused")
		List<? extends Number> l2 = new ArrayList<Integer>();
		// we can't don't know the type parameter
		// l2.add(10);

		List<? super Number> l3 = new ArrayList<>();
		// we know the super type parameter whose reference can hold the sub type
		l3.add(10);

	}
}
