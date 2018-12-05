package com.creolestudios

import android.app.Activity
import android.app.Application
import com.crashlytics.android.Crashlytics
import com.creolestudios.di.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.fabric.sdk.android.Fabric
import javax.inject.Inject

class DemoApp : Application() , HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

     AppInjector.init(this)
        Fabric.with(this, Crashlytics())
    }

    override fun activityInjector() = dispatchingAndroidInjector
}