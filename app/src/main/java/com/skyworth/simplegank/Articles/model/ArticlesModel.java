package com.skyworth.simplegank.Articles.model;

/**
 * Created by Sky000 on 2016/10/1.
 */

public interface ArticlesModel {

    void loadArticles(String category,
                      int page,
                      ArticlesModelImpl.onLoadArticlesListener listener);
}
