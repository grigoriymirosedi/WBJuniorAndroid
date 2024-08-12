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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.wbjuniorandroid.R
import com.example.wbjuniorandroid.ui.general.components.AuthCodeInput
import com.example.wbjuniorandroid.ui.general.components.GhostTextButton
import com.example.wbjuniorandroid.ui.theme.WBJuniorAppTheme
import com.example.wbjuniorandroid.ui.utils.Screen

@Composable
fun AuthCodeInputScreen(
    navController: NavHostController
) {
    AuthCodeInputContent(onNavigateToProfile = { navController.navigate(Screen.AuthProfile.route)} )
}

@Composable
private fun AuthCodeInputContent(
    modifier: Modifier = Modifier.fillMaxSize(),
    onNavigateToProfile: () -> Unit,
) {
    Column(
        modifier = modifier.padding(horizontal = 63.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.auth_code_input_title),
            style = WBJuniorAppTheme.typography.heading2
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = stringResource(id = R.string.auth_code_input_details),
            style = WBJuniorAppTheme.typography.bodytext2
        )
        Spacer(modifier = Modifier.size(49.dp))
        AuthCodeInput(onCodeComplete = {
            onNavigateToProfile()
        })
        GhostTextButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.auth_code_input_request),
            onClick = { }
        )
    }
}