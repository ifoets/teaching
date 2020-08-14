package com.design.analysis.concurrent.utils.running;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapExpl implements Runnable {

	public ConcurrentMap<String, String> cmap = null;

	public ConcurrentMapExpl() {
		cmap = new ConcurrentHashMap<>();
	}

	@Override
	public void run() {

		String str = Thread.currentThread().getName();
		cmap.put(str, str);
	}
}
