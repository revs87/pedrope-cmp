package com.rvcoding.pedropeapp.di

import com.russhwolf.settings.Settings
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module {
    single { Settings() }
//    single<PreferencesRepository> { PreferencesImpl(settings = get()) }
}

fun initializeKoin() {
    startKoin {
        modules(appModule)
    }
}