package com.design.analysis.concurrent.thread;

import com.design.analysis.concurrent.thread.runing.BlockingQueue;
import com.design.analysis.concurrent.thread.runing.CompAndSwapByAtomic;
import com.design.analysis.concurrent.thread.runing.Counter;
import com.design.analysis.concurrent.thread.runing.CounterThread;
import com.design.analysis.concurrent.thread.runing.DeadLockSolveByOrderChange;
import com.design.analysis.concurrent.thread.runing.ImmutableValue;
import com.design.analysis.concurrent.thread.runing.LocalObjectReference;
import com.design.analysis.concurrent.thread.runing.LocalVariable;
import com.design.analysis.concurrent.thread.runing.LockTimeOut;
import com.design.analysis.concurrent.thread.runing.MyRunnableNoThreadSafe;
import com.design.analysis.concurrent.thread.runing.NotThreadSafe;
import com.design.analysis.concurrent.thread.runing.ReentranceExample;
import com.design.analysis.concurrent.thread.runing.ReentranceLockout;
import com.design.analysis.concurrent.thread.runing.SchCounter;
import com.design.analysis.concurrent.thread.runing.ShareVisibility;
import com.design.analysis.concurrent.thread.runing.SimpleComAndSwap;
import com.design.analysis.concurrent.thread.runing.SimpleDeadLock;
import com.design.analysis.concurrent.thread.runing.ThreadLocalExp;
import com.design.analysis.concurrent.thread.runing.TwoSum;
import com.design.analysis.concurrent.thread.runing.VarWithVolatile;
import com.design.analysis.concurrent.thread.runing.VolatileVar;
import com.design.analysis.concurrent.thread.runing.lock.CounterLock;
import com.design.analysis.concurrent.thread.runing.lock.CounterSyn;
import com.design.analysis.concurrent.thread.runing.lock.ReentrantLockUse;
import com.design.analysis.concurrent.thread.runing.lock.SimpleReentrant;
import com.design.analysis.concurrent.thread.runing.lock.UnlockFromFinallyBlock;
import com.design.analysis.concurrent.thread.runing.nestedmonitor.NestedMointorFairLockUse;
import com.design.analysis.concurrent.thread.runing.nestedmonitor.NestedMointorLockUse;
import com.design.analysis.concurrent.thread.runing.readwritelock.ReadWriteLockReadReentranceUse;
import com.design.analysis.concurrent.thread.runing.readwritelock.ReadWriteLockUse;
import com.design.analysis.concurrent.thread.runing.readwritelock.ReadWriteLockWriteReentranceUse;
import com.design.analysis.concurrent.thread.runing.readwritelock.ReadWriteReadToWriteReentranceUse;
import com.design.analysis.concurrent.thread.runing.semaphore.BoundedSemaphore;
import com.design.analysis.concurrent.thread.runing.semaphore.CountingSemaphore;
import com.design.analysis.concurrent.thread.runing.semaphore.SimpleSemaphore;
import com.design.analysis.concurrent.thread.runing.signaling.Message;
import com.design.analysis.concurrent.thread.runing.signaling.Notifier;
import com.design.analysis.concurrent.thread.runing.signaling.NotifierConstantObj;
import com.design.analysis.concurrent.thread.runing.signaling.NotifierSaveSignal;
import com.design.analysis.concurrent.thread.runing.signaling.NotifierSpuriousWakeups;
import com.design.analysis.concurrent.thread.runing.signaling.SignalingBySharedObj;
import com.design.analysis.concurrent.thread.runing.signaling.Waiter;
import com.design.analysis.concurrent.thread.runing.signaling.WaiterConstantObj;
import com.design.analysis.concurrent.thread.runing.signaling.WaiterSaveSingnal;
import com.design.analysis.concurrent.thread.runing.signaling.WaiterSpuriousWakeups;
import com.design.analysis.concurrent.thread.runing.slipped.AvoidSlippedFairLockUse;
import com.design.analysis.concurrent.thread.runing.slipped.AvoidSlippedlockUse;
import com.design.analysis.concurrent.thread.runing.slipped.SlippedFairLockUse;
import com.design.analysis.concurrent.thread.runing.slipped.SlippedlockUse;
import com.design.analysis.concurrent.thread.runing.starvationfairness.FairLocalLockUse;
import com.design.analysis.concurrent.thread.runing.starvationfairness.LocalLockUse;
import com.design.analysis.concurrent.thread.runing.starvationfairness.StarvationBlockedIndefinitely;
import com.design.analysis.concurrent.thread.runing.starvationfairness.StarvationPriority;
import com.design.analysis.concurrent.thread.runing.synchronize.SynchronizedNonStatic;
import com.design.analysis.concurrent.thread.runing.synchronize.SynchronizedNonStaticContineous;
import com.design.analysis.concurrent.thread.runing.synchronize.SynchronizedStatic;
import com.design.analysis.concurrent.thread.runing.synchronize.SynchronizedStaticContineous;
import com.design.analysis.concurrent.thread.runing.threadpool.PoolBlockingQueue;
import com.design.analysis.concurrent.thread.runing.threadpool.ThreadPool;

