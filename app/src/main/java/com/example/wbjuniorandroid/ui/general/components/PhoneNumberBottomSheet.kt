package com.example.wbjuniorandroid.ui.general.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbjuniorandroid.ui.theme.WBJuniorAppTheme
import com.example.wbjuniorandroid.ui.utils.CodeRegion
import com.example.wbjuniorandroid.ui.utils.Mock

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneNumberBottomSheet(
    codeRegionList: List<CodeRegion> = Mock.codeRegionList,
    onValueChange: (CodeRegion) -> Unit,
    onDismiss: () -> Unit
) {
    val modalBottomSheetState = rememberModalBottomSheetState()

    var selectedItem by remember { mutableStateOf(codeRegionList.first().title) }

    ModalBottomSheet(
        sheetState = modalBottomSheetState,
        onDismissRequest = { onDismiss() }) {
        LazyColumn {
            items(codeRegionList) { country ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp, horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row {
                        Image(
                            painter = painterResource(id = country.icon),
                            contentDescription = null,
                            modifier = Modifier.padding(end = 20.dp)
                        )
                        Text(
                            text = country.title,
                            style = WBJuniorAppTheme.typography.subheading2
                        )
                    }
                    RadioButton(
                        selected = selectedItem == country.title,
                        onClick = {
                            selectedItem = country.title
                            onValueChange(country)
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PhoneNumberBottomSheetPreview(codeRegionList: List<CodeRegion> = Mock.codeRegionList) {
    PhoneNumberBottomSheet(codeRegionList = codeRegionList, onDismiss = { }, onValueChange = {})
}