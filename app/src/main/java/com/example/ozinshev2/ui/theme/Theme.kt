package com.example.ozinshev2.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    background = Color(0xFF111827),
    onBackground = Color(0xFFFFFFFF),
    onSurfaceVariant = Color(0xFF9CA3AF),
    primary = Color(0xFF7E2DFC),
    onPrimary = Color(0xFFFFFFFF),
    inversePrimary = Color(0xFF4B5563),
    primaryContainer = Color(0xFF374151),
    surfaceContainer = Color(0xFF1C2431),
    onPrimaryContainer = Color(0xFF9CA3AF),
)

private val LightColorScheme = lightColorScheme(
    background = Color(0xFFFFFFFF),
    onBackground = Color(0xFF111827),
    onSurfaceVariant = Color(0xFF6B7280),
    primary = Color(0xFF7E2DFC),
    onPrimary = Color(0xFFFFFFFF),
    inversePrimary = Color(0xFFD1D5DB),
    primaryContainer = Color(0xFFE5EBF0),
    surfaceContainer = Color(0xFFFFFFFF),
    onPrimaryContainer = Color(0xFF9CA3AF),
)

@Composable
fun OzinsheV2Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}