public class JavaConcurrencyImpl implements IJavaConcurrency {

	public static String threadCall = null;
	public int no = 0;

	/** Creating and Starting Java Threads **/
	@Override
	public void createStartThread() {

		System.out.println(Thread.currentThread().getName());
		for (int i = 0; i < 10; i++) {
			new Thread("" + i) {
				public void run() {
					System.out.println("Thread: " + getName() + " running");
				}
			}.start();
		}
	}

	/** Race Conditions and Critical Sections **/
	/* race condition occur */
	@Override
	public void raceCondition() throws InterruptedException {
		Counter counter = new Counter();
		Thread t1 = new Thread(counter);
		counter.add(2);
		t1.start();
		Thread t2 = new Thread(counter);
		// Thread.sleep(10); result is not same every time
		counter.add(3);
		t2.start();
	}

	/* prevent race condition */
	@Override
	public void preventRaceCondition() throws InterruptedException {

		TwoSum s1 = new TwoSum();
		Thread t1 = new Thread(s1);
		s1.add(3, 4);
		t1.start();
		Thread t2 = new Thread(s1);
		Thread.sleep(10); // result will be same every time
		s1.add(5, 6);
		t2.start();
	}

	@Override
	/** Thread Safety and Shared Resources **/
	/* check local varible are thread safe */
	public void localVarialeByDefaultThreadSafe() {
		LocalVariable locVar = new LocalVariable();
		Thread t1 = new Thread(locVar);
		locVar.loacalVariable();
		t1.start();
		Thread t2 = new Thread(locVar);
		locVar.loacalVariable();
		t2.start();
	}

	/* a case of local reference is thread safe */
	@Override
	public void safeLocalObjectReference() {
		LocalObjectReference locObjRef = new LocalObjectReference();
		Thread t1 = new Thread(locObjRef);
		t1.start();

		Thread t2 = new Thread(locObjRef);
		t2.start();
	}

	/* Object Member Variables are not thread safe on same instance */
	public void objectMembarVariableNotThreadSafe() {
		NotThreadSafe sharedInstance = new NotThreadSafe();

		new Thread(new MyRunnableNoThreadSafe(sharedInstance)).start();
		sharedInstance.printText();
		new Thread(new MyRunnableNoThreadSafe(sharedInstance)).start();
		sharedInstance.printText();

	}

	/* Object Member Variables are not thread safe on different instance */
	public void objectMembarVariableThreadSafe() {
		NotThreadSafe sharedInstance1 = new NotThreadSafe();
		NotThreadSafe sharedInstance2 = new NotThreadSafe();

		new Thread(new MyRunnableNoThreadSafe(sharedInstance1)).start();
		sharedInstance1.printText();
		new Thread(new MyRunnableNoThreadSafe(sharedInstance2)).start();
		sharedInstance2.printText();
	}

	/* Immutability formation */
	@Override
	public void immutableClassForm() {

		ImmutableValue immu1 = new ImmutableValue(5);
		ImmutableValue immu2 = new ImmutableValue(7);

		immu1 = immu1.add(5);
		Thread t1 = new Thread(immu1);
		Thread t2 = new Thread(immu2);

		t1.start();
		t2.start();
	}

