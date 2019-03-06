package com.roche.koindemo

import android.app.Application
import com.roche.koindemo.di.applicationModule
import com.roche.koindemo.di.networkModule
import com.roche.koindemo.di.viewModule
import org.koin.android.ext.android.startKoin

class KoinDemoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(
            this,
            listOf(
                applicationModule,
                networkModule,
                viewModule
            )
        )
    }
}