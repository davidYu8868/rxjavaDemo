package com.ztony.davidyu.rxjavademo;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableLastMaybe;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observers.ResourceObserver;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    private static final CompositeDisposable disposables = new CompositeDisposable();


    private static int start = 1;
    private static int count = 5;


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

        //merging
        

    }

    private void sleep(int i) {


        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    private void runProcess() {

    }
}
