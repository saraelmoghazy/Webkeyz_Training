package com.webkeyz.batchtwotraining.di;

import com.webkeyz.batchtwotraining.MainActivity;
import com.webkeyz.batchtwotraining.di.viewmodels.UserViewModelModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = {UserViewModelModule.class})
    abstract MainActivity contributeMainActivity();
}
