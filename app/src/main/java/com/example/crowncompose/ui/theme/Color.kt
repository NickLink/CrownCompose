package com.example.crowncompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val DarkGold = Color(0xFF7C6F49)
val LightGold = Color(0xFFB4A169)

val Black = Color(0xFF000000)
val Charcoal = Color(0xFF222222)
val DarkGrey = Color(0xFF4D4845)
val MediumGrey = Color(0xFFBAB5B1)
val Grey = Color(0xFFEBEBEB)
val LightGrey = Color(0xFFF8F8F8)
val White = Color(0xFFFFFFFF)

val Black94 = Color(0xF0000000)
val Grey94 = Color(0xF0EBEBEB)
val LightGrey94 = Color(0xF0F8F8F8)

val TierMember = Color(0xFF002D72)
val TierSilver = Color(0xFFA6A9AA)
val TierGold = Color(0xFFAB9D62)
val TierPlatinum = Color(0xFF6E6C69)
val TierBlack = Color(0xFF000000)
val TierCrystal = Color(0xFFB2CBE0)

val ErrorDarkRed = Color(0xFFB00000)
val ErrorLightRed = Color(0xFFF08687)
val SuccessDarkGreen = Color(0xFF027200)
val SuccessLightGreen = Color(0xFF03B800)
val WarningDarkOrange = Color(0xFFCB4F00)
val WarningLightOrange = Color(0xFFFF6200)
val InfoDarkBlue = Color(0xFF057CB1)
val InfoLightBlue = Color(0xFF009ADB)

data class CrownColors(
    val material: ColorScheme,
    val goldBackground: Color,
    val goldText: Color,
    val highBackground: Color,
    val highText: Color,


    val tierMember: Color = TierMember
) {
    val primary: Color get() = material.primary
    val onPrimary: Color get() = material.onPrimary
}

val LightColorPalette = CrownColors(
    material = lightColorScheme(),
    goldBackground = DarkGold,
    goldText = LightGold,
    highBackground = White,
    highText = Charcoal
)

val DarkColorPalette = CrownColors(
    material = darkColorScheme(),
    goldBackground = LightGold,
    goldText = DarkGold,
    highBackground = Charcoal,
    highText = White
)

val LocalColors = staticCompositionLocalOf { LightColorPalette }

val MaterialTheme.crownColors: CrownColors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current

@Composable
fun MyCrownTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    CompositionLocalProvider(
        LocalColors provides colors
    ) {
        MaterialTheme(
            colorScheme = colors.material,
            content = content
        )

    }
}