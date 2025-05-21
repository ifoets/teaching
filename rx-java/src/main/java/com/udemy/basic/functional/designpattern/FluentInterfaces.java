package com.udemy.basic.functional.designpattern;

import com.udemy.basic.functional.model.Order;

public class FluentInterfaces {

	public static void fluentMethod() {
		Order.place(order -> 
		   order.add("Shoe")
			.add("Pen")
			.deliver("Bangalore Sukuka layout Steet 3 third floor")
		);
	}
}
