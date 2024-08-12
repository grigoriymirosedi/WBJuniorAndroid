package com.example.wbjuniorandroid.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.wbjuniorandroid.R
import com.example.wbjuniorandroid.ui.general.components.MeetingCard
import com.example.wbjuniorandroid.ui.theme.WBJuniorAndroidTheme
import com.example.wbjuniorandroid.ui.theme.WBJuniorAppTheme
import com.example.wbjuniorandroid.ui.utils.Event
import com.example.wbjuniorandroid.ui.utils.Mock

@Composable
fun CommunityDetailsScreen(
    navController: NavHostController
) {
    CommunityDetailsContent(
        description = Mock.description,
        communityEvents = Mock.allEventsList
    )
}

@Composable
private fun CommunityDetailsContent(
    modifier: Modifier = Modifier.fillMaxSize(),
    description: String,
    communityEvents: List<Event>,
) {

    var showFullDescription by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = modifier
            .padding(start = 24.dp, end = 24.dp, top = 16.dp)
            .background(WBJuniorAppTheme.colors.neutralWhite),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                modifier = Modifier.clickable { showFullDescription = !showFullDescription },
                text = description,
                style = WBJuniorAppTheme.typography.metadata1,
                color = WBJuniorAppTheme.colors.neutralWeak,
                maxLines = if(showFullDescription) Int.MAX_VALUE else 14,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.size(14.dp))
            Text(
                text = stringResource(id = R.string.meetings_events),
                style = WBJuniorAppTheme.typography.bodytext1,
                color = WBJuniorAppTheme.colors.neutralWeak
            )
        }

        items(communityEvents) {
            MeetingCard(
                event = it,
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CommunityDetailsScreenPreview() {
    WBJuniorAndroidTheme {
        CommunityDetailsContent(
            description = Mock.description,
            communityEvents = Mock.allEventsList
        )
    }
}