package com.example.wbjuniorandroid.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.wbjuniorandroid.R
import com.example.wbjuniorandroid.ui.general.components.CustomSearchBar
import com.example.wbjuniorandroid.ui.general.components.MeetingCard
import com.example.wbjuniorandroid.ui.theme.WBJuniorAndroidTheme
import com.example.wbjuniorandroid.ui.theme.WBJuniorAppTheme
import com.example.wbjuniorandroid.ui.utils.Event
import com.example.wbjuniorandroid.ui.utils.Mock
import com.example.wbjuniorandroid.ui.utils.Screen

@Composable
fun EventsScreen(
    navController: NavHostController
) {
    EventsContent(
        eventsList = Mock.allEventsList,
        onNavigateToEventDetails = { navController.navigate(Screen.EventDetails.route) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EventsContent(
    modifier: Modifier = Modifier.fillMaxSize(),
    eventsList: List<Event>,
    onNavigateToEventDetails: () -> Unit,
) {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf(
        stringResource(id = R.string.tab_all_mettings),
        stringResource(id = R.string.tab_active_meetings)
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(WBJuniorAppTheme.colors.neutralWhite)
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),

        ) {
        item {
            Spacer(modifier = Modifier.size(16.dp))
            CustomSearchBar()
            SecondaryTabRow(
                selectedTabIndex = selectedTab,
                containerColor = WBJuniorAppTheme.colors.neutralWhite,
                contentColor = WBJuniorAppTheme.colors.brandDefault,
                indicator = {
                    TabRowDefaults.SecondaryIndicator(
                        modifier = Modifier.tabIndicatorOffset(
                            selectedTab,
                            matchContentSize = false
                        ),
                        color = WBJuniorAppTheme.colors.brandDefault
                    )
                }
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        text = {
                            Text(
                                text = title.uppercase(),
                                style = WBJuniorAppTheme.typography.bodytext1
                            )
                        },
                        selectedContentColor = WBJuniorAppTheme.colors.brandDefault,
                        unselectedContentColor = WBJuniorAppTheme.colors.neutralWeak
                    )
                }

            }
        }
        when (selectedTab) {
            0 -> {
                items(eventsList) {
                    MeetingCard(
                        event = it,
                        onClick = onNavigateToEventDetails
                    )
                }
            }

            1 -> {
                items(eventsList.filter { !it.passed }) {
                    MeetingCard(
                        event = it,
                        onClick = onNavigateToEventDetails
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventsScreenPreview(
    eventsList: List<Event> = Mock.allEventsList,
    passedEventsList: List<Event> = Mock.passedEventsList,
) {
    WBJuniorAndroidTheme {
        EventsContent(
            eventsList = eventsList,
            onNavigateToEventDetails = {}
        )
    }
}