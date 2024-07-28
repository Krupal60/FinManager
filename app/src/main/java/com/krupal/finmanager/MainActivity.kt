package com.krupal.finmanager

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.krupal.finmanager.ui.screens.MainContent
import com.krupal.finmanager.ui.theme.FinManagerTheme
import com.krupal.finmanager.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            navigationBarStyle = SystemBarStyle.auto(
                Color.TRANSPARENT, Color.TRANSPARENT
            )
        )
        installSplashScreen().setKeepOnScreenCondition {
            viewModel.isLoading
        }
        setContent {
            FinManagerTheme {
                Surface {
                    MainContent(
                        startDestination = viewModel.startDestination,
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}

