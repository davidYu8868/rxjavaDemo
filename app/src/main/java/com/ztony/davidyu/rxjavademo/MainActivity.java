package com.ztony.davidyu.rxjavademo;

import android.annotation.SuppressLint;
import android.nfc.Tag;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableLastMaybe;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.observers.ResourceObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;
import io.reactivex.subjects.UnicastSubject;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    private static final CompositeDisposable disposables = new CompositeDisposable();


    private static int start = 1;
    private static int count = 5;


    int numberOfThreads = 20 ;



    @SuppressLint("CheckResult")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Observable<String> source = Observable.just("APLHA","BETA","GAMMA","DELTA","EPSILON");
//        ConnectableObservable<String> source = Observable.just("APLHA", "BETA", "GAMMA", "DELTA", "EPSILON").publish();
//
//
//        //first observer
//        source.subscribe(s -> Log.i(TAG,"observer 1 received "+ s));
//
//
//        //second observer
//
//        source.map(String::length).filter(i-> i>=5).
//                subscribe(s -> Log.i(TAG,"observer 2 received "+ s));
//
//
//        //fire
//        source.connect();


//        Observable.range(1,10).subscribe(i-> Log.i(TAG,"item is "+ i ));
//        Observable.interval(1, TimeUnit.SECONDS).subscribe(i-> Log.i(TAG, i + "  observable 1 "));

//        sleep(5000);


//        Observable.interval(1, TimeUnit.SECONDS).subscribe(i-> Log.i(TAG, i + " observable 2 "));


//        ConnectableObservable<Long> second = Observable.interval(1, TimeUnit.SECONDS).publish();


        // observe 1
//        second.subscribe(i-> Log.i(TAG, "observable 1 " + i));
//        second.connect();
//
//        sleep(5000);
//
//
//        second.subscribe(i-> Log.i(TAG, "observable 2 " + i));


//        Observable<String> source = Observable.empty();

//        source.subscribe(i->Log.i(TAG,i),Throwable::printStackTrace,()->Log.i(TAG,"done"));


//        Observable.error(()->new Exception("some thing crash"))
//                .subscribe(System.out::println,Throwable::printStackTrace,()->Log.i(TAG,"done"));

//        Observable<Integer> source = Observable.range(start, count);
        //  Observable<Integer> source = Observable.defer(()->Observable.range(start, count));


        //object one
        //  source.subscribe(i->Log.i(TAG,"object 1 "+i));

        //   count = 10;


        // source.subscribe(i->Log.i(TAG,"object 2 "+i));


//        Observable.fromCallable(()->1/0)
//                .subscribe(i->Log.i("TAG", "item is "+ i),e->Log.i(TAG, "error is "+ e));


//        Single.just("hello")
//                .map(String::length)
//                .subscribe(i->Log.i(TAG,""+i),Throwable::printStackTrace);


//                Observable<String> source = Observable.just("APLHA","BETA","GAMMA","DELTA","EPSILON");


//        source.first("BETA")
//                .subscribe(i->Log.i(TAG,""+i),Throwable::printStackTrace);


//        Completable.fromRunnable(()->runProcess())
//                .subscribe(()->Log.i(TAG,"Done"));


//        Observable<Long> second = Observable.interval(1, TimeUnit.SECONDS);
//
//
//        Disposable disposable = second.subscribe(l -> Log.i(TAG, "recevied " + l));
//
//
//        sleep(5000);
//
//
//        disposable.dispose();


//        Observer<Integer> myObserver = new Observer<Integer>() {
//
//
//            private Disposable disposable;
//
//            @Override
//            public void onSubscribe(Disposable disposable) {
//
//                this.disposable = disposable;
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        };


//                Observable<Long> second = Observable.interval(1, TimeUnit.SECONDS);
//
//
//        ResourceObserver<Long> myObserver = new ResourceObserver<Long>() {
//            @Override
//            public void onNext(Long aLong) {
//                Log.i(TAG,"value is "+ aLong);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onComplete() {
//               Log.i(TAG,"done");
//            }
//        };
//
//          Disposable disposable = second.subscribeWith(myObserver);


//       Observable<Long> second = Observable.interval(1,TimeUnit.SECONDS);
//
//
//        Disposable disposable1 = second.subscribe(l -> Log.i(TAG, "Observer 1 " + l));
//
//
//        Disposable disposable2 = second.subscribe(l -> Log.i(TAG, "Observer 2 " + l));
//
//
//        disposables.addAll(disposable1,disposable2);
//
//        sleep(5000);
//
//
//        disposables.dispose();


//        Observable.create(observableEmitter->{
//
//            try {
//                for (int i = 0; i < 1000; i++) {
//
//                    while (!observableEmitter.isDisposed())
//                    {
//                        observableEmitter.onNext(i);
//                    }
//
//                    if(observableEmitter.isDisposed())
//                    {
//                        return;
//                    }
//
//
//                observableEmitter.onComplete();
//
//
//                }
//            } catch (Exception e) {
//                observableEmitter.onError(e);
//            }
//
//
//        });


//        Observable.just("ALPHA","BETA","GAMMA","DELTA","EPSILON")
//                .filter(s->s.length() !=5)
//                .subscribe(s->Log.i(TAG,"recieved: "+ s));

