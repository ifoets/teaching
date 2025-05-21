package com.udemy.basic.functional.demo;

import java.util.function.Consumer;

import com.udemy.basic.functional.model.Mobile;

public class MobileBuilder {
	public int ram, storage;
	public int battery;
	public int camera;
	public String processor;
	public double screenSize;

	public MobileBuilder with(Consumer<MobileBuilder> buildFields) {
		buildFields.accept(this);
		return this;
	}

	public Mobile createMobile() {
		return new Mobile(this);
	}

}
