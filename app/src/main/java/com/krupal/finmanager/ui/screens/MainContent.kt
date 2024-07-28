package com.krupal.finmanager.ui.screens

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.krupal.finmanager.ui.navigation.MainNavHost
import com.krupal.finmanager.ui.viewmodel.MainViewModel

@Composable
fun MainContent(startDestination:String, viewModel: MainViewModel) {
    Surface {
        MainNavHost(startDestination,viewModel)
    }
}