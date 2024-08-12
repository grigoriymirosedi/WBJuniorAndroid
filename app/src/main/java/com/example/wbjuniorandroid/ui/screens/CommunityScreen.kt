package com.example.wbjuniorandroid.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.wbjuniorandroid.ui.general.components.CommunityCard
import com.example.wbjuniorandroid.ui.general.components.CustomSearchBar
import com.example.wbjuniorandroid.ui.theme.WBJuniorAndroidTheme
import com.example.wbjuniorandroid.ui.theme.WBJuniorAppTheme
import com.example.wbjuniorandroid.ui.utils.Community
import com.example.wbjuniorandroid.ui.utils.Mock
import com.example.wbjuniorandroid.ui.utils.Screen

@Composable
fun CommunityScreen(
    navController: NavHostController
) {
    CommunityContent(
        communityList = Mock.communityList,
        onNavigateToCommunityDetails = { navController.navigate(Screen.CommunityDetails.route) }
    )
}

@Composable
private fun CommunityContent(
    communityList: List<Community>,
    onNavigateToCommunityDetails: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(WBJuniorAppTheme.colors.neutralWhite)
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.size(16.dp))
            CustomSearchBar()
        }
        items(communityList) {
            CommunityCard(
                community = it,
                onClick = onNavigateToCommunityDetails
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CommunityScreenPreview(
    communityList: List<Community> = Mock.communityList
) {
    WBJuniorAndroidTheme {
        CommunityContent(
            communityList = communityList,
            onNavigateToCommunityDetails = {}
        )
    }
}