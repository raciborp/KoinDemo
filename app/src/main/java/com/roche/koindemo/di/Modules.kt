package com.roche.koindemo.di

import android.preference.PreferenceManager
import com.roche.koindemo.LocalRepository
import com.roche.koindemo.LocalRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val applicationModule = module {
    factory { PreferenceManager.getDefaultSharedPreferences(androidContext()) }
    single<LocalRepository> { LocalRepositoryImpl() }
}