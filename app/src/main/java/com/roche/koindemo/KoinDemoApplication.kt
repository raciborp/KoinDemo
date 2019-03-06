package com.roche.koindemo

import android.app.Application
import com.roche.koindemo.di.applicationModule
import org.koin.android.ext.android.startKoin

class KoinDemoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(
            this,
            listOf(applicationModule)
        )
    }
}