package com.udemy.basic.generic.creation;

/***
 * A Generic class can extends other generic class and implements other Generic
 * interface using same type(T) parameter
 * 
 **/


public class SubclassingData<T> extends BaseData<T> implements ISubclassingData<T> {

	private T data;

	public SubclassingData(T data) {
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
