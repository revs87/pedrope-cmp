package com.rvcoding.pedropeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rvcoding.pedropeapp.di.androidStaticInitialize
import com.rvcoding.pedropeapp.di.initializeKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}