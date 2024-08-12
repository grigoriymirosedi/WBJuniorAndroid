package com.example.wbjuniorandroid.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

class TopAppBarState(
    val navController: NavController,
) {
    private val currentScreenRoute: String?
        @Composable get() = navController
            .currentBackStackEntryAsState()
            .value?.destination?.route

    val currentScreen: Screen?
        @Composable get() = getScreen(currentScreenRoute)

    val isVisible: Boolean
        @Composable get() = currentScreen?.isAppBarVisible == true

    val canNavigateBack: Boolean
        @Composable get() = currentScreen?.canNavigateBack == true

    val navigationTrailingIcon: ImageVector?
        @Composable get() = currentScreen?.trailingIcon

    val onNavigationIconClick: (() -> Unit)?
        @Composable get() = currentScreen?.onNavigationIconClick

    val appBarTitle: Int?
        @Composable get() = currentScreen?.appBarTitle

}

@Composable
fun rememberAppBarState(
    navController: NavController,
) = remember { TopAppBarState(navController) }