//        Observable.just("ALPHA","BETA","GAMMA","DELTA","EPSILON")
//                .take(3)
//                .subscribe(s->Log.i(TAG,"recieved: "+ s));


//         Observable.interval(300,TimeUnit.MILLISECONDS)
//                 .take(2,TimeUnit.SECONDS)
//                 .subscribe(i->Log.i(TAG,"recieved: "+ i));


//        Observable.range(1,100)
//                .skip(90)
//                .subscribe(i->Log.i(TAG,"recieved: "+ i));


//        Observable.range(1,100)
//                .skipWhile(i->i<=95)
//                .subscribe(i->Log.i(TAG,"recieved: "+ i));

//                Observable.just("ALPHA","BETA","GAMMA","DELTA","EPSILON")
//                        .distinct(String::length)
//                        .subscribe(i->Log.i(TAG,"recieved: "+ i));


//        Observable.just(1,1,1,2,2,3,3,2,1,1)
//                .distinctUntilChanged()
//          .subscribe(i->Log.i(TAG,"recieved: "+ i));


//                Observable.just("ALPHA","BETA","zeta","eta","gamma")
//                        .distinctUntilChanged(String::length)
//                        .subscribe(i->Log.i(TAG,"recieved: "+ i));


//        Observable.just("ALPHA","BETA","zeta","eta","gamma","Delta")
//                .elementAt(3)
//                .subscribe(i->Log.i(TAG,"recieved: "+ i));


//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
//
//
//        Observable.just("1/3/2016","5/9/2016","10/12/2016")
//                .map(s-> LocalDate.parse(s,dtf))
//                .subscribe(i->Log.i(TAG,"recieved: "+ i));


//        Observable<String> items = Observable.just("ALPHA", "BETA", "Gamma", "delta", "epsilion");
//
//
//        items.filter(s->s.startsWith("Z"))
//                .switchIfEmpty(Observable.just("Zeta","Eta","Theta"))
//                .subscribe(i->Log.i(TAG,"recieved: "+ i));


//        Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
//                .sorted()
//                .subscribe(i -> Log.i(TAG, "recieved: " + i));


//        Observable.just("ALPHA", "BETA", "Gamma", "delta", "epsilion")
//                .sorted((x,y)->Integer.compare(x.length(),y.length()))
//                .subscribe(i -> Log.i(TAG, "recieved: " + i));


//                Observable.just("ALPHA", "BETA", "Gamma", "delta", "epsilion")
//                        .delay(3,TimeUnit.SECONDS)
//                        .subscribe(i -> Log.i(TAG, "recieved: " + i));
//
//                sleep(2000);


//                Observable.just("ALPHA", "BETA", "Gamma", "delta", "epsilion")
//                .repeat(2)
//                                .subscribe(i -> Log.i(TAG, "recieved: " + i));


//        Observable.just(5,3,7,10,2,14)
//
//                .scan(0,(accumulator,next)-> accumulator+next)
//                .skip(1)
//                .subscribe(i -> Log.i(TAG, "recieved: " + i));

//        Observable.just("ALPHA", "BETA", "Gamma", "delta", "epsilion")
//                .scan(0,(total,next)->total+1)
//                .skip(1)
//                .subscribe(i -> Log.i(TAG, "recieved: " + i));


//        Observable.just(5,3,7,10,2,14).reduce((total,next)->total+next)
//                .subscribe(i -> Log.i(TAG, "recieved: " + i));


//        Observable.just(5,3,7,10,2,14).
//                reduce("",(total,next)->total+ (total.equals("")?"":",")+next )
//                .subscribe(i -> Log.i(TAG, "recieved: " + i));


//        Observable.just("2016-01-01","2016-05-02","2016-09-12","2016-04-03")
//                .map(LocalDate::parse)
//                .any(dt->dt.getMonthValue() >=6)
//                .subscribe(i -> Log.i(TAG, "recieved: " + i));

//
//        Observable.range(1,10000)
//                .contains(9563)
//                        .subscribe(i -> Log.i(TAG, "recieved: " + i));


//        Observable.just("ALPHA", "BETA", "Gamma", "delta", "epsilion")
//                .toList()
//                .subscribe(i -> Log.i(TAG, "recieved: " + i));


//        Observable.range(1,1000)
//                .toList(1000)
//                .subscribe(i -> Log.i(TAG, "recieved: " + i));

//                Observable.just("ALPHA", "BETA", "Gamma", "delta", "epsilion")
//                        .toList(CopyOnWriteArrayList::new)
//                        .subscribe(i -> Log.i(TAG, "recieved: " + i));

//        Observable.just(5,3,7,10,2,14)
//                .toSortedList()
//                .subscribe(i -> Log.i(TAG, "recieved: " + i));


//        Observable.just("ALPHA", "BETA", "Gamma", "delta", "epsilion")
//                .toMap(s->s.charAt(0),String::length, ConcurrentHashMap::new)
//                .subscribe(i -> Log.i(TAG, "recieved: " + i));


//        Observable.just("ALpha", "Beta", "Gamma", "Delta", "Epsilon")
//                .toMultimap(String::length)
//        .subscribe(i -> Log.i(TAG, "recieved: " + i));


//        Observable.just("ALpha", "Beta", "Gamma", "Delta", "Epsilon")
//       .collect(HashSet::new,HashSet::add)
//                .subscribe(i -> Log.i(TAG, "recieved: " + i));


