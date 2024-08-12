package com.example.wbjuniorandroid.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.wbjuniorandroid.ui.general.components.MoreItemCard
import com.example.wbjuniorandroid.ui.general.components.ProfileCard
import com.example.wbjuniorandroid.ui.theme.WBJuniorAndroidTheme
import com.example.wbjuniorandroid.ui.theme.WBJuniorAppTheme
import com.example.wbjuniorandroid.ui.utils.Mock
import com.example.wbjuniorandroid.ui.utils.MoreItem
import com.example.wbjuniorandroid.ui.utils.Screen

@Composable
fun MoreScreen(
    navController: NavHostController
) {
    MoreContent(
        profileIcon = Mock.profileImageURL,
        profileName = Mock.username,
        profilePhoneNumber = Mock.userPhoneNumber,
        moreItemsList = Mock.moreItemsList,
        onNavigateToProfileScreen = { navController.navigate(Screen.Profile.route) },
        onNavigateTo = { navController.navigate(route = Mock.moreItemsList.first().route )}
    )
}

@Composable
private fun MoreContent(
    modifier: Modifier = Modifier.fillMaxSize(),
    profileIcon: String,
    profileName: String,
    profilePhoneNumber: String,
    moreItemsList: List<MoreItem>,
    onNavigateToProfileScreen: () -> Unit,
    onNavigateTo: (String) -> Unit
) {
    LazyColumn(
        modifier = modifier.padding(top = 8.dp),
    ) {
        item {
            ProfileCard(
                profileImageURL = profileIcon,
                profileName = profileName,
                profilePhoneNumber = profilePhoneNumber,
                onNavigateToProfileScreen = onNavigateToProfileScreen
            )
        }
        items(moreItemsList.size) { moreItemIndex ->
            when(moreItemIndex) {
                0 -> {
                    MoreItemCard(
                        modifier = Modifier
                            .padding(vertical = 8.dp),
                        moreItem = moreItemsList[moreItemIndex],
                        onNavigateTo = onNavigateTo
                    )
                }
                in 1..3 -> {
                    Spacer(modifier = Modifier.size(8.dp))
                    MoreItemCard(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .clickable {
                                onNavigateTo(moreItemsList[moreItemIndex].route)
                            },
                        moreItem = moreItemsList[moreItemIndex],
                        onNavigateTo = onNavigateTo
                    )
                }
                4 -> {
                    Spacer(modifier = Modifier.size(8.dp))
                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        color = WBJuniorAppTheme.colors.neutralLine
                    )
                }
                else -> {
                    Spacer(modifier = Modifier.size(8.dp))
                    MoreItemCard(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .clickable {
                                onNavigateTo(moreItemsList[moreItemIndex].route)
                            },
                        moreItem = moreItemsList[moreItemIndex],
                        onNavigateTo = onNavigateTo
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MoreScreenPreview(
    profileName: String = Mock.username,
    profilePhoneNumber: String = Mock.userPhoneNumber,
    profileIcon: String = Mock.profileImageURL,
    moreItemsList: List<MoreItem> = Mock.moreItemsList,
    onNavigateToProfileScreen: () -> Unit = {},
    onNavigateTo: (String) -> Unit = {
        Mock.moreItemsList.first().route
    }
) {
    WBJuniorAndroidTheme {
        MoreContent(
            profileIcon = profileIcon,
            profileName = profileName,
            profilePhoneNumber = profilePhoneNumber,
            moreItemsList = moreItemsList,
            onNavigateToProfileScreen = onNavigateToProfileScreen,
            onNavigateTo = onNavigateTo
        )
    }
}