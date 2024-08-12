package com.example.wbjuniorandroid.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

class BottomNavBarState(
    val navController: NavController,
) {

    private val currentScreenRoute: String?
    @Composable get() = navController
        .currentBackStackEntryAsState()
        .value?.destination?.route

    val currentScreen: Screen?
    @Composable get() = getScreen(currentScreenRoute)

    val isVisible: Boolean
    @Composable get() = currentScreen?.isBottomNavBarVisible == true

}

@Composable
fun rememberBottomNavBarState(
    navController: NavController,
) = remember { BottomNavBarState(navController) }