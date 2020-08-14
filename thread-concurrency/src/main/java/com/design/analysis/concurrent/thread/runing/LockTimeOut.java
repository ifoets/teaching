package com.design.analysis.concurrent.thread.runing;

public class LockTimeOut implements Runnable {

	public boolean isAunlocked = false;
	public boolean isBunlocked = false;
	public boolean isCunlocked = false;

	public synchronized void A() throws InterruptedException {
		isAunlocked = false;
		System.out.println(Thread.currentThread().getName() + " Is in method A()");
		for (int i = 0; i < 10; i++)
			;
		isAunlocked = true;
	}

	public synchronized void B() throws InterruptedException {
		isBunlocked = false;
		System.out.println(Thread.currentThread().getName() + " Is in method B()");
		for (int i = 0; i < 10; i++)
			;
		isBunlocked = true;
	}

	public synchronized void C() throws InterruptedException {
		isCunlocked = false;
		System.out.println(Thread.currentThread().getName() + " Is in method C()");
		for (int i = 0; i < 10; i++)
			;
		isCunlocked = true;
	}

	@Override
	public void run() {

		String str = Thread.currentThread().getName();
		switch (str) {
		case "xy":
			try {
				A();
				B();
				C();
			} catch (InterruptedException e) {

			}
			break;
		case "yz":
			try {
				do{
					A();
				}while(!isAunlocked);
				
				do{
					B();
				}while(!isBunlocked);
				
				do{
					C();
				}while(!isCunlocked);
				
			} catch (InterruptedException e) {

			}
		}
	}
}
