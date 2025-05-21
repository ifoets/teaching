package com.udemy.design.analysis.functional.finterface;

@FunctionalInterface
public interface ICalculatorServie<T, R> {

	R operation(T t1, T t2);
}
