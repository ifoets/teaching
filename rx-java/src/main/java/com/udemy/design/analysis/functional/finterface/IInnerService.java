package com.udemy.design.analysis.functional.finterface;

public interface IInnerService<T, R> {
	R execute(T t);

}
