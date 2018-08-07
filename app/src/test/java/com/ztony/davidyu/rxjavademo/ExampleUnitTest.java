package com.ztony.davidyu.rxjavademo;

import org.junit.Test;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import io.reactivex.Observable;

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


}