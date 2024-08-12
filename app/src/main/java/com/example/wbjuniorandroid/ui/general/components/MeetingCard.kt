package com.example.wbjuniorandroid.ui.general.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.wbjuniorandroid.R
import com.example.wbjuniorandroid.ui.theme.WBJuniorAndroidTheme
import com.example.wbjuniorandroid.ui.theme.WBJuniorAppTheme
import com.example.wbjuniorandroid.ui.utils.Event
import com.example.wbjuniorandroid.ui.utils.Mock

@Composable
fun MeetingCard(
    modifier: Modifier = Modifier.fillMaxWidth(),
    event: Event,
    onClick: () -> Unit
) {
    Column(modifier = modifier.clickable { onClick() }) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            AsyncImage(
                modifier = Modifier.size(56.dp).clip(RoundedCornerShape(16.dp)),
                model = event.eventURL,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.image_placeholder),
                contentDescription = null
            )
            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Absolute.SpaceBetween
                ) {
                    Text(
                        text = event.title,
                        style = WBJuniorAppTheme.typography.bodytext1,
                    )
                    if(event.passed) {
                        Text(
                            text = stringResource(id = R.string.passed_event),
                            style = WBJuniorAppTheme.typography.metadata2,
                            color = WBJuniorAppTheme.colors.neutralWeak,
                        )
                    }
                }
                Text(
                    text = event.place,
                    style = WBJuniorAppTheme.typography.metadata1,
                    color = WBJuniorAppTheme.colors.neutralWeak
                )
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    event.tags.forEach { tagName ->
                        CustomChip(tagName)
                    }
                }

            }
        }
        Spacer(modifier = Modifier.size(12.dp))
        Divider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = WBJuniorAppTheme.colors.neutralLine)
    }

}

@Preview(showBackground = true)
@Composable
fun MeetingCardPreview(
    meeting: Event = Mock.allEventsList.first(),
) {
    WBJuniorAndroidTheme {
        MeetingCard(
            event = meeting,
            onClick = {}
        )
    }
}
