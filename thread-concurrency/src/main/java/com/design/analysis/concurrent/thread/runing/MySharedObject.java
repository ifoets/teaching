package com.design.analysis.concurrent.thread.runing;

public class MySharedObject {

	// static variable pointing to instance of MySharedObject

	public static final MySharedObject sharedInstance = new MySharedObject();

	// member variables pointing to two objects on the heap

	@SuppressWarnings("deprecation")
	public Integer object2 = new Integer(22);
	@SuppressWarnings("deprecation")
	public Integer object4 = new Integer(44);

	public long member1 = 12345;
	public long member2 = 67890;
}
