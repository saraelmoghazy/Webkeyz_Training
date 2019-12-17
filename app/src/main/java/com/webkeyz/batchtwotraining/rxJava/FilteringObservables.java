package com.webkeyz.batchtwotraining.rxJava;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class FilteringObservables {

    public Observable<Integer> distinctOperator() {
        Observable<Integer> integerObservable = Observable.just(10, 10, 20, 20, 30, 40, 40, 50, 60, 60)
                .distinct()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return integerObservable;
    }

    public Maybe<Integer> elementAtOperator() {
        Maybe<Integer> integerObservable = Observable.just(10, 20, 30, 40, 50, 60, 70)
                .elementAt(3)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return integerObservable;

    }

    public Observable<Integer> filterOperator() {
        Observable<Integer> integerObservable = Observable.just(10, 20, 30, 40, 50, 60)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer > 30;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return integerObservable;
    }
}
