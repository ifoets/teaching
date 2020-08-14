package com.design.analysis.concurrent.thread;

public interface IJavaConcurrency {

	/** Creating and Starting Java Threads **/
	public void createStartThread();

	/** Race Conditions and Critical Sections **/
	/* race condition occur */
	public void raceCondition() throws InterruptedException;

	/* prevent race condition */
	public void preventRaceCondition() throws InterruptedException;

	/** Thread Safety and Shared Resources **/
	/* check local varible are thread safe */
	public void localVarialeByDefaultThreadSafe();

	/* a case of local reference is thread safe */
	public void safeLocalObjectReference();

	/* Object Member Variables are not thread safe on same instance */
	public void objectMembarVariableNotThreadSafe();

	/* Object Member Variables are not thread safe on different instance */
	public void objectMembarVariableThreadSafe();

	/** Thread Safety and Immutability **/

	/* Immutability formation */
	public void immutableClassForm();

	/* Visibility of Shared Objects */
	public void mayNonVisibleToOtherThead() throws InterruptedException;

	/** Java Synchronized Blocks **/
	/* non static block /method seperately synchronized */
	public void synchronizedNonStaticExmpl() throws InterruptedException;

	/* on samme thread */
	public void synchronizedNonStaticExmplX() throws InterruptedException;

	/* on different thread */
	public void synchronizedNonStaticExmplY() throws InterruptedException;

	/* non static block /method contineous synchronized */
	public void synchronizedNonStaticExmplContineous() throws InterruptedException;

	/* non static block /method seperately synchronized */
	public void synchronizedStaticExmpl() throws InterruptedException;

	/* non static block /method contineous synchronized */
	public void synchronizedStaticExmplContineous() throws InterruptedException;

	/** Java Volatile Keyword **/
	/* only update volatile variable */
	public void volatileVar() throws InterruptedException;

	/* all varibale update with volatile update */
	public void volatileAllVar() throws InterruptedException;

	/** Java ThreadLocal **/
	public void threadLocalVar() throws InterruptedException;

	/** Thread Signaling **/
	public void threadSignaling() throws InterruptedException;

	/* using wait notify */
	public void waitNotifySignal() throws InterruptedException;

	/* By using wait notifyAll */
	public void waitNotifyAllSignal() throws InterruptedException;

	/* Missed Signals */
	public void missedSignals() throws InterruptedException;

	/* Cover Missed Singal */
	public void coverMissedSignals() throws InterruptedException;

	/* Manage Spurious Wakeups..might be theread wake up without signal */
	/* this is very serious problem */
	public void manageSpuriousWakeupsSignal() throws InterruptedException;

	/* Don't call wait() on constant String's or global objects */
	public void avoidWaitNotifyOnCostanctObj() throws InterruptedException;

	/** Dead lock **/
	public void simpleDeadLock() throws InterruptedException;

	/** Deadlock Prevention **/
	/* Lock Ordering */
	public void lockOrdering() throws InterruptedException;

	/* using time out/wait mechanism */
	public void lockTimeout() throws InterruptedException;

	/** Starvation and Fairness **/
	/*
	 * Starvation * /* Threads with high priority swallow all CPU time from threads
	 * with lower priority
	 */
	public void starvationDueToHighPriority() throws InterruptedException;

	/* Threads are blocked indefinitely waiting to enter a synchronized block */
	public void starvationBlockedIndefinitely() throws InterruptedException;

	/*
	 * Threads waiting on an object (called wait() on it) remain waiting
	 * indefinitely
	 */
	public void starvationDueToWait() throws InterruptedException;
	/* Fairness */

	/* lock inmplementatation */
	public void lock() throws InterruptedException;

	/* implementtaion of FairLock */
	public void fairLock() throws InterruptedException;

	/** Nested Monit or Lockout it is simimalr to dead lock but not dead locak **/
	// indefinite dead lock
	public void nestedMonitorlock() throws InterruptedException;

	public void nestedMonitorFairlock() throws InterruptedException;

	/** Slipped Conditions **/

	/* lock with slipped condittion */
	public void slippedlock() throws InterruptedException;

	/* lock without slipped condition */
	public void avoidSlippedlock() throws InterruptedException;

	/* fair lcok with slipped condition ie nested monitor lock */
	public void slippedFairlock() throws InterruptedException;

	/* fair lock witout slipped condition */
	public void avoidSlippedFairlock() throws InterruptedException;

	/** Locks in Java **/

	/* A Simple Lock using synchronization */
	public void simpleLockBySynch() throws InterruptedException;

	/* A simple lock by lock method call */
	public void simpleLockByLock() throws InterruptedException;

	/* A simple Reentrant lock */
	public void simpleReentrantLock() throws InterruptedException;

	/* ReentrantLock use */
	public void reentrantLockUse() throws InterruptedException;

	/* Calling unlock() From a finally-clause */
	public void unlockFromFinallyBlock() throws InterruptedException;

	/** Read / Write Locks in Java **/
	/* read write lock */
	public void readWriteLockUse() throws InterruptedException;

	/* read write ...read reentarance lock */
	public void readWriteLockReadReentranceUse() throws InterruptedException;

	/* read write ...write reentarance lock */
	public void readWriteLockWriteReentranceUse() throws InterruptedException;

	// TODO th rest of this topic read/write locks

	/* read write ...read to write reentarance lock */
	public void readWriteReadToWriteReentranceUse() throws InterruptedException;

	/* read write ...write to read reentarance lock */
	public void readWriteWriteToReadReentranceUse() throws InterruptedException;

	/* read write ...reentarance lock */
	public void readWriteReentranceUse() throws InterruptedException;

	/** Reentrance Lockout **/
	/* reentrance */
	public void reentranceExample() throws InterruptedException;

	/* reentrance lockout */
	public void reentranceLockout() throws InterruptedException;

	/** Semaphores **/
	/* a simple semaphore example */
	public void simpleSemaphore() throws InterruptedException;

	/* a counting semaphore example */
	public void countingSemaphore() throws InterruptedException;

	/* bounded semaphore */
	public void boundedSemaphore() throws InterruptedException;

	/** Blocking Queues **/
	public void blockingQueue() throws InterruptedException;

	/** Thread Pools **/
	public void simpleThreadPool() throws InterruptedException;

	/** Compare and Swap **/
	public void simpleCompairAndSwap() throws InterruptedException;

	/* using atomic variable */
	// TODO for Atomic varible intenal work
	public void compairAndSwapWithAtomicVar() throws InterruptedException;

	/** Anatomy of a Synchronizer **/
	/** Non-blocking Algorithms **/
}
