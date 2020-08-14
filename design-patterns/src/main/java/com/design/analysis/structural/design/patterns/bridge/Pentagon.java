package com.design.analysis.structural.design.patterns.bridge;

public class Pentagon extends BridgeShape {

	public Pentagon(Color c) {
		super(c);
	}

	@Override
	public void applyColor() {
		System.out.print("Pentagon filled with color ");
		color.applyColor();
	}

}