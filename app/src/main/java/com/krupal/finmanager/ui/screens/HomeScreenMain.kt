package com.krupal.finmanager.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreenMain(paddingValues: PaddingValues) {
    HomeScreen(paddingValues)
}

@Composable
fun HomeScreen(paddingValues: PaddingValues) {
        Content(Modifier.fillMaxSize().padding(paddingValues).systemBarsPadding())
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    Column(modifier) {
        Text("Hello Home Screen")
    }
}
