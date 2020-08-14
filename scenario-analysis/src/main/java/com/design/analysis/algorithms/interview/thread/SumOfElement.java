package com.design.analysis.algorithms.interview.thread;

public class SumOfElement implements Runnable {

	public static int arr[] = { 1, 2, 3, 45, 6, 7, 8, 9, 10 };
	public static int n1, n2;

	public static int sum = 0;

	public static void main(String[] args) {
		SumOfElement eo = new SumOfElement();
		Thread e = new Thread(eo, "even");
		Thread o = new Thread(eo, "odd");
		n1 = 0;
		n2 = arr.length / 2;
		e.start();
		o.start();
	}

	@Override
	public void run() {

		while (Thread.currentThread().getName() == "even" && n1 < arr.length / 2) {
			sum += arr[n1++];
		}

		while (Thread.currentThread().getName() == "odd" && n2 < arr.length) {
			sum += arr[n2++];
		}
		if (n1 == arr.length/2 && n2 == arr.length)
			System.out.println(sum/2);

	}
}
