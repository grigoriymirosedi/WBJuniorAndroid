package com.example.wbjuniorandroid.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.wbjuniorandroid.ui.screens.AuthCodeInputScreen
import com.example.wbjuniorandroid.ui.screens.AuthPhoneInputScreen
import com.example.wbjuniorandroid.ui.screens.AuthProfileScreen
import com.example.wbjuniorandroid.ui.screens.CommunityDetailsScreen
import com.example.wbjuniorandroid.ui.screens.CommunityScreen
import com.example.wbjuniorandroid.ui.screens.EventDetailsScreen
import com.example.wbjuniorandroid.ui.screens.EventsScreen
import com.example.wbjuniorandroid.ui.screens.MoreScreen
import com.example.wbjuniorandroid.ui.screens.MyEventsScreen
import com.example.wbjuniorandroid.ui.screens.ProfileScreen
import com.example.wbjuniorandroid.ui.utils.Screen

@Composable
fun AppNavigation(
    navController: NavHostController,
    innerPadding: PaddingValues,
) {
    NavHost(
        navController,
        startDestination = Screen.AuthPhoneInput.route,
        Modifier.padding(innerPadding)
    ) {
        composable(Screen.AuthPhoneInput.route) {
            AuthPhoneInputScreen(navController = navController)
        }
        composable(Screen.AuthProfile.route) {
            AuthProfileScreen(navController = navController)
        }
        composable(Screen.AuthCodeInput.route) {
            AuthCodeInputScreen(navController = navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }
        composable(Screen.More.route) {
            MoreScreen(navController = navController)
        }
        composable(Screen.MyEvents.route) {
            MyEventsScreen(navController = navController)
        }
        composable(Screen.Events.route) {
            EventsScreen(navController = navController)
        }
        composable(Screen.Community.route) {
            CommunityScreen(navController = navController)
        }
        composable(Screen.CommunityDetails.route) {
            CommunityDetailsScreen(navController = navController)
        }
        composable(Screen.EventDetails.route) {
            EventDetailsScreen(navController = navController)
        }
    }
}