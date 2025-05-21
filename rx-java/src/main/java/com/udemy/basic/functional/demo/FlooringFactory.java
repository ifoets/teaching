package com.udemy.basic.functional.demo;

import java.util.function.Supplier;

public class FlooringFactory {

	public static Iflooring getFlooring(int minTempratue, int maxTemperature) {

		Supplier<Iflooring> flooring;

		if (minTempratue <= 5 && maxTemperature <= 20) {
			flooring = () -> new WoddenFlooring();
		} else if (minTempratue <= 5 && maxTemperature >= 45) {
			flooring = () -> new CorkFlooring();
		} else {
			flooring = () -> new ConcreteFlooring();
		}
		return flooring.get();
	}
}
