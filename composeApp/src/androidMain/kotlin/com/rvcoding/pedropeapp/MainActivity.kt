package com.rvcoding.pedropeapp

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rvcoding.pedropeapp.di.androidStaticInitialize
import com.rvcoding.pedropeapp.di.destroyKoin
import com.rvcoding.pedropeapp.di.initializeKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        androidStaticInitialize(this)
        initializeKoin()

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(1),
            navigationBarStyle = SystemBarStyle.dark(1)
        )
        setContent {
            App()
        }
    }

    override fun onDestroy() {
        destroyKoin()
        window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        super.onDestroy()
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}