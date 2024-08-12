package com.example.wbjuniorandroid.ui.general.components

import androidx.compose.foundation.Image
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.wbjuniorandroid.R
import com.example.wbjuniorandroid.ui.theme.WBJuniorAndroidTheme
import com.example.wbjuniorandroid.ui.theme.WBJuniorAppTheme
import com.example.wbjuniorandroid.ui.utils.Community
import com.example.wbjuniorandroid.ui.utils.Mock

@Composable
fun CommunityCard(
    modifier: Modifier = Modifier,
    community: Community,
    onClick: () -> Unit
) {
    Column(modifier = modifier.clickable { onClick() }) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            AsyncImage(
                modifier = Modifier.size(56.dp)
                    .clip(RoundedCornerShape(16.dp)),
                placeholder = painterResource(id = R.drawable.image_placeholder),
                contentScale = ContentScale.Crop,
                model = community.communityURL,
                contentDescription = null
            )
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(
                    text = community.title,
                    style = WBJuniorAppTheme.typography.bodytext1,
                )
                Text(
                    text = community.followers,
                    style = WBJuniorAppTheme.typography.metadata1,
                    color = WBJuniorAppTheme.colors.neutralWeak
                )
            }
        }
        Spacer(modifier = Modifier.size(12.dp))
        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = WBJuniorAppTheme.colors.neutralLine
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CommunityCardPreview(
    community: Community = Mock.communityList.first()
) {
    WBJuniorAndroidTheme {
        CommunityCard(
            community = community,
            onClick = {}
        )
    }
}