package com.example.wbjuniorandroid.ui.general.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ChipColors
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbjuniorandroid.ui.theme.WBJuniorAndroidTheme
import com.example.wbjuniorandroid.ui.theme.WBJuniorAppTheme


@Composable
fun CustomChip(
    text: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .padding(
                vertical = 4.dp,
                horizontal = 2.dp
            )
            .clip(RoundedCornerShape(16.dp)),
        color = WBJuniorAppTheme.colors.brandBackground,
        contentColor = WBJuniorAppTheme.colors.brandDark
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    top = 4.dp,
                    end = 8.dp,
                    bottom = 4.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                style = WBJuniorAppTheme.typography.metadata3
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomChipPreview(text: String = "Python") {
    WBJuniorAndroidTheme {
        CustomChip(text = text)
    }
}