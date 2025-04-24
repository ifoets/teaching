package com.udemy.basic.generic.creation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TypeErase<T> {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		// class cast exception
		// System.out.println(method1(10));
		// generic parameter right side is just for reference may not use
		ArrayList l = new ArrayList<String>();
		// ArrayList l = new ArrayList(); above code is same as it is
		l.add("BasicStrong");
		l.add(true);
		l.add(10);
		System.out.println(l);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String method1(Integer x) {

		List<String> a = new LinkedList<>();
		// List a = new LinkedList...this compiler do for below line
		List b = a;
		b.add(x);
		// return (String)a.iterator().next() ..compiler do for below line
		return a.iterator().next();
	}

	// the below two method are same
	// public void method2(ArrayList<String> l) {
	// }

	// public void method2(ArrayList<Intege> l) {
	// }
}
