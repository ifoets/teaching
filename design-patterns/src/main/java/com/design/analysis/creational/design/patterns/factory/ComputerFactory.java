package com.design.analysis.creational.design.patterns.factory;

public class ComputerFactory {

	public static ComputerSuper getComputer(ComputerAbstractFactory factory) {
		return factory.createComputer();
	}
}
