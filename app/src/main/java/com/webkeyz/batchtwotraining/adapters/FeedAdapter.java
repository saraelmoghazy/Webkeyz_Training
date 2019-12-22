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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_listitem, parent, false);
        return new ArticlesItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticlesItemViewHolder holder, int position) {
        ArticlesItem articlesItem = getItem(position);
        if (articlesItem != null) {
            holder.nameTextView.setText(articlesItem.getTitle());
            holder.ageTextView.setText(articlesItem.getPublishedAt());
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
        TextView nameTextView, ageTextView;

        public ArticlesItemViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name);
            ageTextView = itemView.findViewById(R.id.age);
        }
    }
}
