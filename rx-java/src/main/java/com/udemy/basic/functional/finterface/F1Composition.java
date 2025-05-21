package com.udemy.basic.functional.finterface;

import java.util.Objects;

@FunctionalInterface
public interface F1Composition<T, R> {

	R apply(T t);

	default <V> F1Composition<V, R> compose(F1Composition<V, T> before) {
		Objects.requireNonNull(before);
		return (V v) -> {
			// return apply(before.apply(v));
			T t = before.apply(v);
			R r = this.apply(t);
			return r;
		};
	}

}
