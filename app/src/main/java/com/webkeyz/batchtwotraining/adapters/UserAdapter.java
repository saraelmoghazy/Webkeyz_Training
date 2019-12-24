package com.webkeyz.batchtwotraining.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.webkeyz.batchtwotraining.R;
import com.webkeyz.batchtwotraining.databinding.UserListItemBinding;
import com.webkeyz.batchtwotraining.models.User;

import java.util.List;

import javax.inject.Inject;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> userList;
    private LayoutInflater layoutInflater;

    @Inject
    public UserAdapter() {
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        UserListItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.user_list_item, parent, false);
        return new UserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.bind(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private UserListItemBinding binding;

        public UserViewHolder(UserListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(User user) {
            binding.userIdTextView.setText(String.valueOf(user.getId()));
            binding.userNameTextView.setText(user.getName());
            binding.executePendingBindings();
        }
    }
}