//                Observable.just("ALpha", "Beta", "Gamma", "Delta", "Epsilon")

//        Observable.just(5,2,4,0,3,2,8)
//                .map(i->10/i)
//                .onErrorReturn(e->-1)
//                .subscribe(i -> Log.i(TAG, "recieved: " + i),e->Log.i(TAG,"received error: "+e));

//        Observable.just(5, 2, 4, 0, 3, 2, 8)
//                .map(i -> {
//
//                            try {
//                                return 10 / i;
//
//                            } catch (ArithmeticException e) {
//                                return -1;
//                            }
//                        }
//                )
//
//                .subscribe(i -> Log.i(TAG, "recieved: " + i), e -> Log.i(TAG, "received error: " + e));

//
//        Observable.just(5,2,4,0,3,2,8)
//                .map(i->10/i)
//                .onErrorResumeNext(Observable.just(-1).repeat(3))
//                .subscribe(i -> Log.i(TAG, "recieved: " + i),e->Log.i(TAG,"received error: "+e));

//        Observable.just(5,2,4,0,3,2,8)
//                .map(i->10/i)
//                .onErrorResumeNext(Observable.empty())
//                .subscribe(i -> Log.i(TAG, "recieved: " + i),e->Log.i(TAG,"received error: "+e));

//        Observable.just(5,2,4,0,3,2,8)
//                .map(i->10/i)
//                .onErrorResumeNext((Throwable e)->Observable.just(-1).repeat(3))
//                .subscribe(i -> Log.i(TAG, "recieved: " + i),e->Log.i(TAG,"received error: "+e));


//        Observable.just(5,2,4,0,3,2,8)
//                .map(i->10/i)
//                .retry( 1)
//                .subscribe(i -> Log.i(TAG, "recieved: " + i),e->Log.i(TAG,"received error: "+e));


//        Observable.just("ALpha", "Beta", "Gamma", "Delta", "Epsilon")
//        .doOnNext(s -> Log.i(TAG, "Processing"+ s ))
//                 .doOnComplete(()->Log.i(TAG,"done!"))
//                .map(String::length)
//                        .subscribe(i -> Log.i(TAG, "recieved: " + i),e->Log.i(TAG,"received error: "+e));


//        Observable.just(5,2,4,0,3,2,8)
//                .map(i->10/i)
//                .doOnError(e->Log.i(TAG,"Division failed"))
//                        .subscribe(i -> Log.i(TAG, "recieved: " + i),e->Log.i(TAG,"received error: "+e));

//
//        Disposable subscribe = Observable.just("ALpha", "Beta", "Gamma", "Delta", "Epsilon")
//                .doOnSubscribe(disposable -> Log.i(TAG, "subscribing"))
//                .doOnDispose(() -> Log.i(TAG, "disposing!"))
//                .subscribe(i -> Log.i(TAG, "recieved: " + i), e -> Log.i(TAG, "received error: " + e));
//

//        Observable.just(5,3,7,10,2,14)
//                .reduce((total,next)->total+next)
//                .doOnSuccess(i -> Log.i(TAG,"emitting: "+i))
//                .subscribe(i -> Log.i(TAG, "recieved: " + i), e -> Log.i(TAG, "received error: " + e));


        //-------------------merging-----------------

//        Observable<String> source1 = Observable.just("ALpha", "Beta", "Gamma", "Delta", "Epsilon");
//        Observable<String> source2 = Observable.just("Zeta", "Eta", "Theta");
//
////        Observable.merge(source1,source2)
//        source1.mergeWith(source2)
//                        .subscribe(i -> Log.i(TAG, "recieved: " + i), e -> Log.i(TAG, "received error: " + e));


        //emit every second
//        Observable<String> source1 = Observable.interval(1, TimeUnit.SECONDS)
//                .map(l -> l + 1)
//                .map(l -> "source1: " + l + " seconds");
//
//
//        Observable<String> source2 = Observable.interval(300, TimeUnit.MILLISECONDS)
//                .map(l -> (l+1)*300)
//                .map(l -> "source1: " + l + " millseconds");
//
//
//        Disposable subscribe = Observable.merge(source1, source2)
//                .subscribe(i -> Log.i(TAG, i));
//
//
//        sleep(10000);
//
//        subscribe.dispose();

//        Observable<String> source = Observable.just("ALpha", "Beta", "Gamma", "Delta", "Epsilon");
//
//        source.flatMap(s->Observable.fromArray(s.split("")))
//                .subscribe(i -> Log.i(TAG, i));


//        Observable<String> source = Observable.just("521934/2342/FOXTROT", "21962/12112/78886/TANGO", "2832242/452/WHISKEY/2348562");
//
//        source.flatMap(s->Observable.fromArray(s.split("/")))
//                .filter(s->s.matches("[0-9]+"))
//                .map(Integer::parseInt)
//                .subscribe(i -> Log.i(TAG, ""+i));


//        Observable<Integer> secondIntervals = Observable.just(2, 0, 3, 10, 7);
//
//
//        secondIntervals.flatMap(i -> {
//
//            if (i == 0) {
//                return Observable.empty();
//            } else {
//
//                return Observable.interval(i, TimeUnit.SECONDS)
//                        .map(l -> i + "s interval: " + ((l + 1) * i) + "seconds elasped");
//            }
//
//        }).subscribe(
//                i -> Log.i(TAG, "" + i)
//        );

