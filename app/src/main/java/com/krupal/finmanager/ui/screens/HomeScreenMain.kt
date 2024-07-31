package com.krupal.finmanager.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import sdp
import ssp

@Composable
fun HomeScreenMain() {
    HomeScreen()
}

@Composable
fun HomeScreen( ) {
        Content(
            Modifier
                .fillMaxSize()
                .navigationBarsPadding()
                .systemBarsPadding())
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    Column(modifier) {
        LazyColumn {
            repeat(20){
                item {
                    Card(modifier = Modifier.size(200.sdp)) {

                        Text("Hello Home Screen", fontSize = 16.ssp)
                    }
                }
            }

        }

    }
}

@Preview(device = "spec:parent=pixel_tablet")
@Composable
private fun Home() {
    Content(modifier = Modifier
        .fillMaxSize()
        .navigationBarsPadding()
        .systemBarsPadding())
}
