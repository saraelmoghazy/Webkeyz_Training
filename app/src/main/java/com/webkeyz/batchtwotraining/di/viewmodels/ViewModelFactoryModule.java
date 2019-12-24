package com.webkeyz.batchtwotraining.di.viewmodels;

import androidx.lifecycle.ViewModelProvider;

import com.webkeyz.batchtwotraining.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);
}
