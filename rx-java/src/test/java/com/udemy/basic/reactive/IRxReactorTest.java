package com.udemy.basic.reactive;

import org.junit.Before;
import org.junit.Test;

import com.udemy.basic.reactive.utils.ReactorUtil;

public class IRxReactorTest {

	IRxReactor irr = null;

	@Before
	public void init() {
		irr = new RxReactorImpl();
	}

	/** Mono **/

	/* Stream Lazy behaviour */
	@Test
	public void streamLeazyBehaiourExmplTest() {
		irr.streamLeazyBehaiourExmpl();
	}

	/* Mono Just Example */
	@Test
	public void monoJustExmpl() {
		irr.monoJustExmpl();
	}

	/* Mono Subscribe Example */
	@Test
	public void monoSubscribeEmplTest() {
		irr.monoSubscribeEmpl();
	}

	/* Mono on Error Example */
	@Test
	public void monoOnErrorExmplTest() {
		irr.monoOnErrorExmpl();
	}

	/* Mono Emitting Empty Example */
	@Test
	public void monoEmptyEmaplTest() {
		irr.monoEmptyEmapl(1);
		System.out.println("----------");
		irr.monoEmptyEmapl(2);
		System.out.println("------------");
		irr.monoEmptyEmapl(6);
	}

	/* Mono from Supplier, use Mono.just only when data is ready */
	@Test
	public void monoSupplierExmplTest() {
		irr.monoSupplierExmpl();
	}

	/* Mono from Callable just like Supplier */
	@Test
	public void monoCallableExmplTest() {
		irr.monoCallableExmpl();
	}

	/** Mono building pipeline vs Execution */
	@Test
	public void pipelineVsExectutionTest() {
		irr.pipelineVsExectution();
	}

	/* making subscriber Async */
	@Test
	public void ashyncReactorExmplTest() {
		irr.ashyncReactorExmpl();
	}

	/* blocking main thread usually shouldn't us it, only testing purpose */
	@Test
	public void blockingMainThreadTest() {
		irr.blockingMainThread();
	}

	/* Mono from Future Example */
	@Test
	public void monoFromFutureExmplTest() {
		irr.monoFromFutureExmpl();
	}

	/*
	 * Mono From Runnable..use mostly when operation is completed notify me senarios
	 */
	@Test
	public void monoFromRunnableExmplTest() {
		irr.monoFromRunnableExmpl();
	}

	/** Assignment File Service operation */
	/* create file and write content into it */
	@Test
	public void writeTest() {
		irr.write("rxjava.txt", "Hello Rx java!..")
		        .subscribe(ReactorUtil.onNext(), ReactorUtil.onEroor(), ReactorUtil.onCompleted());
		// ReactorUtil.sleeppSecond(5);
	}

	/* read file and return content */
	@Test
	public void readTest() {
		irr.read("rxjava.txt")
		        .subscribe(ReactorUtil.onNext(), ReactorUtil.onEroor(), ReactorUtil.onCompleted());
	}

	/* delete the file */
	@Test
	public void deleteTest() {
		irr.delete("rxjava.txt")
		        .subscribe(ReactorUtil.onNext(), ReactorUtil.onEroor(), ReactorUtil.onCompleted());
	}
}
