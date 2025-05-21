package com.udemy.basic.generic.creation;

import java.util.ArrayList;

public class Behaviour {

	// generic area only we can add with Type parameter
	public static void displayGen() {
		ArrayList<String> l = new ArrayList<>();
		l.add("Basic");
		l.add("Strong");
		displayNonGen(l);
		System.out.println(l);

	}

	// non generic area ie Row type can use anything
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void displayNonGen(ArrayList l) {
		l.add(10);
		l.add("Basic");
		l.add("Strong");
	}

	// non generic area ie Row type can use anything
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void displayGenReverse() {
		ArrayList l = new ArrayList<>();
		l.add(10);
		l.add("Basic");
		l.add("Strong");
		displayGenGen(l);
		System.out.println(l);
	}

	public static void displayGenGen(ArrayList<String> l) {
		l.add("Basic");
		l.add("Strong");
	}
}
