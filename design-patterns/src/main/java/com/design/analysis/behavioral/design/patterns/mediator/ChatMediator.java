package com.design.analysis.behavioral.design.patterns.mediator;

public interface ChatMediator {

	public void sendMessage(String msg, User user);

	void addUser(User user);
}
