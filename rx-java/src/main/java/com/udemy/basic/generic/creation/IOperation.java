package com.udemy.basic.generic.creation;

@FunctionalInterface
interface IOperation {

	// generic method without class level declaration
	<X, Y> Y operation(X x1, X x2);
}
