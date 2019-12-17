package com.webkeyz.batchtwotraining.rxJava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class TransformingObservables {

    public Observable<Integer> switchMapOperator() {
        final Observable<Integer> integerObservable = originalSource()
                .switchMap(new Function<Integer, ObservableSource<? extends Integer>>() {
                    @Override
                    public ObservableSource<? extends Integer> apply(Integer integer) throws Exception {
                        int myInt = integer * 2;
                        return secondSource(myInt);
                    }
                }).observeOn(AndroidSchedulers.mainThread());
        return integerObservable;
    }

    private Observable<Integer> secondSource(final Integer integer) {
        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(integer);
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io());
    }

    private Observable<Integer> originalSource() {
        Observable<Integer> source = Observable.range(1, 6)
                .subscribeOn(Schedulers.io());
        return source;
    }

    public Observable<Integer> mapOperator() {
        Observable<Integer> integerObservable = Observable.range(1, 6)
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        return integer * 2;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return integerObservable;
    }
}
