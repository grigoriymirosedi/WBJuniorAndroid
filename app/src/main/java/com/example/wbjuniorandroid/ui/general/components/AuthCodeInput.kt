package com.example.wbjuniorandroid.ui.general.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbjuniorandroid.ui.theme.WBJuniorAndroidTheme
import com.example.wbjuniorandroid.ui.theme.WBJuniorAppTheme

@Composable
fun AuthCodeInput(
    modifier: Modifier = Modifier,
    onCodeComplete: (String) -> Unit,
    digitsCount: Int = 4
) {
    var code by remember { mutableStateOf("") }

    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
        keyboardController?.show()
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(digitsCount) { index ->
                Box(
                    modifier = Modifier
                        .size(
                            width = 32.dp,
                            height = 40.dp
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    if (index < code.length) {
                        Text(
                            text = code[index].toString(),
                            style = WBJuniorAppTheme.typography.heading1,
                            color = WBJuniorAppTheme.colors.neutralActive
                        )
                    } else {
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .background(
                                    color = WBJuniorAppTheme.colors.neutralLine,
                                    shape = CircleShape
                                )
                        )
                    }
                }
            }
        }

        TextField(
            value = code,
            onValueChange = {
                if (it.length <= digitsCount && it.all { char -> char.isDigit() }) {
                    code = it
                    if (code.length == digitsCount) {
                        onCodeComplete(code)
                        keyboardController?.hide() 
                    }
                }
            },
            modifier = Modifier
                .focusRequester(focusRequester)
                .alpha(0f),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AuthCodeInputPreview() {
    WBJuniorAndroidTheme {
        AuthCodeInput(onCodeComplete = {})
    }
}
