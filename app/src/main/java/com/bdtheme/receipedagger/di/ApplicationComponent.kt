package com.bdtheme.receipedagger.di

import android.app.Application
import com.bdtheme.receipedagger.BaseApplication
import com.bdtheme.receipedagger.di.module.ActivityBindingModule
import com.bdtheme.receipedagger.di.module.ApplicationModule
import com.bdtheme.receipedagger.di.module.ContextModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton


@Singleton
@Component(
    modules = [ContextModule::class, AndroidSupportInjectionModule::class,
        ApplicationModule::class, ActivityBindingModule::class]
)
interface ApplicationComponent : AndroidInjector<DaggerApplication> {
    fun inject(application: BaseApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}