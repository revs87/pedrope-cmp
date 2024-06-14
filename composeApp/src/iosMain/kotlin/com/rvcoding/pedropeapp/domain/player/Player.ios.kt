package com.rvcoding.pedropeapp.domain.player

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import com.rvcoding.pedropeapp.utils.getMediaSourcePlayerFromRawResource
import kotlinx.cinterop.CValue
import kotlinx.cinterop.ExperimentalForeignApi
import platform.AVFoundation.AVPlayerActionAtItemEndNone
import platform.AVFoundation.AVPlayerLayer
import platform.AVFoundation.actionAtItemEnd
import platform.AVFoundation.pause
import platform.AVFoundation.play
import platform.AVKit.AVPlayerViewController
import platform.CoreGraphics.CGRect
import platform.QuartzCore.CATransaction
import platform.QuartzCore.kCATransactionDisableActions
import platform.UIKit.UIView


@OptIn(ExperimentalForeignApi::class)
class IosPlayer : Player {
    private val player = getMediaSourcePlayerFromRawResource()
    private val playerLayer = AVPlayerLayer()
    private val avPlayerViewController = AVPlayerViewController()

    init {
        player.actionAtItemEnd = AVPlayerActionAtItemEndNone
        avPlayerViewController.player = player
        avPlayerViewController.showsPlaybackControls = true
        playerLayer.player = player
    }

    @Composable
    override fun View() {
        UIKitView(
            factory = {
                val playerContainer = UIView()
                playerContainer.addSubview(avPlayerViewController.view)
                playerContainer
            },
            onResize = { view: UIView, rect: CValue<CGRect> ->
                CATransaction.begin()
                CATransaction.setValue(true, kCATransactionDisableActions)
                view.layer.setFrame(rect)
                playerLayer.setFrame(rect)
                avPlayerViewController.view.layer.frame = rect
                CATransaction.commit()
            },
            update = { view ->
                player.play()
                avPlayerViewController.player!!.play()
            },
            modifier = Modifier
                .fillMaxSize()
        )
    }
    override fun play() = player.play()
    override fun pause() = player.pause()
}

actual fun getPlayer(): Player = IosPlayer()