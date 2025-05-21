package com.udemy.basic.reactive;

import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.udemy.basic.reactive.utils.ReactorUtil;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class RxReactorImpl implements IRxReactor {

	/** Mono **/

	/* Stream Lazy behaviour */
	@Override
	public void streamLeazyBehaiourExmpl() {

		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5)
		        .map(i ->
			        {
				        try {
					        Thread.sleep(1000);
				        } catch (InterruptedException e) {
					        e.printStackTrace();
				        }
				        System.out.println("Stream is in processing...");
				        return i = i * 2;
			        });
		// nothing happen since this is not subscription ie without subscribe/terminal
		// operation
		// stream is lazy/not execute
		// System.out.println(stream);

		// this is just like subscription
		stream.forEach(System.out::println);
	}

	/* Mono Just Example */
	@Override
	public void monoJustExmpl() {

		Mono<Integer> mono = Mono.just(1)
		        .map(e ->
			        {
				        try {
					        Thread.sleep(1000);
					        System.out.println("Mono is executing...");
				        } catch (InterruptedException e1) {
					        e1.printStackTrace();
				        }
				        return e * 2;
			        });
		// this will just print toString of mono ie.. no any terminal/subscription
		System.out.println(mono);
		mono.subscribe(e -> System.out.println("Terminal opeartion is fied and getting value.." + e));
	}

	/* Mono Subscribe Example */
	@Override
	public void monoSubscribeEmpl() {
		Mono<String> mono = Mono.just("GuruJi");

		// on subscription mono emits data
		// mono.subscribe();
		mono.subscribe(ReactorUtil.onNext(), ReactorUtil.onEroor(), ReactorUtil.onCompleted());
	}

	/* Mono on Error Example */
	@Override
	public void monoOnErrorExmpl() {
		Mono<Integer> mono = Mono.just("GuruJi")
		        .map(s -> s.length())
		        .map(l -> l / 0);

		// when error raised on emission then it just throw and subscription catch it
		mono.subscribe(ReactorUtil.onNext(), ReactorUtil.onEroor(), ReactorUtil.onCompleted());
	}

	/* Mono Emitting Empty Example */
	@Override
	public Mono<String> userRepository(Mono<Integer> mono) {
		return mono.flatMap(t ->
			{
				if (t == 1)
					return Mono.just(ReactorUtil.faker()
					        .name()
					        .firstName());
				else if (t == 2)
					return Mono.empty();
				return Mono.error(new RuntimeException("Not in allwed range	"));
			});

	}

	@Override
	public void monoEmptyEmapl(int x) {
		this.userRepository(Mono.just(x))
		        .subscribe(ReactorUtil.onNext(), ReactorUtil.onEroor(), ReactorUtil.onCompleted());
	}

	/* Mono from Supplier, use Mono.just only when data is ready */
	@Override
	public void monoSupplierExmpl() {
		// without subscribing ReactorUtil.getName() get executed that is not good
		Mono.just(ReactorUtil.getName());
		System.out.println("-----------X-----------X-----------");
		Supplier<String> supplyString = () -> ReactorUtil.faker()
		        .name()
		        .fullName();
		Mono<String> mono = Mono.fromSupplier(supplyString);
		System.out.println("Now Subscribing...");
		mono.subscribe(ReactorUtil.onNext());
	}

	/* Mono from Callable just like Supplier */
	@Override
	public void monoCallableExmpl() {
		Callable<String> callString = () -> ReactorUtil.faker()
		        .name()
		        .fullName();
		Mono.fromCallable(callString)
		        .subscribe(ReactorUtil.onNext());
	}

	/** Mono building pipeline vs Execution */
	@Override
	public Mono<String> getMonoName() {
		System.out.println("Executed before name...");
		return Mono.fromSupplier(() ->
			{ // logic should be lazy ie get executed only on subscription
				System.out.println("Executing pipeline now...");
				ReactorUtil.sleeppSecond(3);
				return ReactorUtil.faker()
				        .name()
				        .fullName();
			}

		) // make name upper case
		        .map(String::toUpperCase);

	}

	@Override
	public void pipelineVsExectution() {
		// here pipeline build but not executed since not subscribed
		getMonoName();
		System.out.println("---------X-----------X---------");
		// here pipe line get builded as well executed
		getMonoName().subscribe(ReactorUtil.onNext());
		System.out.println("---------X-----------X---------");
		getMonoName();
	}

	/* making subscriber Async */
	@Override
	public void ashyncReactorExmpl() {
		// here pipeline build but not executed since not subscribed
		getMonoName();
		System.out.println("---------X-----------X---------");
		// here making Async by using executed by new thread
		getMonoName().subscribeOn(Schedulers.boundedElastic())
		        .subscribe(ReactorUtil.onNext());
		System.out.println("---------X-----------X---------");
		getMonoName();

		ReactorUtil.sleeppSecond(4);
	}

	/* blocking main thread usually shouldn't us it, only testing purpose */
	@Override
	public void blockingMainThread() {
		// here pipeline build but not executed since not subscribed
		getMonoName();
		System.out.println("---------X-----------X---------");
		// here blocking main thread
		String name = getMonoName().subscribeOn(Schedulers.boundedElastic())
		        .block();
		System.out.println(name);
		System.out.println("---------X-----------X---------");
		getMonoName();

		ReactorUtil.sleeppSecond(4);
	}

	/* Mono from Future Example */
	public CompletableFuture<String> getName() {
		// this execute async using ForkJoin pool
		return CompletableFuture.supplyAsync(() -> ReactorUtil.faker()
		        .name()
		        .fullName());
	}

	@Override
	public void monoFromFutureExmpl() {
		Mono.fromFuture(getName())
		        .subscribe(ReactorUtil.onNext());
		ReactorUtil.sleeppSecond(4);
	}

	/*
	 * Mono From Runnable..use mostly when operation is completed notify me senarios
	 */
	@Override
	public Runnable timeConsumeingProcess() {
		ReactorUtil.sleeppSecond(3);
		return () -> System.out.println("Operation completed...");
	}

	@Override
	public void monoFromRunnableExmpl() {
		Mono.fromRunnable(timeConsumeingProcess())
		        .subscribe(ReactorUtil.onNext(), ReactorUtil.onEroor(), () ->
			        {
				        System.out.println("Got notification Operation completed...Sending email");
			        }

				);
	}

	/** Assignment File Service operation */
	/* create file and write content into it */
	@Override
	public Mono<Void> write(String fileName, String content) {
		return Mono.fromRunnable(() -> writeFile(fileName, content));
	}

	private void writeFile(String fileName, String content) {
		try {
			Files.writeString(ReactorUtil.PATH.resolve(fileName), content);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/* read file and return content */
	@Override
	public Mono<String> read(String fileName) {
		return Mono.fromSupplier(() -> readFile(fileName));
	}

	private String readFile(String fileName) {
		try {
			return Files.readString(ReactorUtil.PATH.resolve(fileName));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/* delete the file */

	@Override
	public Mono<Void> delete(String fileName) {
		return Mono.fromRunnable(() -> deleteFile(fileName));
	}

	private void deleteFile(String fileName) {
		try {
			Files.delete(ReactorUtil.PATH.resolve(fileName));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
