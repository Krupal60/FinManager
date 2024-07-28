package com.krupal.finmanager.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun OnBoardScreen(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Column(Modifier.fillMaxSize().systemBarsPadding()) {

        Text("Hello onBoard Screen")
        Button(onClick = { onClick() }) {
            Text("Get Started")
        }
    }
}