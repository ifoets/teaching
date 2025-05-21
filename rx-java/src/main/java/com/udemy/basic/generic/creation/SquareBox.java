package com.udemy.basic.generic.creation;

import java.util.List;

//both must have same Parameter Type only then it can extended
public class SquareBox<T> extends Box<T> {

	public SquareBox(List<T> a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

}
