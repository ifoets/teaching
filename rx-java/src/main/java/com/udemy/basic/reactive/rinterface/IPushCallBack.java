package com.udemy.basic.reactive.rinterface;

public interface IPushCallBack {

	void pushData(String data);

	void pushComplete();

	void pushError(Exception ex);
}
