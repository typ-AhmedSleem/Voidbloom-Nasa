package com.typ.voidbloom.common.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Composable
@Stable
fun initVbColors(): ColorScheme {
    // todo: Use app color tokens
    return if (isSystemInDarkTheme()) {
        vbDarkColorScheme()
    } else {
        vbLightColorScheme()
    }
}

val VbColors: ColorScheme
    @Composable get() = MaterialTheme.colorScheme