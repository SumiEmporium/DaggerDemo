package com.bdtheme.receipedagger

import android.app.Application
import android.content.Context
import com.bdtheme.receipedagger.di.ApiModule
import com.bdtheme.receipedagger.di.AppComponent
import com.bdtheme.receipedagger.di.DaggerAppComponent
import com.bdtheme.receipedagger.repository.APIURL

class MyApplication : Application() {

    companion object {
        var context: Context? = null
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        context = applicationContext
        appComponent = initDaggerComponent()
    }

    fun initDaggerComponent(): AppComponent {
        appComponent = DaggerAppComponent
            .builder().apiModule(ApiModule(APIURL.BASE_URL))
            .build()
        return appComponent
    }
}