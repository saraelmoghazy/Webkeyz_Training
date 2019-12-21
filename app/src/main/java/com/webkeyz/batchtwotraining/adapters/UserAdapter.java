package com.webkeyz.batchtwotraining.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.AsyncPagedListDiffer;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.webkeyz.batchtwotraining.R;
import com.webkeyz.batchtwotraining.models.User;

public class UserAdapter extends PagedListAdapter<User, UserAdapter.ViewHolder> {

    public UserAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_listitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = getItem(position);
        if (user != null) {
            holder.nameTextView.setText(user.getName());
            holder.ageTextView.setText(user.getAge());
        }
    }

    private static DiffUtil.ItemCallback<User> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<User>() {
                // User details may have changed if reloaded from the database,
                // but ID is fixed.
                @Override
                public boolean areItemsTheSame(@NonNull User oldUser, @NonNull User newUser) {
                    return oldUser.getId() == newUser.getId();
                }

                @Override
                public boolean areContentsTheSame(@NonNull User oldUser,
                                                  @NonNull User newUser) {
                    return oldUser.equals(newUser);
                }
            };

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, ageTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name);
            ageTextView = itemView.findViewById(R.id.age);
        }
    }
}
