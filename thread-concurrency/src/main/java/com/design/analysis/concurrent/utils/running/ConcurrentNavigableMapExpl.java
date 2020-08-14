package com.design.analysis.concurrent.utils.running;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentNavigableMapExpl implements Runnable {

	public ConcurrentNavigableMap<String, String> cmap = null;

	public ConcurrentNavigableMapExpl() {
		cmap = new ConcurrentSkipListMap<>();
	}

	@Override
	public void run() {

		String str = Thread.currentThread().getName();
		cmap.put(str, str);
	}
}
