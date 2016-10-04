package com.skyworth.simplegank.entity;

import java.util.List;

/**
 * Created by Sky000 on 2016/9/30.
 */

public class ArticlesWrapper {

    private boolean error;
    private List<ArticleItem> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ArticleItem> getResults() {
        return results;
    }

    public void setResults(List<ArticleItem> results) {
        this.results = results;
    }
}
