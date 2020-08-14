package com.design.analysis.structural.design.patterns.bridge;

public class Triangle extends BridgeShape {

	public Triangle(Color c) {
		super(c);
	}

	@Override
	public void applyColor() {
		System.out.print("Triangle filled with color ");
		color.applyColor();
	}

}