package com.skyworth.simplegank.Articles.presenter;

import com.android.volley.VolleyError;
import com.skyworth.simplegank.Articles.model.ArticlesModel;
import com.skyworth.simplegank.Articles.model.ArticlesModelImpl;
import com.skyworth.simplegank.Articles.view.ArticlesView;
import com.skyworth.simplegank.entity.ArticleItem;

import java.util.List;

/**
 * Created by Sky000 on 2016/10/1.
 */

public class ArticlesPresenterImpl implements
        ArticlesPresenter, ArticlesModelImpl.onLoadArticlesListener {

    private static final String TAG = "ArticlesPresenterImpl";

    private ArticlesView mArticlesView;
    private ArticlesModel mArticlesModel;

    public ArticlesPresenterImpl(ArticlesView articlesView) {
        mArticlesView = articlesView;
        mArticlesModel = new ArticlesModelImpl();
    }

    @Override
    public void loadArticles(String category, int page) {
        mArticlesModel.loadArticles(category, page, this);
    }

    @Override
    public void onSuccess(List<ArticleItem> articleItems) {
        mArticlesView.hideLoading();
        mArticlesView.loadArticles(articleItems);
    }

    @Override
    public void onFailure(String msg, VolleyError error) {
        mArticlesView.hideLoading();
        mArticlesView.showLoadFailMsg();
    }
}
