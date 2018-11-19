package com.creolestudios

import android.app.Activity
import android.app.Application
import com.creolestudios.di.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class DemoApp : Application() , HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

     AppInjector.init(this)

    }

    override fun activityInjector() = dispatchingAndroidInjector
}