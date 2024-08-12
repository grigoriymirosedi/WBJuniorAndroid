package com.example.wbjuniorandroid.ui.general.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.wbjuniorandroid.ui.theme.BrandColorDark
import com.example.wbjuniorandroid.ui.theme.BrandColorDefault
import com.example.wbjuniorandroid.ui.theme.NeutralSecondaryBG
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.wbjuniorandroid.R
import com.example.wbjuniorandroid.ui.theme.BrandColorLight
import com.example.wbjuniorandroid.ui.theme.BrandDisableDefault
import com.example.wbjuniorandroid.ui.theme.WBJuniorAndroidTheme
import com.example.wbjuniorandroid.ui.theme.WBJuniorAppTheme

@Composable
fun SecondaryOutlinedButton(
    modifier: Modifier = Modifier,
    text: String,
    icon: Int? = null,
    onClick: () -> Unit,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.outlinedShape,
    elevation: ButtonElevation? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val disableOutlinedButtonColor =
        if (enabled) WBJuniorAppTheme.colors.brandDefault else BrandDisableDefault

    val outlinedButtonColor =
        if (isPressed) WBJuniorAppTheme.colors.brandDark else WBJuniorAppTheme.colors.brandDefault

    val outlinedBorderColor =
        if (enabled) WBJuniorAppTheme.colors.brandDefault else BrandDisableDefault

    OutlinedButton(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 8.dp),
        onClick = onClick,
        enabled = enabled,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = outlinedButtonColor,
            disabledContentColor = disableOutlinedButtonColor
        ),
        shape = shape,
        interactionSource = interactionSource,
        border = BorderStroke(width = 2.dp, color = outlinedBorderColor),
        contentPadding = contentPadding,
        elevation = elevation
    ) {

        if(icon != null)
            Image(painter = painterResource(id = icon), contentDescription = null)
        else {
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = text,
                style = WBJuniorAppTheme.typography.subheading2
            )
        }
    }
}

@Preview()
@Composable
fun OutlinedButtonPreview(
    text: String = "",
    icon: Int = R.drawable.twitter_icon,
    onClick: () -> Unit = {},
) {
    WBJuniorAndroidTheme {
        SecondaryOutlinedButton(text = text, icon = icon, onClick = onClick)
    }
}