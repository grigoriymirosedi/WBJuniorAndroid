package com.example.wbjuniorandroid.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.wbjuniorandroid.R
import com.example.wbjuniorandroid.ui.general.components.ProfileImage
import com.example.wbjuniorandroid.ui.general.components.SecondaryOutlinedButton
import com.example.wbjuniorandroid.ui.theme.WBJuniorAndroidTheme
import com.example.wbjuniorandroid.ui.theme.WBJuniorAppTheme
import com.example.wbjuniorandroid.ui.utils.Mock


@Composable
fun ProfileScreen(
    navController: NavHostController
) {
    ProfileContent(
        username = Mock.username,
        userPhoneNumber = Mock.userPhoneNumber
    )
}
@Composable
private fun ProfileContent(
    modifier: Modifier = Modifier.fillMaxSize(),
    username: String,
    userPhoneNumber: String,
) {
    Column(
        modifier = modifier.padding(top = 46.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ProfileImage(profileImageURL = Mock.profileImageURL)
        Spacer(modifier = Modifier.size(20.dp))
        Text(
            text = username,
            style = WBJuniorAppTheme.typography.heading2,
            lineHeight = 24.sp,
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = userPhoneNumber,
            style = WBJuniorAppTheme.typography.subheading2,
            color = WBJuniorAppTheme.colors.neutralDisabled,
            lineHeight = 20.sp
        )
        Spacer(modifier = Modifier.size(40.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally), ) {
            SecondaryOutlinedButton(
                text = "",
                icon = R.drawable.twitter_icon,
                onClick = { /*TODO*/ }
            )
            SecondaryOutlinedButton(
                text = "",
                icon = R.drawable.instagram_icon,
                onClick = { /*TODO*/ }
            )
            SecondaryOutlinedButton(
                text = "",
                icon = R.drawable.linkedin_icon,
                onClick = { /*TODO*/ }
            )
            SecondaryOutlinedButton(
                text = "",
                icon = R.drawable.facebook_icon,
                onClick = { /*TODO*/ }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview(
    username: String = "Иван Иванов",
    userPhoneNumber: String = "+7 999 999-99-99",
) {
    WBJuniorAndroidTheme {
        ProfileContent(
            username = username,
            userPhoneNumber = userPhoneNumber
        )
    }
}