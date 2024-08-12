package com.example.wbjuniorandroid.ui.general.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbjuniorandroid.R
import com.example.wbjuniorandroid.ui.theme.WBJuniorAndroidTheme
import com.example.wbjuniorandroid.ui.theme.WBJuniorAppTheme
import com.example.wbjuniorandroid.ui.utils.Mock
import com.example.wbjuniorandroid.ui.utils.MoreItem

@Composable
fun MoreItemCard(
    modifier: Modifier = Modifier.fillMaxWidth(),
    moreItem: MoreItem,
    onNavigateTo: (String) -> Unit
) {
    Row(
        modifier = modifier
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            )
            .clickable {
                onNavigateTo(moreItem.route)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = moreItem.icon),
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(6.dp))
        Text(
            text = stringResource(id = moreItem.title),
            style = WBJuniorAppTheme.typography.bodytext1,
            color = WBJuniorAppTheme.colors.neutralActive
        )
        Spacer(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )
        Icon(
            imageVector = Icons.Outlined.KeyboardArrowRight,
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MoreItemCardPreview(
    @DrawableRes icon: Int = R.drawable.ic_coffee_bar,
    title: Int = R.string.more_my_events,
    onNavigateTo: (String) -> Unit = {},
) {
    WBJuniorAndroidTheme {
        MoreItemCard(
            moreItem = Mock.moreItemsList.first(),
            onNavigateTo = {
                Mock.moreItemsList.first()
            }
        )
    }
}