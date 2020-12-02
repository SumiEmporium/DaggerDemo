package com.bdtheme.receipedagger

import com.bdtheme.receipedagger.di.ApplicationComponent
import com.bdtheme.receipedagger.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApplication : DaggerApplication() {
    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val applicationComponent: ApplicationComponent =
            DaggerApplicationComponent.builder().application(this).build()
        applicationComponent.inject(this)
        return applicationComponent
    }
}