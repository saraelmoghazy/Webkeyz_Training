package com.webkeyz.batchtwotraining;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class CustomWorker extends Worker {
    private static final String TAG = "CustomWorker";

    public CustomWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.d(TAG, "doWork: some work to be done on a background thread");
        Data outputData = new Data.Builder().putString("output","work from 1st worker").build();
        return Result.success(outputData);
    }
}