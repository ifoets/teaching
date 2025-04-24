package com.udemy.basic.functional.finterface;

@FunctionalInterface
public interface IFactory<T> {

	T create();
}
