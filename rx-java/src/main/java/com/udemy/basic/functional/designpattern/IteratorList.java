package com.udemy.basic.functional.designpattern;

import java.util.function.Consumer;

public class IteratorList {

	private Object[] elemnets;

	public IteratorList(Object[] objects) {
		this.elemnets = objects;
	}

	public void foreach(Consumer<Object> consumer) {
		for (int i = 0; i < elemnets.length; i++) {
			consumer.accept(elemnets[i]);
		}
	}
}
