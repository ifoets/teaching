package com.udemy.basic.functional.designpattern;

import java.util.function.Function;

import com.udemy.basic.functional.model.Burger;

public class DecoratorBurger {

	Function<Burger, Burger> decorator;

	public DecoratorBurger(Function<Burger, Burger> decoration) {
		this.decorator = decoration;
	}

	public Burger use(Burger baseBurger) {
		System.out.println("Base Burger :" + baseBurger);
		return decorator.apply(baseBurger);
	}
}
