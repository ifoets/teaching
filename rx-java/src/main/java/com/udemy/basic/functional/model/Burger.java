package com.udemy.basic.functional.model;

public class Burger {

	String burgerType;

	public Burger() {
		this.burgerType = "";
	}

	private Burger(String burgetType) {
		this.burgerType = burgetType;
	}

	public Burger addVegies() {
		System.out.println("Adding vegies to Burge");
		return new Burger(this.burgerType += " Vegies");
	}

	public Burger addCheese() {
		System.out.println("Adding cheesee to Burge");
		return new Burger(this.burgerType += " Cheese");
	}

	@Override
	public String toString() {
		return String.format("%s",  burgerType + " burger");
	}
}
