package com.app.idCard.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = DarkThemeBlack,
    secondary = DarkThemeWhite,
    tertiary = DarkThemeVeryDarkGrey,
    background = DarkThemeLightGrey,
    surface = DarkThemeVeryDarkGrey,
    onPrimary = DarkThemeGreen,
    onSecondary = DarkThemeRed,
    onTertiary = DarkThemeDarkGrey,
    onBackground = DarkThemeWhite,
    onSurface = DarkThemeWhite
)

private val LightColorScheme = lightColorScheme(
    primary = LightThemeWhite,
    secondary = LightThemeBlack,
    tertiary = LightThemeVLightGrey,
    background = LightThemeDarkGrey,
    surface = LightThemeVLightGrey,
    onPrimary = LightThemeGreen,
    onSecondary = LightThemeRed,
    onTertiary = LightThemeVLightGrey,
    onBackground = LightThemeBlack,
    onSurface = LightThemeBlack
)





@Composable
fun IdCardAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }





        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            shapes = shapes,
            content = content
        )

}
