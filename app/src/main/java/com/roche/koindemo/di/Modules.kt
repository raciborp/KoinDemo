package com.roche.koindemo.di

import android.preference.PreferenceManager
import com.roche.koindemo.FakeApi
import com.roche.koindemo.FakeApiImpl
import com.roche.koindemo.LocalRepository
import com.roche.koindemo.LocalRepositoryImpl
import com.roche.koindemo.MainActivityPresenter
import com.roche.koindemo.MainActivityPresenterImpl
import com.roche.koindemo.di.Scopes.Companion.SCOPE_ACTIVITY
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
    scope(SCOPE_ACTIVITY) { MainActivityPresenterImpl(get(), get()) } bind MainActivityPresenter::class
    // ^ `equals scope<MainActivityPresenter>(Scopes.SCOPE_VIEW) { MainActivityPresenterImpl(get(), get()) }`
}

class Scopes private constructor() {
    companion object {
        const val SCOPE_ACTIVITY = "SCOPE_ACTIVITY"
    }
}