//        Observable<String> source = Observable.just("ALpha", "Beta", "Gamma", "Delta", "Epsilon");
//
//        source.flatMap(s->Observable.fromArray(s.split("")),(s,r)->s+ "-" +r)
//                .subscribe(i -> Log.i(TAG, ""+i));


//                Observable<String> source1 = Observable.just("ALpha", "Beta", "Gamma", "Delta", "Epsilon");
//                Observable<String> source2 = Observable.just("Zeta", "Eta", "Theta");
//
//
//                Observable.concat(source1,source2)
//                        .subscribe(i -> Log.i(TAG, ""+i));


        // emit every second, but only take 2 emissions
//        Observable<String> source1 = Observable.interval(1, TimeUnit.SECONDS)
//                .take(2)
//                .map(l -> l + 1)
//                .map(l -> "source1: " + l + " seconds");
//
//
//        Observable<String> source2 = Observable.interval(300, TimeUnit.MILLISECONDS)
//                .map(l -> (l + 1) * 30)
//                .map(l -> "source2: " + l + " milliseconds");
//
//
//        Observable.concat(source1 , source2)
//                .subscribe(i -> Log.i(TAG, ""+i));


        // emit every second, but only take 2 emissions
//        Observable<String> source1 = Observable.interval(1, TimeUnit.SECONDS)
//                .take(2)
//                .map(l -> l + 1)
//                .map(l -> "source1: " + l + " seconds");
//
//
//        Observable<String> source2 = Observable.interval(1200, TimeUnit.MILLISECONDS)
//                .map(l -> (l + 1) * 1200)
//                .map(l -> "source2: " + l + " milliseconds");
//
//
//        Observable.amb(Arrays.asList(source1, source2))
//                .subscribe(i -> Log.i(TAG, ""+i));

//
//                Observable<String> source = Observable.just("ALpha", "Beta", "Gamma", "Delta", "Epsilon");
//
//
//        Observable<Integer> source2 = Observable.range(1, 6);
//
//        Observable.zip(source,source2,(s,i)->s+"-"+i).subscribe(i -> Log.i(TAG, ""+i));

//
//        Observable<String> source = Observable.just("ALpha", "Beta", "Gamma", "Delta", "Epsilon");
//
//        Observable<Long> second = Observable.interval(1, TimeUnit.SECONDS);
//
//        Observable.zip(source,second,(s,l)->s)
//                .subscribe(s->Log.i(TAG,"received "+ s));


//        Observable<Long> source1 = Observable.interval(300, TimeUnit.MILLISECONDS);
//        Observable<Long> source2= Observable.interval(1, TimeUnit.SECONDS);
//
//        Observable.combineLatest(source1,source2,(l1,l2)->"SOURCE 1: "+ l1 + " source 2: "+ l2)
//                .subscribe(s->Log.i(TAG,s));


//        Observable<Long> source1 = Observable.interval(300, TimeUnit.MILLISECONDS);
//        Observable<Long> source2= Observable.interval(1, TimeUnit.SECONDS);
//
//        source2.withLatestFrom(source1,(l1,l2)->"SOURCE 1: "+ l1 + " source 2: "+ l2)
//                .subscribe(s->Log.i(TAG,s));


//        Observable<String> source = Observable.just("ALpha", "Beta", "Gamma", "Delta", "Epsilon");
//
//        Observable<GroupedObservable<Integer, String>> byLengths = source.groupBy(s -> s.length());
//
//
//        byLengths.flatMapSingle(grp->grp.toList())
//
//                .subscribe(s->Log.i(TAG,"item is "+ s));
//
//        byLengths.flatMapSingle(grp->
//        grp.reduce("",(x,y)->x.equals("")?y : x+ ","+y)
//                .map(s->grp.getKey() + ": "+s )
//
//
//        ).subscribe(s->Log.i(TAG,"item is "+ s));


//        List<String> stringArrayList = new ArrayList<String>();
//
//        List<Integer> integerArrayList = new ArrayList<Integer>();
//
//        Class classStringArrayList = stringArrayList.getClass();
//        Class classIntegerArrayList = integerArrayList.getClass();
//
//
//
//        if(classStringArrayList.equals(classIntegerArrayList)){
//            Log.d("泛型测试","类型相同");
//        }
//
//
//        Generic<Integer> integerGeneric = new Generic<>(1234);
//
//      //传入的实参类型需与泛型的类型参数类型相同，即为String.
//        Generic<String> genericString = new Generic<String>("key_vlaue");
//
//
//        Log.d("泛型测试","key is " + integerGeneric.getKey());
//        Log.d("泛型测试","key is " + genericString.getKey());


//        Generic generic = new Generic("111111");
//        Generic generic1 = new Generic(4444);
//        Generic generic2 = new Generic(55.55);
//        Generic generic3 = new Generic(false);
//
//        Log.d("泛型测试","key is " + generic.getKey());
//        Log.d("泛型测试","key is " + generic1.getKey());
//        Log.d("泛型测试","key is " + generic2.getKey());
//        Log.d("泛型测试","key is " + generic3.getKey());
//
//        Generic<Integer> gInteger = new Generic<Integer>(123);
//        Generic<Number> gNumber = new Generic<Number>(456);
//
//        showKeyValue(gNumber);
//
//        showKeyValue(gInteger);

