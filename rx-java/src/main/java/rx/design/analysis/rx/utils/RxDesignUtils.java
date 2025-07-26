package rx.design.analysis.rx.utils;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.ObservableTransformer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class RxDesignUtils {

    /**57.	Write a custom ObservableTransformer.*/
    public static class CustomTransformer implements ObservableTransformer<String, String>
    {
        @Override
        public ObservableSource<String> apply(Observable<String> upstream) {
            return upstream
                .filter(item->!StringUtils.isEmpty(item))
                .map(String::trim)
                .map(String::toUpperCase);
        }
    }
    /**58.	Implement a simple EventBus using PublishSubject.**/
    public static class RxSimpleEventBus
    {
        private static final RxSimpleEventBus INSTANCE  = new RxSimpleEventBus();
        private  final PublishSubject<Object> bus = PublishSubject.create();

        private RxSimpleEventBus(){}

        public static RxSimpleEventBus getInstance()
        {
            return INSTANCE;
        }

        //post an event
        public void post(Object object)
        {
            bus.onNext(object);
        }

        //Observe events of specific type
        public <T> Observable<T> listen(Class<T> eventType)
        {
            return bus.ofType(eventType);
        }
    }

    /**65.	Build a countdown timer with intervalRange().**/
    public static class CountDownTimer{

        public static void runCountDownTimer(int countdownStart) throws InterruptedException {
           Observable.intervalRange(
                    0,                     // start index
                    countdownStart,        // number of emissions
                    0,                     // initial delay
                    1,                     // period between emissions
                    TimeUnit.SECONDS
                )
                .map(i -> countdownStart - i) // reverse the count
                .doOnNext(i -> System.out.println("Countdown: " + i))
                .doOnComplete(() -> System.out.println("Countdown complete!"))
                .subscribeOn(Schedulers.io()).subscribe(); // run on background thread

            // Keep the main thread alive long enough to see the countdown
            sleep((countdownStart + 1) * 1000L);
        }
    }
    public static class ReactiveCircuitBreaker {

        private static final int FAILURE_THRESHOLD = 3;
        private static final long OPEN_DURATION_MS = 5000;

        private static final AtomicInteger failureCount = new AtomicInteger(0);
        private static volatile long circuitOpenedTime = 0;

        public static void circuitBreaker() throws InterruptedException {
            for (int i = 0; i < 6; i++) {
                Disposable disposable = callWithCircuitBreaker()
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        result -> System.out.println("Result: " + result),
                        error -> System.err.println("Error: " + error.getMessage())
                    );

                sleep(1000);
            }

            sleep(10000); // Wait to observe open/close behavior

        }

        static Single<String> callWithCircuitBreaker() {
            if (isCircuitOpen()) {
                System.out.println(" Circuit is OPEN. Returning fallback immediately.");
                return fallbackService();
            }

            return simulatedServiceCall()
                .timeout(1, TimeUnit.SECONDS)
                .doOnSuccess(result -> {
                    failureCount.set(0); // reset failures on success
                })
                .doOnError(error -> {
                    int failures = failureCount.incrementAndGet();
                    System.out.println(" Failure #" + failures);
                    if (failures >= FAILURE_THRESHOLD) {
                        circuitOpenedTime = System.currentTimeMillis();
                        System.out.println(" Circuit opened due to consecutive failures");
                    }
                })
                .onErrorResumeNext(error -> fallbackService());
        }

        static boolean isCircuitOpen() {
            if (failureCount.get() < FAILURE_THRESHOLD) return false;
            long now = System.currentTimeMillis();
            if ((now - circuitOpenedTime) < OPEN_DURATION_MS) return true;

            // Try closing the circuit after open duration
            System.out.println("✅ Circuit closed after open timeout");
            failureCount.set(0);
            return false;
        }

        static Single<String> simulatedServiceCall() {
            return Single.fromCallable(() -> {
                System.out.println("Calling remote service...");
                sleep(2000); // Simulate delay
                return "HEALTHY";
            });
        }

        static Single<String> fallbackService() {
            return Single.just("FALLBACK_RESPONSE");
        }
    }
}
