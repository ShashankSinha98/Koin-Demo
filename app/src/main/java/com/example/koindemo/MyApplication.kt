package com.example.koindemo

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {

    // init Koin
    override fun onCreate() {
        super.onCreate()

        startKoin {
            // used to pass application context to koin
            androidContext(this@MyApplication)
            modules(appModule + activityModule)
        }
    }
}