//        GenericFruit.Apple apple = new GenericFruit.Apple();
//        GenericFruit.Person person = new GenericFruit.Person();
//

        //printMsg("111",333,"32423.4",44.44);


        //Generic<String> generic1 = new Generic<String>("11111");
//        Generic<Integer> generic2 = new Generic<Integer>(2222);
//        Generic<Float> generic3 = new Generic<Float>(2.4f);
//        Generic<Double> generic4 = new Generic<Double>(2.56);
//
//
//        //这一行代码编译器会提示错误，因为String类型并不是Number类型的子类
//      // showKeyValue1(generic1);
//
//        showKeyValue1(generic2);
//        showKeyValue1(generic3);
//        showKeyValue1(generic4);


        //page 279

//        Observable<Integer> range = Observable.range(1, 3);
//
//        range.subscribe(i->Log.i(TAG,"observer one : "+ i));
//        range.subscribe(i->Log.i(TAG,"observer two : "+ i));

//        ConnectableObservable<Integer> range = Observable.range(1, 3).publish();
//
//        range.subscribe(i->Log.i(TAG,"observer one : "+ i));
//       range.subscribe(i->Log.i(TAG,"observer two : "+ i));

//        range.connect();


//        ConnectableObservable<Integer> threeRandoms = Observable.range(1, 3)
//                .map(i -> randomInt()).publish();
//
//        threeRandoms.subscribe(i->Log.i(TAG,"observer 1: "+ i));
//        threeRandoms.subscribe(i->Log.i(TAG,"observer 2: "+ i));
//
//        threeRandoms.connect();


//        ConnectableObservable<Integer> threeInts = Observable.range(1, 3).publish();
//        Observable<Integer> threeRandoms = threeInts.map(i -> randomInt());
//
//        threeRandoms.subscribe(i->Log.i(TAG,"observer 1: "+ i));
//        threeRandoms.subscribe(i->Log.i(TAG,"observer 2: "+ i));
//
//        threeInts.connect();


//        ConnectableObservable<Integer> threeRandoms = Observable.range(1, 3)
//                .map(i -> randomInt()).publish();
//
//
//        threeRandoms.subscribe(i->Log.i(TAG,"Observer 1: "+ i));
//
//
//
//        threeRandoms.reduce(0, (total,next)->total + next)
//                .subscribe(i->Log.i(TAG,"Observer 2 : "+ i));
//
//        threeRandoms.connect();


//        Observable<Integer> threeRandoms = Observable.range(1, 3)
//                .map(i -> randomInt()).publish().autoConnect(2);
//
//
//
//        threeRandoms.subscribe(i->Log.i(TAG,"Observer 1: "+ i));
//
//        threeRandoms.reduce(0, (total,next)->total + next)
//                .subscribe(i->Log.i(TAG,"Observer 2 : "+ i));
//
//
//        threeRandoms.reduce(0, (total,next)->total + next)
//                .subscribe(i->Log.i(TAG,"Observer 3 : "+ i));

//
//        Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS)
//                .publish()
//                .autoConnect();
//
//        //observer 1
//        seconds.subscribe(i->Log.i(TAG,"Observer 1: "+ i));
//
//
//        sleep(3000);
//
//        //observer 2
//        seconds.subscribe(i->Log.i(TAG,"Observer 2: "+ i));


//
//        Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS)
//                .publish()
//                .refCount();
//
//        //observer 1
//        seconds.take(5).subscribe(i->Log.i(TAG,"Observer 1: "+ i));
//
//        sleep(3000);
//
//        seconds.take(2).subscribe(i->Log.i(TAG,"Observer 2: "+ i));
//
//        sleep(3000);
//
//
//        seconds.subscribe(i->Log.i(TAG,"Observer 3: "+ i));


//        Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS)
//                .replay(2).autoConnect();
//
//        //observer 1
//        seconds.subscribe(i->Log.i(TAG,"Observer 1: "+ i));
//
//        sleep(5000);
//
//        //observer 2
//        seconds.subscribe(i->Log.i(TAG,"Observer 2: "+ i));


//        Observable<String> source = Observable.just("ALpha", "Beta", "Gamma", "Delta", "Epsilon")
//                .replay(1)
//                .refCount()
//                ;
//
//
//        //observer 1
//        source.subscribe(i->Log.i(TAG,"Observer 1: "+ i));
//
//
//        //observer 2
//        source.subscribe(i->Log.i(TAG,"Observer 2: "+ i));


//        Observable<Long> seconds = Observable.interval(300, TimeUnit.MILLISECONDS)
//                .map(l->(l+1)*300) // map to elapsed  milliseconds
//                .replay(1,TimeUnit.SECONDS)
//                .autoConnect();
//
//
//        //observer 1
//        seconds.subscribe(i->Log.i(TAG,"Observer 1: "+ i));
//
//
//        sleep(2000);
//
//        //observer 2
//        seconds.subscribe(i->Log.i(TAG,"Observer 2: "+ i));


//        Observable<Integer> cachedRollingTotals = Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
//                .scan(0, (total, next) -> total + next)
//                .cacheWithInitialCapacity(7);
//
//        cachedRollingTotals.subscribe(i->Log.i(TAG,"Observer 1: "+ i));


        // page 312

