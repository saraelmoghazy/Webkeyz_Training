package com.webkeyz.batchtwotraining.di;

import android.app.Application;

import com.webkeyz.batchtwotraining.BaseApplication;
import com.webkeyz.batchtwotraining.di.viewmodels.ViewModelFactoryModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {AndroidSupportInjectionModule.class,
                AppModule.class,
                ViewModelFactoryModule.class,
                ActivityBuildersModule.class
        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
