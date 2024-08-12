package com.example.wbjuniorandroid.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.wbjuniorandroid.R
import com.example.wbjuniorandroid.ui.general.components.AuthPhoneInput
import com.example.wbjuniorandroid.ui.general.components.PhoneNumberBottomSheet
import com.example.wbjuniorandroid.ui.general.components.PrimaryFilledButton
import com.example.wbjuniorandroid.ui.theme.WBJuniorAndroidTheme
import com.example.wbjuniorandroid.ui.theme.WBJuniorAppTheme
import com.example.wbjuniorandroid.ui.utils.CodeRegion
import com.example.wbjuniorandroid.ui.utils.Screen


@Composable
fun AuthPhoneInputScreen(
    navController: NavHostController
) {
    AuthPhoneInputContent(onNavigateToCodeInput = { navController.navigate(Screen.AuthCodeInput.route) })
}

@Composable
private fun AuthPhoneInputContent(
    modifier: Modifier = Modifier.fillMaxSize(),
    onNavigateToCodeInput: () -> Unit,
) {

    var showPhoneBottomSheet by remember { mutableStateOf(false) }
    var phoneNumberRegion by remember {
        mutableStateOf(
            CodeRegion(title = "Россия", icon = R.drawable.ic_ru, prefix = "+7"),
        )
    }
    var phoneNumberComplete by remember { mutableStateOf(false) }


    if (showPhoneBottomSheet) {
        PhoneNumberBottomSheet(onValueChange = {
            phoneNumberRegion = it
        }) {
            showPhoneBottomSheet = false
        }
    }

    Column(
        modifier = modifier
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = R.string.auth_phone_input_title),
            style = WBJuniorAppTheme.typography.heading2
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.auth_phone_input_details),
            style = WBJuniorAppTheme.typography.bodytext2
        )
        Spacer(modifier = Modifier.size(49.dp))
        AuthPhoneInput(
            prefix = phoneNumberRegion.prefix,
            flag = phoneNumberRegion.icon,
            onValueChange = {
                phoneNumberComplete = it.length == PHONE_MAX_LENGTH
            },
            onExpandBottomSheet = {
                showPhoneBottomSheet = true
            }
        )
        Spacer(modifier = Modifier.size(69.dp))
        PrimaryFilledButton(
            modifier = Modifier.fillMaxWidth(),
            enabled = phoneNumberComplete,
            text = stringResource(id = R.string.auth_phone_continue_button),
            onClick = { onNavigateToCodeInput() }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AuthPhoneInputScreenPreview() {
    WBJuniorAndroidTheme {
        AuthPhoneInputContent(onNavigateToCodeInput = {})
    }
}

const val PHONE_MAX_LENGTH = 10