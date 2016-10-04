package com.skyworth.simplegank.Articles;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skyworth.simplegank.R;
import com.skyworth.simplegank.entity.ArticleItem;

import java.util.List;

/**
 * Created by Sky000 on 2016/9/30.
 */

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder> {

    private static final String TAG = "ArticlesAdapter";

    private Context mContext;
    private List<ArticleItem> mArticleItems;

    private OnItemClickListener mOnItemClickListener;

    public ArticlesAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<ArticleItem> data){
        this.mArticleItems = data;
        this.notifyDataSetChanged();
    }
    @Override
    public ArticlesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_articles, parent, false);
        return new ArticlesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticlesViewHolder holder, int position) {
        ArticleItem articleItem = mArticleItems.get(position);
        if (articleItem == null) {
            return;
        }
        holder.mTextView.setText(articleItem.getDesc());
    }

    @Override
    public int getItemCount() {
        return mArticleItems.size() == 0 ? 0 : mArticleItems.size();
    }

    public class ArticlesViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {
        private TextView mTextView;

        public ArticlesViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.article_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(view, this.getAdapterPosition());
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