	/* Visibility of Shared Objects */
	@Override // both should show same value but due to invisibility its showing different
	public void mayNonVisibleToOtherThead() throws InterruptedException {
		System.out.println("Non Volatile varible");
		ShareVisibility sharVar = new ShareVisibility();
		Thread t1 = new Thread(sharVar);
		sharVar.update(1);
		// sharVar.updateVolatile(1);
		t1.start();
		Thread.sleep(10);
		Thread t2 = new Thread(sharVar);
		sharVar.update(1);
		// sharVar.updateVolatile(1);
		t2.start();

		Thread.sleep(10);// wait to run misture of valatile and non valaitel varible test call

		System.out.println("\nVolatile varible");
		// for volatile take and update to main memory
		ShareVisibility sharVar1 = new ShareVisibility();
		Thread t11 = new Thread(sharVar1);
		sharVar.updateVolatile(1);
		t11.start();
		Thread.sleep(10);
		Thread t21 = new Thread(sharVar);
		sharVar.updateVolatile(1);
		t21.start();
	}

	/** Java Synchronized Blocks **/
	/* non static block /method */
	public void synchronizedNonStaticExmpl() throws InterruptedException {
		SynchronizedNonStatic ss = new SynchronizedNonStatic();
		// all thread call same time on sychronized methods
		Thread t1 = new Thread(ss);
		Thread t2 = new Thread(ss);
		Thread t4 = new Thread(ss);
		Thread t5 = new Thread(ss);
		t1.start();
		t2.start();
		t4.start();
		t5.start();
	}

	/* on samme thread */
	public void synchronizedNonStaticExmplX() throws InterruptedException {
		SchCounter counter = new SchCounter();
		Thread threadA = new CounterThread(counter);
		Thread threadB = new CounterThread(counter);
		Thread.sleep(10);
		threadA.start();
		threadB.start();
	}

	/* on different thread */
	public void synchronizedNonStaticExmplY() throws InterruptedException {
		SchCounter counter = new SchCounter();
		SchCounter counter1 = new SchCounter();
		Thread threadA = new CounterThread(counter);
		Thread threadB = new CounterThread(counter1);
		Thread.sleep(10);
		threadA.start();
		threadB.start();
	}

	/* non static block /method contineous */
	public void synchronizedNonStaticExmplContineous() throws InterruptedException {
		SynchronizedNonStaticContineous ss = new SynchronizedNonStaticContineous();
		// all thread call same time on sychronized methods
		Thread t1 = new Thread(ss);
		Thread t2 = new Thread(ss);
		Thread t4 = new Thread(ss);
		Thread t5 = new Thread(ss);
		t1.start();
		t2.start();
		t4.start();
		t5.start();
	}

	/* non static block /method seperately synchronized */
	@Override
	public void synchronizedStaticExmpl() throws InterruptedException {
		SynchronizedStatic ss1 = new SynchronizedStatic();
		SynchronizedStatic ss2 = new SynchronizedStatic();
		SynchronizedStatic ss3 = new SynchronizedStatic();
		SynchronizedStatic ss4 = new SynchronizedStatic();
		// all thread call same time on sychronized methods
		Thread t1 = new Thread(ss1);
		Thread t2 = new Thread(ss2);
		Thread t4 = new Thread(ss3);
		Thread t5 = new Thread(ss4);
		t1.start();
		t2.start();
		t4.start();
		t5.start();
	}

	/* non static block /method contineous synchronized */
	@Override
	public void synchronizedStaticExmplContineous() throws InterruptedException {
		SynchronizedStaticContineous ss1 = new SynchronizedStaticContineous();
		SynchronizedStaticContineous ss2 = new SynchronizedStaticContineous();
		SynchronizedStaticContineous ss3 = new SynchronizedStaticContineous();
		SynchronizedStaticContineous ss4 = new SynchronizedStaticContineous();
		// all thread call same time on sychronized methods
		Thread t1 = new Thread(ss1);
		Thread t2 = new Thread(ss2);
		Thread t4 = new Thread(ss3);
		Thread t5 = new Thread(ss4);
		t1.start();
		t2.start();
		t4.start();
		t5.start();
	}

	/** Java Volatile Keyword **/
	/* only update volatile variable */
	@Override
	public void volatileVar() throws InterruptedException {

		VolatileVar vv = new VolatileVar();
		Thread t1 = new Thread(vv);
		Thread t2 = new Thread(vv);
		t1.start();
		vv.update(8);
		t2.start();

	}

