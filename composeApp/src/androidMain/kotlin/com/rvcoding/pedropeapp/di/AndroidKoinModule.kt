package com.rvcoding.pedropeapp.di

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context

@SuppressLint("StaticFieldLeak")
object Static {
    lateinit var context: Context
}

fun androidStaticInitialize(activity: Activity) {
    Static.context = activity.applicationContext
}