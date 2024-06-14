package com.rvcoding.pedropeapp.utils

import com.rvcoding.pedropeapp.domain.player.IosPlayer
import com.rvcoding.pedropeapp.domain.player.Player
import platform.AVFoundation.AVPlayer
import platform.Foundation.NSBundle
import platform.Foundation.NSURL


fun IosPlayer.getMediaSourcePlayerFromRawResource(): AVPlayer = AVPlayer(
    uRL = NSBundle.mainBundle.URLForResource(
        name = Player.FILE_NAME,
        withExtension = "mp4"
    )!!
)

fun IosPlayer.getMediaSourcePlayerFromURL(): AVPlayer = AVPlayer(
    uRL = NSURL.URLWithString(Player.URL_MP4_EXAMPLE)!!
)