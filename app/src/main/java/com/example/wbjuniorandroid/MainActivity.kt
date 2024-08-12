package com.example.wbjuniorandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.wbjuniorandroid.ui.navigation.MainNavigation
import com.example.wbjuniorandroid.ui.theme.WBJuniorAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            WBJuniorAndroidTheme {
                MainNavigation()
            }
        }
    }
}
