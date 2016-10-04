package com.skyworth.simplegank.network;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Sky000 on 2016/9/29.
 */

public class RequestQueueManager {

    private static RequestQueue mRequestQueue;

    private RequestQueueManager() {

    }

    public static void init(Context context) {
        if (mRequestQueue == null){
            mRequestQueue = Volley.newRequestQueue(context);
        }
    }

    public static RequestQueue getRequestQueue() {
        return mRequestQueue;
    }
}
