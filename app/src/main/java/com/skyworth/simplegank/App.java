package com.skyworth.simplegank;

import android.app.Application;

import com.skyworth.simplegank.network.RequestQueueManager;

/**
 * Created by Sky000 on 2016/9/30.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        RequestQueueManager.init(this);
    }
}
