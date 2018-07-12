package com.ztony.davidyu.rxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.internal.operators.observable.ObservableLastMaybe;
import io.reactivex.observables.ConnectableObservable;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";


    private static int start = 1;
    private static int count = 5;


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


        Completable.fromRunnable(()->runProcess())
                .subscribe(()->Log.i(TAG,"Done"));
    }

    private void sleep(int i) {


        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    private void runProcess()
    {

    }
}
