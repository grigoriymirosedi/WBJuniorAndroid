package com.example.wbjuniorandroid.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

//BrandColors
val BrandColorDark = Color(0xff660EC8) // use for on pressed
val BrandColorDefault = Color(0xff9A41FE) // use for button
val BrandColorDarkMode = Color(0xff8207E8) // use for Dark Mode
val BrandColorLight = Color(0xffECDAFF) // variant
val BrandColorBG = Color(0xffF5ECFF) // use for background
val BrandDisableDefault = Color(0xffcb9ffd) // use for disable button color
val BrandDisableContentDefault = Color(0xfff9f9fc) // use for disable button content color

//Neutral
val NeutralActive = Color(0xff29183B) // use for font
val NeutralDark = Color(0xff190E26) // use for dark mode
val NeutralBody = Color(0xff1D0835) // use for text
val NeutralWeak = Color(0xffA4A4A4) // use for secondary text
val NeutralBorderLine = Color(0xffD2D5F9)
val NeutralDisabled = Color(0xffD4DBE7) // use for disabled
val NeutralLine = Color(0xffEDEDED) // use for divider
val NeutralSecondaryBG = Color(0xffF7F7FC) // use for BG
val NeutralWhite = Color(0xffFFFFFF) // use for BG

//Accent
val AccentDanger = Color(0xffE94242) // use for errors
val AccentWarning = Color(0xffFDCF41) // use for warning
val AccentSuccess = Color(0xff2CC069) // use for success
val AccentSafe =  Color(0xff7BCBCF) // variant

data class WbJuniorColorScheme(
    //brand colors
    val brandDark: Color,
    val brandDefault: Color,
    val brandDarkMode: Color,
    val brandLight: Color,
    val brandBackground: Color,

    //neutral colors
    val neutralActive: Color,
    val neutralDark: Color,
    val neutralBody: Color,
    val neutralWeak: Color,
    val neutralDisabled: Color,
    val neutralLine: Color,
    val neutralSecondaryBackground: Color,
    val neutralWhite: Color,

    //accent colors
    val accentDanger: Color,
    val accentWarning: Color,
    val accentSuccess: Color,
    val accentSafe:  Color
)

val LocalWbJuniorColorScheme = staticCompositionLocalOf {
    WbJuniorColorScheme (
        brandDark = Color.Unspecified,
        brandDefault = Color.Unspecified,
        brandDarkMode = Color.Unspecified,
        brandLight = Color.Unspecified,
        brandBackground = Color.Unspecified,
        neutralActive = Color.Unspecified,
        neutralDark = Color.Unspecified,
        neutralBody = Color.Unspecified,
        neutralWeak = Color.Unspecified,
        neutralDisabled = Color.Unspecified,
        neutralLine = Color.Unspecified,
        neutralSecondaryBackground = Color.Unspecified,
        neutralWhite = Color.Unspecified,
        accentDanger = Color.Unspecified,
        accentWarning = Color.Unspecified,
        accentSuccess = Color.Unspecified,
        accentSafe = Color.Unspecified
    )
}

val lightColorScheme = WbJuniorColorScheme(
    brandDark = BrandColorDark,
    brandDefault = BrandColorDefault,
    brandDarkMode = BrandColorDarkMode,
    brandLight = BrandColorLight,
    brandBackground = BrandColorBG,
    neutralActive = NeutralActive,
    neutralDark = NeutralDark,
    neutralBody = NeutralBody,
    neutralWeak = NeutralWeak,
    neutralDisabled = NeutralDisabled,
    neutralLine = NeutralLine,
    neutralSecondaryBackground = NeutralSecondaryBG,
    neutralWhite = NeutralWhite,
    accentDanger = AccentDanger,
    accentWarning = AccentWarning,
    accentSuccess = AccentSuccess,
    accentSafe = AccentSafe
)

val darkColorScheme = WbJuniorColorScheme(
    brandDark = BrandColorDark,
    brandDefault = BrandColorDefault,
    brandDarkMode = BrandColorDarkMode,
    brandLight = BrandColorLight,
    brandBackground = BrandColorBG,
    neutralActive = NeutralActive,
    neutralDark = NeutralDark,
    neutralBody = NeutralBody,
    neutralWeak = NeutralWeak,
    neutralDisabled = NeutralDisabled,
    neutralLine = NeutralLine,
    neutralSecondaryBackground = NeutralSecondaryBG,
    neutralWhite = NeutralWhite,
    accentDanger = AccentDanger,
    accentWarning = AccentWarning,
    accentSuccess = AccentSuccess,
    accentSafe = AccentSafe
)