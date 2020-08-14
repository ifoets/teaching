package com.design.analysis.algorithms.interview.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Party extends Thread {
	private int duration;
	private CyclicBarrier barrier;

	public Party(int duration, CyclicBarrier barrier, String name) {
		super(name);
		this.duration = duration;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(duration);
			System.out.println(Thread.currentThread().getName() + " waiting at barrier 1");
			this.barrier.await();
			System.out.println(Thread.currentThread().getName()+" after barrier 1");
			//System.out.println(Thread.currentThread().getName() + " has started running again");
			System.out.println(Thread.currentThread().getName() + " waiting at barrier 2");
			this.barrier.await();

			System.out.println(Thread.currentThread().getName() + " done!");
			
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}

public class CycleBarrierExpl {

	public static void main(String[] args) {

		CyclicBarrier barrier = new CyclicBarrier(4);
		Party first = new Party(1000, barrier, "PARTY-1");
		Party second = new Party(2000, barrier, "PARTY-2");
		Party third = new Party(3000, barrier, "PARTY-3");
		Party fourth = new Party(4000, barrier, "PARTY-4");
		first.start();
		second.start();
		third.start();
		fourth.start();
		System.out.println(Thread.currentThread().getName() + " has finished");
	}
}
