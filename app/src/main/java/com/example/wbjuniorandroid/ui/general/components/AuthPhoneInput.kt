package com.example.wbjuniorandroid.ui.general.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbjuniorandroid.R
import com.example.wbjuniorandroid.ui.theme.WBJuniorAndroidTheme
import com.example.wbjuniorandroid.ui.theme.WBJuniorAppTheme

@Composable
fun AuthPhoneInput(
    modifier: Modifier = Modifier,
    prefix: String = "+7",
    flag: Int = R.drawable.ic_ru,
    phoneMaxLength: Int = 10,
    onExpandBottomSheet: () -> Unit,
    onValueChange: (String) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 24.dp
            ),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .background(WBJuniorAppTheme.colors.neutralSecondaryBackground)
                .padding(
                    horizontal = 8.dp,
                    vertical = 10.dp,
                ),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(flag),
                contentDescription = null,
                modifier = Modifier
                    .size(16.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .clickable {
                        onExpandBottomSheet()
                    }
            )
            Text(
                text = prefix,
                color = WBJuniorAppTheme.colors.neutralDisabled,
                style = WBJuniorAppTheme.typography.bodytext1
            )
        }
        var value by remember { mutableStateOf("") }
        BasicTextField(
            value = value,
            onValueChange = {
                val digits = it.filter { char -> char.isDigit() }
                if (digits.length <= phoneMaxLength) {
                    value = digits
                    onValueChange(digits)
                }
            },
            modifier = Modifier
                .weight(1f),
            textStyle = WBJuniorAppTheme.typography.bodytext1.copy(color = WBJuniorAppTheme.colors.neutralActive),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            visualTransformation = PhoneVisualTransformation,
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(WBJuniorAppTheme.colors.neutralSecondaryBackground)
                        .padding(
                            vertical = 10.dp,
                            horizontal = 8.dp
                        )
                ) {
                    if (value.isEmpty()) {
                        Text(
                            text = "999 999-99-99",
                            color = WBJuniorAppTheme.colors.neutralDisabled,
                            style = WBJuniorAppTheme.typography.bodytext1
                        )
                    }
                    innerTextField()
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AuthPhoneInputPreview() {
    WBJuniorAndroidTheme {
        AuthPhoneInput(
            onValueChange = {},
            onExpandBottomSheet = {})
    }
}

object PhoneVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val string = text.text
        val formattedString = buildString {
            for (i in string.indices) {
                append(string[i])
                when (i) {
                    2 -> append(" ")
                    5, 7 -> append("-")
                }
            }
        }

        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                return when {
                    offset <= 2 -> offset
                    offset <= 5 -> offset + 1
                    offset <= 7 -> offset + 2
                    offset <= 9 -> offset + 3
                    else -> formattedString.length
                }
            }

            override fun transformedToOriginal(offset: Int): Int {
                return when {
                    offset <= 2 -> offset
                    offset <= 6 -> offset - 1
                    offset <= 9 -> offset - 2
                    offset <= 11 -> offset - 3
                    else -> text.length
                }
            }
        }

        return TransformedText(
            AnnotatedString(formattedString),
            offsetMapping
        )
    }
}

