package com.example.wbjuniorandroid.ui.general.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbjuniorandroid.ui.theme.BrandColorDark
import com.example.wbjuniorandroid.ui.theme.BrandColorDefault
import com.example.wbjuniorandroid.ui.theme.BrandDisableContentDefault
import com.example.wbjuniorandroid.ui.theme.BrandDisableDefault
import com.example.wbjuniorandroid.ui.theme.NeutralSecondaryBG
import com.example.wbjuniorandroid.ui.theme.WBJuniorAppTheme

@Composable
fun GhostTextButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.shape,
    border: BorderStroke? = null,
    elevation: ButtonElevation? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val containerColor =
        if (isPressed) WBJuniorAppTheme.colors.neutralSecondaryBackground else Color.Transparent
    val contentColor =
        if (isPressed) WBJuniorAppTheme.colors.brandDark else WBJuniorAppTheme.colors.brandDefault
    val disableContentColor =
        if (enabled) WBJuniorAppTheme.colors.brandDark else BrandDisableDefault

    TextButton(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 8.dp),
        onClick = onClick,
        enabled = enabled,
        colors = ButtonDefaults.textButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContentColor = disableContentColor
        ),
        elevation = elevation,
        shape = shape,
        interactionSource = interactionSource,
        border = border,
        contentPadding = contentPadding,
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = text,
            style = WBJuniorAppTheme.typography.subheading2
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GhostTextButtonPreview(
    text: String = "Ghost button",
    onClick: () -> Unit = {},
) {
    GhostTextButton(text = text, onClick = onClick)
}