package com.webkeyz.batchtwotraining.di.viewmodels;

import androidx.lifecycle.ViewModel;

import com.webkeyz.batchtwotraining.di.ViewModelKey;
import com.webkeyz.batchtwotraining.viewmodels.UserViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class UserViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel.class)
    public abstract ViewModel bindUserViewModel(UserViewModel userViewModel);
}
