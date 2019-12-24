package com.webkeyz.batchtwotraining.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.webkeyz.batchtwotraining.R;
import com.webkeyz.batchtwotraining.databinding.FeedListitemBinding;
import com.webkeyz.batchtwotraining.models.ArticlesItem;
import com.webkeyz.batchtwotraining.utils.NetworkState;

public class FeedAdapter extends PagedListAdapter<ArticlesItem, RecyclerView.ViewHolder> {
    private static final String TAG = "FeedAdapter";
    private final int LOADING = -1;
    private final int ERROR = -2;
    private final int SUCCESS = 1;
    private NetworkState networkState;

    public FeedAdapter() {
        super(DIFF_CALLBACK);
    }

    private LayoutInflater layoutInflater;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        View view;
        if (viewType == LOADING) {
            view = layoutInflater.inflate(R.layout.loading_layout, parent, false);
            return new LoadingViewHolder(view);
        } else if (viewType == ERROR) {
            view = layoutInflater.inflate(R.layout.error_layout, parent, false);
            return new ErrorViewHolder(view);
        } else {
            FeedListitemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.feed_listitem, parent, false);
            return new ArticlesItemViewHolder(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == SUCCESS) {
            ArticlesItem articlesItem = getItem(position);
            Log.d(TAG, "onBindViewHolder: " + articlesItem);
            if (articlesItem != null) {
                ((ArticlesItemViewHolder) holder).bind(articlesItem);
            }
        }
    }

    private static DiffUtil.ItemCallback<ArticlesItem> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<ArticlesItem>() {
                // User details may have changed if reloaded from the database,
                // but ID is fixed.
                @Override
                public boolean areItemsTheSame(@NonNull ArticlesItem oldArticle, @NonNull ArticlesItem newArticle) {
                    return oldArticle.getSource().getId().equals(newArticle.getSource().getId());
                }

                @Override
                public boolean areContentsTheSame(@NonNull ArticlesItem oldArticle,
                                                  @NonNull ArticlesItem newArticle) {
                    return oldArticle.equals(newArticle);
                }
            };

    @Override
    public int getItemViewType(int position) {
        if (networkState.isLoading && position == getItemCount() - 1) {
            return LOADING;
        } else if (networkState.status == NetworkState.Status.ERROR && position == getItemCount() - 1) {
            return ERROR;
        } else {
            return SUCCESS;
        }
    }

    public void setNetworkState(NetworkState networkState) {
        this.networkState = networkState;
    }

    public class ArticlesItemViewHolder extends RecyclerView.ViewHolder {
        private FeedListitemBinding binding;

        public ArticlesItemViewHolder(FeedListitemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ArticlesItem item) {
            binding.title.setText(item.getTitle());
            binding.author.setText(item.getAuthor());
            binding.executePendingBindings();
        }
    }

    public class LoadingViewHolder extends RecyclerView.ViewHolder {
        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class ErrorViewHolder extends RecyclerView.ViewHolder {
        public ErrorViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}