//        PublishSubject<String> subject = PublishSubject.create();
//
//
//        subject.map(String::length)
//                .subscribe(i->Log.i(TAG,"this letter's length is "+ i));
//
//
//        subject.onNext("Alpha");
//        subject.onNext("Beta");
//        subject.onNext("Gamma");
//        subject.onComplete();


//        Observable<String> source
//                = Observable.interval(1, TimeUnit.SECONDS)
//                .map(l -> (l + 1) + " seconds");
//
//
//        Observable<String> source2
//                = Observable.interval(300, TimeUnit.MILLISECONDS)
//                .map(l -> ((l + 1)*300) + " milliseconds");
//
//
//        PublishSubject<String> subject = PublishSubject.create();
//
//        subject.subscribe(s->Log.i(TAG,"item is "+ s));
//
//        source.subscribe(subject);
//
//        source2.subscribe(subject);


//        PublishSubject<String> subject = PublishSubject.create();
//
//        subject.onNext("Alpha");
//        subject.onNext("Beta");
//        subject.onNext("Gamma");
//        subject.onComplete();
//
//
//        subject.map(String::length)
//                .subscribe(s->Log.i(TAG,"item is "+ s));

//        ReplaySubject<String> subject = ReplaySubject.create();
//
//
//         subject.subscribe(s->Log.i(TAG,"item 1  is "+ s));
//
//
//        subject.onNext("Alpha");
//        subject.onNext("Beta");
//        subject.onNext("Gamma");
//
//
//
//        subject.subscribe(s->Log.i(TAG,"item 2  is "+ s));


//        AsyncSubject<String> subject = AsyncSubject.create();
//
//        subject.subscribe(s->Log.i(TAG,"item is "+ s),Throwable::printStackTrace,()->Log.i(TAG,"Observer1 done"));
//
//        subject.onNext("Alpha");
//        subject.onNext("Beta");
//        subject.onNext("Gamma");
//        subject.onComplete();
//
//        subject.subscribe(s->Log.i(TAG,"item2 is "+ s),Throwable::printStackTrace,()->Log.i(TAG,"Observer2 done"));


//        UnicastSubject<String> subject = UnicastSubject.create();
//
//        Observable.interval(300,TimeUnit.MILLISECONDS)
//                        .map(l->((l+1)*300)+ " milliseconds")
//                .subscribe(subject);
//
//
//        sleep(2000);
//
//       // subject.subscribe(s->Log.i(TAG,"Observa1 : "+ s));
//
//        Observable<String> multicast = subject.publish().autoConnect();
//
//        //bring in first Observer
//        multicast.subscribe(s->Log.i(TAG,"Observa1 :"+ s));
//
//
//        sleep(2000);
//
//      //bring in second Observer
//        multicast.subscribe(s->Log.i(TAG,"Observa2 :"+ s));


        //340 concurrency

//        Observable.interval(1, TimeUnit.SECONDS)
//                .map(i -> i + " Mississippi")
//                .subscribe(s -> Log.i(TAG, s));
//
//        sleep(5000);

//
//        Observable<String> source1 = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
//                .subscribeOn(Schedulers.computation())
//                .map(s -> intenseCalculation(s));
//
//
//        Observable<Integer> source2 = Observable.range(1, 6)
//                .subscribeOn(Schedulers.computation())
//                .map(s -> intenseCalculation(s));
//
//
//        Observable.zip(source1, source2,(s,i)->s+" _ "+ i )
//                 .subscribe(s -> Log.i(TAG,s));


//        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
//
//
//        Scheduler scheduler = Schedulers.from(executor);
//
//
//        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
//                .subscribeOn(scheduler)
//                .doFinally(executor::shutdown)
//                .subscribe(s -> Log.i(TAG, s));


//        Observable<Integer> lengths = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
//                .subscribeOn(Schedulers.computation())
//                .map(MainActivity::intenseCalculation)
//                .map(String::length);
//
//
//        lengths.subscribe(i->Log.i(TAG, "received "+ i +" on thread "+ Thread.currentThread().getName()));
//
//
//        lengths.subscribe(i->Log.i(TAG, "received "+ i +" on thread "+ Thread.currentThread().getName()));



//        Observable<Integer> lengths = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
//                .subscribeOn(Schedulers.computation())
//                .map(MainActivity::intenseCalculation)
//                .map(String::length)
//                .publish()
//                .autoConnect(2);
//
//
//        lengths.subscribe(i->Log.i(TAG, "received "+ i +" on thread "+ Thread.currentThread().getName()));
//
//
//        lengths.subscribe(i->Log.i(TAG, "received "+ i +" on thread "+ Thread.currentThread().getName()));



//        Observable.fromCallable(()->getResponse("https://api.github.com/users/thomasnield/starred"))
//                .subscribeOn(Schedulers.io())
//                .subscribe(System.out::println);


        //happens on IO scheduler
