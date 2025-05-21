package com.udemy.basic.generic.creation;

import java.util.List;

public class Cbound<T> implements Ibound1, Ibound2 {

	@SuppressWarnings("unused")
	private List<T> list;

	public Cbound(List<T> list) {
		this.list = list;
	}
}
