package com.example.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

enum class ThemeMode(val label: String) {
    LIGHT("Light"),
    DARK("Dark"),
    SYSTEM("Follow System")
}

enum class ReadingFontSize(val label: String, val scale: Float) {
    SMALL("Compact", 0.92f),
    MEDIUM("Standard", 1.00f),
    LARGE("Comfortable", 1.10f),
    EXTRA_LARGE("Large Print", 1.20f)
}

private val LightEditorialScheme = lightColorScheme(
    primary = EditorialAccentLight,
    onPrimary = Color.White,
    primaryContainer = EditorialAccentContainerLight,
    onPrimaryContainer = OnEditorialAccentContainerLight,
    secondary = SecondaryAccentLight,
    onSecondary = Color.White,
    secondaryContainer = SecondaryContainerLight,
    onSecondaryContainer = OnSecondaryContainerLight,
    tertiary = TertiaryAccentLight,
    onTertiary = Color.White,
    tertiaryContainer = TertiaryContainerLight,
    background = WarmWhiteBackground,
    onBackground = CharcoalInk,
    surface = WarmPaperSurface,
    onSurface = CharcoalInk,
    surfaceVariant = WarmPaperSurfaceVariant,
    onSurfaceVariant = CharcoalInkSecondary,
    outline = WarmBorderLight,
    outlineVariant = WarmBorderLight.copy(alpha = 0.6f)
)

private val DarkEditorialScheme = darkColorScheme(
    primary = EditorialAccentDark,
    onPrimary = Color(0xFF231707),
    primaryContainer = EditorialAccentContainerDark,
    onPrimaryContainer = OnEditorialAccentContainerDark,
    secondary = SecondaryAccentDark,
    onSecondary = Color(0xFF0F241B),
    secondaryContainer = SecondaryContainerDark,
    onSecondaryContainer = OnSecondaryContainerDark,
    tertiary = TertiaryAccentDark,
    onTertiary = Color(0xFF26170F),
    tertiaryContainer = TertiaryContainerDark,
    background = DeepCharcoalBackground,
    onBackground = SoftWhiteInk,
    surface = DeepCharcoalSurface,
    onSurface = SoftWhiteInk,
    surfaceVariant = DeepCharcoalSurfaceVariant,
    onSurfaceVariant = SoftWhiteInkSecondary,
    outline = WarmBorderDark,
    outlineVariant = WarmBorderDark.copy(alpha = 0.65f)
)

val LocalIsDarkTheme = staticCompositionLocalOf { false }
val LocalReadingFontSize = staticCompositionLocalOf { ReadingFontSize.MEDIUM }

@Composable
fun MindtrapTheme(
    themeMode: ThemeMode = ThemeMode.SYSTEM,
    readingFontSize: ReadingFontSize = ReadingFontSize.MEDIUM,
    content: @Composable () -> Unit
) {
    val systemDark = isSystemInDarkTheme()
    val useDarkTheme = when (themeMode) {
        ThemeMode.LIGHT -> false
        ThemeMode.DARK -> true
        ThemeMode.SYSTEM -> systemDark
    }

    val colorScheme = if (useDarkTheme) DarkEditorialScheme else LightEditorialScheme
    val typography = buildEditorialTypography(readingFontSize.scale)

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as? Activity)?.window
            if (window != null) {
                WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !useDarkTheme
                WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = !useDarkTheme
            }
        }
    }

    CompositionLocalProvider(
        LocalIsDarkTheme provides useDarkTheme,
        LocalReadingFontSize provides readingFontSize
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            content = content
        )
    }
}
