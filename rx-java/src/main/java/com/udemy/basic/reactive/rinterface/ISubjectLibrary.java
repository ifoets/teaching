package com.udemy.basic.reactive.rinterface;

public interface ISubjectLibrary {

	public void subscribeObserver(IObserver ob);

	public void unsubscribeObserver(IObserver ob);

	public void notifyObserver();
}
