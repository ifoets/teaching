package com.udemy.basic.generic.creation;

public class Data<T> implements IData<T> {

	private T data;

	public Data(T data) {
		super();
		this.data = data;
	}

	@Override
	public T getData() {
		return data;
	}

	@Override
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Data is- " + data;
	}

}
