package com.design.analysis.creational.design.patterns.factory;

import com.design.analysis.creational.design.patterns.factory.model.PC;

public class PCFactory implements ComputerAbstractFactory {

	private String ram;
	private String hdd;
	private String cpu;

	public PCFactory(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public ComputerSuper createComputer() {
		return new PC(ram, hdd, cpu);
	}

}
