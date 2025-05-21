package com.udemy.basic.functional.demo;

import com.udemy.basic.functional.finterface.ICommand;

public class ACAutomationRemote {
	ICommand command;

	public void setCommand(ICommand command) {
		this.command = command;
	}

	public void buttonPressed() {
		command.execute();
	}
}
