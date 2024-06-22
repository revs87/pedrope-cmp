package com.rvcoding.pedropeapp.domain.platform

import android.os.Build

class AndroidPlatform : Platform {
    override var id: String = "android"
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()