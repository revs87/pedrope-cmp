package presentation

import Video
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun VideoScreen() {
    val player = remember { Video().player }

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        player.View()
    }
}