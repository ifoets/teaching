package interview.preparation.rxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.TestObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import jdk.jfr.Timespan;
import jdk.jfr.Timestamp;
import org.awaitility.spi.Timeout;
import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Delayed;

public class RxJavaTesting {
    private static final List<String> WORDS = Arrays.asList(
            "the",
            "quick",
            "brown",
            "fox",
            "jumped",
            "over",
            "the",
            "lazy",
            "dog"
    );
    @Test
    public void testInSameThread() {
        // given:
        List<String> results = new ArrayList<>();
        Observable<String> observable = Observable.fromArray(WORDS).flatMap(Observable::fromIterable)
                .zipWith(Observable.range(1, Integer.MAX_VALUE),
                        (string, count)->String.format("%2d. %s", count, string));

        // when:
        observable.subscribe(results::add).dispose();
        System.out.print(results);

        // then:
        Assert.assertNotNull(results);
        Assert.assertEquals(9, results.size());
        Assert.assertTrue(results.contains(" 4. fox"));
    }


    @Test
    public void testUsingTestObserver()  {
        // given:
        TestObserver<String> testObserver = new TestObserver<>();
        Observable<String> observable = Observable.fromArray(WORDS).flatMap(Observable::fromIterable)
                .zipWith(Observable.range(1, Integer.MAX_VALUE),
                        (string, count)->String.format("%2d. %s", count, string));

        // when:
        observable.subscribe(testObserver);

        // then:
        testObserver.assertComplete();
        testObserver.assertNoErrors();
        testObserver.assertValueCount(9);
        testObserver.assertValueAt(3," 4. fox");
        }

    @Test
    public void testFailure() {
        // given:
        TestObserver<String> testObserver = new TestObserver<>();
        Exception exception = new RuntimeException("boom!");

        Observable<String> observable = Observable.fromArray(WORDS).flatMap(Observable::fromIterable)
                .zipWith(Observable.range(1, Integer.MAX_VALUE),
                        (string, count)->String.format("%2d. %s", count, string))
                .concatWith(Observable.error(exception));

        // when:
        observable.subscribe(testObserver);

        // then:
        testObserver.assertError(exception);
        testObserver.assertNotComplete();
    }
    @Test
    public void testUsingComputationScheduler() throws InterruptedException {
        // given:
        TestObserver<String> testObserver = new TestObserver<>();

        Observable<String> observable = Observable.fromArray(WORDS).flatMap(Observable::fromIterable)
                .zipWith(Observable.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d. %s", count, string));

        // when:
        observable.subscribeOn(io.reactivex.rxjava3.schedulers.Schedulers.computation()).subscribe(testObserver);
        Thread.sleep(5000);

        testObserver.assertComplete();
        testObserver.assertNoErrors();
        testObserver.values().stream().forEach(System.out::println);
        testObserver.assertValueAt(3, " 4. fox");

    }
    @Test
    public void testUsingBlockingCall() {
        // given:

        Observable<String> observable = Observable.fromArray(WORDS).flatMap(Observable::fromIterable)
                .zipWith(Observable.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d. %s", count, string));

        // when:
        Iterable<String> results = observable
                .subscribeOn(Schedulers.computation())
                .blockingIterable();
        int i = 0;
        while(results.iterator().hasNext()) {
            i++;
            results.iterator().next();
        }
        // then:
        Assert.assertNotNull(results);
        Assert.assertEquals(9, 9);
        Assert.assertEquals(results.iterator().next()," 1. the");
    }

    @Test
   public void testUsingComputationScheduler1() throws InterruptedException {

        // given:
        TestObserver<String> testObserver = new TestObserver<>();

        Observable<String> observable = Observable.fromArray(WORDS).flatMap(Observable::fromIterable)
                .zipWith(Observable.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d. %s", count, string));

        observable.subscribeOn(Schedulers.computation())
                   .subscribe(testObserver);

      //  testObserver.await().awaitDone(2, TimeUn.)
        //          .until(testObserver::values, 9);
    }
    }