package com.skyworth.simplegank;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.skyworth.simplegank.Articles.widget.ArticlesFragment;
import com.skyworth.simplegank.utils.ActivityUtil;

public class MainActivity extends AppCompatActivity {

    private ArticlesFragment mArticlesFragment;
    private FragmentManager mFragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getSupportFragmentManager();
        mArticlesFragment = ArticlesFragment.newInstance("ArticlesFragment");

        ActivityUtil.addFragmenToActivity(
                mFragmentManager,
                mArticlesFragment,
                R.id.container_frame);
    }
}
