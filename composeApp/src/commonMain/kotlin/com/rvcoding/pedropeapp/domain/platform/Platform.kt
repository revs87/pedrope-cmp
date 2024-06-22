package com.rvcoding.pedropeapp.domain.platform

interface Platform {
    var id: String
    val name: String
}

expect fun getPlatform(): Platform