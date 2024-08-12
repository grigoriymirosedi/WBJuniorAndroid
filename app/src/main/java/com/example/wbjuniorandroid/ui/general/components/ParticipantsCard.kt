package com.example.wbjuniorandroid.ui.general.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbjuniorandroid.R
import com.example.wbjuniorandroid.ui.theme.WBJuniorAppTheme
import com.example.wbjuniorandroid.ui.utils.Mock

@Composable
fun ParticipantsCard(
    participants: List<String>,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OverlappingRow {
            participants.forEach {
                BorderImage(imageURL = it)
            }
        }
        if (participants.size > 5) {
            Text(text = ("+" + (participants.size - 5)), style = WBJuniorAppTheme.typography.bodytext1)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ParticipantsCardPreview(
    participants: List<String> = MutableList(4) { Mock.borderImageURL },
) {
    ParticipantsCard(participants = participants)
}