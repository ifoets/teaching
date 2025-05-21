package interview.preparation.company.interviews.impl;

public class EvenOddThread {
	int counter = 1;
	int N = 20;

	public static void main(String[] args) {
		EvenOddThread ev = new EvenOddThread();
		new Thread( ()->ev.printEven(),"even").start();
		new Thread( ()->ev.printOdd(),"odd").start();
	}

	public void printEven() {
		synchronized (this) {
			while (counter < N) {
				if (counter % 2 == 1) {
					try {
						wait();
						Thread.sleep(1000);
					} catch (InterruptedException e) {

					}
				}
				System.out.println(Thread.currentThread().getName() + ":" + counter);
				counter++;
				notify();
			}
		}
	}

	public void printOdd() {
		synchronized (this) {
			while (counter < N) {
				String str1 = Thread.currentThread().getName();
				if (counter % 2 == 0) {
					try {
						wait();
						Thread.sleep(1000);
					} catch (InterruptedException e) {

					}
				}
				System.out.println(Thread.currentThread().getName() + ":" + counter);
				counter++;
				notify();
			}
		}

	}
}
