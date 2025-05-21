package com.udemy.basic.generic.creation;

import java.util.List;

public class BasicWildCard {

	// it can't use, these are totally illegal
	// public static <T> void displayGen(? list)
	// public static ? displayGen(List<T> list)

	// type parameter
	public static <T> void displayGen(List<T> list) {
		for (Object o : list) {
			System.out.println(o);
		}
	}

//then what use of wild card special, the place we can't use Type parameter there wild card is useful
	// wlid card
	public static void displayWildCard(List<?> list) {
		for (Object o : list) {
			System.out.println(o);
		}
	}
}
