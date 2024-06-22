package com.rvcoding.pedropeapp

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.setSingletonImageLoaderFactory
import coil3.request.crossfade
import coil3.util.DebugLogger
import com.rvcoding.pedropeapp.presentation.VideoScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .background(color = Color.Black),
            contentAlignment = Alignment.BottomEnd
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Black),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                VideoScreen()
            }

            RotatingImage(
                imageUrl = "https://yt3.googleusercontent.com/BAC0XLkL-GL6oq1MFWRRxV7GqJMZC7vbh0Q6QMg753E6oJZngV33QQ6cvAnZWLB5OOx9nOh7KSQ=s900-c-k-c0x00ffffff-no-rj"
            )
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun RotatingImage(imageUrl: String) {
    setSingletonImageLoaderFactory { context ->
        getAsyncImageLoader(context)
    }

    val infiniteTransition = rememberInfiniteTransition()
    val angle by infiniteTransition.animateFloat(
        initialValue = 360f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 5500, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    SubcomposeAsyncImage(
        model = imageUrl,
        contentDescription = imageUrl.takeLast(5),
        modifier = Modifier
            .padding(12.dp)
            .size(64.dp)
            .graphicsLayer {
                rotationZ = angle
            }
    )
}

fun getAsyncImageLoader(context: PlatformContext) =
    ImageLoader.Builder(context).crossfade(true).logger(DebugLogger()).build()