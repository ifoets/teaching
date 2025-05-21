package com.udemy.basic.functional.finterface;

//SAM Single Abstract Method notation @FunctionalInterface
@FunctionalInterface
public interface IOpertionService<X, Y> {
	Y operation(X x1, X x2);
}
