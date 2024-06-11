import android.content.Context
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.annotation.OptIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.rvcoding.pedropeapp.di.Static
import com.rvcoding.pedropeapp.utils.getMediaSourceFromRawResource


@UnstableApi
class AndroidPlayer : Player {
    private val context: Context = Static.context
    private var exoPlayer: ExoPlayer = ExoPlayer.Builder(context).build()
//    private val mediaSession: MediaSession =
//        MediaSession.Builder(context, exoPlayer)
//            .setId(UUID.randomUUID().toString())
//            .build()

    init {
        exoPlayer.setMediaSource(getMediaSourceFromRawResource(context))
        exoPlayer.prepare()
    }

    @Composable
    override fun View() {
        val playerView = remember {
            PlayerView(context).apply {
                exoPlayer.repeatMode = ExoPlayer.REPEAT_MODE_ONE
                player = exoPlayer // Set the ExoPlayer instance to PlayerView
                useController = false // Hide the default controller
                layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT) // Or your desired dimensions
            }
        }

        DisposableEffect(key1 = exoPlayer) {
            onDispose {
                exoPlayer.release()
            }
        }
        val lifecycleOwner = LocalLifecycleOwner.current
        DisposableEffect(Unit) {
            val observer = LifecycleEventObserver { _, event ->
                when (event) {
                    Lifecycle.Event.ON_PAUSE -> pause()
                    Lifecycle.Event.ON_RESUME -> play()
                    else -> {}
                }
            }
            lifecycleOwner.lifecycle.addObserver(observer)
            onDispose {
                lifecycleOwner.lifecycle.removeObserver(observer)
            }
        }

        AndroidView({ playerView }) { view ->
            exoPlayer.play()
        }
    }
    override fun play() { exoPlayer.play() }
    override fun pause() { exoPlayer.pause() }
}

@OptIn(UnstableApi::class)
actual fun getPlayer(): Player = AndroidPlayer()
