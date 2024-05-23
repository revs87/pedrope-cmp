package com.rvcoding.pedropeapp.di

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context

//val androidModule = module {
//}

@SuppressLint("StaticFieldLeak")
object Static {
    lateinit var context: Context
}

fun initializeKoin(activity: Activity) {
    Static.context = activity.applicationContext
//    startKoin {
//        modules(androidModule)
//    }
}