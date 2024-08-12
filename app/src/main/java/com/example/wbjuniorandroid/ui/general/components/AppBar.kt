package com.example.wbjuniorandroid.ui.general.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.wbjuniorandroid.ui.theme.WBJuniorAppTheme
import com.example.wbjuniorandroid.ui.utils.TopAppBarState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    appBarState: TopAppBarState,
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = WBJuniorAppTheme.colors.neutralWhite,
            titleContentColor = WBJuniorAppTheme.colors.neutralActive,
            navigationIconContentColor = WBJuniorAppTheme.colors.neutralActive,
            actionIconContentColor = WBJuniorAppTheme.colors.neutralActive
        ),
        navigationIcon = {
            val canNavigateBack = appBarState.canNavigateBack
            if (canNavigateBack) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Outlined.KeyboardArrowLeft, contentDescription = null)
                }
            }
        },
        title = {
            val title = appBarState.appBarTitle
            if (title != null) {
                Text(
                    text = stringResource(id = title),
                    style = WBJuniorAppTheme.typography.subheading1,
                )
            }
        },
        actions = {
            val trailingIcon = appBarState.navigationTrailingIcon
            if (trailingIcon != null) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = trailingIcon, contentDescription = null)
                }
            }
        }
    )
}