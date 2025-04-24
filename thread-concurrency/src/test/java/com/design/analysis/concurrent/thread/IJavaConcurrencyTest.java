package com.design.analysis.concurrent.thread;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class IJavaConcurrencyTest {

	public IJavaConcurrency ijc = null;

	@Before
	public void init() {
		ijc = new JavaConcurrencyImpl();
	}

	/* Creating and Starting Java Threads */
	@Test
	public void createStartThreadTest() {
		ijc.createStartThread();
	}

	/** Race Conditions and Critical Sections **/
	@Test
	public void raceConditionTest() throws InterruptedException {
		ijc.raceCondition();
	}

	@Test
	public void preventRaceConditionTest() throws InterruptedException {
		ijc.preventRaceCondition();
	}

	/** Thread Safety and Shared Resources **/
	/* check local varible are thread safe */
	@Test
	public void localVarialeByDefaultThreadSafeTest() {
		ijc.localVarialeByDefaultThreadSafe();
	}

	/* a case of local reference is thread safe */
	@Test
	public void safeLocalObjectReferenceTest() {
		ijc.safeLocalObjectReference();
	}

	/* Object Member Variables are not thread safe on same instance */
	@Test // debug for check correct result with breaking point on printText
	public void objectMembarVariableNotThreadSafeTest() {
		ijc.objectMembarVariableNotThreadSafe();
	}

	/* Object Member Variables are not thread safe on different instance */
	@Test // debug for check correct result with breaking point on printText
	public void objectMembarVariableThreadSafeTest() {
		ijc.objectMembarVariableThreadSafe();
	}

	/** Thread Safety and Immutability **/
	/* Immutability formation */
	@Test
	public void immutableClassFormTest() {
		ijc.immutableClassForm();
	}

	/* Visibility of Shared Objects */
	@Test
	public void mayNonVisibleToOtherTheadTest() throws InterruptedException {
		ijc.mayNonVisibleToOtherThead();
	}

	/** Java Synchronized Blocks **/
	/* non static block /method */
	@Test
	public void synchronizedNonStaticExmplTest() throws InterruptedException {
		ijc.synchronizedNonStaticExmpl();
		// one of the output
		/*
		 * only one method is loced at same time on same object log1() :Thread-0 log2()
		 * :Thread-0 log1() :Thread-1 log1() :Thread-2 log2() :Thread-2 log3() :Thread-2
		 * log3() :Thread-0 log4() :Thread-0 log2() :Thread-1 log3() :Thread-1 log4()
		 * :Thread-1 log4() :Thread-2 log1() :Thread-3 log2() :Thread-3 log3() :Thread-3
		 * log4() :Thread-3
		 */
	}

	/* on samme thread */
	@Test
	public void synchronizedNonStaticExmplX() throws InterruptedException {
		ijc.synchronizedNonStaticExmplX();
		/*
		 * one of the out put means only one thread enter sychnronized block Thread-0 ::
		 * 0 Thread-0 :: 1 Thread-0 :: 2 Thread-0 :: 3 Thread-0 :: 4 Thread-0 :: 5
		 * Thread-0 :: 6 Thread-0 :: 7 Thread-0 :: 8 Thread-0 :: 9 Thread-1 :: 0
		 * Thread-1 :: 1 Thread-1 :: 2 Thread-1 :: 3 Thread-1 :: 4 Thread-1 :: 5
		 * Thread-1 :: 6 Thread-1 :: 7 Thread-1 :: 8 Thread-1 :: 9
		 * 
		 */
	}

	/* on different thread */
	@Test
	public void synchronizedNonStaticExmplY() throws InterruptedException {
		ijc.synchronizedNonStaticExmplY();
		/*
		 * one of the output ie any thread enter the sychnronized block Thread-1 :: 0
		 * Thread-1 :: 1 Thread-1 :: 2 Thread-0 :: 0 Thread-1 :: 3 Thread-1 :: 4
		 * Thread-1 :: 5 Thread-1 :: 6 Thread-1 :: 7 Thread-1 :: 8 Thread-1 :: 9
		 * Thread-0 :: 1 Thread-0 :: 2 Thread-0 :: 3 Thread-0 :: 4 Thread-0 :: 5
		 * Thread-0 :: 6 Thread-0 :: 7 Thread-0 :: 8 Thread-0 :: 9
		 */
	}

	/* non static block /method contineous */
	@Test
	public void synchronizedNonStaticExmplContineousTest() throws InterruptedException {
		ijc.synchronizedNonStaticExmplContineous();
		/*
		 * //all methods are locked on same object one of the output log1() :Thread-1
		 * log2() :Thread-1 log3() :Thread-1 log4() :Thread-1 log1() :Thread-3 log2()
		 * :Thread-3 log3() :Thread-3 log4() :Thread-3 log1() :Thread-2 log2() :Thread-2
		 * log3() :Thread-2 log4() :Thread-2 log1() :Thread-0 log2() :Thread-0 log3()
		 * :Thread-0 log4() :Thread-0
		 */

	}

	/* non static block /method seperately synchronized */
	@Test
	public void synchronizedStaticExmplTest() throws InterruptedException {
		ijc.synchronizedStaticExmpl();
		/*
		 * ie hole class is not locked but the particular method is locked one of the
		 * output log1() :Thread-1 log2() :Thread-1 log3() :Thread-1 log4() :Thread-1
		 * log1() :Thread-3 log1() :Thread-2 log2() :Thread-3 log3() :Thread-3 log4()
		 * :Thread-3 log2() :Thread-2 log3() :Thread-2 log1() :Thread-0 log2() :Thread-0
		 * log3() :Thread-0 log4() :Thread-0 log4() :Thread-2
		 * 
		 */
	}

	/* non static block /method contineous synchronized */
	@Test
	public void synchronizedStaticExmplContineousTest() throws InterruptedException {
		ijc.synchronizedStaticExmplContineous();
		/*
		 * one of the out put ie all methods or class locked by a thread during run it
		 * log1() :Thread-0 log2() :Thread-0 log3() :Thread-0 log4() :Thread-0 log1()
		 * :Thread-2 log2() :Thread-2 log3() :Thread-2 log4() :Thread-2 log1() :Thread-3
		 * log2() :Thread-3 log3() :Thread-3 log4() :Thread-3 log1() :Thread-1 log2()
		 * :Thread-1 log3() :Thread-1 log4() :Thread-1
		 */
	}

	/** Java Volatile Keyword **/
	/* only update volatile variable */
	@Test
	public void volatileVar() throws InterruptedException {

		ijc.volatileVar();
	}

	/* all varibale update with volatile update */
	@Test
	public void volatileAllVar() throws InterruptedException {
		ijc.volatileAllVar();
		/*
		 * Thread-0::824 Thread-1::824
		 */
	}

	/** Java ThreadLocal **/
	@Test
	public void threadLocalVarTest() throws InterruptedException {
		ijc.threadLocalVar();
	}

	/** Thread Signaling **/
	@Test
	public void threadSignalingTest() throws InterruptedException {
		ijc.threadSignaling();
	}

	/* using wait notify */
	@Test
	public void waitNotifySignalTest() throws InterruptedException {
		ijc.waitNotifySignal();
	}

	/* By using wait notifyAll */
	@Test
	public void waitNotifyAllSignalTest() throws InterruptedException {
		ijc.waitNotifyAllSignal();
	}

	/* Missed Signals */
	@Test
	public void missedSignals() throws InterruptedException {
		ijc.missedSignals();
	}

	/* Cover Missed Singal */
	@Test
	public void coverMissedSignals() throws InterruptedException {
		ijc.coverMissedSignals();
	}

	/* Manage Spurious Wakeups..might be theread wake up without signal */
	/* this is very serious problem */
	@Test
	public void manageSpuriousWakeupsSignalTest() throws InterruptedException {
		ijc.manageSpuriousWakeupsSignal();
	}

	/* Don't call wait() on constant String's or global objects */
	@Test
	public void avoidWaitNotifyOnCostanctObjTest() throws InterruptedException {
		ijc.avoidWaitNotifyOnCostanctObj();
	}

	@Test
	public void simpleDeadLockTest() throws InterruptedException {
		ijc.simpleDeadLock();
	}

	/** Deadlock Prevention **/
	/* Lock Ordering */
	@Test
	public void lockOrderingTest() throws InterruptedException {
		ijc.lockOrdering();
	}

	/* using time out/wait mechanism */
	@Test
	public void lockTimeoutTest() throws InterruptedException {
		ijc.lockTimeout();
	}

	/** Starvation and Fairness **/
	/*
	 * Threads with high priority swallow all CPU time from threads with lower
	 * priority
	 */
	@Test
	public void starvationDueToHighPriority() throws InterruptedException {
		ijc.starvationDueToHighPriority();
	}

	/* Threads are blocked indefinitely waiting to enter a synchronized block */
	@Test
	public void starvationBlockedIndefinitely() throws InterruptedException {
		ijc.starvationBlockedIndefinitely();
	}

	/*
	 * Threads waiting on an object (called wait() on it) remain waiting
	 * indefinitely
	 */
	@Test
	public void starvationDueToWait() throws InterruptedException {
		ijc.starvationDueToWait();
	}

	/* Fairness */
	/* lock inmplementatation */
	@Test
	public void lockTest() throws InterruptedException {
		ijc.lock();
	}

	/* implementtaion of FairLock */
	@Test
	public void fairLockTest() throws InterruptedException {
		ijc.fairLock();
	}

	/** Nested Monitor Lockout it is simimalr to dead lock but not dead locak **/
	// indefinite dead lock
	@Test
	public void nestedMonitorlockTest() throws InterruptedException {
		ijc.nestedMonitorlock();
	}

	@Test
	public void nestedMonitorFairlockTest() throws InterruptedException {
		ijc.nestedMonitorFairlock();
	}

	/** Slipped Conditions **/

	/* lock with slipped condittion */
	@Test
	public void slippedlockTest() throws InterruptedException {
		ijc.slippedlock();
	}

	/* lock without slipped condition */
	@Test
	public void avoidSlippedlockTest() throws InterruptedException {
		ijc.avoidSlippedlock();
	}

	/* fair lcok with slipped condition ie nested monitor lock */
	@Test
	public void slippedFairlockTest() throws InterruptedException {
		ijc.slippedFairlock();
	}

	/* fair lock witout slipped condition */
	@Test
	public void avoidSlippedFairlock() throws InterruptedException {
		ijc.avoidSlippedFairlock();
	}

	/** Locks in Java **/

	/* A Simple Lock using synchronization */
	@Test
	public void simpleLockBySynch() throws InterruptedException {
		ijc.simpleLockBySynch();
	}

	/* A simple lock by lock method call */
	@Test
	public void simpleLockByLock() throws InterruptedException {
		ijc.simpleLockByLock();
	}

	/* A simple Reentrant lock */
	@Test
	public void simpleReentrantLock() throws InterruptedException {
		ijc.simpleReentrantLock();
	}

	/* ReentrantLock use */
	@Test
	public void reentrantLockUse() throws InterruptedException {
		ijc.reentrantLockUse();
	}

	/* Calling unlock() From a finally-clause */
	@Test
	public void unlockFromFinallyBlock() throws InterruptedException {
		ijc.unlockFromFinallyBlock();
	}

	/** Read / Write Locks in Java **/
	/* read write lock */
	@Test
	public void readWriteLockUse() throws InterruptedException {
		ijc.readWriteLockUse();
	}

	/* read write ...read reentarance lock */
	@Test
	public void readWriteLockReadReentranceUse() throws InterruptedException {
		ijc.readWriteLockReadReentranceUse();
	}

	/* read write ...read reentarance lock */
	@Test
	public void readWriteLockWriteReentranceUse() throws InterruptedException {
		ijc.readWriteLockWriteReentranceUse();
	}

	// TODO th rest of this topic read/write locks
	/* read write ...read to write reentarance lock */
	@Test
	public void readWriteReadToWriteReentranceUse() throws InterruptedException {
		ijc.readWriteReadToWriteReentranceUse();
	}

	/* read write ...write to read reentarance lock */
	@Test
	public void readWriteWriteToReadReentranceUse() throws InterruptedException {

	}

	/* read write ...reentarance lock */
	@Test
	public void readWriteReentranceUse() throws InterruptedException {

	}

	/** Reentrance Lockout **/
	/* reentrance */
	@Test
	public void reentranceExampleTest() throws InterruptedException {
		ijc.reentranceExample();
	}

	/* reentrance lockout */
	@Test
	public void reentranceLockout() throws InterruptedException {
		ijc.reentranceLockout();
	}

	/** Semaphores **/
	/* a simple semaphore example */
	@Test
	public void simpleSemaphore() throws InterruptedException {
		ijc.simpleSemaphore();
	}

	/* a counting semaphore example */
	@Test
	public void countingSemaphore() throws InterruptedException {
		ijc.countingSemaphore();
	}

	/* bounded semaphore */
	@Test
	public void boundedSemaphore() throws InterruptedException {
		ijc.boundedSemaphore();
	}

	/** Blocking Queues **/
	@Test
	public void blockingQueue() throws InterruptedException {
		ijc.blockingQueue();
	}

	/** Thread Pools **/
	@Test
	public void simpleThreadPool() throws InterruptedException {
		ijc.simpleThreadPool();
	}

	/** Compare and Swap **/
	@Test
	public void simpleCompairAndSwap() throws InterruptedException {
		ijc.simpleCompairAndSwap();
	}

	/* using atomic variable */
	@Test
	public void compairAndSwapWithAtomicVar() throws InterruptedException {
		ijc.compairAndSwapWithAtomicVar();
	}

	/** Anatomy of a Synchronizer **/
}