	/* all varibale update with volatile update */
	@Override
	public void volatileAllVar() throws InterruptedException {
		VarWithVolatile vv = new VarWithVolatile();
		Thread t1 = new Thread(vv);
		Thread t2 = new Thread(vv);
		t1.start();
		vv.update(2, 3, 4);
		t2.start();
	}

	/** Java ThreadLocal **/
	@Override
	public void threadLocalVar() throws InterruptedException {
		ThreadLocalExp sharedRunnableInstance = new ThreadLocalExp();

		Thread thread1 = new Thread(sharedRunnableInstance);
		Thread thread2 = new Thread(sharedRunnableInstance);

		thread1.start();
		thread2.start();

		thread1.join(); // wait for thread 1 to terminate
		thread2.join(); // wait for thread 2 to terminate
	}

	/** Thread Signaling **/
	@Override
	public void threadSignaling() throws InterruptedException {

		SignalingBySharedObj sbyso = new SignalingBySharedObj(new SignalingBySharedObj());
		Thread thread1 = new Thread(sbyso, "xy");
		Thread thread2 = new Thread(sbyso, "yz");
		thread1.start();
		thread2.start();
	}

	/* using wait notify */
	@Override
	public void waitNotifySignal() throws InterruptedException {

		Message msg = new Message("process it");
		msg.setNotifyAll(false);

		Waiter waiter = new Waiter(msg);
		new Thread(waiter, "waiter").start();

		Waiter waiter1 = new Waiter(msg);
		new Thread(waiter1, "waiter1").start();

		Notifier notifier = new Notifier(msg);
		new Thread(notifier, "notifier").start();
		System.out.println("All the threads are started");
	}

	/* By using wait notifyAll */
	@Override
	public void waitNotifyAllSignal() throws InterruptedException {

		Message msg = new Message("process it");
		msg.setNotifyAll(true);

		Waiter waiter = new Waiter(msg);
		new Thread(waiter, "waiter").start();

		Waiter waiter1 = new Waiter(msg);
		new Thread(waiter1, "waiter1").start();

		Notifier notifier = new Notifier(msg);
		new Thread(notifier, "notifier").start();
		System.out.println("All the threads are started");
	}

	/* Missed Signals ie notify get called before any thread waiting */
	public void missedSignals() throws InterruptedException {

		Message msg = new Message("process it");
		msg.setNotifyAll(false);

		Notifier notifier = new Notifier(msg);
		new Thread(notifier, "notifier").start();
		Thread.sleep(100);

		Waiter waiter = new Waiter(msg);
		new Thread(waiter, "waiter").start();

		Waiter waiter1 = new Waiter(msg);
		new Thread(waiter1, "waiter1").start();

		System.out.println("All the threads are started");
	}

	/* Cover Missed Singal */
	@Override
	public void coverMissedSignals() throws InterruptedException {
		Message msg = new Message("process it");
		msg.setNotifyAll(false);

		NotifierSaveSignal notifier = new NotifierSaveSignal(msg);
		new Thread(notifier, "notifier").start();
		Thread.sleep(100);

		WaiterSaveSingnal waiter = new WaiterSaveSingnal(msg);
		new Thread(waiter, "waiter").start();

		WaiterSaveSingnal waiter1 = new WaiterSaveSingnal(msg);
		new Thread(waiter1, "waiter1").start();

		System.out.println("All the threads are started");
	}

	/* Manage Spurious Wakeups..might be theread wake up without signal */
	/* this is very serious problem */
	@Override
	public void manageSpuriousWakeupsSignal() throws InterruptedException {
		Message msg = new Message("process it");
		msg.setWasSignalled(false);

		WaiterSpuriousWakeups waiter = new WaiterSpuriousWakeups(msg);
		new Thread(waiter, "waiter").start();

		WaiterSpuriousWakeups waiter1 = new WaiterSpuriousWakeups(msg);
		new Thread(waiter1, "waiter1").start();

		NotifierSpuriousWakeups notifier = new NotifierSpuriousWakeups(msg);
		new Thread(notifier, "notifier").start();

		System.out.println("All the threads are started");
	}

