package com.design.analysis.structural.design.patterns.adapter;

public class Socket {

	public Volt getVolt() {
		return new Volt(120);
	}
}