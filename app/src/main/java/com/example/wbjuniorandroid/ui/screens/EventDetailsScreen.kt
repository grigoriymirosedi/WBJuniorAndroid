package com.example.wbjuniorandroid.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.wbjuniorandroid.R
import com.example.wbjuniorandroid.ui.general.components.ParticipantsCard
import com.example.wbjuniorandroid.ui.general.components.PrimaryFilledButton
import com.example.wbjuniorandroid.ui.general.components.CustomChip
import com.example.wbjuniorandroid.ui.general.components.ZoomableImage
import com.example.wbjuniorandroid.ui.theme.WBJuniorAndroidTheme
import com.example.wbjuniorandroid.ui.theme.WBJuniorAppTheme
import com.example.wbjuniorandroid.ui.utils.Mock

@Composable
fun EventDetailsScreen(
    navController: NavHostController
) {
    EventDetailsContent(
        place = Mock.place,
        description = Mock.description,
        tags = Mock.tags,
        participants = List(12) { Mock.profileImageURL }
    )
}

@Composable
private fun EventDetailsContent(
    modifier: Modifier = Modifier.fillMaxSize(),
    place: String = Mock.place,
    description: String = Mock.description,
    tags: List<String> = Mock.tags,
    participants: List<String> = MutableList(12) { Mock.profileImageURL },
) {

    var showFullDescription by remember { mutableStateOf(false) }
    var showFullImage by remember { mutableStateOf(false) }

    if (showFullImage) {
        Dialog(
            properties = DialogProperties(usePlatformDefaultWidth = false),
            onDismissRequest = { showFullImage = false }
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                ZoomableImage(model = Mock.mapImageURL)
            }
        }
    }


    Column(
        modifier = modifier
            .padding(horizontal = 24.dp, vertical = 20.dp)
            .background(WBJuniorAppTheme.colors.neutralWhite)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            place,
            style = WBJuniorAppTheme.typography.bodytext1,
            color = WBJuniorAppTheme.colors.neutralWeak
        )
        Row {
            tags.forEach { tagName ->
                CustomChip(text = tagName)
            }
        }
        Spacer(modifier = Modifier.size(12.dp))
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(175.dp)
                .clickable { showFullImage = true }
                .clip(RoundedCornerShape(24.dp)),
            contentScale = ContentScale.Crop,
            model = Mock.mapImageURL,
            placeholder = painterResource(id = R.drawable.image_placeholder),
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(20.dp))
        Text(
            modifier = Modifier.clickable { showFullDescription = !showFullDescription },
            text = description,
            style = WBJuniorAppTheme.typography.metadata1,
            color = WBJuniorAppTheme.colors.neutralWeak,
            maxLines = if (showFullDescription) Int.MAX_VALUE else 8,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.size(20.dp))
        ParticipantsCard(participants = participants)
        Spacer(modifier = Modifier
            .weight(1f)
            .fillMaxHeight())
        PrimaryFilledButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Пойду на встречу!",
            onClick = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EventDetailsPreview(
    place: String = Mock.place,
    tags: List<String> = Mock.tags,
    description: String = Mock.description,
    participants: List<String> = MutableList(135) { Mock.eventURL },
) {
    WBJuniorAndroidTheme {
        EventDetailsContent(
            place = place,
            tags = tags,
            description = description,
            participants = participants
        )
    }
}