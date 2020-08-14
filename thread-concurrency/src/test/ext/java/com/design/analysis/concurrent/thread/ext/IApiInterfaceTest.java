package com.design.analysis.concurrent.thread.ext;

import org.junit.Before;
import org.junit.Test;

import com.design.analysis.concurrent.thread.api.ApiInterfaceImpl;
import com.design.analysis.concurrent.thread.api.IApiInterface;

public class IApiInterfaceTest {

	public IApiInterface iai = null;

	@Before
	public void init() {
		iai = new ApiInterfaceImpl();
	}

	/* producer consumer commmunication */
	@Test
	public void producerConsumerIntr() throws InterruptedException {
		iai.producerConsumerIntr();
	}
}