//        Observable.just("WHISKEY/27653/TANGO","6555/BRAVO","232352/5675675/FOXTROT")
//                .subscribeOn(Schedulers.io())
//                .flatMap(s-> Observable.fromArray(s.split("/")))
//                .doOnNext(s ->Log.i(TAG,"split out "+s + " on thread "+ Thread.currentThread().getName()))
//
//        //happends on computation scheduler
//                 .observeOn(Schedulers.computation())
//                   .filter(s-> s.matches("[0-9]+"))
//                   .map(Integer::valueOf)
//                   .reduce((total,next)->total+next)
//                    .doOnSuccess(i->Log.i(TAG,"calculated sum "+ i + " on thread "+ Thread.currentThread().getName()))
////                   .subscribe(i->Log.i(TAG,"Received "+ i + " on thread "+ Thread.currentThread().getName()));
//
//        // switch back to IO Scheduler
//        .observeOn(Schedulers.io())
//                .map(i->i.toString())
//                .doOnSuccess(i->Log.i(TAG,"write sum "+ i + " on thread "+ Thread.currentThread().getName()))
//                .subscribe(s->Log.i(TAG,"sum is "+ s));


        //380

//        Observable.range(1,10)
//                .map(i->intenseCalculation(i))
//                .subscribe(i->Log.i(TAG,"Received "+ i + LocalTime.now()));


//        Observable.range(1,10)
//
//                .flatMap(i->Observable.just(i).subscribeOn(Schedulers.computation())
//                .map(i2->intenseCalculation(i2))
//                )
//                .subscribe(i->Log.i(TAG," Received "+ i + " "+LocalTime.now()+ " on thread"+ Thread.currentThread().getName()));


//        int coreCount = Runtime.getRuntime().availableProcessors();
//
//        Log.i(TAG,"core is "+ coreCount);
//
//        AtomicInteger assigner =new AtomicInteger(0);
//
//
//        Observable.range(1,10)
//                .groupBy(i->assigner.incrementAndGet() % coreCount)
//                .flatMap(grp ->grp.observeOn(Schedulers.io()).map(i2->intenseCalculation(i2))
//                )
//               .subscribe(i->Log.i(TAG," Received "+ i + " "+LocalTime.now()+ " on thread"+ Thread.currentThread().getName()));
//


//        Disposable d = Observable.interval(1, TimeUnit.SECONDS)
//                .doOnDispose(() -> Log.i(TAG, "Disposing on thread " + Thread.currentThread().getName()))
//                .unsubscribeOn(Schedulers.io())
//                .subscribe(i -> Log.i(TAG, "Recevied " + i));
//
//        sleep(3000);
//
//        d.dispose();


//          Observable.range(1,10)
//                  .buffer(2,1)
//                  .filter(c->c.size() ==2)
//                  .subscribe(System.out::println);

//        Observable<Long> cutOffs = Observable.interval(1, TimeUnit.SECONDS);
//
//
//        Observable.interval(300,TimeUnit.MILLISECONDS)
//                .map(i->(i+1)*300)
//                .buffer(cutOffs)
//                .subscribe(i->Log.i(TAG, ""+i));


//        Observable.range(1,50)
//                .window(2,3)
//                .flatMapSingle(obs->obs.reduce("",(total,next)->  total +":"+ next))
//                .subscribe(s->Log.i(TAG,s));

//        Observable<Long> cutOffs = Observable.interval(1, TimeUnit.SECONDS);
//
//
//        Observable.interval(300,TimeUnit.MILLISECONDS)
//                .map(i->(i+1)*300)
//                .window(cutOffs)
//                .flatMapSingle(obs->obs.reduce("",(total,next)->  total +":"+ next))
//                .subscribe(i->Log.i(TAG, ""+i));


//        Observable<String> source1 = Observable.interval(100, TimeUnit.SECONDS)
//                .map(i -> (i + 1) * 100)
//                .map(i -> "SOURCE 1: " + i)
//                .take(10);
//
//
//        Observable<String> source2 = Observable.interval(300, TimeUnit.SECONDS)
//                .map(i -> (i + 1) * 300)
//                .map(i -> "SOURCE 2: " + i)
//                .take(3);
//
//
//        Observable<String> source3 = Observable.interval(2000, TimeUnit.SECONDS)
//                .map(i -> (i + 1) * 2000)
//                .map(i -> "SOURCE 3: " + i)
//                .take(2);
//
//
//        Observable.concat(source1,source2,source3)
//                .subscribe(s->Log.i(TAG,s));
//
//
//
//        sleep(6000);

//        Observable<String> source1 = Observable.interval(100, TimeUnit.MILLISECONDS) .map(i -> (i + 1) * 100) // map to elapsed time
//                .map(i -> "SOURCE 1: " + i)
//                .take(10);

//        Observable<String> source1 = Observable.interval(100, TimeUnit.MILLISECONDS) .map(i -> (i + 1) * 100) // map to elapsed time
//                .map(i -> "SOURCE 1: " + i)
//                .take(10);
//
//
//        Observable<String> source2 = Observable.interval(300, TimeUnit.MILLISECONDS) .map(i -> (i + 1) * 300) // map to elapsed time
//                .map(i -> "SOURCE 2: " + i)
//                .take(3);
//
//
//        Observable<String> source3 = Observable.interval(2000, TimeUnit.MILLISECONDS) .map(i -> (i + 1) * 2000) // map to elapsed time
//                .map(i -> "SOURCE 3: " + i)
//                .take(2);
//        Observable.concat(source1, source2, source3)
//                .throttleWithTimeout(1,TimeUnit.SECONDS)
//                .subscribe(s-> Log.i(TAG,s));
//
//        sleep(6000);


