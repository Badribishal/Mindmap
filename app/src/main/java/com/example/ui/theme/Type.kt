package com.example.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.R

val PlayfairDisplayFamily = FontFamily(
    Font(R.font.playfair_display, FontWeight.Normal),
    Font(R.font.playfair_display, FontWeight.SemiBold),
    Font(R.font.playfair_display, FontWeight.Bold)
)

val SourceSerifFamily = FontFamily(
    Font(R.font.source_serif_4, FontWeight.Normal),
    Font(R.font.source_serif_4, FontWeight.Medium),
    Font(R.font.source_serif_4, FontWeight.SemiBold)
)

val InterFamily = FontFamily(
    Font(R.font.inter, FontWeight.Normal),
    Font(R.font.inter, FontWeight.Medium),
    Font(R.font.inter, FontWeight.SemiBold),
    Font(R.font.inter, FontWeight.Bold)
)

val JetBrainsMonoFamily = FontFamily(
    Font(R.font.jetbrains_mono, FontWeight.Normal),
    Font(R.font.jetbrains_mono, FontWeight.Medium)
)

fun buildEditorialTypography(fontScaleMultiplier: Float = 1.0f): Typography {
    val bodyScale = fontScaleMultiplier.coerceIn(0.85f, 1.30f)
    val headingScale = 1f + (bodyScale - 1f) * 0.55f
    val labelScale = 1f + (bodyScale - 1f) * 0.35f

    return Typography(
        displayLarge = TextStyle(
            fontFamily = PlayfairDisplayFamily,
            fontWeight = FontWeight.Bold,
            fontSize = (28f * headingScale).sp,
            lineHeight = (36f * headingScale).sp,
            letterSpacing = (-0.3).sp
        ),
        displayMedium = TextStyle(
            fontFamily = PlayfairDisplayFamily,
            fontWeight = FontWeight.Bold,
            fontSize = (24f * headingScale).sp,
            lineHeight = (32f * headingScale).sp,
            letterSpacing = (-0.2).sp
        ),
        displaySmall = TextStyle(
            fontFamily = PlayfairDisplayFamily,
            fontWeight = FontWeight.Bold,
            fontSize = (22f * headingScale).sp,
            lineHeight = (29f * headingScale).sp,
            letterSpacing = (-0.15).sp
        ),
        headlineLarge = TextStyle(
            fontFamily = PlayfairDisplayFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = (20f * headingScale).sp,
            lineHeight = (27f * headingScale).sp
        ),
        headlineMedium = TextStyle(
            fontFamily = PlayfairDisplayFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = (18.5f * headingScale).sp,
            lineHeight = (25f * headingScale).sp
        ),
        headlineSmall = TextStyle(
            fontFamily = PlayfairDisplayFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = (17f * headingScale).sp,
            lineHeight = (23.5f * headingScale).sp
        ),
        titleLarge = TextStyle(
            fontFamily = InterFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = (17f * headingScale).sp,
            lineHeight = (24f * headingScale).sp
        ),
        titleMedium = TextStyle(
            fontFamily = InterFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = (15.5f * headingScale).sp,
            lineHeight = (22f * headingScale).sp,
            letterSpacing = 0.1.sp
        ),
        titleSmall = TextStyle(
            fontFamily = InterFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = (14f * headingScale).sp,
            lineHeight = (20f * headingScale).sp,
            letterSpacing = 0.1.sp
        ),
        bodyLarge = TextStyle(
            fontFamily = SourceSerifFamily,
            fontWeight = FontWeight.Normal,
            fontSize = (16f * bodyScale).sp,
            lineHeight = (25f * bodyScale).sp,
            letterSpacing = 0.1.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = InterFamily,
            fontWeight = FontWeight.Normal,
            fontSize = (14f * bodyScale).sp,
            lineHeight = (20.5f * bodyScale).sp,
            letterSpacing = 0.15.sp
        ),
        bodySmall = TextStyle(
            fontFamily = InterFamily,
            fontWeight = FontWeight.Normal,
            fontSize = (13f * bodyScale).sp,
            lineHeight = (18.5f * bodyScale).sp,
            letterSpacing = 0.15.sp
        ),
        labelLarge = TextStyle(
            fontFamily = InterFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = (13f * labelScale).sp,
            lineHeight = (18f * labelScale).sp,
            letterSpacing = 0.15.sp
        ),
        labelMedium = TextStyle(
            fontFamily = InterFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = (12f * labelScale).sp,
            lineHeight = (16f * labelScale).sp,
            letterSpacing = 0.35.sp
        ),
        labelSmall = TextStyle(
            fontFamily = InterFamily,
            fontWeight = FontWeight.Medium,
            fontSize = (11.5f * labelScale).sp,
            lineHeight = (15.5f * labelScale).sp,
            letterSpacing = 0.2.sp
        )
    )
}

val Typography = buildEditorialTypography(1.0f)

