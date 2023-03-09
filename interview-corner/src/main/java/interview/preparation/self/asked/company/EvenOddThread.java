package interview.preparation.self.asked.company;

public class EvenOddThread {
	int counter = 1;
	int N = 20;

	public static void main(String[] args) {
		EvenOddThread ev = new EvenOddThread();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				ev.printEven();
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				ev.printOdd();
			}
		});
		t1.start();
		t2.start();
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
