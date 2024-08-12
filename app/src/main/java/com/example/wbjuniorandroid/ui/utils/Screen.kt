package com.example.wbjuniorandroid.ui.utils

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.wbjuniorandroid.R

sealed class Screen(
    val route: String,
    val isAppBarVisible: Boolean,
    val canNavigateBack: Boolean,
    @StringRes val appBarTitle: Int,
    val onNavigationIconClick: (() -> Unit)? = null,
    val isBottomNavBarVisible: Boolean = true,
    val trailingIcon: ImageVector? = null,
) {
    object Events: Screen(
        route = "events",
        isAppBarVisible = true,
        canNavigateBack = false,
        appBarTitle = R.string.app_bar_title_events,
        trailingIcon = Icons.Filled.Add,
    )
    object AuthProfile: Screen(
        route = "authprofile",
        isAppBarVisible = true,
        canNavigateBack = true,
        appBarTitle = R.string.app_bar_title_profile,
        isBottomNavBarVisible = false
    )
    object Community: Screen(
        route = "community",
        isAppBarVisible = true,
        canNavigateBack = false,
        appBarTitle = R.string.app_bar_title_community,
    )
    object More: Screen(
        route = "more",
        isAppBarVisible = true,
        canNavigateBack = false,
        appBarTitle = R.string.app_bar_title_more,
    )
    object Profile: Screen(
        route = "profile",
        isAppBarVisible = true,
        canNavigateBack = true,
        appBarTitle = R.string.app_bar_title_profile,
        trailingIcon = Icons.Filled.Edit
    )
    object MyEvents: Screen(
        route = "myevents",
        isAppBarVisible = true,
        canNavigateBack = true,
        appBarTitle = R.string.app_bar_title_my_events
    )
    object CommunityDetails: Screen(
        route = "communitydetails",
        isAppBarVisible = true,
        canNavigateBack = true,
        appBarTitle = R.string.app_bar_title_community_details
    )
    object EventDetails: Screen(
        route = "eventdetails",
        isAppBarVisible = true,
        canNavigateBack = true,
        appBarTitle = R.string.app_bar_title_event_details
    )

    object AuthPhoneInput: Screen(
        route = "authphoneinput",
        isAppBarVisible = true,
        canNavigateBack = true,
        appBarTitle = R.string.app_bar_title_empty,
        isBottomNavBarVisible = false
    )

    object AuthCodeInput: Screen(
        route = "authcodeinput",
        isAppBarVisible = true,
        canNavigateBack = true,
        appBarTitle = R.string.app_bar_title_empty,
        isBottomNavBarVisible = false
    )
}

fun getScreen(route: String?): Screen? = Screen::class.nestedClasses.map {
        kClass -> kClass.objectInstance as Screen
}.firstOrNull { screen -> screen.route == route }