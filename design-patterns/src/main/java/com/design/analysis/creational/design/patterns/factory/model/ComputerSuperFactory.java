package com.design.analysis.creational.design.patterns.factory.model;

import com.design.analysis.creational.design.patterns.factory.ComputerSuper;

public class ComputerSuperFactory {

	public static ComputerSuper getComputer(String type, String ram, String hdd, String cpu) {
		if ("PC".equalsIgnoreCase(type))
			return new PC(ram, hdd, cpu);
		else if ("Server".equalsIgnoreCase(type))
			return new Server(ram, hdd, cpu);

		return null;
	}
}
