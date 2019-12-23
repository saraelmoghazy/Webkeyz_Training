package com.webkeyz.batchtwotraining.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.webkeyz.batchtwotraining.R;
import com.webkeyz.batchtwotraining.models.ArticlesItem;

public class FeedAdapter extends PagedListAdapter<ArticlesItem, FeedAdapter.ArticlesItemViewHolder> {

    public FeedAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public ArticlesItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_listitem, parent, false);
        return new ArticlesItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticlesItemViewHolder holder, int position) {
        ArticlesItem articlesItem = getItem(position);
        if (articlesItem != null) {
            holder.titleTextView.setText(articlesItem.getTitle());
            holder.authorTextView.setText(articlesItem.getAuthor());
        }
    }

    private static DiffUtil.ItemCallback<ArticlesItem> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<ArticlesItem>() {
                // User details may have changed if reloaded from the database,
                // but ID is fixed.
                @Override
                public boolean areItemsTheSame(@NonNull ArticlesItem oldArticle, @NonNull ArticlesItem newArticle) {
                    return oldArticle.getSource().getId() == newArticle.getSource().getId();
                }

                @Override
                public boolean areContentsTheSame(@NonNull ArticlesItem oldArticle,
                                                  @NonNull ArticlesItem newArticle) {
                    return oldArticle.equals(newArticle);
                }
            };

    public class ArticlesItemViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, authorTextView;

        public ArticlesItemViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title);
            authorTextView = itemView.findViewById(R.id.author);
        }
    }
}
