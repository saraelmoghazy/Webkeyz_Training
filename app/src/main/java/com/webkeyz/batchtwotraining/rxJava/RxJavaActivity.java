package com.webkeyz.batchtwotraining.rxJava;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.webkeyz.batchtwotraining.R;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class RxJavaActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "RxJavaActivity";
    // vars
    CompositeDisposable disposable;
    CreatingObservables creatingObservables;
    TransformingObservables transformingObservables;
    FilteringObservables filteringObservables;
    CombiningObservables combiningObservables;
    List<String> alphabets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);

        findViewById(R.id.createOperator_button).setOnClickListener(this);
        findViewById(R.id.justOperator_button).setOnClickListener(this);
        findViewById(R.id.rangeOperator_button).setOnClickListener(this);
        findViewById(R.id.mapOperator_button).setOnClickListener(this);
        findViewById(R.id.switchMapOperator_button).setOnClickListener(this);
        findViewById(R.id.distinctOperator_button).setOnClickListener(this);
        findViewById(R.id.elementAtOperator_button).setOnClickListener(this);
        findViewById(R.id.filterOperator_button).setOnClickListener(this);
        findViewById(R.id.mergeOperator_button).setOnClickListener(this);
        disposable = new CompositeDisposable();
        creatingObservables = new CreatingObservables();
        transformingObservables = new TransformingObservables();
        filteringObservables = new FilteringObservables();
        combiningObservables = new CombiningObservables();
        alphabets = getAlphabetList();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }

    private void mergeOperator() {
        combiningObservables.mergeOperator()
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "onNext: " + s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete merge: CALLED");
                    }
                });
    }

    private void filterOperator() {
        filteringObservables.filterOperator()
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete filter: CALLED");
                    }
                });
    }

    private void elementAtOperator() {
        filteringObservables.elementAtOperator()
                .subscribe(new MaybeObserver<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onSuccess(Integer integer) {
                        Log.d(TAG, "onSuccess: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete elementAt: will be called only if there was no element at the given position");
                    }
                });
    }

    private void distinctOperator() {
        filteringObservables.distinctOperator()
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete distinct: CALLED");
                    }
                });
    }

    private void switchMapOperator() {
        transformingObservables.switchMapOperator()
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete switch map: CALLED");
                    }
                });
    }

    private void mapOperator() {
        transformingObservables.mapOperator()
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete map: CALLED");
                    }
                });
    }

    private void rangeOperator() {
        creatingObservables.rangeOperator(3, 8)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete range: CALLED");
                    }
                });
    }

    private void justOperator() {
        creatingObservables.justOperator(alphabets)
                .subscribe(new Observer<List<String>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(List<String> strings) {
                        Log.d(TAG, "onNext: " + strings.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete just: CALLED");
                    }
                });
    }

    private void createOperator() {
        creatingObservables.createOperator(alphabets)
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "onNext: " + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete create: CALLED");
                    }
                });
    }

    public List<String> getAlphabetList() {
        List<String> alphabet = new ArrayList<>();
        alphabet.add("a");
        alphabet.add("b");
        alphabet.add("c");
        alphabet.add("d");
        alphabet.add("e");
        alphabet.add("f");
        return alphabet;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.createOperator_button: {
                createOperator();
                break;
            }
            case R.id.justOperator_button: {
                justOperator();
                break;
            }
            case R.id.rangeOperator_button: {
                rangeOperator();
                break;
            }
            case R.id.mapOperator_button: {
                mapOperator();
                break;
            }
            case R.id.switchMapOperator_button: {
                switchMapOperator();
                break;
            }
            case R.id.distinctOperator_button: {
                distinctOperator();
                break;
            }
            case R.id.elementAtOperator_button: {
                elementAtOperator();
                break;
            }
            case R.id.filterOperator_button: {
                filterOperator();
                break;
            }
            case R.id.mergeOperator_button: {
                mergeOperator();
                break;
            }
        }
    }
}
