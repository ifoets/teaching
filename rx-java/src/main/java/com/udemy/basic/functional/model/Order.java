package com.udemy.basic.functional.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Order {

	private List<String> cart = new ArrayList<>();
	private String address = "";

	public Order() {

	}

	public Order(List<String> cart, String address) {
		this.cart = cart;
		this.address = address;
	}

	public Order add(String item) {
		this.cart.add(item);
		System.out.println(item + " addeed to the cart");
		return new Order(this.cart, this.address);
	}

	public Order deliver(String location) {
		this.address = location;
		System.out.println("The delivery address set by you : " + location);
		return new Order(this.cart, this.address);
	}

	public static void place(Function<Order, Order> fun) {
		Order order = new Order();
		fun.apply(order);
		System.out.println("Order Placed");
		System.out.println(
				order.cart.size() + " item orderded by you will be delivered at " + order.address + " by tomorrow");
	}
}
