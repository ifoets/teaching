package com.udemy.basic.generic.creation;

@FunctionalInterface
public interface IStringOperation<T> {

	T strOperation(String str);
}
