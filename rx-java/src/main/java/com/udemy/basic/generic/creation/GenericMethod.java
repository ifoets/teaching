package com.udemy.basic.generic.creation;

import java.util.List;

public class GenericMethod {

	@SuppressWarnings({ "rawtypes", "unused" })
	private List str;

	// generic constructor without generic class
	// require to declare type parameter before method name
	public <T> GenericMethod(List<T> tstr) {
		super();
		this.str = tstr;
	}

	// generic method without generic class
	//// require to declare type parameter before return type
	public static <T> String concat(T data) {
		return "Data is:- " + data;
	}
}
