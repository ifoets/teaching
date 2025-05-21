package com.udemy.basic.generic.creation;

@FunctionalInterface
public interface IInnerService<T, R> {

	R greet(T t);
}
