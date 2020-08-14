package com.design.analysis.structural.design.patterns.bridge;

public abstract class BridgeShape {
	// Composition - implementor
	protected Color color;

	// constructor with implementor as input argument
	public BridgeShape(Color c) {
		this.color = c;
	}

	abstract public void applyColor();
}