//        Observable<String> items = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon",
//                "Zeta", "Eta", "Theta", "Iota");
////        .delay(randomSleepTime(), TimeUnit.MILLISECONDS);
//        Observable<String> proccessStrings = items.concatMap(s -> Observable.just(s).delay(randomSleepTime(), TimeUnit.MILLISECONDS));
//
//        proccessStrings.subscribe(s->Log.i(TAG,s));



//        Observable<String> items = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon",
//                "Zeta", "Eta", "Theta", "Iota");
//
////delay each String to emulate an intense calculation
//        Observable<String> processStrings = items.concatMap(s -> Observable.just(s).delay(randomSleepTime(), TimeUnit.MILLISECONDS));
//
//
//        // rund processString every 5 seconds, and kill each previous instace to start next
//
//        Observable.interval(5,TimeUnit.SECONDS)
//                .switchMap(i->processStrings.doOnDispose(()->Log.i(TAG,"Disposing! Starting next"))).subscribe(s->Log.i(TAG,s));

//       Observable.range(1,999_999_999)
//               .map(MyItem::new)
//               .subscribe(myItem -> {
//                   sleep(500);
//                   Log.i(TAG,"Received MyItem "+ myItem.id);
//
//               });

//        Observable.range(1,999_999_999)
//                .map(MyItem::new)
//                .observeOn(Schedulers.io())
//                .subscribe(myItem -> {
//                    sleep(500);
//                    Log.i(TAG,"Received MyItem "+ myItem.id);
//
//                });


//                Flowable.range(1,999_999_999)
//                .map(MyItem::new)
//                .observeOn(Schedulers.io())
//                .subscribe(myItem -> {
//                    sleep(500);
//                    Log.i(TAG,"Received MyItem "+ myItem.id);
//
//                });


//        Flowable.range(1,1000)
//                .doOnNext(s -> Log.i(TAG,"Source pushed " + s)) .observeOn(Schedulers.io())
//                .map(i -> intenseCalculation(i))
//                .subscribe(s -> Log.i(TAG,"Subscriber received " + s),
//                        Throwable::printStackTrace,
//                        () -> Log.i(TAG,"done")
//                );


//                Flowable.range(1,1000)
//                .doOnNext(s -> Log.i(TAG,"Source pushed " + s)) .observeOn(Schedulers.io())
//                .map(i -> intenseCalculation(i))
//                .subscribe(new Subscriber<Integer>() {
//
//                    Subscription subscription;
//                    AtomicInteger count = new AtomicInteger(0);
//
//                    @Override
//                    public void onSubscribe(Subscription subscription) {
//
//                        this.subscription =  subscription;
//                        Log.i(TAG,"Requesting 40 times!");
//                        subscription.request(Long.MAX_VALUE);
//                    }
//
//                    @Override
//                    public void onNext(Integer s) {
//
//                        sleep(50);
//                        Log.i(TAG,"subscriber received "+ s);
//                        if(count.incrementAndGet()%20 == 0  && count.get() >=40)
//                        {
//                            Log.i(TAG,"Requesting 20 times!");
//
//                            subscription.request(20);
//                        }
//
//
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        t.printStackTrace();
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                        Log.i(TAG,"done");
//
//                    }
//                });


//        Observable<Object> source = Observable.create(emitter -> {
//
//            for (int i = 0; i < 1000; i++) {
//                if(emitter.isDisposed())
//                {
//                    return;
//                }
//
//                emitter.onNext(i);
//            }
//
//            emitter.onComplete();
//
//        });
//
//
//        source.observeOn(Schedulers.io())
//                .subscribe(s->Log.i(TAG,"item is "+ s));


//        Flowable<Object> source = Flowable.create(emitter -> {
//            for (int i = 0; i < 1000; i++) {
//                if(emitter.isCancelled()) return;
//
//                emitter.onNext(i);
//            }
//
//            emitter.onComplete();
//
//        }, BackpressureStrategy.BUFFER);
//
//
//        source.observeOn(Schedulers.io())
//                .subscribe(s->{
//
//                    sleep(50);
//                    Log.i(TAG,"item is "+ s);
//
//
//                        }
//
//
//
//                );

       //460 

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private static int randomSleepTime() {
        return ThreadLocalRandom.current().nextInt(2000);
    }


    private static String getResponse(String path)
    {
        try {
           return new Scanner(new URL(path).openStream(),"UTF-8").useDelimiter("\\A").next();
        } catch (Exception e) {
            e.printStackTrace();

            return e.getMessage();

        }

    }


    static final class MyItem
    {
        final int id;

        MyItem(int id)
        {
            this.id = id;
            Log.i(TAG,"constructing MyItem "+ id);

        }


    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(100000);
    }

    private void showKeyValue(Generic<?> gNumber) {
        Log.d("泛型测试", "key value is " + gNumber.getKey());
    }

    public static void sleep(int i) {


        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    private void runProcess() {

    }


    public <T> T genericMethod(Class<T> tClass) throws InstantiationException, IllegalAccessException {


        T instance = tClass.newInstance();
        return instance;
    }


    public <T> void printMsg(T... args) {

        for (T t : args) {

            Log.d("泛型测试", "t is " + t);
        }

    }


    public void showKeyValue1(Generic<? extends Number> obj) {
        Log.d("泛型测试", "key value is " + obj.getKey());
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static <T> T intenseCalculation(T value) {
        sleep(ThreadLocalRandom.current().nextInt(3000));

        return value;

    }


}
