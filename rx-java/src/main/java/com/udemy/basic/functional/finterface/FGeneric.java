package com.udemy.basic.functional.finterface;

@FunctionalInterface
public interface FGeneric<R, T> {

	R execute(T t);

}
