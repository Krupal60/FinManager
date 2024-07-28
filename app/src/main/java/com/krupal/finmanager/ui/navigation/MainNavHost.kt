@file:Suppress("IMPLICIT_CAST_TO_ANY")

package com.krupal.finmanager.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.krupal.finmanager.ui.screens.MainScreen
import com.krupal.finmanager.ui.screens.OnBoardScreen
import com.krupal.finmanager.ui.viewmodel.MainViewModel


@Composable
fun MainNavHost(startDestination: String, viewModel: MainViewModel) {
    val navHostController = rememberNavController()
    val start = if (startDestination == "main") Main else OnBoard
    androidx.navigation.compose.NavHost(
        navController = navHostController,
        startDestination = start
    ) {
        composable<Main> {
            MainScreen()
        }
        composable<OnBoard> {
            OnBoardScreen {
                viewModel.saveOnBoard()
                navHostController.navigate(Main) {
                    launchSingleTop = true
                }
            }
        }
        composable<DetailScreen> {

        }


    }
}