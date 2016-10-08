package com.skyworth.simplegank.network;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.skyworth.simplegank.utils.Debugger;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * Created by Sky000 on 2016/9/30.
 */

public class GsonRequest<T> extends Request<T> {

    private static final String TAG = "GsonRequest";

    private final Class<T> clazz;
    private final Response.Listener<T> mListener;

    public GsonRequest(int method,
                       String url,
                       Class<T> clazz,
                       Response.Listener<T> listener,
                       Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.clazz = clazz;
        this.mListener = listener;
        setRetryPolicy(getMyOwnDefaultRetryPolicy());
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        String parsed;
        try {
            parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            parsed = new String(response.data);
        }
        Response<T> gsonResponse = Response.success(new Gson().fromJson(parsed, clazz),
                HttpHeaderParser.parseCacheHeaders(response));
        Debugger.d(parsed);
        return gsonResponse;
    }

    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }

    public RetryPolicy getMyOwnDefaultRetryPolicy() {
        RetryPolicy retryPolicy = new DefaultRetryPolicy(5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        return retryPolicy;
    }

    public static HashMap<String, String> wrapHashMap(
            HashMap<String, String> hashMap, String url) {
        return hashMap;
    }
}
