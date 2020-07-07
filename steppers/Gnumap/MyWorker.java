/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  androidx.work.ListenableWorker
 *  androidx.work.ListenableWorker$Result
 *  androidx.work.Worker
 *  androidx.work.WorkerParameters
 *  java.lang.String
 */
package com.steppers.Gnumap;

import android.content.Context;
import android.util.Log;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker
extends Worker {
    private static final String TAG = "MyWorker";

    public MyWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public ListenableWorker.Result doWork() {
        Log.d((String)TAG, (String)"Performing long running task in scheduled job");
        return ListenableWorker.Result.success();
    }
}

