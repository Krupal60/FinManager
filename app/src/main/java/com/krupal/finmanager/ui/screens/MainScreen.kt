package com.krupal.finmanager.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PersonPin
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.krupal.finmanager.ui.navigation.Analysis
import com.krupal.finmanager.ui.navigation.Detail
import com.krupal.finmanager.ui.navigation.Home
import com.krupal.finmanager.ui.navigation.NavHost
import com.krupal.finmanager.ui.navigation.Profile

@Composable
fun MainScreen() {
    var list = listOf(
        Home to Icons.Default.Home,
        Detail to Icons.Default.Category,
        Analysis to Icons.Default.Analytics,
        Profile to Icons.Default.PersonPin
    )
    val navHostController = rememberNavController()
    val navSuiteType =
        calculateFromAdaptiveInfo(currentWindowAdaptiveInfo())
    val currentBackStackEntry by navHostController.currentBackStackEntryAsState()

    NavigationSuiteScaffold(
        layoutType = navSuiteType,
        navigationSuiteColors = NavigationSuiteDefaults.colors(
            navigationBarContainerColor = MaterialTheme.colorScheme.surface.copy(0f),
            navigationRailContainerColor = MaterialTheme.colorScheme.surface.copy(0f),
            navigationDrawerContainerColor = MaterialTheme.colorScheme.surface.copy(0f)
        ),
        containerColor = NavigationSuiteScaffoldDefaults.containerColor.copy(1f),
        navigationSuiteItems = {
            list.forEach { list ->
                item(selected = currentBackStackEntry?.destination?.let { it.route == list.first.javaClass.name } == true,
                    onClick = {
                        navHostController.navigate(list.first) {
                            if (currentBackStackEntry?.destination?.let { it.route != list.first.javaClass.name } == false) {
                                popUpTo(navHostController.graph.startDestinationId)
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Icon(imageVector = list.second, contentDescription = list.second.name)
                    })
            }
        })
    {
        NavHost(navHostController)
    }
}
