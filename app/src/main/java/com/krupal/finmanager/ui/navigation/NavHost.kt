package com.krupal.finmanager.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.krupal.finmanager.ui.screens.HomeScreenMain

@Composable
fun NavHost(paddingValues: PaddingValues) {
    val navHostController = rememberNavController()
    androidx.navigation.compose.NavHost(navController = navHostController, startDestination = Home){
        composable<Home> {
            HomeScreenMain(paddingValues)
        }
        composable<Detail> {

        }
        composable<Analysis> {

        }
    }
}