	/* Don't call wait() on constant String's or global objects */
	public void avoidWaitNotifyOnCostanctObj() throws InterruptedException {

		Message msg = new Message("process it");
		msg.setMyMonitorObject("xyz");
		msg.setNotifyAll(false);

		NotifierConstantObj waiter = new NotifierConstantObj(msg);
		new Thread(waiter, "waiter").start();

		WaiterConstantObj waiter1 = new WaiterConstantObj(msg);
		new Thread(waiter1, "waiter1").start();

		WaiterConstantObj notifier = new WaiterConstantObj(msg);
		new Thread(notifier, "notifier").start();

		System.out.println("All the threads are started");
	}

	@Override
	public void simpleDeadLock() throws InterruptedException {
		SimpleDeadLock.excute();
	}

	/** Deadlock Prevention **/
	/* Lock Ordering */
	@Override
	public void lockOrdering() throws InterruptedException {
		DeadLockSolveByOrderChange.execute();
	}

	/* using time out/wait mechanism */
	@Override
	public void lockTimeout() throws InterruptedException {
		LockTimeOut smd = new LockTimeOut();
		new Thread(smd, "xy").start();
		// Thread.sleep(1);
		new Thread(smd, "yz").start();
	}

	/** Starvation and Fairness **/
	/*
	 * Threads with high priority swallow all CPU time from threads with lower
	 * priority
	 */
	@Override
	public void starvationDueToHighPriority() throws InterruptedException {
		StarvationPriority sp = new StarvationPriority();
		Thread t[] = new Thread[10];
		for (int i = 0; i < t.length; i++) {
			t[i] = new Thread(sp);
			if (i < 3)
				t[i].setPriority(Thread.MIN_PRIORITY);
			else
				t[i].setPriority(Thread.MAX_PRIORITY);
		}
		for (int i = t.length - 1; i >= 0; i--)
			t[i].start();
	}

	/* Threads are blocked indefinitely waiting to enter a synchronized block */
	@Override
	public void starvationBlockedIndefinitely() throws InterruptedException {
		StarvationBlockedIndefinitely smd = new StarvationBlockedIndefinitely();
		new Thread(smd, "xy").start();
		// Thread.sleep(1);
		new Thread(smd, "yz").start();
	}

	/*
	 * Threads waiting on an object (called wait() on it) remain waiting
	 * indefinitely
	 */
	@Override
	public void starvationDueToWait() throws InterruptedException {
		Message msg = new Message("process it");
		msg.setNotifyAll(false);

		Waiter waiter = new Waiter(msg);
		new Thread(waiter, "waiter").start();

		Waiter waiter1 = new Waiter(msg);
		new Thread(waiter1, "waiter1").start();

		Notifier notifier = new Notifier(msg);
		new Thread(notifier, "notifier").start();
		System.out.println("All the threads are started");
	}

	/* lock inmplementatation */
	@Override
	public void lock() throws InterruptedException {
		LocalLockUse smd = new LocalLockUse();
		new Thread(smd, "xy").start();
		new Thread(smd, "yz").start();
		Thread.sleep(1);
		new Thread(smd, "zx").start();
	}

	/* implementtaion of FairLock */
	@Override
	public void fairLock() throws InterruptedException {
		FairLocalLockUse smd = new FairLocalLockUse();
		new Thread(smd, "xy").start();
		new Thread(smd, "yz").start();
		Thread.sleep(1);
		new Thread(smd, "zx").start();
	}

	// TODO need to understand well through out
	/** Nested Monitor Lockout it is simimalr to dead lock but not dead locak **/
	// indefinite dead lock
	@Override
	public void nestedMonitorlock() throws InterruptedException {
		NestedMointorLockUse smd = new NestedMointorLockUse();
		new Thread(smd, "xy").start();
		new Thread(smd, "yz").start();
		// Thread.sleep(1);
		new Thread(smd, "zx").start();
	}

	@Override
	public void nestedMonitorFairlock() throws InterruptedException {
		NestedMointorFairLockUse smd = new NestedMointorFairLockUse();
		new Thread(smd, "xy").start();
		new Thread(smd, "yz").start();
		// Thread.sleep(1);
		new Thread(smd, "zx").start();
	}

