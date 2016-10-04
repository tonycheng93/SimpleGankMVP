package com.skyworth.simplegank.Articles.view;

import com.skyworth.simplegank.entity.ArticleItem;

import java.util.List;

/**
 * Created by Sky000 on 2016/9/30.
 */

public interface ArticlesView {
    void showLoading();

    void loadArticles(List<ArticleItem> articleItems);

    void hideLoading();

    void showLoadFailMsg();

}
