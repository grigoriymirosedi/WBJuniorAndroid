package com.example.wbjuniorandroid.ui.general.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbjuniorandroid.R
import com.example.wbjuniorandroid.ui.theme.WBJuniorAndroidTheme
import com.example.wbjuniorandroid.ui.theme.WBJuniorAppTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun CustomSearchBar(
    modifier: Modifier = Modifier,
) {
    var text by rememberSaveable { mutableStateOf("") }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = WBJuniorAppTheme.colors.neutralSecondaryBackground,
                shape = RoundedCornerShape(5.dp)
            )
    ) {
        Icon(
            imageVector = Icons.Outlined.Search,
            contentDescription = null,
            modifier = Modifier
                .padding(
                    vertical = 6.dp,
                    horizontal = 8.dp
                ),
            tint = WBJuniorAppTheme.colors.neutralDisabled
        )
        Box(modifier = Modifier.weight(1f)) {
            if (text.isEmpty()) {
                Text(
                    text = stringResource(id = R.string.search),
                    color = WBJuniorAppTheme.colors.neutralDisabled,
                    style = WBJuniorAppTheme.typography.bodytext1
                )
            }
            BasicTextField2(
                value = text,
                onValueChange = { text = it },
                lineLimits = TextFieldLineLimits.SingleLine,
                textStyle = WBJuniorAppTheme.typography.bodytext1.copy(color = WBJuniorAppTheme.colors.neutralActive),
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomSearchBarPreview(modifier: Modifier = Modifier.fillMaxWidth()) {
    WBJuniorAndroidTheme {
        CustomSearchBar(modifier = modifier)
    }
}