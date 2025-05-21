package com.udemy.basic.functional.finterface;

public interface F1Closer {

	void doTask();

	default F1Closer thenDoNextTask(F1Closer fcal) {
		F1Closer fcalNew = () -> {
			this.doTask();
			fcal.doTask();
		};
		return fcalNew;
	}
}
