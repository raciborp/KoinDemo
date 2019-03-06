package com.roche.koindemo.di

import android.preference.PreferenceManager
import com.roche.koindemo.FakeApi
import com.roche.koindemo.FakeApiImpl
import com.roche.koindemo.LocalRepository
import com.roche.koindemo.LocalRepositoryImpl
import com.roche.koindemo.MainActivityPresenter
import com.roche.koindemo.MainActivityPresenterImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val applicationModule = module {
    factory { PreferenceManager.getDefaultSharedPreferences(androidContext()) }
    single<LocalRepository> { LocalRepositoryImpl() }
}

val networkModule = module {
    single { FakeApiImpl() as FakeApi } // equals `single<FakeApi> { FakeApiImpl() }`
}

val viewModule = module {
    factory<MainActivityPresenter> { MainActivityPresenterImpl(get(), get()) }
}