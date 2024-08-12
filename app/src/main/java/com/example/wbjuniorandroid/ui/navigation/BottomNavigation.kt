package com.example.wbjuniorandroid.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.wbjuniorandroid.R

sealed class BottomNavItem(
    val route: String,
    @DrawableRes val icon: Int,
    @StringRes val resourceId: Int
) {
    data object Events: BottomNavItem(
        route = "events",
        icon = R.drawable.ic_coffee_bar,
        resourceId = R.string.bottom_bar_events
    )
    data object Community: BottomNavItem(
        route = "community",
        icon = R.drawable.community_bar_icon,
        resourceId = R.string.bottom_bar_community
    )
    data object More: BottomNavItem(
        route = "more",
        icon = R.drawable.more_bar_item,
        resourceId = R.string.bottom_bar_more
    )
}

val bottomNavItems = listOf(
    BottomNavItem.Events,
    BottomNavItem.Community,
    BottomNavItem.More
)