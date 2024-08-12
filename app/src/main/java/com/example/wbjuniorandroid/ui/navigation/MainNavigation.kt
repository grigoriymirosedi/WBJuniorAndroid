package com.example.wbjuniorandroid.ui.navigation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.wbjuniorandroid.ui.general.components.AppBar
import com.example.wbjuniorandroid.ui.theme.WBJuniorAppTheme
import com.example.wbjuniorandroid.ui.utils.NoRippleInteractionSource
import com.example.wbjuniorandroid.ui.utils.rememberAppBarState
import com.example.wbjuniorandroid.ui.utils.rememberBottomNavBarState

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    val appBarState = rememberAppBarState(navController = navController)
    val bottomNavBarState = rememberBottomNavBarState(navController = navController)

    Scaffold(
        topBar = {
            if(appBarState.isVisible) {
                AppBar(
                    modifier = Modifier.fillMaxWidth(),
                    appBarState = appBarState
                )
            }
        },
        bottomBar = {
            if(bottomNavBarState.isVisible) {
                NavigationBar(
                    containerColor = WBJuniorAppTheme.colors.neutralWhite,
                    contentColor = WBJuniorAppTheme.colors.neutralActive
                ) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    bottomNavItems.forEach { screen ->
                        val selected =
                            currentDestination?.hierarchy?.any() { it.route == screen.route } == true
                        NavigationBarItem(
                            interactionSource = NoRippleInteractionSource,
                            selected = selected,
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = {
                                Icons.Filled.Favorite
                                if (!selected)
                                    Image(
                                        painter = painterResource(id = screen.icon),
                                        contentDescription = null
                                    )
                                else
                                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                        Text(
                                            text = stringResource(id = screen.resourceId),
                                            style = WBJuniorAppTheme.typography.bodytext2,
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.SemiBold
                                        )
                                        Spacer(modifier = Modifier.size(11.dp))
                                        Canvas(modifier = Modifier.fillMaxWidth()) {
                                            drawCircle(Color.Black, radius = 6.0f)
                                        }
                                    }
                            },
                            colors = NavigationBarItemDefaults.colors(
                                indicatorColor = WBJuniorAppTheme.colors.neutralWhite
                            )
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        AppNavigation(
            navController = navController,
            innerPadding = innerPadding
        )
    }
} 