	/** Slipped Conditions **/
	// TODO need to understand very cleary the Lock Mechanism
	/* lock with slipped condittion */
	@Override
	public void slippedlock() throws InterruptedException {

		SlippedlockUse smd = new SlippedlockUse();
		new Thread(smd, "xy").start();
		new Thread(smd, "yz").start();
		new Thread(smd, "zx").start();
	}

	/* lock without slipped condition */
	@Override
	public void avoidSlippedlock() throws InterruptedException {
		AvoidSlippedlockUse smd = new AvoidSlippedlockUse();
		new Thread(smd, "xy").start();
		new Thread(smd, "yz").start();
		new Thread(smd, "zx").start();
	}

	/* fair lcok with slipped condition ie nested monitor lock */
	@Override
	public void slippedFairlock() throws InterruptedException {
		SlippedFairLockUse smd = new SlippedFairLockUse();
		new Thread(smd, "xy").start();
		new Thread(smd, "yz").start();
		new Thread(smd, "zx").start();
	}

	/* fair lock witout slipped condition */
	@Override
	public void avoidSlippedFairlock() throws InterruptedException {
		AvoidSlippedFairLockUse smd = new AvoidSlippedFairLockUse();
		new Thread(smd, "xy").start();
		new Thread(smd, "yz").start();
		new Thread(smd, "zx").start();
	}

	/* A Simple Lock using synchronization */
	@Override
	public void simpleLockBySynch() throws InterruptedException {
		CounterSyn smd = new CounterSyn();
		new Thread(smd, "xy").start();
		new Thread(smd, "yz").start();
		new Thread(smd, "zx").start();
	}

	/* A simple lock by lock method call */
	@Override
	public void simpleLockByLock() throws InterruptedException {
		CounterLock smd = new CounterLock();
		new Thread(smd, "xy").start();
		new Thread(smd, "yz").start();
		new Thread(smd, "zx").start();
	}

	/* A simple Reentrant lock */
	@Override
	public void simpleReentrantLock() throws InterruptedException {
		SimpleReentrant smd = new SimpleReentrant();
		new Thread(smd, "xy").start();
		new Thread(smd, "yz").start();
		new Thread(smd, "zx").start();
	}

	/* ReentrantLock use */
	@Override
	public void reentrantLockUse() throws InterruptedException {
		ReentrantLockUse smd = new ReentrantLockUse();
		new Thread(smd, "xy").start();
		new Thread(smd, "yz").start();
		new Thread(smd, "zx").start();
	}

	/* Calling unlock() From a finally-clause */
	@Override
	public void unlockFromFinallyBlock() throws InterruptedException {

		UnlockFromFinallyBlock smd = new UnlockFromFinallyBlock();
		new Thread(smd, "xy").start();
		new Thread(smd, "yz").start();
		new Thread(smd, "zx").start();
	}

	/** Read / Write Locks in Java **/
	/* read write lock */
	@Override
	public void readWriteLockUse() throws InterruptedException {

		ReadWriteLockUse smd = new ReadWriteLockUse();
		new Thread(smd, "a").start();
		new Thread(smd, "b").start();
		new Thread(smd, "c").start();
		new Thread(smd, "d").start();
		new Thread(smd, "e").start();
	}

	/* read write ...read reentarance lock */
	public void readWriteLockReadReentranceUse() throws InterruptedException {
		ReadWriteLockReadReentranceUse smd = new ReadWriteLockReadReentranceUse();

		new Thread(smd, "a").start();
		new Thread(smd, "b").start();
		new Thread(smd, "c").start();
		new Thread(smd, "d").start();
		new Thread(smd, "e").start();
	}

	/* read write ...read reentarance lock */
	@Override
	public void readWriteLockWriteReentranceUse() throws InterruptedException {
		ReadWriteLockWriteReentranceUse smd = new ReadWriteLockWriteReentranceUse();

		new Thread(smd, "a").start();
		new Thread(smd, "b").start();
		new Thread(smd, "c").start();
		new Thread(smd, "d").start();
		new Thread(smd, "e").start();
	}

