package com.skyworth.simplegank.Articles.widget;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.skyworth.simplegank.Articles.ArticlesAdapter;
import com.skyworth.simplegank.Articles.presenter.ArticlesPresenter;
import com.skyworth.simplegank.Articles.presenter.ArticlesPresenterImpl;
import com.skyworth.simplegank.Articles.view.ArticlesView;
import com.skyworth.simplegank.R;
import com.skyworth.simplegank.entity.ArticleItem;
import com.skyworth.simplegank.utils.Debugger;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticlesFragment extends Fragment implements ArticlesView {

    private static final String TAG = "ArticlesFragment";

    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;

    private ArticlesPresenter mPresenter;
    private ArticlesAdapter mAdapter;
    private List<ArticleItem> mData;

    public ArticlesFragment() {
        // Required empty public constructor
    }

    public static ArticlesFragment newInstance(String type) {
        Bundle args = new Bundle();
        args.putString("type", type);
        ArticlesFragment fragment = new ArticlesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new ArticlesPresenterImpl(this);
        mPresenter.loadArticles("Android",1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_articles, container, false);
        mProgressBar = (ProgressBar) view.findViewById(R.id.load_progress);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.articles_list);

        mAdapter = new ArticlesAdapter(getActivity());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter.setOnItemClickListener(mOnItemClickListener);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(mOnScrollListener);
        return view;
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void loadArticles(List<ArticleItem> articleItems) {
        if (mData == null) {
            mData = new ArrayList<>();
        }
        mPresenter.loadArticles("Android",1);
        mData.addAll(articleItems);
        mAdapter.setData(mData);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showLoadFailMsg() {
        Debugger.e(TAG,"数据加载失败！");
    }

    private ArticlesAdapter.OnItemClickListener mOnItemClickListener = new ArticlesAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            Toast.makeText(getActivity(),position + "",Toast.LENGTH_SHORT).show();
        }
    };

    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            mPresenter.loadArticles("Android",1);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
        }
    };
}
