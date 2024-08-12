package com.example.wbjuniorandroid.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wbjuniorandroid.R
import com.example.wbjuniorandroid.ui.general.components.PrimaryFilledButton
import com.example.wbjuniorandroid.ui.general.components.ProfileImage
import com.example.wbjuniorandroid.ui.theme.WBJuniorAndroidTheme
import com.example.wbjuniorandroid.ui.theme.WBJuniorAppTheme
import com.example.wbjuniorandroid.ui.utils.Mock
import com.example.wbjuniorandroid.ui.utils.Screen

@Composable
fun AuthProfileScreen(
    navController: NavController,
) {
    var name by rememberSaveable { mutableStateOf("") }
    var secondName by rememberSaveable { mutableStateOf("") }


    AuthProfileContent(
        profileImageURL = Mock.profileImageURL,
        name = name,
        secondName = secondName,
        onNameValueChange = { name = it },
        onSecondNameValueChange = { secondName = it },
        onComplete = { navController.navigate(Screen.Events.route) }
    )
}

@Composable
private fun AuthProfileContent(
    modifier: Modifier = Modifier.fillMaxSize(),
    name: String,
    secondName: String,
    profileImageURL: String,
    onNameValueChange: (String) -> Unit,
    onSecondNameValueChange: (String) -> Unit,
    onComplete: () -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = modifier.padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ProfileImage(
            modifier = Modifier.size(100.dp),
            profileImageURL = profileImageURL,
            isEditModeEnabled = true
        )
        Spacer(modifier = Modifier.size(31.dp))
        BasicTextField(
            modifier = Modifier.fillMaxWidth(),
            value = name,
            singleLine = true,
            textStyle = WBJuniorAppTheme.typography.bodytext1.copy(color = WBJuniorAppTheme.colors.neutralActive),
            onValueChange = onNameValueChange,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            ),
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
                    if (name.isEmpty()) {
                        Text(
                            text = stringResource(id = R.string.auth_profile_name),
                            color = WBJuniorAppTheme.colors.neutralDisabled,
                            style = WBJuniorAppTheme.typography.bodytext1
                        )
                    }
                    innerTextField()
                }
            }
        )
        Spacer(modifier = Modifier.size(12.dp))
        BasicTextField(
            modifier = Modifier.fillMaxWidth(),
            value = secondName,
            singleLine = true,
            textStyle = WBJuniorAppTheme.typography.bodytext1.copy(color = WBJuniorAppTheme.colors.neutralActive),
            onValueChange = onSecondNameValueChange,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            ),
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
                    if (secondName.isEmpty()) {
                        Text(
                            text = stringResource(id = R.string.auth_profile_second_name),
                            color = WBJuniorAppTheme.colors.neutralDisabled,
                            style = WBJuniorAppTheme.typography.bodytext1
                        )
                    }
                    innerTextField()
                }
            }
        )
        Spacer(modifier = Modifier.size(56.dp))
        PrimaryFilledButton(
            enabled = name.isNotEmpty() && secondName.isNotEmpty(),
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.auth_profile_save_button),
            onClick = onComplete,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AuthProfileScreenPreview(
    name: String = Mock.name,
    secondName: String = Mock.secondName,
    profileImageURL: String = Mock.profileImageURL,
    onNameValueChange: (String) -> Unit = {},
    onSecondNameValueChange: (String) -> Unit = {},
    onComplete: () -> Unit = {},
) {
    WBJuniorAndroidTheme {
        AuthProfileContent(
            name = name,
            secondName = secondName,
            profileImageURL = profileImageURL,
            onNameValueChange = onNameValueChange,
            onSecondNameValueChange = onSecondNameValueChange,
            onComplete = onComplete
        )
    }
}