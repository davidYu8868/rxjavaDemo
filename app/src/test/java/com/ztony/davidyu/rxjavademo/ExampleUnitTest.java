package com.ztony.davidyu.rxjavademo;

import org.junit.Test;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {

//        AtomicInteger hitCount = new AtomicInteger();
//
//
//        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS)
//                .take(5);
//
//        source.subscribe(i->hitCount.incrementAndGet());
//
//        assertTrue(hitCount.get() == 5);
//
//
        assertEquals(4, 2 + 2);
    }


    @Test
    public void testBlockingSubscribe() throws Exception {

        AtomicInteger hitCount = new AtomicInteger();
        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS) .take(5);
        source.blockingSubscribe(i -> hitCount.incrementAndGet());

        assertTrue(hitCount.get() == 5);
    }


    @Test
    public void testFirst() throws Exception
    {

        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Zeta");


        String firstWithLengthFour = source.filter(s -> s.length() == 4).blockingFirst();

        assertTrue(firstWithLengthFour.equals("Beta"));


    }



    @Test
    public void testSingle() {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Zeta");
        List<String> allWithLengthFour = source.filter(s -> s.length() == 4) .toList()
                .blockingGet();
        assertTrue(allWithLengthFour.equals(Arrays.asList("Beta","Zeta"))); }



    @Test
    public void testLast()
    {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Zeta");

        String lastWithLengthFour = source.filter(s -> s.length() == 4).blockingLast();


        assertTrue(lastWithLengthFour.equals("Zeta"));


    }


    @Test
    public void testIterable() {

        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Zeta");

        Iterable<String> allWithLengthFive = source.filter(s -> s.length() == 5).blockingIterable();

        for (String s : allWithLengthFive) {
            assertTrue(s.length() == 5);
        }

    }


    @Test
    public void testBlockingForEach()
    {

        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Zeta");

        source.filter(s->s.length() == 5)
                .blockingForEach(s-> assertTrue(s.length() == 5));


    }


    @Test
    public void testBlockingNext()
    {

        Observable<Long> source =
                Observable.interval(1, TimeUnit.MICROSECONDS) .take(1000);


        Iterable<Long> iterable = source.blockingNext();


        for(Long i : iterable)
        {

            System.out.println(i);
        }


    }


    @Test
    public void testBlockingLatest() { Observable<Long> source =
            Observable.interval(1, TimeUnit.MICROSECONDS) .take(1000);
        Iterable<Long> iterable = source.blockingLatest();
        for (Long i: iterable) { System.out.println(i); }
    }

    @Test
    public void testBlockingMostRecent()
    {
        Observable<Long> source = Observable.interval(10, TimeUnit.MILLISECONDS) .take(5);

        Iterable<Long> iterable = source.blockingMostRecent(-1L);

        for (Long i: iterable) { System.out.println(i); }
    }

    //536


    @Test
    public void usingTestObserver()
    {

        //An Observable with 5 one-second emissions
        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS) .take(5);


        //Declare TestObserver
        TestObserver<Long> testObserver = new TestObserver<>();


        //Assert no subscription has occurred yet
        testObserver.assertNotSubscribed();

     //Subscribe TestObserver to source
        source.subscribe(testObserver);

     //Assert TestObserver is subscribed
        testObserver.assertSubscribed();


        //Block and wait for Observable to terminate
        testObserver.awaitTerminalEvent();


        //Assert TestObserver called onComplete()
        testObserver.assertComplete();


       //Assert there were no errors
        testObserver.assertNoErrors();


        //Assert 5 values were received
        testObserver.assertValueCount(5);


        //Assert the received emissions were 0, 1, 2, 3, 4

        testObserver.assertValues(0L, 1L, 2L, 3L, 4L);





    }


    @Test
    public void usingTestScheduler()
    {

        //Declare TestScheduler
        TestScheduler testScheduler = new TestScheduler();


        //Declare TestObserver
        TestObserver<Long> testObserver = new TestObserver<>();


        Observable<Long> minuteTicker = Observable.interval(1, TimeUnit.MINUTES, testScheduler);

        //Subscribe to TestObserver
        minuteTicker.subscribe(testObserver);


        //fast forward by 30 seconds
        testScheduler.advanceTimeBy(30,TimeUnit.SECONDS);


        //Assert no emissions have occurred yet
        testObserver.assertValueCount(0);

        //Fast forward to 70 seconds after subscription
        testScheduler.advanceTimeTo(70, TimeUnit.SECONDS);

        //Assert the first emission has occurred
        testObserver.assertValueCount(1);


        //Fast Forward to 90 minutes after subscription
        testScheduler.advanceTimeTo(90, TimeUnit.MINUTES);


        //Assert 90 emissions have occurred
        testObserver.assertValueCount(90);

    }


}