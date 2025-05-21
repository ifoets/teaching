package com.udemy.design.analysis.functional.finterface;

@FunctionalInterface
public interface IOuterService<T, R> {

	R apply(T t);
}
