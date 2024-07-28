package com.krupal.finmanager.ui.screens

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.krupal.finmanager.ui.navigation.NavHost

@Composable
fun MainScreen() {
    Scaffold {
        NavHost(it)
    }
}