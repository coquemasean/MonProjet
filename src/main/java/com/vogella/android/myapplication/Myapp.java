package com.vogella.android.myapplication;

import android.app.Application;
import android.os.SystemClock;

/**
 * Created by Onilax on 13/04/2017.
 */

class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(10000);
    }
}