package com.rvcoding.pedropeapp.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.rvcoding.pedropeapp.domain.player.VideoPlayer

@Composable
fun VideoScreen() {
    val player = remember { VideoPlayer().player }

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        player.View()
    }
}