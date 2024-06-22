package com.rvcoding.pedropeapp.domain.platform

import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override var id: String = "ios"
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()