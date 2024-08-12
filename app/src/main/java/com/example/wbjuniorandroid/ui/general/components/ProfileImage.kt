package com.example.wbjuniorandroid.ui.general.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.wbjuniorandroid.R
import com.example.wbjuniorandroid.ui.theme.WBJuniorAppTheme
import com.example.wbjuniorandroid.ui.utils.Mock

@Composable
fun ProfileImage(
    modifier: Modifier = Modifier,
    size: Dp = 200.dp,
    profileImageURL: String,
    backgroundColor: Color = Color.Transparent,
    isEditModeEnabled: Boolean = false,
) {
    Box(
        modifier = modifier
            .size(size)
            .background(
                color = backgroundColor,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(0.80f).clip(CircleShape),
            model = profileImageURL,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.profile_image_placeholder),
            contentDescription = null
        )
        if (isEditModeEnabled) {
            Icon(
                modifier = Modifier
                    .fillMaxSize(0.24f)
                    .align(Alignment.BottomEnd),
                imageVector = Icons.Filled.AddCircle,
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileImagePreview(
    modifier: Modifier = Modifier.size(200.dp),
    profileImageURL: String = Mock.profileImageURL,
    isEditModeEnabled: Boolean = true,
) {
    ProfileImage(
        modifier = modifier,
        profileImageURL = profileImageURL,
        isEditModeEnabled = isEditModeEnabled)
}