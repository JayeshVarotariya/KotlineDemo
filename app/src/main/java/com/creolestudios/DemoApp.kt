package com.creolestudios

import android.app.Activity
import android.app.Application
import com.creolestudios.di.DaggerAppComponets
import com.creolestudios.di.builder.AppModule
import com.creolestudios.di.builder.NetModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class DemoApp : Application() , HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponets.builder()
            .build().inject(this)

    }

    override fun activityInjector() = dispatchingAndroidInjector
}