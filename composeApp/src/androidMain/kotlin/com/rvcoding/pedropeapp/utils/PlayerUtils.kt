package com.rvcoding.pedropeapp.utils

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import com.rvcoding.pedropeapp.domain.player.AndroidPlayer
import com.rvcoding.pedropeapp.domain.player.Player


@UnstableApi
fun AndroidPlayer.getMediaSourceFromRawResource(context: Context): ProgressiveMediaSource {
    val rawResourceId = context.resources.getIdentifier(Player.FILE_NAME, "raw", context.packageName)
    val uri = Uri.Builder().scheme(ContentResolver.SCHEME_ANDROID_RESOURCE).path(rawResourceId.toString()).build()
    val mediaItem = MediaItem.fromUri(uri)
    val dataSourceFactory = DefaultDataSource.Factory(context)
    val mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(mediaItem)
    return mediaSource
}

@UnstableApi
fun AndroidPlayer.getMediaSourceFromURL(context: Context): ProgressiveMediaSource {
    val mediaItem = MediaItem.fromUri(Player.URL_MP4_EXAMPLE)
    val dataSourceFactory = DefaultDataSource.Factory(context)
    val mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(mediaItem)
    return mediaSource
}