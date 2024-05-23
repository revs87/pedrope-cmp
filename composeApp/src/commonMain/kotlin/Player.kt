import androidx.compose.runtime.Composable

interface Player {
    @Composable
    fun View()
    fun play()
    fun pause()

    companion object {
        const val FILE_NAME = "pedrope"
        const val URL_MP4_EXAMPLE = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
        const val URL_MP4_EXAMPLE2 = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4"
    }
}

expect fun getPlayer(): Player