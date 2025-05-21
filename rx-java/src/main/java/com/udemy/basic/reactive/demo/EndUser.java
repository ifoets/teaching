package com.udemy.basic.reactive.demo;

import com.udemy.basic.reactive.rinterface.IObserver;
import com.udemy.basic.reactive.rinterface.ISubjectLibrary;

public class EndUser implements IObserver {

	public String name;

	public EndUser(String name, ISubjectLibrary subject) {
		this.name = name;
		subject.subscribeObserver(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return name;
	}

	@Override
	public void update(String avail) {
		System.out.println("Hello " + name + "! we are glad to notify you that your book is now " + avail);

	}

}
