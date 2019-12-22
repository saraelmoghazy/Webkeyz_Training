package com.webkeyz.batchtwotraining;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class SecondWorker extends Worker {
    private static final String TAG = "SecondWorker";

    public SecondWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        String data = getInputData().getString("output");
        Log.d(TAG, "doWork: " + data);
        return Result.success();
    }
}
