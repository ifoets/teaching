package com.udemy.basic.generic.creation;

/**
 * /* A Generic interface can extends other generic interface using same type(T)
 * parameter
 * 
 **/

interface IBaseSubClassing<T> {
}

public interface ISubclassingData<T> extends IBaseSubClassing<T> {

	public T getData();

	public void setData(T t);
}
