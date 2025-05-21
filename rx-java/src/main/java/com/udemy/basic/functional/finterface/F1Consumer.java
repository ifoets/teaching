package com.udemy.basic.functional.finterface;

import java.util.Objects;

@FunctionalInterface
public interface F1Consumer<T> {
	void accept(T t);

	default F1Consumer<T> thenAccept(F1Consumer<T> next) {
		Objects.requireNonNull(next); // to avoid NE
		return (T t) -> {
			this.accept(t);
			next.accept(t);
		};
	}
}
