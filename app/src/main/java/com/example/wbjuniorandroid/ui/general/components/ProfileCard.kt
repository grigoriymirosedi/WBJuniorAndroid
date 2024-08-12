package com.example.wbjuniorandroid.ui.general.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.wbjuniorandroid.R
import com.example.wbjuniorandroid.ui.theme.WBJuniorAndroidTheme
import com.example.wbjuniorandroid.ui.theme.WBJuniorAppTheme
import com.example.wbjuniorandroid.ui.utils.Mock

@Composable
fun ProfileCard(
    modifier: Modifier = Modifier.fillMaxWidth(),
    profileImageURL: String,
    profileName: String,
    profilePhoneNumber: String,
    onNavigateToProfileScreen: () -> Unit,
) {
    Row(
        modifier = modifier
            .padding(
                vertical = 8.dp,
                horizontal = 16.dp
            )
            .clickable {
                onNavigateToProfileScreen()
            },
    ) {
        AsyncImage(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            model = profileImageURL,
            placeholder = painterResource(id = R.drawable.image_placeholder),
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(20.dp))
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(
                text = profileName,
                style = WBJuniorAppTheme.typography.bodytext1
            )
            Text(
                text = profilePhoneNumber,
                style = WBJuniorAppTheme.typography.metadata1,
                color = WBJuniorAppTheme.colors.neutralDisabled
            )
        }
        Spacer(modifier = Modifier.weight(1f).fillMaxWidth())
        Icon(
            modifier = Modifier.align(Alignment.CenterVertically),
            imageVector = Icons.Outlined.KeyboardArrowRight,
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileCardPreview(
    profileImageURL: String = Mock.profileImageURL,
    profileName: String = Mock.username,
    profilePhoneNumber: String = Mock.userPhoneNumber,
) {
    WBJuniorAndroidTheme {
        ProfileCard(
            profileImageURL = profileImageURL,
            profileName = profileName,
            profilePhoneNumber = profilePhoneNumber,
            onNavigateToProfileScreen = {}
        )
    }
}
