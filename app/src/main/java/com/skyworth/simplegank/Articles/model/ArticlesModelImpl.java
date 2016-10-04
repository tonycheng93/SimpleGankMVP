package com.skyworth.simplegank.Articles.model;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.skyworth.simplegank.entity.ArticleItem;
import com.skyworth.simplegank.entity.ArticlesWrapper;
import com.skyworth.simplegank.network.GsonRequest;
import com.skyworth.simplegank.network.RequestQueueManager;
import com.skyworth.simplegank.utils.Debugger;

import java.util.List;

/**
 * Created by Sky000 on 2016/10/1.
 */

public class ArticlesModelImpl implements ArticlesModel {

    private static final String TAG = "ArticlesModelImpl";


    @Override
    public void loadArticles(String category, int page, final onLoadArticlesListener listener) {
        String url = "http://gank.io/api/data/" + category + "/10/ " + page;
        GsonRequest<ArticlesWrapper> request = new GsonRequest<>(Request.Method.GET,
                url, ArticlesWrapper.class, new Response.Listener<ArticlesWrapper>() {
            @Override
            public void onResponse(ArticlesWrapper response) {
                List<ArticleItem> articleItems = response.getResults();
                Debugger.d(TAG, articleItems.toString());
                listener.onSuccess(articleItems);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onFailure("load articles fail", error);
            }
        });
        RequestQueueManager.getRequestQueue().add(request);
    }

    public interface onLoadArticlesListener {

        void onSuccess(List<ArticleItem> articleItems);

        void onFailure(String msg, VolleyError error);
    }
}
