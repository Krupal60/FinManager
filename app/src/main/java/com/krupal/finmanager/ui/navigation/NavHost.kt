package com.krupal.finmanager.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.krupal.finmanager.ui.screens.HomeScreenMain

@Composable
fun NavHost(navHostController: NavHostController) {

    androidx.navigation.compose.NavHost(
        navController = navHostController,
        startDestination = Home
    ) {
        composable<Home> {
            HomeScreenMain()
        }
        composable<Detail> {

        }
        composable<Analysis> {

        }
        composable<Profile> {

        }
    }
}