	/* read write ...read to write reentarance lock */
	// TODO th rest of this topic read/write locks
	@Override
	public void readWriteReadToWriteReentranceUse() throws InterruptedException {

		ReadWriteReadToWriteReentranceUse smd = new ReadWriteReadToWriteReentranceUse();

		new Thread(smd, "a").start();
		new Thread(smd, "b").start();
		new Thread(smd, "c").start();
		new Thread(smd, "d").start();
		new Thread(smd, "e").start();
	}

	/* read write ...write to read reentarance lock */
	@Override
	public void readWriteWriteToReadReentranceUse() throws InterruptedException {

	}

	/* read write ...reentarance lock */
	@Override
	public void readWriteReentranceUse() throws InterruptedException {

	}

	/** Reentrance Lockout **/
	/* reentrance */
	@Override
	public void reentranceExample() throws InterruptedException {
		ReentranceExample smd = new ReentranceExample();

		new Thread(smd, "a").start();
		new Thread(smd, "b").start();
		new Thread(smd, "c").start();
		new Thread(smd, "d").start();
		new Thread(smd, "e").start();
	}

	/* reentrance lockout */
	@Override
	public void reentranceLockout() throws InterruptedException {

		ReentranceLockout smd = new ReentranceLockout();

		new Thread(smd, "a").start();
		new Thread(smd, "b").start();
		new Thread(smd, "c").start();
		new Thread(smd, "d").start();
		new Thread(smd, "e").start();
	}

	/** Semaphores **/
	/* a simple semaphore example */
	@Override
	public void simpleSemaphore() throws InterruptedException {
		SimpleSemaphore smd = new SimpleSemaphore();

		new Thread(smd, "a").start();
		new Thread(smd, "b").start();
		new Thread(smd, "c").start();
		new Thread(smd, "d").start();
	}

	/* a counting semaphore example */
	@Override
	public void countingSemaphore() throws InterruptedException {

		CountingSemaphore smd = new CountingSemaphore();

		new Thread(smd, "a").start();
		new Thread(smd, "b").start();
		new Thread(smd, "c").start();
		new Thread(smd, "d").start();
	}

	/* bounded semaphore */
	@Override
	public void boundedSemaphore() throws InterruptedException {
		BoundedSemaphore smd = new BoundedSemaphore(1);

		new Thread(smd, "a").start();
		new Thread(smd, "b").start();
		new Thread(smd, "c").start();
		new Thread(smd, "d").start();
		new Thread(smd, "e").start();
		new Thread(smd, "f").start();
	}

	/** Blocking Queues **/
	@Override
	public void blockingQueue() throws InterruptedException {

		BlockingQueue smd = new BlockingQueue(2);

		new Thread(smd, "a").start();
		new Thread(smd, "b").start();
		new Thread(smd, "c").start();
		new Thread(smd, "d").start();
		new Thread(smd, "e").start();
		new Thread(smd, "f").start();

		new Thread(smd, "a1").start();
		new Thread(smd, "b1").start();
		new Thread(smd, "c1").start();
		new Thread(smd, "d1").start();
		new Thread(smd, "e1").start();
		new Thread(smd, "f1").start();
	}

	/** Thread Pools **/
	@Override
	public void simpleThreadPool() throws InterruptedException {
		Runnable worker = new PoolBlockingQueue(5);
		ThreadPool tpool = new ThreadPool(5, 2);
		for (int i = 0; i < 10; i++) {
			try {
				tpool.execute(worker);
			} catch (Exception e) {
			}
			;
		}
	}

	/** Compare and Swap **/
	@Override
	public void simpleCompairAndSwap() throws InterruptedException {
		SimpleComAndSwap smd = new SimpleComAndSwap();
		new Thread(smd, "a").start();
		new Thread(smd, "b").start();
		new Thread(smd, "c").start();
		new Thread(smd, "d").start();
		new Thread(smd, "e").start();
		new Thread(smd, "f").start();
	}

	/* using atomic variable */
	@Override
	public void compairAndSwapWithAtomicVar() throws InterruptedException {
		CompAndSwapByAtomic smd = new CompAndSwapByAtomic();
		new Thread(smd, "a").start();
		new Thread(smd, "b").start();
		new Thread(smd, "c").start();
		new Thread(smd, "d").start();
		new Thread(smd, "e").start();
		new Thread(smd, "f").start();
	}
}
