package com.example.wbjuniorandroid.ui.general.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.wbjuniorandroid.R
import com.example.wbjuniorandroid.ui.theme.WBJuniorAndroidTheme
import com.example.wbjuniorandroid.ui.theme.WBJuniorAppTheme
import com.example.wbjuniorandroid.ui.utils.Mock

@Composable
fun BorderImage(
    modifier: Modifier = Modifier.size(48.dp),
    imageURL: String,
) {
    AsyncImage(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .border(
                width = 2.dp,
                color = WBJuniorAppTheme.colors.neutralLine,
                shape = RoundedCornerShape(16.dp)
            ),
        contentScale = ContentScale.Crop,
        model = imageURL,
        placeholder = painterResource(id = R.drawable.image_placeholder),
        contentDescription = null
    )
}

@Preview
@Composable
fun BorderImagePreview(imageURL: String = Mock.borderImageURL) {
    WBJuniorAndroidTheme {
        BorderImage(imageURL = imageURL)
    }
}