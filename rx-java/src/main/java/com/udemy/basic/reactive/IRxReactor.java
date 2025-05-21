package com.udemy.basic.reactive;

import reactor.core.publisher.Mono;

public interface IRxReactor {

	/** Mono **/

	/* Stream Lazy behaviour example */
	public void streamLeazyBehaiourExmpl();

	/* Mono Just Example */
	public void monoJustExmpl();

	/* Mono Subscribe Example */
	public void monoSubscribeEmpl();

	/* Mono on Error Example */
	public void monoOnErrorExmpl();

	/* Mono Emitting Empty Example */
	public Mono<String> userRepository(Mono<Integer> mono);

	public void monoEmptyEmapl(int x);

	/* Mono from Supplier, use Mono.just only when data is ready */
	public void monoSupplierExmpl();

	/* Mono from Callable just like Supplier */
	public void monoCallableExmpl();

	/** Mono building pipeline vs Execution */
	public Mono<String> getMonoName();

	public void pipelineVsExectution();

	/* making subscriber Async */
	public void ashyncReactorExmpl();

	/* blocking main thread usually shouldn't us it, only testing purpose */
	public void blockingMainThread();

	/* Mono from Future Example */
	public void monoFromFutureExmpl();

	/*
	 * Mono From Runnable..use mostly when operation is completed notify me senarios
	 */
	public Runnable timeConsumeingProcess();

	public void monoFromRunnableExmpl();

	/** Assignment File Service operation */
	/* create file and write content into it */
	public Mono<Void> write(String fileName, String content);

	/* read file and return content */
	public Mono<String> read(String fileName);

	/* delete the file */
	public Mono<Void> delete(String fileName);

}
