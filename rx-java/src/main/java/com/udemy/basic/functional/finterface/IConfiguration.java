package com.udemy.basic.functional.finterface;

@FunctionalInterface
public interface IConfiguration<T, R> {
	R configure(T t);
}
