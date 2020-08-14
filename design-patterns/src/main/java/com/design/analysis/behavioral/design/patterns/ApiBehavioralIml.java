package com.design.analysis.behavioral.design.patterns;

import java.util.List;
import java.util.Scanner;

import com.design.analysis.behavioral.design.patterns.chainofresponsibility.ATMDispenseChain;
import com.design.analysis.behavioral.design.patterns.chainofresponsibility.Currency;
import com.design.analysis.behavioral.design.patterns.chainofresponsibility.Dollar50Dispenser;
import com.design.analysis.behavioral.design.patterns.mediator.ChatMediator;
import com.design.analysis.behavioral.design.patterns.mediator.ChatMediatorImpl;
import com.design.analysis.behavioral.design.patterns.mediator.User;
import com.design.analysis.behavioral.design.patterns.mediator.UserImpl;
import com.design.analysis.behavioral.design.patterns.template.HouseTemplate;

public class ApiBehavioralIml implements IApiBehavioral {

	/** 1. Template Method Pattern **/
	public void templateMethodPattern(HouseTemplate ht) {
		ht.buildHouse();
	}

	/** 2. Mediator Pattern **/
	public void mediatorPattern(List<String> nameList) {
		ChatMediator mediator = new ChatMediatorImpl();
		User usr = null;
		for (String usrName : nameList) {
			usr = new UserImpl(mediator, usrName);
			mediator.addUser(usr);
		}
		usr.send("Hi All");
	}

	/** 3. Chain of Responsibility Pattern **/
	public void chainOfRespPattern() {

		ATMDispenseChain atmDispenser = new ATMDispenseChain(new Dollar50Dispenser());
		while (true) {
			int amount = 0;
			System.out.println("Enter amount to dispense");
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			amount = input.nextInt();
			if (amount % 10 != 0) {
				System.out.println("Amount should be in multiple of 10s.");
			}
			// process the request
			atmDispenser.c1.dispense(new Currency(amount));
		}
	}
}
